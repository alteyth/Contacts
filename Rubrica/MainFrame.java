package Rubrica;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
    public MainFrame(){
        super("Rubrica");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}