

import java.util.ArrayList;
import javax.swing.JProgressBar;

/**
 *
 * @author Vittorio Passuello-Dussault
 *         Classe achevée le 2016/10/01
 */
public class Etablissement {
    //Attributs
    private static ArrayList<Groupe> tabGroupes = new ArrayList<Groupe>();
    private static int nombreGroupes=0;
    //Méthode pour ajouter un groupe à tabGroupes
    static void addGroupe() {
        getTabGroupes().add(new Groupe(nombreGroupes));
        nombreGroupes++;
    }
    //Constructeur avec groupe de départ
    static void addPremierGroupe(){
        getTabGroupes().add(new Groupe(nombreGroupes));
        ArrayList<Etudiant> tabEtudiants = getTabGroupes().get(nombreGroupes).getTabEtudiants();
        tabEtudiants.add(new Etudiant("Descroches","Yvan","03-08-1997",50,60,70,80));
        tabEtudiants.add(new Etudiant("Terrieur","Alain","02-07-1996",70,60,80,77));
        tabEtudiants.add(new Etudiant("Terrieur","Alex","01-06-1995",66,77,88,99));
        tabEtudiants.add(new Etudiant("Courci","Sarah","04-08-1998",33,64,87,44));
        tabEtudiants.add(new Etudiant("Molli","Sarah","23-08-1996",57,87,98,76));
        tabEtudiants.add(new Etudiant("Brûlé","Yvon","14-11-2001",56,86,34,99));
        tabEtudiants.add(new Etudiant("Noël","Père","25-12-1901",78,98,67,100));
        tabEtudiants.add(new Etudiant("Paul-Paul","Paul","16-02-1997",76,87,56,44));
        nombreGroupes++;
    }
    
    
    /*public JProgressBar drawProgressBar (Groupe grp){
        JProgressBar pBar = new JProgressBar(0,10);
        int numeroDuGrp = Etablissement.getTabGroupes().indexOf(grp);
        pBar.setValue(Etablissement.getTabGroupes().get(numeroDuGrp).getTabEtudiants().size());
        pBar.setBounds(150, 350+(5*numeroDuGrp), 280, 30);
        return pBar;
    }*/
    

    /**
     * @return the tabGroupes
     */
    public static ArrayList<Groupe> getTabGroupes() {
        return tabGroupes;
    }

    /**
     * @param aTabGroupes the tabGroupes to set
     */
    public static void setTabGroupes(ArrayList<Groupe> aTabGroupes) {
        tabGroupes = aTabGroupes;
    }

    /**
     * @return the nombreGroupes
     */
    public static int getNombreGroupes() {
        return nombreGroupes;
    }

    /**
     * @param aNombreGroupes the nombreGroupes to set
     */
    public static void setNombreGroupes(int aNombreGroupes) {
        nombreGroupes = aNombreGroupes;
    }
    
    
    
    public static String afficherInformations(int unNumero){
        String message = tabGroupes.get(unNumero).toStringInfo()+"\n";
        return message;
    }
    
    //Méthode contenant les statistiques
    public static String afficherStatistiques(int UnNumero){
        String msgStats = tabGroupes.get(UnNumero).toStringStats();
        return msgStats;
    }
    
}
