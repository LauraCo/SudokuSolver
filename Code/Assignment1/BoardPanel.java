package Assignment1;

import java.awt.*;
import javax.swing.*;


/**
 * Basic Class drawing the grid in the GUI, and controlling the 'Clear' function.
 *
 * @author Laura Collins lac32 
 * Date Started: 12th October
 */
public class BoardPanel extends JPanel {   
    
    /*
     * BoardPanel constructor, simply sets the background colour.
     */
    public BoardPanel() {
        setBackground(Color.white);    
    }
    
    
    /*
     * Calls paintComponent, saw Grid can be drawn.
     * 
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawGrid(g); 
    }
    
    
    /*
     * Draws the grid using simple For loops and the Graphics component drawRect. 
     * 
     * @param g
     */        
   public void drawGrid(Graphics g) {
		int i, j, begini = 110, beginj = 30;
                
                    for (i = 0; i < 9; i++) {
                    	for (j = 0; j < 9; j++) {
                            g.setColor(Color.black);
                            g.drawRect(begini + i * 30, beginj + j * 30, 30, 30);
                           
                         }
                    }
                } 
   
   /*
    * Originally going to be used for clearing the GUI board of all values.
    * Now being used to make Console appear to have been cleared.
    * A clear method for the Console has yet to be properly defined.
    */
  
    public void clear() {
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++) {
                System.out.println(" ");
            }
        }
    }
        
}
