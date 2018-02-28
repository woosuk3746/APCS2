/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 */
/*
 Woosuk Lee
 APCS2 pd8
 HW10 --  [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
 2018-02-28
*/

public class QueenBoard
{
  private int[][] _board;
    
  public QueenBoard( int size ) 
  {
    _board = new int[size][size];
  }

  
  /***
   * precondition: board is filled with 0's only.
   * postcondition: 
   * If a solution is found, board shows position of N queens, 
   * returns true.
   * If no solution, board is filled with 0's, 
   * returns false.
   */
  public boolean solve()
  {
      int r = 1;
      int c = 0;
      while(r < _board.length && c < _board.length){
          addQueen(r,c);
          r+=2;
          c+=1;
      }
      for(int i = 0; i < _board.length; i++){
          solveH(i);
      }
      
      return false;
  }

  
  /**
   *Helper method for solve. 
   */
  private boolean solveH( int col ) 
  {
    
    for (int i = 0; i < _board.length; i++){
	   if (_board[i][col] == 0)
           return addQueen(i,col);
	    
	}
    return false;
  }


  public void printSolution()
  {
    /** Print board, a la toString...
        Except:
        all negs and 0's replaced with underscore
        all 1's replaced with 'Q'
    */
    String retStr = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		if (_board[r][c] <= 0){
		    ans += "_";
		}
		if (_board[r][c] == 1){
		    ans += "Q";
		}
		ans += "\t";
	    }
	    ans += "\n";
	}
	System.out.println(retStr);
  }



  //================= YE OLDE SEPARATOR =================

  /***
   * <General description>
   * precondition: A valid QueenBoard with at least one spot == 0
   * postcondition: All queen's potential target marked
   */
  private boolean addQueen(int row, int col){
    if(_board[row][col] != 0){
	    return false; //cannot place queen because a queen is there or within the target
    }
    _board[row][col] = 1; //place the queen
      
    /***
    Everything hereafter is for marking the queen targets
    ***/
    int offset = 1; //counter to keep track of the row/column for marking the target
    while(col+offset < _board[row].length){
	    _board[row][col+offset]--; //mark off the rows and columns
	    if(row - offset >= 0){
        _board[row-offset][col+offset]--; //mark off the diagonals (only the lower-right)
	    }
	    if(row + offset < _board.length){
        _board[row+offset][col+offset]--;
	    }
	    offset++;
    }
    return true;
  }


  /***
   * <General description>
   * precondition: A valid QueenBoard with at least one queen == 1
   * postcondition: queen potential target removed
   */
  private boolean removeQueen(int row, int col){
    if ( _board[row][col] != 1 ) {
	    return false; //if there's nothing, just stop the code
    }
    _board[row][col] = 0; //remove it (make it 1)
    int offset = 1; 

    // same mechanism as addQueen, but just increment instead of decrement
    while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
        _board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
        _board[row+offset][col+offset]++;
	    }
	    offset++;
    }
    return true;
  }


  /***
   * <General description>
   * precondition: a valid QueenBoard given
   * postcondition: print the state of the board
   */
  public String toString() 
  {
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
        ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
    }
    return ans;
  }


  //main method for testing...
  public static void main( String[] args )
  {
    QueenBoard b = new QueenBoard(5);
    System.out.println(b);
    b.addQueen(3,0);
    b.addQueen(0,1);
    System.out.println(b);
    b.removeQueen(3,0);
    System.out.println(b);
  }
    
}//end class
