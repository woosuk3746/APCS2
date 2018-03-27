//Woosuk Lee
//APCS2 pd8
//HW25 -- Generically Speaking...
//2018-3-26
/**************************************************************
 * class LList
 * Implements a linked list of DLLNodes, each containing T data
 * new in v4: The data is generically typed.
 **************************************************************/
public class LList<T> implements List<T> //your List interface must be in same dir
{
  //instance vars
  private DLLNode<T> _head;
  private DLLNode<T> _tail;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
      _head = null;
      _tail = null;
      _size = 0; //at birth, a list has no elements
  }

  //--------------v  List interface methods  v--------------

  public boolean add( T newVal )
  {

      if(_size==0){
          DLLNode<T> tmp = new DLLNode<T>( newVal, null, null);
          _head = tmp;
          _tail = tmp;
      }
      else{
          DLLNode<T> tmp = new DLLNode<T>( newVal, _tail, null);
          _tail.setNext(tmp);
          _tail = tmp;
      }
      _size++;
      return true;
  }


  public T get( int index ){
      if ( index < 0 || index >= size() )
	      throw new IndexOutOfBoundsException();


      DLLNode<T> tmp = _head; //create alias to head

      if(index == _size-1){tmp = _tail;}
      else{
      //walk to desired node
      for( int i=0; i < index; i++ )
              tmp = tmp.getNext();
      }
      //check target node's cargo hold
      T retVal = tmp.getCargo();

      return retVal;
  }


  public T set( int index, T newVal )
  {

      if ( index < 0 || index >= size() )
	      throw new IndexOutOfBoundsException();

      DLLNode<T> tmp;
      if(index == _size-1) {tmp = _tail;}
      else{
          tmp = _head; //create alias to head

          //walk to desired node
          for( int i=0; i < index; i++ )
              tmp = tmp.getNext();
      }
          //store target node's cargo
          T oldVal = tmp.getCargo();

          //modify target node's cargo
          tmp.setCargo( newVal );
      return oldVal;
  }


  //return number of nodes in list
  public int size() { return _size; }


  //insert a node containing newVal at position index
  public void add( int index, T newVal ) {

    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    DLLNode<T> newNode = new DLLNode<T>( newVal, null, null );


    if ( index == _size-1) {add( newVal ); return;}
    else if( index == 0 ) {
        DLLNode<T> tmp = _head;
        newNode.setNext(tmp);
        tmp.setPrev(newNode);
    }
    else {
	    DLLNode<T> tmp = _head;

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
  public T remove( int index ) {

      if ( index < 0 || index >= size() )
	      throw new IndexOutOfBoundsException();

      T retVal;
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
          DLLNode<T> tmp = _head; //create alias to head
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
    DLLNode<T> tmp = _head; //init tr
    while( tmp != null ) {
	    retStr +=  tmp.getCargo() + "->";
	    tmp = tmp.getNext();
    }
    retStr += "NULL";
    return retStr;
  }
  
}//end class LList
