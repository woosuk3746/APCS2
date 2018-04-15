/********************************************
 * Woosuk Lee                               *
 * APCS2 pd 8                               *
 * HW 34 -- The English Do Not Wait In Line *
 * 2018-04-16 M                             *
 ********************************************
 * class NodeQueue                          *
 * Uses LLNode to replicate LILO/FIFO queue *
 * Implements Interface Queue               *
 ********************************************/

public class NodeQueue<Quasar> implements Queue<Quasar>{
    
    //inst vars
    private LLNode<Quasar> _head; //keeps track of the first element for peekFront()
    private LLNode<Quasar> _tail; //keeps track of the last element for enqueue()
    private int _size;
    
    //constructor
    public NodeQueue(){
        _head = new LLNode<Quasar>(null,null);
        _head.setNext(_tail);
        _size = 0;
    }
    
    //means of removing an element from collection:
    //Dequeues and returns the first element of the queue.
    public Quasar dequeue(){
        
        Quasar x = _head.getValue();
        if(_size==1) _head.setValue(null);
        else _head = _head.getNext();
        _size--;
        return x;
    }

    //means of adding an element to collection:
    //Enqueue an element onto the back of this queue.
    public void enqueue( Quasar x ){
        if(_size == 0){
            _head.setValue(x);
            _size++;
        }
        else if( _size == 1 ){
            LLNode<Quasar> temp = new LLNode<Quasar>(x,null);
            _head.setNext(temp);
            _tail = temp;
            _size++;
        }
        else{
            LLNode<Quasar> temp = new LLNode<Quasar>(x,null);
            _tail.setNext(temp);
            _tail = temp;
            _size++;
        }
    }

    //Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty(){
        return _size == 0;
    }

    //Returns the first element of the queue without dequeuing it.
    public Quasar peekFront(){
        return _head.getValue();
    }
    
    //main method for testing
    public static void main( String[] args ){
        
        System.out.println("Creating NodeQueue n...");
        NodeQueue<String> n = new NodeQueue<String>();
        System.out.println("Is n empty?: " + n.isEmpty()); //true
        
        System.out.println("Enqueuing \"hello\" to NodeQueue n...");
        n.enqueue("hello");
        System.out.println("The front of the queue is: " + n.peekFront()); //hello
        
        System.out.println("Enqueuing \"hi\" to NodeQueue n...");
        n.enqueue("hi");
        System.out.println("The front of the queue is: " + n.peekFront()); //hello
        
        System.out.println("Enqueuing \"bye\" to NodeQueue n...");
        n.enqueue("bye");
        System.out.println("The front of the queue is: " + n.peekFront()); //hello
        
        System.out.println("Dequeuing the first element...");
        n.dequeue();
        System.out.println("The front of the queue is: " + n.peekFront()); //hi
        
        System.out.println("Dequeuing the first element...");
        n.dequeue();
        System.out.println("The front of the queue is: " + n.peekFront()); //bye
        
        System.out.println("Dequeuing the first element...");
        n.dequeue();
        System.out.println("The front of the queue is: " + n.peekFront()); //null
        
        System.out.println("Is n empty?: " + n.isEmpty()); //true
        
        System.out.println("Enqueuing \"hola\" to NodeQueue n...");
        n.enqueue("hola");
        System.out.println("The front of the queue is: " + n.peekFront()); //hola
    }
}