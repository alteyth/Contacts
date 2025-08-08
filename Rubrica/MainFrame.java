package Rubrica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends JFrame{

    private JTable tabella;
    private DefaultTableModel model;
    private List<Persona> persone = new ArrayList<>();
    private File filePersone = new File("informazioni.txt");
    EditorPersona editor;

    public MainFrame(){
        super("Rubrica Contatti");
        setSize(800, 500);
        setLocationRelativeTo(null);
        // setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //Tabella
        String[] colonne = {"Nome", "Cognome", "Telefono"};
        model = new DefaultTableModel(colonne, 0);
        tabella = new JTable(model){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        JScrollPane scrollPane = new JScrollPane(tabella);
        editor = new EditorPersona(this, persone, model);

        //Pulsanti
        JButton nuovoBtn = new JButton("Nuovo");
        JButton modificaBtn = new JButton("Modifica");
        JButton eliminaBtn = new JButton("Elimina");
        
        JPanel pulsantiPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pulsantiPanel.add(nuovoBtn);
        pulsantiPanel.add(modificaBtn);
        pulsantiPanel.add(eliminaBtn);

        // Layout
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(pulsantiPanel, BorderLayout.SOUTH);

        caricaDaFile();
        aggiornaTabella();
        
        // Pressione pulsanti
       nuovoBtn.addActionListener((ActionEvent e) -> {
           editor.pulisciFields(); 
           editor.setVisible(true);
        });
    }

    private void caricaDaFile(){
        persone.clear();
        if(!filePersone.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(filePersone))){
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(";");
                if(parts.length == 5){
                    Persona p = new Persona(parts[0], parts[1], parts[2], parts[3], Integer.parseInt(parts[4]));
                    persone.add(p);
                    // System.out.println(persone.get(0).getTelefono());
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    private void aggiornaTabella(){
        model.setRowCount(0);
        for (Persona p : persone){
            model.addRow(new Object[]{p.getNome(), p.getCognome(), p.getTelefono()});
        }
    }
}