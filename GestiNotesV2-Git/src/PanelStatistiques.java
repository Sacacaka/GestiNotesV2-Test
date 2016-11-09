

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Victor Rondeau
 */
public class PanelStatistiques extends JPanel{

    Etablissement unEtablissement;
    JComboBox selectionGroupe;
    String[] tabGroupes;
    int numeroGroupeSelectione;
    JTextArea affichageGroupe;

    public PanelStatistiques(Etablissement unEtablissment) {
        this.unEtablissement = unEtablissement;
        setLayout(new BorderLayout());
        setBackground(Color.white);
        //Création d'un tableau ayant la taille du tableau dynamique contenant les groupes
        tabGroupes = new String[getNombreGroupe()];
        //Ajout des groupes dans le tableau
        for (int i = 0; i < getNombreGroupe(); i++) {
            tabGroupes[i] = "Groupe " + Etablissement.getTabGroupes().get(i).getNumero();
        }
        //Création d'une liste déroulante
        selectionGroupe = new JComboBox(tabGroupes);
        selectionGroupe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Création du label qui affichera la liste
                for (int k = 0; k < getNombreGroupe(); k++) {
                    if (selectionGroupe.getSelectedItem().equals("Groupe " + Etablissement.getTabGroupes().get(k).getNumero())) {
                        numeroGroupeSelectione = k;
                    }
                }
            }
        });
        affichageGroupe = new JTextArea(Etablissement.afficherStatistiques(numeroGroupeSelectione));
        add(selectionGroupe, BorderLayout.NORTH);
        add(affichageGroupe, BorderLayout.CENTER);
    }

    //Méthode qui donne le nombre de groupe que contient le tableau dynamique
    public int getNombreGroupe() {
        return Etablissement.getTabGroupes().size();
    }
}