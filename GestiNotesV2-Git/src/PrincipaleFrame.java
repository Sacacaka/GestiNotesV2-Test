

/**
 * Version 1.0 complétée le 2016/10/01
 *
 * @author Victor Rondeau et Vittorio Passuello-Dussault
 */
//Importations
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;


public class PrincipaleFrame extends JFrame {
    //Attributs
    Etablissement unEtablissement = new Etablissement();
    Groupe unGroupe;
    static JPanel simplePanel, simplePanel1;
    static boolean retourAuMenu; //Variable static boolean qui permettra à l'utilisateur de revenir au menu principal lors du clic sur les boutons annuler des menus étudiant<modifier et étudiant<afficher
    JButton option1, option2, option3, option4;
    //GridLayout gl = new GridLayout(4, 1, 0, 3);
    int confirmation, numeroDeGroupe;
    JLabel bienvenue = new JLabel("Bienvenue dans GestiNotes");
    JLabel remplGroupes = new JLabel("Saturation des groupes");
    Boolean nouveauGroupe = false;
    
    JProgressBar pBar1;
    JLabel blackLabel;

    
    
    public PrincipaleFrame(){
        simplePanel = new JPanel();
        simplePanel1 = new JPanel();
        Container contentPane = getContentPane();
        simplePanel.setLayout(null);
        setTitle("GestiNotes");
        setSize(500,700);
        simplePanel.setBackground(Color.white);
        simplePanel1.setBackground(Color.white);
        
        //Création du menu à onglets
        setJMenuBar(new Menu(this));
        
        //Création du panel avec image
        PanelImageMenuPrincipal panelImage = new PanelImageMenuPrincipal();
        panelImage.setBounds(200, 30, 80, 80);
        simplePanel.add(panelImage);
        
        //Labels
        bienvenue.setBounds(150, 100, 280, 30);
        remplGroupes.setBounds(150, 150, 280, 30);
        
        //Logo du programme
        ImageIcon img = new ImageIcon("logo-crosemont-signature.png");
        setIconImage(img.getImage());
        
        
        /*option1 = new JButton("Inscrire un étudiant");
        option1.setBackground(Color.white);
        option1.setForeground(Color.black);
        option1.addActionListener(this);
        option1.setBounds(50, 150, 180, 30);
        
        option2 = new JButton("Afficher la liste des étudiants");
        option2.setBackground(Color.white);
        option2.setForeground(Color.black);
        option2.addActionListener(this);
        option2.setBounds(250, 150, 180, 30);
        
        option3 = new JButton("Afficher les statistiques");
        option3.setBackground(Color.white);
        option3.setForeground(Color.black);
        option3.addActionListener(this);
        option3.setBounds(50, 250, 180, 30);
        
        option4 = new JButton("Quitter");
        option4.setBackground(Color.white);
        option4.setForeground(Color.red);
        option4.addActionListener(this);
        option4.setBounds(250, 250, 180, 30);
        */
        //Remplissage
        simplePanel.add(bienvenue);
        //simplePanel.add(option1);
        //simplePanel.add(option2);
        //simplePanel.add(option3);
        //simplePanel.add(option4);
        simplePanel.add(remplGroupes);
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Look and Feel Natif introuvable");
        }
        contentPane.add(simplePanel);
    }

}
