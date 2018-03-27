/***********Generically typed version****************/
/*****************************************************
 * class DLLNode
 * Implements a doubly-linked node,
 * for use in lists and other collection classes.
 * Stores data of type String
 *****************************************************/
public class DLLNode<T>
{
    private T _cargo;    //cargo may only be of type String
    private DLLNode<T> _nextNode, _prevNode; //pointers to next, prev DLLNodes

    //=====================CONSTRUCTOR==========================
    public DLLNode( T str, DLLNode<T> before, DLLNode<T> after ){
        _cargo = str;
        _prevNode = before;
        _nextNode = after;
    }
    //==========================================================

    //================ACCESSORS=====================
    public T getCargo() { return _cargo; }

    public DLLNode<T> getPrev() { return _prevNode; }

    public DLLNode<T> getNext() { return _nextNode; }
    //==============================================

    //================MUTATORS==================
    public T setCargo( T newCargo ){
        T retStr = getCargo();
        _cargo = newCargo;
        return retStr;
    }

    public DLLNode<T> setPrev( DLLNode<T> newNode ) {
        DLLNode<T> retNode = getPrev();
        _prevNode = newNode;
        return retNode;
    }

    public DLLNode<T> setNext( DLLNode<T> newNode ) {
        DLLNode<T> retNode = getNext();
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
