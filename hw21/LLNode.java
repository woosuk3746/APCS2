//Woosuk Lee
//APCS2 pd8
//HW21b -- We Got a Little Ol' Convoy...
//2018-3-20
/*****************************************************
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/

public class LLNode
{
    //instance vars
    private String cargo;
    private LLNode cdr;

    // constructors
    
    //default
    public LLNode(){
        cargo = null;
        cdr = null;
    }
    
    //overloaded #1
    public LLNode( String s ){
        cargo = s;
    }
    
    //overloaded #2
    public LLNode( String s, LLNode n ){
        cargo = s;
        cdr = n;
    }

    //--------------v  ACCESSORS  v--------------
    public String getCargo()
    {
        return cargo;
    }

    public LLNode getNext()
    {
        return cdr;
    }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo( String s )
    {
        String old = cargo;
        cargo = s;
        return old;        
    }

    public LLNode setNext( LLNode n )
    {
        LLNode old = cdr;
        cdr = n;
        return old;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString()
    {
        return cargo + "," + cdr;
    }


    //main method for testing
    public static void main( String[] args )
    {
	//PROTIP: try creating a few nodes: traversible, connected...
	//note anything notable as you develop and test...
        LLNode lol = new LLNode();
        System.out.println(lol);
        
        LLNode hi = new LLNode("moo");
        System.out.println("printing LLNode hi: " + hi);
        
        LLNode xd = new LLNode("foo",hi);
        System.out.println("printing LLNode xd: " + xd);
        System.out.println("** LLNode hi is the cdr of LLNode xd **");
        
        System.out.println("hi.getCargo(): " + hi.getCargo());
        System.out.println("xd.setCargo(\"boo\"): " + xd.setCargo("boo"));
        System.out.println("xd after setting cargo to boo: " + xd);
    }//end main

}//end class LLNode