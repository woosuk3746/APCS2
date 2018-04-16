/********************************************
 * Team Froggos -- Woosuk Lee and Eric Wong *
 * APCS2 -- pd8                             *
 * HW35 --                                  *
 * 2018-4-16 T                              *
 ********************************************/

import java.util.*;

public class ALQueue<Frog> implements Queue<Frog>{

    //instance vars
    private ArrayList<Frog> _queue;
    private int _size;

    //constructor
    public ALQueue(){
	_size = 0;
	_queue = new ArrayList<Frog>;
    }
    
    //methods
    public void enqueue(Frog x){
	_queue.add(x);
	_size++;
    }

    public Frog dequeue(){
	Frog xd = _queue.get(0);
	_queue.remove(0);
	_size--;
	return xd;
    }
    
    public Frog peek(){
	return _queue.get(0);
    }

    public boolean isEmpty(){
	return _size == 0;
    }
    
}
