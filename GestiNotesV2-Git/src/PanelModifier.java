

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Victor Rondeau
 */
public class PanelModifier extends JPanel{
    Etablissement unEtablissement;
    String[] tabGroupes, tabEtudiants;
    JComboBox selectionGroupe, selectionEtudiant;
    int groupeSelectione, etudiantSelectione;
    JLabel note1,note2,note3,note4;
    JTextField noteModifier1, noteModifier2, noteModifier3, noteModifier4;
    JButton enregistrer;
            
    public PanelModifier(Etablissement unEtablissement){
        this.unEtablissement=unEtablissement;
        setLayout(new GridLayout(6,2));
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
                //Création du textArea qui affichera la liste
                for (int k = 0; k < getNombreGroupe(); k++) {
                    if (selectionGroupe.getSelectedItem().equals("Groupe " + Etablissement.getTabGroupes().get(k).getNumero())) {
                        //Création d'un tableau ayant la taille du tableau dynamqieu contenant les étudiants
                       // tabEtudiants = new String[getNombreEtudiants(k)];
                        groupeSelectione=k;
                        //Ajout des étudiants dans le tableau
                       /* for (int j = 0; j < getNombreGroupe(); j++) {
                            tabEtudiants[j] = Etablissement.getTabGroupes().get(j).getTabEtudiants().get(j).getCode()+", "+Etablissement.getTabGroupes().get(j).getTabEtudiants().get(j).getNom()+", "+Etablissement.getTabGroupes().get(j).getTabEtudiants().get(j).getPrenom();
                        }
                            //Création d'une liste déroulante
                            selectionEtudiant = new JComboBox(tabEtudiants);*/
                            selectionEtudiant.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e){
                                    for (int l=0; l<getNombreEtudiants(groupeSelectione);l++){
                                        if(selectionEtudiant.getSelectedItem().equals(Etablissement.getTabGroupes().get(groupeSelectione).getTabEtudiants().get(l).getCode()+", "+Etablissement.getTabGroupes().get(groupeSelectione).getTabEtudiants().get(l).getNom()+", "+Etablissement.getTabGroupes().get(groupeSelectione).getTabEtudiants().get(l).getPrenom())){
                                            /*note1 = new JLabel("Note du premier cours");
                                            noteModifier1 = new JTextField(""+Etablissement.getTabGroupes().get(groupeSelectione).getTabEtudiants().get(l).getNoteCours1(),10);
                                            note2 = new JLabel("Note du deuxième cours");
                                            noteModifier2 = new JTextField(""+Etablissement.getTabGroupes().get(groupeSelectione).getTabEtudiants().get(l).getNoteCours2(),10);
                                            note3 = new JLabel("Note du troisième cours");
                                            noteModifier3 = new JTextField(""+Etablissement.getTabGroupes().get(groupeSelectione).getTabEtudiants().get(l).getNoteCours3(),10);
                                            note4 = new JLabel("Note du quatrième cours");
                                            noteModifier4 = new JTextField(""+Etablissement.getTabGroupes().get(groupeSelectione).getTabEtudiants().get(l).getNoteCours4(),10);
                                            enregistrer = new JButton("Enregistrer");*/
                                            etudiantSelectione = l;
                                            enregistrer.addActionListener(new ActionListener(){
                                                public void actionPerformed(ActionEvent e){
                                                    Etablissement.getTabGroupes().get(groupeSelectione).getTabEtudiants().get(etudiantSelectione).setNoteCours1(Integer.parseInt(noteModifier1.getText()));
                                                    Etablissement.getTabGroupes().get(groupeSelectione).getTabEtudiants().get(etudiantSelectione).setNoteCours2(Integer.parseInt(noteModifier2.getText()));
                                                    Etablissement.getTabGroupes().get(groupeSelectione).getTabEtudiants().get(etudiantSelectione).setNoteCours3(Integer.parseInt(noteModifier3.getText()));
                                                    Etablissement.getTabGroupes().get(groupeSelectione).getTabEtudiants().get(etudiantSelectione).setNoteCours4(Integer.parseInt(noteModifier4.getText()));
                                                }
                                            });
                                            /*add(note1);
                                            add(noteModifier1);
                                            add(note2);
                                            add(noteModifier2);
                                            add(note3);
                                            add(noteModifier3);
                                            add(note4);
                                            add(noteModifier4);
                                            add(enregistrer);*/
                                        }
                                    }
                                }
                            });
                            //add(selectionEtudiant);
                        
                        
                    }
                }
            }
        });
        //Création d'un tableau ayant la taille du tableau dynamqieu contenant les étudiants
        tabEtudiants = new String[getNombreEtudiants(groupeSelectione)];
                        
        //Ajout des étudiants dans le tableau
        for (int j = 0; j < getNombreEtudiants(groupeSelectione); j++) {
            tabEtudiants[j] = Etablissement.getTabGroupes().get(groupeSelectione).getTabEtudiants().get(j).getCode()+", "+Etablissement.getTabGroupes().get(groupeSelectione).getTabEtudiants().get(j).getNom()+", "+Etablissement.getTabGroupes().get(groupeSelectione).getTabEtudiants().get(j).getPrenom();
        }
        //Création d'une liste déroulante
        selectionEtudiant = new JComboBox(tabEtudiants);
        
        //Création des label et des champs de texte
        note1 = new JLabel("Note du premier cours");
        noteModifier1 = new JTextField(""+Etablissement.getTabGroupes().get(groupeSelectione).getTabEtudiants().get(etudiantSelectione).getNoteCours1(),10);
        note2 = new JLabel("Note du deuxième cours");
        noteModifier2 = new JTextField(""+Etablissement.getTabGroupes().get(groupeSelectione).getTabEtudiants().get(etudiantSelectione).getNoteCours2(),10);
        note3 = new JLabel("Note du troisième cours");
        noteModifier3 = new JTextField(""+Etablissement.getTabGroupes().get(groupeSelectione).getTabEtudiants().get(etudiantSelectione).getNoteCours3(),10);
        note4 = new JLabel("Note du quatrième cours");
        noteModifier4 = new JTextField(""+Etablissement.getTabGroupes().get(groupeSelectione).getTabEtudiants().get(etudiantSelectione).getNoteCours4(),10);
        enregistrer = new JButton("Enregistrer");
        
        //Ajout des éléments au panel
        add(selectionGroupe);
        add(selectionEtudiant);
        add(note1);
        add(noteModifier1);
        add(note2);
        add(noteModifier2);
        add(note3);
        add(noteModifier3);
        add(note4);
        add(noteModifier4);
        add(enregistrer);
        
        
    }
    public int getNombreGroupe() {
        return Etablissement.getTabGroupes().size();
    }
    public int getNombreEtudiants(int numeroGroupe){
        return Etablissement.getTabGroupes().get(numeroGroupe).getTabEtudiants().size();
    }
   
}
