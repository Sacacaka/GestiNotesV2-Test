/*
 * Description de la classe PanelMenuQuestion: 
 * Classe qui permet l'affichage d'un guide d'utilisation pour l'application.
 * Un objet de cette classe sera construit à chaque fois que l'utilisateur sélectionnera l'option ? du menu aide.
 */


import javax.swing.JTextArea;

/**
 *
 * @author Vittorio Passuello-Dussault
 */
public class PanelMenuQuestion extends StandardPanel {
    public PanelMenuQuestion() {
        setLayout(glDisplayLCKDTextArea);
        informations = new JTextArea(texteInformationsQuestion);
        informations.setEditable(false);
        add(informations);
    } 
}
