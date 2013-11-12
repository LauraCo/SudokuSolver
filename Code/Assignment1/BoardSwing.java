package Assignment1;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 * Implements the Sudoku Solver's GUI
 *
 * @author lac32 
 * Date Started - 12th Oct. 2013
 * @version 1.0
 * 
 */

public class BoardSwing extends JFrame implements ActionListener {
    private JPanel buttonPanel;
    private JButton load;
    private JButton solve;
    private JButton clear;
    private BoardPanel panel;
    private JPanel gridPanel;
    private Solving solving;
    private Board board;
    private Thread calc;
    
    /*
     * Main constructor containing most of the Swing implementation.
     * Creates two JPanels for the window, and three buttons.
     * Also calls from the BoardPanel class to draw the basic grid.
     * @throws FileNotFoundException
     */
    
    public BoardSwing() throws FileNotFoundException {
        setTitle("Sudoku Solver");
        
        buttonPanel = new JPanel();
        gridPanel = new JPanel(new GridLayout(1,1));
       
        load = new JButton("Load Puzzle");
        load.addActionListener(this);
        buttonPanel.add(load);
        
        solve = new JButton("Solve");
        solve.addActionListener(this);
        buttonPanel.add(solve);
        
        clear = new JButton("Clear");
        clear.addActionListener(this);
        buttonPanel.add(clear);
        
        buttonPanel.setBackground(Color.LIGHT_GRAY);
     
        panel = new BoardPanel();
        
        gridPanel.add(panel);
       
        add(buttonPanel, BorderLayout.SOUTH);
        add(gridPanel, BorderLayout.CENTER);
        setSize(500, 400);
	this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On Mac, closing via 'x' does not stop application
        
    }

    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    /**
     * actionPerfomed is a automatically-generated method when ActionListener is implemented.
     * Controls what happens when a user clicks a specific button, and calls appropriate methods.
     * 
     * @param ae
     */
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == load) {
        try {
            LoadSudFile l = new LoadSudFile();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Sud Files", "sud");
            JFileChooser loadTxt = new JFileChooser();
            int Checker;
            Checker = loadTxt.showOpenDialog(null);
            if (Checker == JFileChooser.APPROVE_OPTION) {
                File file = loadTxt.getSelectedFile();
                loadTxt.setFileFilter(filter);
                l.setFileName(file);
                board = l.load();
                
            }
            else {
                JOptionPane.showMessageDialog(null, "You Have Clicked Cancel", "Cancel", JOptionPane.WARNING_MESSAGE); //Stops it throwing Null Pointer when load is cancelled
            }
                                
			} 
        catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "File Not Found", "Error", JOptionPane.WARNING_MESSAGE); //Warning Message if there'board an error loading in a file
            } 
        catch (IOException ex) {
            Logger.getLogger(BoardSwing.class.getName()).log(Level.SEVERE, null, ex); //Automatically generated
        }
        }
        
        if (ae.getSource() == solve) {
            
            if (board != null){
                
                solving = new Solving(board);
                calc = new Thread(solving);
                calc.start();
            }
            else {
                JOptionPane.showMessageDialog(null, "No File Loaded in!", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
        
        if (ae.getSource() == clear) {
            if (board != null){
            panel.clear();
            }
            else {
                JOptionPane.showMessageDialog(null, "The Board GUI is empty!", "Cannot Clear Empty Board", JOptionPane.WARNING_MESSAGE); //Stops it throwing Null Pointer when clear is clicked as GUI is empty
       
            }
        }        
    }        
}