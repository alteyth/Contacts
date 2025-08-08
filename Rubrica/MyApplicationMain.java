package Rubrica;

public class MyApplicationMain{
    public static void main(String[] args) {
       MainFrame finestra = new MainFrame();
       finestra.setVisible(true);
       EditorPersona editor = new EditorPersona(finestra);
       editor.setVisible(true); 
       
    }
}