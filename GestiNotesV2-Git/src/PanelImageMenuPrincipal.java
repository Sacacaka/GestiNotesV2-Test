/*
 * Classe PanelImageMenuPrincipal:
 * Panel indépendant qui contient l'image du menu principal
 */


import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Vittorio Passuello-Dussault
 */
public class PanelImageMenuPrincipal extends StandardPanel {
    public PanelImageMenuPrincipal() {
        setLayout(null);
        setSize(50,50);
        setBackground(Color.WHITE);
        try {                
            image = ImageIO.read(new File("gestiNotesImg1.png"));
        }catch (IOException ex) {
           JOptionPane.showMessageDialog(null,"erreur");
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, 10, 10,50,50, this); 
    }
}
