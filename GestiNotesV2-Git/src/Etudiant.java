

/**
 *
 * @author Vittorio Passuello-Dussault
 *         Classe achevée le 2016/10/01
 */
public class Etudiant {
    
    private String nom;
    private String prenom;
    private String dateDeNaissance;
    private String code;
    private int noteCours1 = 0;
    private int noteCours2 = 0;
    private int noteCours3 = 0;
    private int noteCours4 = 0;

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the dateDeNaissance
     */
    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    /**
     * @param dateDeNaissance the dateDeNaissance to set
     */
    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the noteCours1
     */
    public int getNoteCours1() {
        return noteCours1;
    }

    /**
     * @param noteCours1 the noteCours1 to set
     */
    public void setNoteCours1(int noteCours1) {
        this.noteCours1 = noteCours1;
    }

    /**
     * @return the noteCours2
     */
    public int getNoteCours2() {
        return noteCours2;
    }

    /**
     * @param noteCours2 the noteCours2 to set
     */
    public void setNoteCours2(int noteCours2) {
        this.noteCours2 = noteCours2;
    }

    /**
     * @return the noteCours3
     */
    public int getNoteCours3() {
        return noteCours3;
    }

    /**
     * @param noteCours3 the noteCours3 to set
     */
    public void setNoteCours3(int noteCours3) {
        this.noteCours3 = noteCours3;
    }

    /**
     * @return the noteCours4
     */
    public int getNoteCours4() {
        return noteCours4;
    }

    /**
     * @param noteCours4 the noteCours4 to set
     */
    public void setNoteCours4(int noteCours4) {
        this.noteCours4 = noteCours4;
    }
    
    //Constructeur
    public Etudiant (String nom, String prenom, String dateDeNaissance, int uneNote1, int uneNote2, int uneNote3, int uneNote4){
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setDateDeNaissance(dateDeNaissance);
        code = this.calculerCode();
        this.noteCours1=uneNote1;
        this.noteCours2=uneNote2;
        this.noteCours3=uneNote3;
        this.noteCours4=uneNote4;
    }
    //Méthodes
    //Méthode qui génère le code permanent
    public String calculerCode(){
        String codeUsager = getNom().toUpperCase().charAt(0)+"";
        codeUsager = codeUsager+getPrenom().toUpperCase().charAt(0)+"";
        codeUsager = codeUsager+getDateDeNaissance().substring(6,10);
        return codeUsager;
    }
    //Méthode qui calcule la note finale de l'étudiant
    public double calculerNoteFinale(){
            return (getNoteCours1()*0.20)+(getNoteCours2()*0.20)+(getNoteCours3()*0.30)+(getNoteCours4()*0.30);
    }
    
    //Méthode toString() qui retourne la liste des notes de l'étudiant
    public String listageNotes(){
        return "Note cours 1: "+this.noteCours1 +"\nNote cours 2: "+this.noteCours2+"\nNote cours 3: "+this.noteCours3+"\nNote cours 4: "+this.noteCours4;
    }
}
