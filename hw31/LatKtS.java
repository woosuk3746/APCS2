/*****************************************************
 * skeleton for class LatKtS
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/


public class LatKtS
{

  /**********************************************************
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **********************************************************/
  public static String flip( String s )
  {
	Latkes x = new Latkes(s.length());
	for(int i=s.length()-1; i>=0;i--){
		x.push(s.substring(i,i+1));
	}
	String retStr = "";
	while(!x.isEmpty()){
		retStr = retStr + x.pop();
	}
	return retStr;
  }//end flip()


  /**********************************************************
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **********************************************************/
  public static boolean allMatched( String s )
  {
	Latkes x = new Latkes(s.length()/2);
	String left, right;
	for(int i = 0; i<s.length(); i++){
		right = s.substring(i,i+1);
		if(x.isEmpty()) x.push(right);
		else{
			left = x.pop();
			if(!(left.equals("{") && right.equals("}") ||
			     left.equals("(") && right.equals(")") ||
			     left.equals("[") && right.equals("]") )){
				x.push(left);
				if( x.isFull() ) return false;
				x.push(right);
			}
		}
	}
	return x.isEmpty();
	
  }//end allMatched()


  //main method to test
  public static void main( String[] args )
  {
    
    System.out.println(flip("stressed"));

    System.out.println(allMatched( "({}[()])" )); //true
    System.out.println(allMatched( "([)]" ) ); //false
    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
      /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }

}//end class LatKtS
