package Assignment1;

import java.io.*;

/**
 * This loads in the .sud file and adds it to the Board array. 
 * Each square in the array is assigned a char value, read in from the file.
 * Used BufferedReader to read in the file.
 * Threw several exceptions to catch any unwanted errors.
 *
 * @author lac32 
 * Date Started: 12th Oct. 2013
 * 
 */
public class LoadSudFile {
    
    private BufferedReader input;
    public File filename;
    private Board squares = new Board();
    
    public LoadSudFile() {
        
    }
    
    /*
     * So when using the JFileChooser, the appropriate filename is assigned.
     */
    
    public void setFileName(File filename) {
        this.filename = filename;
    }
    
    /*
     * Load in .sud file.
     * Improvements could be made here, or in the Swing class so it can only load in .sud files.
     * Also improvements where the board could be printed in the GUI.
     */
    
    public Board load() throws FileNotFoundException {

        try { 
       
            input = new BufferedReader(new FileReader(filename)); 
            
            for (int x=0; x<9; x++) {
               
                  String currentLine = input.readLine();
                  
                  for (int y=0; y<9; y++) {
                      squares.setValue(x,y,currentLine.charAt(y));
                      System.out.print(squares.getValue(x, y));
                  }
                  
                System.out.print("\n");
            }
        }
        
        catch (IOException e){
            e.printStackTrace();
        }
        
        finally {
            try {
                if (input != null) {
                     input.close();
                }
            }
            catch (IOException ie) {
                ie.printStackTrace();
            }
        }
        return squares;
    }
}