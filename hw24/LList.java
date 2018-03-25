//Woosuk Lee
//APCS2 pd8
//HW24b -- On the DLL
//2018-3-25
/*****************************************************
 * class LList
 * Implements a linked list of DLLNodes, each containing String data
 * new in v3: uses DLLNode.java
 *****************************************************/
public class LList implements List //your List interface must be in same dir
{
  //instance vars
  private DLLNode _head;
  private DLLNode _tail;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
      _head = null;
      _tail = null;
      _size = 0; //at birth, a list has no elements
  }

  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {

      if(_size==0){
          DLLNode tmp = new DLLNode( newVal, null, null);
          _head = tmp;
          _tail = tmp;
      }
      else{
          DLLNode tmp = new DLLNode( newVal, _tail, null);
          _tail.setNext(tmp);
          _tail = tmp;
      }
      _size++;
      return true;
  }


  public String get( int index ){
      if ( index < 0 || index >= size() )
	      throw new IndexOutOfBoundsException();


      DLLNode tmp = _head; //create alias to head

      if(index == _size-1){tmp = _tail;}
      else{
      //walk to desired node
      for( int i=0; i < index; i++ )
              tmp = tmp.getNext();
      }
      //check target node's cargo hold
      String retVal = tmp.getCargo();

      return retVal;
  }


  public String set( int index, String newVal )
  {

      if ( index < 0 || index >= size() )
	      throw new IndexOutOfBoundsException();

      DLLNode tmp;
      if(index == _size-1) {tmp = _tail;}
      else{
          tmp = _head; //create alias to head

          //walk to desired node
          for( int i=0; i < index; i++ )
              tmp = tmp.getNext();
      }
          //store target node's cargo
          String oldVal = tmp.getCargo();

          //modify target node's cargo
          tmp.setCargo( newVal );
      return oldVal;
  }


  //return number of nodes in list
  public int size() { return _size; }


  //insert a node containing newVal at position index
  public void add( int index, String newVal ) {

    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    DLLNode newNode = new DLLNode( newVal, null, null );


    if ( index == _size-1) {add( newVal ); return;}
    else if( index == 0 ) {
        DLLNode tmp = _head;
        newNode.setNext(tmp);
        tmp.setPrev(newNode);
    }
    else {
	    DLLNode tmp = _head;

	    //walk to node before desired node
	    for( int i=0; i < index-1; i++ )
            tmp = tmp.getNext();


      //insert
      newNode.setNext( tmp.getNext());
      newNode.setPrev(tmp);
      tmp.getNext().setPrev(newNode);
      tmp.setNext(newNode);
    }
      //increment size attribute
	  _size++;

  }


  //remove node at pos index, return its cargo
  public String remove( int index ) {

      if ( index < 0 || index >= size() )
	      throw new IndexOutOfBoundsException();

      String retVal;
      if(_size == 0 ){
          _head = null;
          _tail = null;
          retVal = null;
      }

      //if index==0, remove head node
      if ( index == 0 ) {
	      //check target node's cargo hold
	      retVal = _head.getCargo();

	      //remove target node
	      _head = _head.getNext();
      }
      else if( index == _size-1 ){
          retVal = _tail.getCargo();
          _tail = _tail.getPrev();
      }
      else {
          DLLNode tmp = _head; //create alias to head
          //walk to node before desired node
	    for( int i=0; i < index-1; i++ ){
            tmp = tmp.getNext();
        }

	      //check target node's cargo hold
	      retVal = tmp.getNext().getCargo();
          tmp.setNext( tmp.getNext().getNext() );
          tmp.getNext().setPrev(tmp);
      }

      //decrement size attribute
      _size--;

      return retVal;
  }

  //--------------^  List interface methods  ^--------------


  // override inherited toString
  public String toString()
  {
    String retStr = "NULL->";
    DLLNode tmp = _head; //init tr
    while( tmp != null ) {
	    retStr +=  tmp.getCargo() + "->";
	    tmp = tmp.getNext();
    }
    retStr += "NULL";
    return retStr;
  }
  
}//end class LList
