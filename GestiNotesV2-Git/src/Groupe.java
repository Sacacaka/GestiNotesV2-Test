

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 *
 * @author Vittorio Passuello-Dussault
 *         Classe achevée le 2016/10/01
 */
public class Groupe {
    
    //Attributs
    private int numero = 0;
    private ArrayList<Etudiant> tabEtudiants = new ArrayList<Etudiant>();
    final int NOMBRE_MAX_ETUDIANTS = 10;
    private boolean groupePlein = false;
    
    //Constructeur 
    public Groupe(int unNumero){
        unNumero = numero;
    }
    
    
    //Méthodes
    
    //Méthode pour calculer le nombre de places libres dans un groupe
    public int freeSpace(){
        int occupe = getTabEtudiants().size();
        int libre = NOMBRE_MAX_ETUDIANTS - occupe;
        return libre;
    }
    //Méthode pour ajouter un étudiant au groupe
    public void ajouter(Etudiant unEtudiant){
         getTabEtudiants().add(unEtudiant);
    }
    //Méthode pour calculer la moyenne
    public double calculerMoyenne(){
        double somme=0;
        for(int count=0;count<getTabEtudiants().size();count++){
            somme+=getTabEtudiants().get(count).calculerNoteFinale();
        }
        return somme/getTabEtudiants().size();
    }
    //Méthode pour calculer l'écart-type 
    public double calculerEcartType(){
        double ecart = Math.sqrt(calculerVariance());
        return ecart;
    }
    
    //Méthode calculer variance 
    public double calculerVariance(){
        double variance = 0;
        for(int count=0;count<getTabEtudiants().size();count++){
            variance += Math.pow((getTabEtudiants().get(count).calculerNoteFinale())-(calculerMoyenne()),2.) / getTabEtudiants().size();
        }
        return variance;
    }
    
    //Méthode qui trie le tableau des étudiants en ordre alphabétique
    public void triAlphabetique(){
        Collections.sort(getTabEtudiants(), new Comparator<Etudiant>(){
            @Override
            public int compare(Etudiant e1, Etudiant e2){
                return e1.getNom().compareToIgnoreCase(e2.getNom());
            }
        });
        
    }
    
    //Méthode toString() contenant les informations d'un étudiant
    public String toStringInfo(){
        String msgInfo="";
        for(int count=0;count<getTabEtudiants().size();count++){
         msgInfo += "Code d'étudiant: " + getTabEtudiants().get(count).calculerCode()+ ", Nom: " + getTabEtudiants().get(count).getNom() + ", Prénom: " + getTabEtudiants().get(count).getPrenom() + ", Date de naissance: " + getTabEtudiants().get(count).getDateDeNaissance() + ", Note finale: "+getTabEtudiants().get(count).calculerNoteFinale()+"\n\n";
        }
        return msgInfo;
    }
    
    //Méthode toString() contenant les statistiques du groupe
    public String toStringStats(){
        String msgStats="";
        msgStats = "Moyenne du groupe: "+calculerMoyenne()+ "\nÉcart-Type: " + calculerEcartType() + "\nVariance du groupe: "+ calculerVariance()+"\nMeilleure note: "+calculerPlusHauteNote()+"\nPire note: "+calculerPireNote()+"\nTaux de succès: "+calculerTauxSucces()+"%";
        return msgStats;
    }
    //Méthode qui trouve la plus haute note
    public double calculerPlusHauteNote(){
        double plusHauteNote=0;
        for (int i=0; i<getTabEtudiants().size();i++){
            if (getTabEtudiants().get(i).calculerNoteFinale()>plusHauteNote)
               plusHauteNote=getTabEtudiants().get(i).calculerNoteFinale();
        }
        return plusHauteNote;
    }
    //Méthode qui trouve la pire note
    public double calculerPireNote(){
        double pireNoteDeBase = Double.MAX_VALUE;
        double pireNote=0;
        for (int j=0; j<getTabEtudiants().size();j++){
            if(getTabEtudiants().get(j).calculerNoteFinale()<pireNoteDeBase)
                pireNote=getTabEtudiants().get(j).calculerNoteFinale();
        }
        return pireNote;
    }
    //Méthode qui calcule le taux de succès
    public double calculerTauxSucces(){
        double tauxSucces;
        double nombreReussites=0;
        for(int k=0;k<getTabEtudiants().size();k++){
            if (getTabEtudiants().get(k).calculerNoteFinale()>=60)
                nombreReussites++;
        }
        tauxSucces=nombreReussites/getTabEtudiants().size();
        return tauxSucces*100;
    }
    
    
    
    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the tabEtudiants
     */
    public ArrayList<Etudiant> getTabEtudiants() {
        return tabEtudiants;
    }

    /**
     * @param tabEtudiants the tabEtudiants to set
     */
    public void setTabEtudiants(ArrayList<Etudiant> tabEtudiants) {
        this.tabEtudiants = tabEtudiants;
    }

    /**
     * @return the groupePlein
     */
    public boolean isGroupePlein() {
        return groupePlein;
    }

    /**
     * @param groupePlein the groupePlein to set
     */
    public void setGroupePlein(boolean groupePlein) {
        this.groupePlein = groupePlein;
    }
    
}
