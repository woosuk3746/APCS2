//Team Soup Nazis - Woosuk Lee and Jackie Li
//APCS2 pd8
//HW36 -- Now Let's Consider You Lot at Fake Terry's
//2018-04-18 W
/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 ******************************************************/


public class RQueue<T> implements Queue<T>
{
  //instance variables
  private LLNode<T> _front, _end;
  private int _size;


  // default constructor creates an empty queue
  public RQueue() 
	{
	    _front = new LLNode<T>(null,_end);
	    _size=0;
	}//end default constructor


  public void enqueue( T enQVal ) 
  {
        if(_size == 0){
            _front.setValue(enQVal);
            _size++;
        }
        else if( _size == 1 ){
            LLNode<T> temp = new LLNode<T>(enQVal,null);
            _front.setNext(temp);
            _end = temp;
            _size++;
        }
        else{
            LLNode<T> temp = new LLNode<T>(enQVal,null);
            _end.setNext(temp);
            _end = temp;
            _size++;
        }
    }//end enqueue()


  // remove and return thing at front of queue
  // assume _queue ! empty
  public T dequeue() 
  {
        sample();
        T x = _front.getValue();
        if(_size==1) _front.setValue(null);
        else _front = _front.getNext();
        _size--;
        return x;
      
  }//end dequeue()

  public T dequeueNoRand(){
        T x = _front.getValue();
        if(_size==1) _front.setValue(null);
        else _front = _front.getNext();
        _size--;
        return x;
      
  }

  public T peekFront() 
  {
      return _front.getValue();
  }


  /******************************************
   * void sample() -- a means of "shuffling" the queue
   * Algo:
   * ...
   * 
   ******************************************/
  public void sample () {
        int rand = (int) Math.random() * _size;
        while (rand > 0 ) {
                enqueue(dequeueNoRand());
                rand--;
            }
}//end sample()


  public boolean isEmpty() 
  {
    return _size==0;
  } //O(?)
  

    // print each node, separated by spaces
  public String toString() 
  { 
    LLNode<T> temp = _front;
    String s = "";
    for(int i = 0; i < _size; i++){
        s += temp.getValue() + " ";
        temp = temp.getNext();
    }
    return s.substring(0,s.length()-1);
  }//end toString()



  //main method for testing
  public static void main( String[] args )
  {
    

      Queue<String> PirateQueue = new RQueue<String>();

      System.out.println("\nnow enqueuing..."); 
      PirateQueue.enqueue("Dread");
      PirateQueue.enqueue("Pirate");
      PirateQueue.enqueue("Robert");
      PirateQueue.enqueue("Blackbeard");
      PirateQueue.enqueue("Peter");
      PirateQueue.enqueue("Stuyvesant");
      
      
      
      System.out.println("\nnow testing toString()..."); 
      System.out.println( PirateQueue ); //for testing toString()...

      System.out.println("\nnow dequeuing..."); 
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );

      System.out.println("\nnow dequeuing fr empty queue..."); 
      System.out.println( PirateQueue.dequeue() );
      /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main

}//end class RQueue
