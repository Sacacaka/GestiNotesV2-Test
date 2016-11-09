/*
 * Description de la classe StandardPanel:
 *  Méthode qui regrouppe les standards que doivent avoir les panels
 *  qui seront affichés pour chaque action exécutée par les onglets.
 */


/**
 *
 * @author Vittorio Passuello-Dussault
 */

// Importations nécessaires
//import static gestinotes_v2.PrincipaleFrame.simplePanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class StandardPanel extends JPanel {
    //Attribut commun
    Etablissement unEtablissement;
    
    //Attributs du PanelNouvelEtudiant
    JLabel nom,prenom,dateDeNaissance,note1,note2,note3,note4;
    JTextField tnom,tprenom,tdateDeNaissance,tnote1,tnote2,tnote3,tnote4;
    JButton confirmer,annuler;
    
    //Attributs du PanelAfficher+PanelMenuModifier2
    String codeEntryResponse;
    JButton find;
    boolean etudiantFound;
    String validation;
    
    //Attribut propre à PanelMenuModifier2 présent dans le formulaire
    JTextField codeEtudiantLCK;
    JLabel codeEtudiantLabel;
    int numeroGroupeTrouve,numeroEtudiantTrouve;
    
    //Attributs de PanelMenuApropos
    GridLayout glDisplayLCKDTextArea = new GridLayout(1,1,30,30); //Aussi attribut de PanelMenuQuestion
    JTextArea informations;//Aussi attribut de PanelMenuQuestion
    String texteInformationsApropos = "GestiNotes\nVersion 2.0\n\nAuteurs:\nPASSUELLO-DUSSAULT, Vittorio\nRONDEAU, Victor\n\nDate de réalisation: 2016-11-04\n\nRosemont, Montréal, Qc, Canada";
    
    //Attribut propre à PanelMenuQuestion
    String texteInformationsQuestion = "Guide d'utilisation:\n\nPour inscrire un étudiant:\n  Sélectionnez l'onglet Étudiant\n  Sélectionnez l'option Nouveau\n  Remplissez le formulaire qui s'affiche à l'écran\n  Cliquez sur le bouton confimer\n  L'étudiant sera désormais ajouté à la liste du groupe auquel il sera attribué.\n\nPour afficher les informations d'un étudiant:\n  Sélectionnez l'onglet Étudiant\n  Sélectionnez l'option Afficher\n  Entrez le code de l'étudiant et sélectionnez OK\n\nPour modifier les infomrations d'un étudiant:\n  Sélectionnez l'onglet Étudiant\n  Sélectionnez l'option Modifier\n  Entrez le code de l'étudiant dont vous souhaiter mettre à jour les informations\n  Remplissez le formulaire qui apparaîtra à l'écran\n  Appuyez sur le bouton confirmer\n\n";
    
    //Attributs propre à PanelImageMenuPrincipal
    BufferedImage image;
    
    //Menu principal
    JLabel bienvenue = new JLabel("Bienvenue dans GestiNotes");
    JLabel remplGroupes = new JLabel("Saturation des groupes");
    JProgressBar pBar;
    JLabel pBarLabel;
    
    int i;
    //Méthode qui permet de dessiner les JProgressBar
    public void drawProgressBar(){
        
        PrincipaleFrame.simplePanel.revalidate();
        if(i!=0){
            if(Etablissement.getTabGroupes().get(i-1).getTabEtudiants().size()==10){
                        pBar.setValue(10);
                        PrincipaleFrame.simplePanel.revalidate();
                        PrincipaleFrame.simplePanel.repaint();
            }
        }
        if(Etablissement.getTabGroupes().get(i).getTabEtudiants().isEmpty() | Etablissement.getTabGroupes().get(0).getTabEtudiants().size()==8){
            pBar = new JProgressBar(0,10);
            pBarLabel = new JLabel("Groupe "+i);
            pBarLabel.setBounds(340, 200+(60*i), 70, 30);
            pBar.setValue(Etablissement.getTabGroupes().get(i).getTabEtudiants().size()+1);
            pBar.setBounds(100, 200+(60*i), 200, 30);
            PrincipaleFrame.simplePanel.add(pBar);
            PrincipaleFrame.simplePanel.add(pBarLabel);
            PrincipaleFrame.simplePanel.revalidate();
            PrincipaleFrame.simplePanel.repaint();
        }else{
            pBar.setValue(Etablissement.getTabGroupes().get(i).getTabEtudiants().size()+1);
            PrincipaleFrame.simplePanel.revalidate();
            PrincipaleFrame.simplePanel.repaint();
        }
        
        PrincipaleFrame.simplePanel.revalidate();
        PrincipaleFrame.simplePanel.repaint();
    }
    
    
}
