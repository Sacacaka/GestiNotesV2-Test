

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Victor Rondeau
 */
public class PanelLister extends JPanel{

    Etablissement unEtablissement;
    JComboBox selectionGroupe;
    String[] tabGroupes;
    int numeroGroupeSelectione;
    JTextArea affichageGroupe;

    public PanelLister(Etablissement unEtablissement) {
        this.unEtablissement = unEtablissement;
        setLayout(new BorderLayout());
        setBackground(Color.white);
        //Création d'un tableau ayant la taille du tableau dynamique contenant les groupes
        //tabGroupes = new String[getNombreGroupe()];
        //Ajout des groupes dans le tableau
        selectionGroupe = new JComboBox();
        selectionGroupe.addItem("Groupe 0");
        selectionGroupe.addItem("Groupe 1");
        for (int i = 0; i < Etablissement.getNombreGroupes(); i++) {
            if (Etablissement.getNombreGroupes()==Etablissement.getNombreGroupes()+1)
               selectionGroupe.addItem("Groupe "+Etablissement.getNombreGroupes()); 
        }
        //Création d'une liste déroulante
        //selectionGroupe = new JComboBox(tabGroupes);
        selectionGroupe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Création du label qui affichera la liste
                for (int k = 0; k < Etablissement.getNombreGroupes(); k++) {
                    if (selectionGroupe.getSelectedItem().equals("Groupe " + Etablissement.getTabGroupes().get(k).getNumero())) {
                        numeroGroupeSelectione = k;
                    }
                }
            }
        });
        Etablissement.getTabGroupes().get(numeroGroupeSelectione).triAlphabetique();
        affichageGroupe = new JTextArea(Etablissement.afficherInformations(numeroGroupeSelectione));
        add(selectionGroupe, BorderLayout.NORTH);
        add(affichageGroupe, BorderLayout.CENTER);
        
        
    }

}
