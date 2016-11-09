/*
 * Description de la classe PanelAfficher:
 * Cette classe contient le code nécessaite pour permettre la recherche d'un étudiant dans l'ensemble des groupes et des élèves de l'école.
 * Un objet de cette classe sera alors créé à chaque fois que l'utilisateur sélectionnera l'option afficher du menu Étudiant.
 */


/**
 *
 * @author Vittorio Passuello-Dussault
 */
//import static gestinotes_v2.PrincipaleFrame.retourAuMenu;
import javax.swing.*;
import java.awt.*;
public class PanelAfficher extends StandardPanel {
    public PanelAfficher (Etablissement unEtablissement, String uneEntree){
        this.unEtablissement = unEtablissement;
        etudiantFound = false;
        validation="";
        //Traitement de la saisie d'un code d'étudiant
        this.codeEntryResponse = uneEntree;
        for(int count1 = 0; count1 < Etablissement.getTabGroupes().size(); count1 ++){
               for(int count2 = 0; count2 < Etablissement.getTabGroupes().get(count1).getTabEtudiants().size(); count2 ++){
                   validation = Etablissement.getTabGroupes().get(count1).getTabEtudiants().get(count2).getCode();
                   if(validation.equalsIgnoreCase(codeEntryResponse)){
                       etudiantFound = true;
                       JOptionPane.showMessageDialog(null,"Notes de l'étudiant : "+ Etablissement.getTabGroupes().get(count1).getTabEtudiants().get(count2).getNom()+", "+Etablissement.getTabGroupes().get(count1).getTabEtudiants().get(count2).getPrenom()+"\n"+Etablissement.getTabGroupes().get(count1).getTabEtudiants().get(count2).listageNotes());
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
            //wowowowowowowow
        }
    }
    
}
    
