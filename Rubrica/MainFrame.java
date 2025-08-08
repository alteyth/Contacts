package Rubrica;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends JFrame{

    private JTable tabella;
    private DefaultTableModel model;

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
        tabella = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabella);

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

        
    }
}