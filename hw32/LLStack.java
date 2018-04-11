//Woosuk Lee
//APCS2 pd8
//HW32 -- Leon Leonwood Stack
//2018-04-12 R
import java.util.*;

public class LLStack implements Stack<String> 
{
    private LinkedList<String> _stack;
    private int _stackSize;

    public LLStack(){
		_stack = new LinkedList<String>();
		_stackSize = 0;
	}

	public boolean isEmpty() { return _stackSize == 0; }

	public String peek(){
		if(!isEmpty()) return (String) _stack.get(_stackSize-1);
		return null;
	}

	public String pop(){
		_stackSize--;
		return (String) _stack.remove(_stackSize);
	}

	public void push(String s){
		_stack.add(s);
		_stackSize++;
	}
}