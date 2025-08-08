package Rubrica;

import java.awt.*;
import javax.swing.*;

class EditorPersona extends JDialog {

    private JTextField nomeField = new JTextField(20);
    private JTextField cognomeField = new JTextField(20);
    private JTextField telefonoField = new JTextField(20);

    public EditorPersona(JFrame parent) {
        super(parent, "Editor Persona", true);
        setSize(300, 200);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        // Campi
        JPanel campiPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.anchor = GridBagConstraints.WEST;

        // Nome
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        campiPanel.add(new JLabel("Nome:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        campiPanel.add(nomeField, gbc);

        // Cognome
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        campiPanel.add(new JLabel("Cognome:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        campiPanel.add(cognomeField, gbc);

        // Telefono
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        campiPanel.add(new JLabel("Telefono:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        campiPanel.add(telefonoField, gbc);
        
        // Pulsanti
        JPanel bottoniPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton salvaBtn = new JButton("Salva");
        JButton annullaBtn = new JButton("Annulla");
        bottoniPanel.add(salvaBtn);
        bottoniPanel.add(annullaBtn);

        // Eventi
        annullaBtn.addActionListener(e -> dispose());

        // Aggiunta pannelli
        add(campiPanel, BorderLayout.CENTER);
        add(bottoniPanel, BorderLayout.SOUTH);
    }
}