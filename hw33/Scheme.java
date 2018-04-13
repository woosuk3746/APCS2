//Woosuk Lee
//APCS2 pd8
//Hw33 -- What a Racket
//2018-04-13
/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 * 
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Steal underpants.
 *   2. Check the operation at the front
 *   3. Pop the numbers and perform that operation
 *   4. If there is an open parentheses, repeat 2 and 3 recursively
 *   5. Profit!
 *
 * STACK OF CHOICE: ALStack by Woosuk Lee
 * There does not seem to be any difference between ALStack and LLStack, and I just decided to use ALStack.
 ******************************************************/

public class Scheme
{
  /****************************************************** 
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and 
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	       evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   ******************************************************/
  public static String evaluate( String expr ) 
  {
      String[] temp = expr.split("\\s+");
      Stack<String> s = new ALStack<String>();
      for(int i = temp.length-1; i > 0;i--){
          s.push(temp[i]);          
      }
      String op = s.pop();
      if(op.equals("+")){
          return unload(1,s);
      }
      if(op.equals("*")){
          return unload(3,s);
      }
      if(op.equals("-")){
          return unload(2,s);
      }
      return null;
  }//end evaluate()


  /****************************************************** 
   * precond:  Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek().
   *           Returns the result of operating on sequence of operands.
   *           Ops: + is 1, - is 2, * is 3
   ******************************************************/
  public static String unload( int op, Stack<String> numbers ) 
  {
      //code quote creds: Willam Lu
      //algo was clearly explained
      //procedure done recursively...
      int result = 0;
      int subResult = 0;
      String current, nextOp;
        
      current = numbers.pop();
      if ( current.equals("(") ) {
          nextOp = numbers.pop();
          if ( nextOp.equals("+") ) result = Integer.parseInt( unload(1, numbers) );
            if ( nextOp.equals("-") ) result = Integer.parseInt( unload(2, numbers) );
            if ( nextOp.equals("*") ) result = Integer.parseInt( unload(3, numbers) );
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
  
  //main method for testing
  public static void main( String[] args )
  {   
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
