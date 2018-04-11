/*****************************************************
 * class Stckr
 * driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 *****************************************************/

public class Stckr 
{
    public static void main( String[] args )
    {
	/*
	Stack cakes = new ALStack();
	cakes.push("hi");
	cakes.push("boo");
	System.out.println(cakes.peek());
	*/
	Stack cakes = new LLStack();
	cakes.push("hi");
	cakes.push("boo");
	System.out.println(cakes.peek());
	//...
	
    }//end main

}//end class

