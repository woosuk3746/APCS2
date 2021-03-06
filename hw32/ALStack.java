import java.util.ArrayList;
public class ALStack implements Stack<String>{
	private ArrayList _stack;
	private int _stackSize;

	public ALStack(){
		_stack = new ArrayList<String>();
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
