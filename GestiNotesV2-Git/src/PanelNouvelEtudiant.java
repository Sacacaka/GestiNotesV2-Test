/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author usager
 */
//import static gestinotes_v2.PrincipaleFrame.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelNouvelEtudiant extends StandardPanel implements ActionListener{
    
    public PanelNouvelEtudiant(Etablissement unEtablissement){
        this.unEtablissement = unEtablissement;
        setLayout(new GridLayout(9,2,30,30));
        if(Etablissement.getNombreGroupes()==0){
               Etablissement.addPremierGroupe();
            }
            revalidate();
                
                //Saisie des informations
                nom=new JLabel("Entrez le nom de famille de l'étudiant");
                prenom=new JLabel("Entrez le prénom de l'étudiant");
                dateDeNaissance=new JLabel("Entrez la date de naissance de l'étudiant sour le format JJ-MM-AAAA");
                note1=new JLabel("Entrez la note du premier cours");
                note2=new JLabel("Entrez la note du deuxième cours");
                note3=new JLabel("Entrez la note du troisième cours");
                note4=new JLabel("Entrez la note du quatrième cours");
                
                tnom = new JTextField(10);
                tprenom = new JTextField(10);
                tdateDeNaissance = new JTextField(10);
                tnote1 = new JTextField(10);
                tnote2 = new JTextField(10);
                tnote3 = new JTextField(10);
                tnote4 = new JTextField(10);
                
                confirmer = new JButton("Confirmer");
                confirmer.addActionListener(this);
                
                annuler = new JButton("Annuler");
                annuler.addActionListener(this);
                
                add(nom);
                add(tnom);
                add(prenom);
                add(tprenom);
                add(dateDeNaissance);
                add(tdateDeNaissance);
                add(note1);
                add(tnote1);
                add(note2);
                add(tnote2);
                add(note3);
                add(tnote3);
                add(note4);
                add(tnote4);
                add(confirmer);
                add(annuler);
                
                
    }
    @Override
    public void actionPerformed(ActionEvent event){
        if (event.getSource()== confirmer){
            //Mise à jour des JProgressBar
            //simplePanel.revalidate();
            drawProgressBar();
            
            //Création de l'objet Etudiant
            Etudiant temoin = new Etudiant(tnom.getText(),tprenom.getText(),tdateDeNaissance.getText(),Integer.parseInt(tnote1.getText()),Integer.parseInt(tnote2.getText()),Integer.parseInt(tnote3.getText()),Integer.parseInt(tnote4.getText()));
                
                //Création de l'objet étudiant dans le groupe dans l'établissement s'il y a de la place pour lui
                if(Etablissement.getTabGroupes().get(i).getTabEtudiants().size()!=11){
                    Etablissement.getTabGroupes().get(i).getTabEtudiants().add(temoin);
                }
                
                JOptionPane.showMessageDialog(null, "Étudiant inscrit avec succès. Code d'étudiant: "+temoin.getCode());
                
                //Vérification de l'espace disponible dans le groupe
                int libre = Etablissement.getTabGroupes().get(i).freeSpace();
                if(libre>=0&libre!=-1){
                JOptionPane.showMessageDialog(null,"Il reste encore "+libre+" places dans le groupe: "+ ((int)(Etablissement.getNombreGroupes()-1)));
                }
                //Avertissement pour la création du premier élève d'un nouveau groupe
                if(libre == 0){
                    JOptionPane.showMessageDialog(null,"Attention, il n'y a plus de places dans le groupe: "+ ((int)(Etablissement.getNombreGroupes()-1))+" Le prochain élève inscrit sera placé dans le groupe: "+(Etablissement.getNombreGroupes()));
                            i++;
                            Etablissement.addGroupe();
                            
                            
                }
                
                PrincipaleFrame.simplePanel.repaint();
                PrincipaleFrame.simplePanel.revalidate();
                tnom.setText("");
                tprenom.setText("");
                tdateDeNaissance.setText("");
                tnote1.setText("");
                tnote2.setText("");
                tnote3.setText("");
                tnote4.setText("");
        }else if(event.getSource() == annuler){
            
        }
    }
   
}
