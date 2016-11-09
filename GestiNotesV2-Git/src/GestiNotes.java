

/**
 * GestiNotes:
 * Version 1.0 complétée le 2016/09/28
 * @author Vittorio PASSUELLO-DUSSAULT (Classes Groupe, Etudiant et Etablissement)
 *         Victor RONDEAU (Classes graphiques)
 */
//Importations
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class GestiNotes {
    public static void main(String[] args){
        try{
            PrincipaleFrame main = new PrincipaleFrame();
            //main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //main.pack();
            main.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e) {
                    int confirmed = JOptionPane.showConfirmDialog(null,"Voulez-Vous vraiment quitter GestiNotes?","",JOptionPane.YES_NO_OPTION);

                    if (confirmed == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Merci d'avoir utilisé GestiNotes!");
                        System.exit(0);
                    }
                }
            });
            
            main.setVisible(true);
            main.setLocationRelativeTo(null);   
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
}
