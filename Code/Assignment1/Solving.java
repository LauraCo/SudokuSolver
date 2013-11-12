package Assignment1;

import java.util.LinkedList;

/**
 *
 * Contains Solving algorithms for finding the Sudoku's solution. 
 * Uses the Naked Singles solving algorithm, so finds squares that have only one possibility and inputting it.
 * Repeats this until all squares are filled.
 * This solving algorithm can solve 2 simple Sudokus.
 * 
 * @author Laura Collins (lac32) 
 * Date Started: 16th October 2013
 * 
 */

public class Solving implements Runnable {
    
    private Board board;
    private LinkedList <Character> possibles[][] = new LinkedList[9][9];
   
    /*
     * Links board from the Board class, into this Class
     * @param board Board array of squares
     */
    public Solving(Board squares) {
        this.board = squares;
    }
    
    /*
     * Checks if char is empty, create a new linkedlist of possibilities, and then adds possible values
     * that don't come up in the corresponding row, column or box.
     */
    
    private void addCandidates() {
       // char current='c';
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++) {
               if (board.getValue(i,j) == ' ') {
                   possibles[i][j] = new LinkedList();
                   possibles[i][j].add('1');
                   possibles[i][j].add('2');
                   possibles[i][j].add('3');
                   possibles[i][j].add('4');
                   possibles[i][j].add('5');
                   possibles[i][j].add('6');
                   possibles[i][j].add('7');
                   possibles[i][j].add('8');
                   possibles[i][j].add('9');
                 }
            }
        }
        System.out.print("\n");
           
    }
    
    /*
     * Iterates through each row in a column, finding chars and removing them from the Possibility LinkedList.
     * Then iterates through all 9 columns.
     * @param i 
     * @param j
     */
    
    private void checkCol(int i, int j){
        
        for (int x = 0; x < 9; x++) {
            if (board.getValue(x, j) != ' '){
            for (int k = 0; k < possibles[i][j].size(); k++) {
                if (board.getValue(x, j) == possibles[i][j].get(k)) {
                    possibles[i][j].remove(k);
                } 
                }
            }
            
        }
    }
   
   /*
    * Iterates through each column in a row, finding chars and removing them from the Possibility LinkedList.
    * Then iterates through all 9 rows. 
    * @param i
    * @param j
    */
    
    private void checkRow(int i, int j) {
        for (int y = 0; y < 9; y++) {
            if (board.getValue(i, y) != ' '){
                for (int k = 0; k < possibles[i][j].size(); k++) {
                     if (board.getValue(i, y) == possibles[i][j].get(k)) {
                         possibles[i][j].remove(k);
                     } 
                }
            }
        }
    }
    
    /*
     * Checks 3x3 Box, one at a time, starting with the upper-leftmost box, and iterating right.
     * Once it gets to the last 3x3 box on that row, then checks the next row down etc.
     * Changing the i and j changes between which coordinates to check.
     * @param i
     * @param j
     */
    
    private void checkBox(int i, int j) {
        if (i<3 && j<3) {
            for (int x = 0; x<3; x++) {
                for (int y = 0; y<3; y++) {
                    if (board.getValue(x, y) != ' ') {
                        for (int k =0; k < possibles[i][j].size(); k++) {
                            if (board.getValue(x, y) == possibles[i][j].get(k)) {
                                possibles[i][j].remove(k);
                            }
                        }
                    }
                }
            }
        }
        
        if ((i>2 && i<6) && j<3) {
            for (int x = 3; x<6; x++) {
                for (int y = 0; y<3; y++) {
                    if (board.getValue(x, y) != ' ') {
                        for (int k =0; k < possibles[i][j].size(); k++) {
                            if (board.getValue(x, y) == possibles[i][j].get(k)) {
                                possibles[i][j].remove(k);
                            }
                        }
                    }
                }
            }
        }
        
        if ((i>5 && i<9) && j<3) {
            for (int x = 6; x<9; x++) {
                for (int y = 0; y<3; y++) {
                    if (board.getValue(x, y) != ' ') {
                        for (int k =0; k < possibles[i][j].size(); k++) {
                            if (board.getValue(x, y) == possibles[i][j].get(k)) {
                                possibles[i][j].remove(k);
                            }
                        }
                    }
                }
            }
        }
        
        if (i<3 && (j>2 && j<6)) {
            for (int x = 0; x<3; x++) {
                for (int y = 3; y<6; y++) {
                    if (board.getValue(x, y) != ' ') {
                        for (int k =0; k < possibles[i][j].size(); k++) {
                            if (board.getValue(x, y) == possibles[i][j].get(k)) {
                                possibles[i][j].remove(k);
                            }
                        }
                    }
                }
            }
        }
        
        if ((i>2 && i<6) && (j>2 && j<6)) {
            for (int x = 3; x<6; x++) {
                for (int y = 3; y<6; y++) {
                    if (board.getValue(x, y) != ' ') {
                        for (int k =0; k < possibles[i][j].size(); k++) {
                            if (board.getValue(x, y) == possibles[i][j].get(k)) {
                                possibles[i][j].remove(k);
                            }
                        }
                    }
                }
            }
        }
        
        if ((i>5 && i<9) && (j>2 && j<6)) {
            for (int x = 6; x<9; x++) {
                for (int y = 3; y<6; y++) {
                    if (board.getValue(x, y) != ' ') {
                        for (int k =0; k < possibles[i][j].size(); k++) {
                            if (board.getValue(x, y) == possibles[i][j].get(k)) {
                                possibles[i][j].remove(k);
                            }
                        }
                    }
                }
            }
        }
        
        if (i<3 && (j>5 && j<9)) {
            for (int x = 0; x<3; x++) {
                for (int y = 6; y<9; y++) {
                    if (board.getValue(x, y) != ' ') {
                        for (int k =0; k < possibles[i][j].size(); k++) {
                            if (board.getValue(x, y) == possibles[i][j].get(k)) {
                                possibles[i][j].remove(k);
                            }
                        }
                    }
                }
            }
        }
        
        if ((i>2 && i<6) && (j>5 && j<9)) {
            for (int x = 3; x<6; x++) {
                for (int y = 6; y<9; y++) {
                    if (board.getValue(x, y) != ' ') {
                        for (int k =0; k < possibles[i][j].size(); k++) {
                            if (board.getValue(x, y) == possibles[i][j].get(k)) {
                                possibles[i][j].remove(k);
                            }
                        }
                    }
                }
            }
        }
        
        if ((i>5 && i<9) && (j>5 && j<9)) {
            for (int x = 6; x<9; x++) {
                for (int y = 6; y<9; y++) {
                    if (board.getValue(x, y) != ' ') {
                        for (int k =0; k < possibles[i][j].size(); k++) {
                            if (board.getValue(x, y) == possibles[i][j].get(k)) {
                                possibles[i][j].remove(k);
                            }
                        }
                    }
                }
            }
        }
    }
    
    
    /*
     * Brings all methods together
     */
    
    
    public void solve() {
        addCandidates();
        
        for (int j=0; j<9; j++) {
            for (int i=0; i<9; i++) {
                if (board.getValue(i, j) == ' ') {
                    checkCol(i,j);
                    checkRow(i,j);
                    checkBox(i,j);
                    if (possibles[i][j].size()==1) {
                         board.setValue(i, j, possibles[i][j].getFirst());
                    }
                }
            } 
            //  System.out.print("\n");
        }  
        // printCandidates(); //Uncommented, this prints out each box's possibilities whilst the solving algorithm runs.
        //System.out.print('\n');
        }
        
         
    //}
        
    /*
     * Checks to see if there are any empty squares left.
     * Not the best way to implement a loop so it keeps solving, as for ones it cannot solve it gets stuck in an infinite loop.
     * To combat this, create thread, so when method is called, the window can still be closed.
     */
    
    private boolean notComplete() {
        int k = 0;
    
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if(board.getValue(i, j) == ' ') {
                    k++;
            }
        }
    }
        if (k>0) {
            return true;
        }
        return false;
    }
    
    /*
     * Currently commented out, this is the method for returning which squares are blank, and what possibilities they contain.
     */
    
    private void printCandidates() {
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (board.getValue(i, j) == ' ') {
                    System.out.print(i + " " + j + ": " + possibles[i][j]);
                }
                 System.out.print('\n');
            }
            
        }
    }
    
    /*
     * Needed to implement runnable, so a thread can be created to help with infinite loops.
     * @Override
     */

    @Override
    public void run() {
        while (notComplete()){
            solve();
        }
        board.printValues();
    }
}