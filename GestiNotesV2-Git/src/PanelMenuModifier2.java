/*
 * Description de la classe PanelMenuModifier2:
 * Cette classe permet à l'utilisateur de modifier les informations d'un étudiant inscrit dans un groupe,
 * lorsque l'option Modifier du menu Étudiant est sélectionnée. Un objet de cette classe sera alors créé à chaque fois
 * que l'utilisateur de GestiNotes sélectionnera cete option du menu Étudiant.
 */


/**
 *
 * @author Vittorio Passuello-Dussault
 */
//import static gestinotes_v2.PrincipaleFrame.retourAuMenu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PanelMenuModifier2 extends StandardPanel implements ActionListener{
    public PanelMenuModifier2(Etablissement unEtablissement, String uneEntree){
        this.unEtablissement = unEtablissement;
        etudiantFound = false;
        validation="";
        
        //Traitement de la saisie d'un code d'étudiant
        this.codeEntryResponse = uneEntree;
        for(int count1 = 0; count1 < Etablissement.getTabGroupes().size(); count1 ++){
               for(int count2 = 0; count2 < Etablissement.getTabGroupes().get(count1).getTabEtudiants().size(); count2 ++){
                   validation = Etablissement.getTabGroupes().get(count1).getTabEtudiants().get(count2).calculerCode();
                   if(validation.equalsIgnoreCase(codeEntryResponse)){
                       etudiantFound = true;
                       numeroGroupeTrouve = count1;
                       numeroEtudiantTrouve = count2;
                       break;
                   }else{
                       etudiantFound = false;
                   }
                   //TEST JOptionPane.showMessageDialog(null,""+Etablissement.getTabGroupes().get(count1).getTabEtudiants().get(count2).getNom());
                }
        }
        if(!etudiantFound){
            JOptionPane.showMessageDialog(null,"Ce code ne correspond à aucun étudiant enregistré. Veuillez réessayer");
            PrincipaleFrame.retourAuMenu = true;
        }

        //Cas où l'étudiant a été identifié et que ses informations doivent être modifiées
        if(etudiantFound == true){
            //Création du formulaire identique à celui qui a servi à inscrire l'étudiant dans un groupe
            //Dans ce formulaire, toutes les données doivent être éditables, sauf le code d'étudiant
            setLayout(new GridLayout(11,2,30,30));
            if(Etablissement.getNombreGroupes()==0){
               Etablissement.addPremierGroupe();
            }
            revalidate();
                //Code étudiant non éditable et label approprié
                codeEtudiantLabel = new JLabel("Code Étudiant");
                codeEtudiantLCK = new JTextField(10);
                codeEtudiantLCK.setText(validation);
                codeEtudiantLCK.setEditable(false);
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
                
                confirmer = new JButton("Confirmer les modifications");
                confirmer.addActionListener(this);
                
                annuler = new JButton("Annuler les modifications");
                annuler.addActionListener(this);
                
                add(codeEtudiantLabel);
                add(codeEtudiantLCK);
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
    }
@Override
    public void actionPerformed(ActionEvent event){
        if (event.getSource()== confirmer){
            //Création de l'objet Etudiant temoin (celui qui remplacera l'objet actuel) avec les valeurs éditées
            Etudiant temoin = new Etudiant(tnom.getText(),tprenom.getText(),tdateDeNaissance.getText(),Integer.parseInt(tnote1.getText()),Integer.parseInt(tnote2.getText()),Integer.parseInt(tnote3.getText()),Integer.parseInt(tnote4.getText()));
            //Modification du code étudiant pour qu'il reste le même qu'avant les modifications
            temoin.setCode(validation);
            //Remplacement de l'objet étudiant précédent par l'étudiant témoin
            Etablissement.getTabGroupes().get(numeroGroupeTrouve).getTabEtudiants().get(numeroEtudiantTrouve).setCode(temoin.getCode());
            Etablissement.getTabGroupes().get(numeroGroupeTrouve).getTabEtudiants().get(numeroEtudiantTrouve).setDateDeNaissance(temoin.getDateDeNaissance());
            Etablissement.getTabGroupes().get(numeroGroupeTrouve).getTabEtudiants().get(numeroEtudiantTrouve).setNom(temoin.getNom());
            Etablissement.getTabGroupes().get(numeroGroupeTrouve).getTabEtudiants().get(numeroEtudiantTrouve).setPrenom(temoin.getPrenom());
            Etablissement.getTabGroupes().get(numeroGroupeTrouve).getTabEtudiants().get(numeroEtudiantTrouve).setNoteCours1(temoin.getNoteCours1());
            Etablissement.getTabGroupes().get(numeroGroupeTrouve).getTabEtudiants().get(numeroEtudiantTrouve).setNoteCours2(temoin.getNoteCours2());
            Etablissement.getTabGroupes().get(numeroGroupeTrouve).getTabEtudiants().get(numeroEtudiantTrouve).setNoteCours3(temoin.getNoteCours3());
            Etablissement.getTabGroupes().get(numeroGroupeTrouve).getTabEtudiants().get(numeroEtudiantTrouve).setNoteCours4(temoin.getNoteCours4());
            repaint();
            revalidate();
        }else if(event.getSource() == annuler){
            //Retour au frame principal
            //retourAuMenu = true;
        }
    }    
}
