/*************************************************************
 * Woosuk Lee                                                *
 * APCS2 pd8                                                 *
 * HW #30 -- Tasty Latkes                                    *
 * 2018-4-10                                                 *
 *************************************************************
 * skeleton for class Latkes                                 *
 * Implements a stack of Strings using an encapsulated array *
 *************************************************************/

public class Latkes
{
  private String [] _stack;
  private int _stackSize;

  //constructor
  public Latkes( int size )
  {
      _stack = new String[size];
      _stackSize = 0;
  }

  //means of insertion
  public void push( String s )
  {
      if(isFull()) return;
      else{
        _stack[_stackSize] = s;
        _stackSize++;
      }
      
  }

  //means of removal
  public String pop()
  {
      if(isEmpty()) return null;
      String retStr = _stack[_stackSize-1];
      _stack[_stackSize-1] = null;
      _stackSize--;
      return retStr;
  }

  //chk for emptiness
  public boolean isEmpty()
  {
      return _stack[0] == null;
  }

  //chk for fullness
  public boolean isFull()
  {
      return _stack[_stack.length-1] != null;
  }


  //main method for testing
  public static void main( String[] args )
  {
    
      Latkes tastyStack = new Latkes(10);

      tastyStack.push("aoo");
      tastyStack.push("boo");
      tastyStack.push("coo");
      tastyStack.push("doo");
      tastyStack.push("eoo");
      tastyStack.push("foo");
      tastyStack.push("goo");
      tastyStack.push("hoo");
      tastyStack.push("ioo");
      tastyStack.push("joo");
      tastyStack.push("coocoo");
      tastyStack.push("cachoo");

      //cachoo
      System.out.println( tastyStack.pop() );
      //coocoo
      System.out.println( tastyStack.pop() );
      //joo
      System.out.println( tastyStack.pop() );
      //ioo
      System.out.println( tastyStack.pop() );
      //hoo
      System.out.println( tastyStack.pop() );
      //goo
      System.out.println( tastyStack.pop() );
      //foo
      System.out.println( tastyStack.pop() );
      //eoo
      System.out.println( tastyStack.pop() );
      //doo
      System.out.println( tastyStack.pop() );
      //coo
      System.out.println( tastyStack.pop() );
      //boo
      System.out.println( tastyStack.pop() );
      //aoo
      System.out.println( tastyStack.pop() );

      //stack empty by now; SOP(null)
      System.out.println( tastyStack.pop() );
      
  }//end main()

}//end class Latkes
