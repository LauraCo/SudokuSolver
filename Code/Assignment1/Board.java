package Assignment1;

/**
 * 
 * Is a board of Squares, setting values to each square, returning these values.
 * Also has a Print method for print out the Sudoku board once it is completed.
 *
 * @author Laura Collins (lac32)
 * Date started - 14th Oct. 2013
 * 
 */

public class Board {
    
    private char squares[][];
    private static final int ARRAY_SIZE = 9;
    private char value;
   
    
    /*
     * Instatiate the 2D Arrays 'squares' and set it's size to be the final array size of 9x9
     */
    
    public Board() {
           squares = new char[ARRAY_SIZE][ARRAY_SIZE];
    }
    
    /*
     * Sets Value of a Square in the Board
     * @param i Row value
     * @param j Column value
     * @param Value the char value
     */
    
    public void setValue(int i, int j, char value) {
        this.value = value;
        squares[i][j] = value;
    }
    
    /* 
     * Returns the value of a Square in the board
     * @param i Row value
     * @param j Column value
     * @return char Value of the square
     */
    
    public char getValue(int i, int j) {
        return squares[i][j];
    }
    
    /*
     * Prints out the Board.
     * For use in the final solving algorithm.
     */
    
    public void printValues() {
        for (int i = 0; i<9; i++) {
            for (int j = 0; j<9; j++) {
                System.out.print(getValue(i,j));
            }
            System.out.print('\n');
    } 
    }
    
}