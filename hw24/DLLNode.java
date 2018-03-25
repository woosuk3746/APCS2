//Woosuk Lee
//APCS2 pd8
//HW24a -- On the DLL
//2018-3-25
/*****************************************************
 * class DLLNode
 * Implements a doubly-linked node,
 * for use in lists and other collection classes.
 * Stores data of type String
 *****************************************************/
public class DLLNode
{
    private String _cargo;    //cargo may only be of type String
    private DLLNode _nextNode, _prevNode; //pointers to next, prev DLLNodes

    //=====================CONSTRUCTOR==========================
    public DLLNode( String str, DLLNode before, DLLNode after ){
        _cargo = str;
        _prevNode = before;
        _nextNode = after;
    }
    //==========================================================

    //================ACCESSORS=====================
    public String getCargo() { return _cargo; }

    public DLLNode getPrev() { return _prevNode; }

    public DLLNode getNext() { return _nextNode; }
    //==============================================

    //================MUTATORS==================
    public String setCargo( String newCargo ){
        String retStr = getCargo();
        _cargo = newCargo;
        return retStr;
    }

    public DLLNode setPrev( DLLNode newNode ) {
        DLLNode retNode = getPrev();
        _prevNode = newNode;
        return retNode;
    }

    public DLLNode setNext( DLLNode newNode ) {
        DLLNode retNode = getNext();
        _nextNode = newNode;
        return retNode;
    }
    //==========================================

    //toString method
    public String toString(){ return _cargo.toString(); }

    //main method for testing
    public static void main( String[] args ){
        DLLNode woo = new DLLNode("foo",null,null);
        System.out.println( woo );

        DLLNode boo = new DLLNode("moo",null,woo);
        System.out.println( boo );
    }

}//end class DLLNode
