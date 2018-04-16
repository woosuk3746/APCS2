/********************************************
 * Team Froggos -- Woosuk Lee and Eric Wong *
 * APCS2 -- pd8                             *
 * HW35 -- Nor Do Aussies                   *
 * 2018-4-16 T                              *
 ********************************************
 * class ALQueue                            *
 * Uses ArrayList to replicate queue        *
 * Implements interface Queue               *
 ********************************************/
 
import java.util.*;

public class ALQueue<Frog> implements Queue<Frog>{

    /*v****INSTANCE VARIABLES****v*/ 
    private ArrayList<Frog> _queue;
    private int _size;
    /*^****INSTANCE VARIABLES****^*/
    
    /*v*******CONSTRUCTOR************v*/
    public ALQueue(){
	_size = 0;
	_queue = new ArrayList<Frog>();
    }
    /*^*******CONSTRUCTOR************^*/
    
    /*v*******************METHODS*********************v*/    
    /***************************************************
     * method enqueue ( Frog x )                       *
     * Add at the back of the queue using method add() *
     * Runtime: O(1) *Adding at the back is constant*  *
     ***************************************************/
    public void enqueue(Frog x){
	_queue.add(x);
	_size++;
    }

    /***************************************************
     * method dequeue()                                *
     * Remove the element at the front of the queue    *
     * Runtime: O(n) *Shifting causes linear runtime   *
     ***************************************************/
    public Frog dequeue(){
	if(isEmpty()) throw new RuntimeException();
	Frog xd = _queue.get(0);
	_queue.remove(0);
	_size--;
	return xd;
    }
    
    public Frog peekFront(){
	return _queue.get(0);
    }

    public boolean isEmpty(){
	return _size == 0;
    }
    /*^*******************METHODS*********************^*/
}

    
