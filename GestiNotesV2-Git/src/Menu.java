

//import static gestinotesv2-Git.PrincipaleFrame.retourAuMenu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Victor Rondeau¸=
 */
public class Menu extends JMenuBar implements ActionListener{
    JFrame uneFrame;
    Etablissement unEtablissement = new Etablissement();
    PanelNouvelEtudiant pne = new PanelNouvelEtudiant(unEtablissement);
    JProgressBar pBar1;
    JLabel blackLabel;
    JMenu gestionnaire, etudiant, aide;
    JMenuItem menuLister, menuModifier, menuStatistiques, menuNouveau, menuAfficher, menuModifier2, menuApropos, menuQuestion, menuAnnuler, menuQuitter;
    int i=0;
    public Menu(JFrame frame){
        this.uneFrame=frame;
        gestionnaire = new JMenu("Gestionnaire"); //Création du menu Gestionnaire
        etudiant = new JMenu("Étudiant"); //Création du menu Étudiant
        aide = new JMenu("Aide"); //Création du menu Aide
        //Ajout des onglets
        add(gestionnaire);
        add(etudiant);
        add(aide);
        //Création des options du menu Gestionnaire
        menuLister = new JMenuItem("Lister");
        menuModifier = new JMenuItem("Modifier");
        menuStatistiques = new JMenuItem("Statisitques");
        //Création des options du menu Etudiant
        menuNouveau = new JMenuItem("Nouveau");
        menuAfficher = new JMenuItem("Afficher");
        menuModifier2 = new JMenuItem("Modifier");
        //Création des options du menu Aide
        menuApropos = new JMenuItem("À propos");
        menuQuestion = new JMenuItem("?");
        menuAnnuler = new JMenuItem("Annuler");
        menuQuitter = new JMenuItem("Quitter");
        //Ajout des options du menu Gestionnaire
        gestionnaire.add(menuLister);
        menuLister.addActionListener(this);
        gestionnaire.add(menuModifier);
        menuModifier.addActionListener(this);
        gestionnaire.add(menuStatistiques);
        menuStatistiques.addActionListener(this);
        //Ajout des options du menu Etudiant
        etudiant.add(menuNouveau);
        menuNouveau.addActionListener(this);
        etudiant.add(menuAfficher);
        menuAfficher.addActionListener(this);
        etudiant.add(menuModifier2);
        menuModifier2.addActionListener(this);
        //Ajout des options du menu Aide
        aide.add(menuApropos);
        menuApropos.addActionListener(this);
        aide.add(menuQuestion);
        menuQuestion.addActionListener(this);
        aide.add(menuAnnuler);
        menuAnnuler.addActionListener(this);
        aide.add(menuQuitter);
        menuQuitter.addActionListener(this);
    }
    

    
    @Override
    public void actionPerformed(ActionEvent event){
        if (event.getSource() == menuLister){
            uneFrame.getContentPane().removeAll();
            uneFrame.add(new PanelLister(unEtablissement));
            uneFrame.revalidate();
            uneFrame.repaint();
        }else if (event.getSource() == menuModifier){
            uneFrame.getContentPane().removeAll();
            uneFrame.add(new PanelModifier(unEtablissement));
            uneFrame.revalidate();
            uneFrame.repaint();
        }else if (event.getSource() == menuStatistiques){
            uneFrame.getContentPane().removeAll();
            uneFrame.add(new PanelStatistiques(unEtablissement));
            uneFrame.revalidate();
            uneFrame.repaint();
        }else if(event.getSource() == menuNouveau){
            uneFrame.getContentPane().removeAll();
            uneFrame.add(pne);
            uneFrame.revalidate();
            uneFrame.repaint();
        }else if(event.getSource() == menuAfficher){
            uneFrame.getContentPane().removeAll();
            String uneEntree = JOptionPane.showInputDialog("Code de l'étudiant");
            uneFrame.add(new PanelAfficher(unEtablissement,uneEntree));
            if(PrincipaleFrame.retourAuMenu = true){
                uneFrame.getContentPane().removeAll();
                uneFrame.add(PrincipaleFrame.simplePanel);
                uneFrame.revalidate();
                uneFrame.repaint();
                PrincipaleFrame.retourAuMenu = false;
            }
            uneFrame.revalidate();
            uneFrame.repaint();
        }else if(event.getSource() == menuModifier2){
            uneFrame.getContentPane().removeAll();
            String uneEntree = JOptionPane.showInputDialog("Code de l'étudiant");
            uneFrame.add(new PanelMenuModifier2(unEtablissement,uneEntree));
            uneFrame.revalidate();
            uneFrame.repaint();   
        }else if(event.getSource() == menuApropos){
            uneFrame.getContentPane().removeAll();
            uneFrame.add(new PanelMenuApropos());
            uneFrame.revalidate();
            uneFrame.repaint();
        }else if(event.getSource() == menuQuestion) {
            uneFrame.getContentPane().removeAll();
            uneFrame.add(new PanelMenuQuestion());
            uneFrame.revalidate();
            uneFrame.repaint();
        }else if(event.getSource() == menuAnnuler) {
            uneFrame.getContentPane().removeAll();
            uneFrame.add(PrincipaleFrame.simplePanel);
            uneFrame.revalidate();
            uneFrame.repaint();
        }else if(event.getSource() == menuQuitter) {
           int answer = JOptionPane.showConfirmDialog(null,"Êtes-vous certain de vouloir fermer l'application?");
            switch (answer) {
                case JOptionPane.YES_OPTION:
                    JOptionPane.showMessageDialog(null, "Merci d'avoir utilisé GestiNotes");
                    System.exit(0);
            
                case JOptionPane.NO_OPTION://L'application demeure sur le panel actuel
                    break;
            
                case JOptionPane.CANCEL_OPTION://L'option d'annuler permet de réaliser la même action que lorsque l'option aide>annuler est sélectionée
                    uneFrame.getContentPane().removeAll();
                    uneFrame.add(PrincipaleFrame.simplePanel);
                    uneFrame.revalidate();
                    uneFrame.repaint();
                    
                default:
                    break;
            }
        }
    }
}
