/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 * 
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Steal underpants.
 *   2. ...
 *   5. Profit!
 *
 * STACK OF CHOICE: ____ by ____
 * b/c ...
 ******************************************************/

import java.util.Stack;

public class Scheme{
    
    /****************************************************** 
    * precond:  Assumes expr is a valid Scheme (prefix) expression,
    *           with whitespace separating all operators, parens, and 
    *           integer operands.
    * postcond: Returns the simplified value of the expression, as a String
    * eg,
    *           evaluate( "( + 4 3 )" ) -> 7
    *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
    ******************************************************/
    public static String evaluate( String expr ) {
        String[] arr = expr.split( "\\s+" );
        Stack<String> latkes = new Stack();
        for (int i = arr.length-1; i > 0; i --){
            System.out.println( arr[i] );
            latkes.push( arr[i] );
        }
        String op = latkes.pop();
        if ( op.equals("+") ) return unload(1, latkes);
        if ( op.equals("-") ) return unload(2, latkes);
        if ( op.equals("*") ) return unload(3, latkes);
        return null;
    }//end evaluate()


    /****************************************************** 
    * precond:  Assumes top of input stack is a number.
    * postcond: Performs op on nums until closing paren is seen thru peek().
    *           Returns the result of operating on sequence of operands.
    *           Ops: + is 1, - is 2, * is 3
    ******************************************************/
    public static String unload( int op, Stack<String> numbers ) {
        int result = 0;
        int subResult = 0;
        String current, nextOp;
        
        current = numbers.pop();
        if ( current.equals("(") ) {
            nextOp = numbers.pop();
            if ( nextOp.equals("+") )
                result = Integer.parseInt( unload(1, numbers) );
            if ( nextOp.equals("-") )
                result = Integer.parseInt( unload(2, numbers) );
            if ( nextOp.equals("*") )
                result = Integer.parseInt( unload(3, numbers) );
        } else result = Integer.parseInt( current );
    
        while ( ! numbers.peek().equals(")") ){
            current = numbers.pop();
            if ( current.equals("(") ){
                nextOp = numbers.pop();
                if ( nextOp.equals("+") )
                    subResult = Integer.parseInt( unload(1, numbers) );
                if ( nextOp.equals("-") )
                    subResult = Integer.parseInt( unload(2, numbers) );
                if ( nextOp.equals("*") )
                    subResult = Integer.parseInt( unload(3, numbers) );
                if ( op == 1 ) result += subResult;
                if ( op == 2 ) result -= subResult;
                if ( op == 3 ) result *= subResult;
            } else {
                if ( op == 1 ) result += Integer.parseInt( current );
                if ( op == 2 ) result -= Integer.parseInt( current );
                if ( op == 3 ) result *= Integer.parseInt( current );
            }
        }
        numbers.pop();
        return Integer.toString( result );
    }//end unload()


    /*
    //optional check-to-see-if-its-a-number helper fxn:
    public static boolean isNumber( String s ) {
    try {
    Integer.parseInt(s);
    return true;
	}
    catch( NumberFormatException e ) {
    return false;
	}
    }
    */


    //main method for testing
    public static void main( String[] args ) {

    
      String zoo1 = "( + 4 3 )";
      System.out.println(zoo1);
      System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
      //...7

      String zoo2 = "( + 4 ( * 2 5 ) 3 )";
      System.out.println(zoo2);
      System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
      //...17

      String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
      System.out.println(zoo3);
      System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
      //...29

      String zoo4 = "( - 1 2 3 )";
      System.out.println(zoo4);
      System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
      //...-4
      /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
    }//main

}//end class Scheme
