package Rubrica;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class EditorPersona extends JDialog {

    private List<Persona> persone;
    private DefaultTableModel model;
    private File filePersone;
    private JTextField nomeField = new JTextField(20);
    private JTextField cognomeField = new JTextField(20);
    private JTextField indirizzoField = new JTextField(20);
    private JTextField telefonoField = new JTextField(20);
    private JTextField etaField = new JTextField(20);


    public EditorPersona(JFrame parent, List<Persona> persone, DefaultTableModel model, File filePersone) {
        super(parent, "Editor Persona", true);
        this.persone = persone;
        this.model = model;
        this.filePersone = filePersone;
        setSize(300, 200);
        setLocationRelativeTo(parent);
       
        // Pannello centrale con le etichette e i campi
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));

        nomeField = new JTextField(20);
        cognomeField = new JTextField(20);
        indirizzoField = new JTextField(20);
        telefonoField = new JTextField(20);
        etaField = new JTextField(20);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        inputPanel.add(nomeLabel);
        inputPanel.add(nomeField);

        JLabel cognomeLabel = new JLabel("Cognome:");
        cognomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        inputPanel.add(cognomeLabel);
        inputPanel.add(cognomeField);

        JLabel indirizzoLabel = new JLabel("Indirizzo:");
        indirizzoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        inputPanel.add(indirizzoLabel);
        inputPanel.add(indirizzoField);

        JLabel telefonoLabel = new JLabel("Telefono:");
        telefonoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        inputPanel.add(telefonoLabel);
        inputPanel.add(telefonoField);

        JLabel etaLabel = new JLabel("Età:");
        etaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        inputPanel.add(etaLabel);
        inputPanel.add(etaField);

        // Pulsanti
        JPanel bottoniPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton salvaBtn = new JButton("Salva");
        JButton annullaBtn = new JButton("Annulla");
        bottoniPanel.add(salvaBtn);
        bottoniPanel.add(annullaBtn);

        // Eventi
        annullaBtn.addActionListener(e -> dispose());

        salvaBtn.addActionListener(e -> {
            String testoNome = nomeField.getText();
            String testoCognome = cognomeField.getText();
            String testoIndirizzo = indirizzoField.getText();
            String testoTelefono = telefonoField.getText();
            String testoEta = etaField.getText();

            if(!testoNome.equals("") && !testoCognome.equals("") && !testoIndirizzo.equals("") && !testoTelefono.equals("") && !testoEta.equals("")){
                Persona p = new Persona(testoNome, testoCognome, testoIndirizzo, testoTelefono, Integer.parseInt(testoEta));
                persone.add(p);
                aggiornaTabella();
                aggiornaFile();
                dispose();
            }   
        });

        // Aggiunta pannelli
        add(inputPanel, BorderLayout.CENTER);
        add(bottoniPanel, BorderLayout.SOUTH);
    }

    public void pulisciFields(){
        nomeField.setText("");
        cognomeField.setText("");
        indirizzoField.setText("");
        telefonoField.setText("");
        etaField.setText("");
    }

    private void aggiornaTabella(){
        model.setRowCount(0);
        for (Persona p : persone){
            model.addRow(new Object[]{p.getNome(), p.getCognome(), p.getTelefono()});
        }
    }

    private void aggiornaFile(){
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePersone))) {
            for (Persona p : persone){
                pw.println(p.getNome() + ";" + ";" + p.getCognome() + ";" + p.getIndirizzo() + ";" + p.getTelefono() + ";" + p.getEta());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}