/*****************************************************
 * class DLLNode
 * Implements a doubly-linked node,
 * for use in lists and other collection classes.
 * Stores data of type String
 *****************************************************/
`
public class DLLNode 
{
    private String _cargo;    //cargo may only be of type String
    private DLLNode _nextNode, _prevNode; //pointers to next, prev DLLNodes
    
    //=====================CONSTRUCTOR=========================
    public DLLNode( String str, DLLNode before, DLLNode after ){
	_cargo = str;
	_prevNode = before;
	_nextNode = after;
    }
    //=========================================================

    //================ACCESSORS=====================
    public String getCargo() { return _cargo; }

    public DLLNode getFirst() { return _prevNode; }

    public DLLNode getNext() { return _nextNode; }
    //==============================================

    //================MUTATORS=======================
    public String setCargo( String newCargo ){
	String retStr = getCargo();
	_cargo = newCargo;
	return retStr;
    }
    //===============================================
}//end class DLLNode
