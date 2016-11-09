/*
 * Description de la classe PanelMenuApropos: 
 * Classe qui permet l'affichage des informations concernant le développement de l'application.
 * Un objet de cette classe sera créé lorsque l'utilisateur sélectionnera l'option À propos du menu aide.
 */


/**
 *
 * @author Vittorio Passuello-Dussault
 */

//Importations nécessaires
import javax.swing.*;

public class PanelMenuApropos extends StandardPanel {
    public PanelMenuApropos(){
        setLayout(glDisplayLCKDTextArea);
        informations = new JTextArea(texteInformationsApropos);
        informations.setEditable(false);
        add(informations);
    }
}
