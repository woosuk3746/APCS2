// Woosuk Lee
// APCS2 pd8
// HW46 -- Arrr, There Be Priorities Here Matey
// 2018-05-09

//Collaborated with LWong from pd 8
/*****************************************************
* class ArrayPriorityQueue
* An ArrayList based, prioritized queue
* Hold Strings and compares them
******************************************************/
import java.util.*;

public class ArrayPriorityQueue implements PriorityQueue{

  //container
  private ArrayList<String> _data;

  //constructor
  public ArrayPriorityQueue(){
    _data = new ArrayList<String>();
  }

  /**********************************************************
  * precondition:  given a String
  * postcondition: _data adds at the end
  * O(1) - independent of other elements
  **********************************************************/
  public void add(String str){
    _data.add(str);
  }

  /**********************************************************
  * precondition:  _data is not null
  * postcondition: returns true if size is 0, else return true
  * O(1) - independent of other elements
  **********************************************************/
  public boolean isEmpty(){
    return _data.size() == 0;
  }

  /**********************************************************
  * precondition:  _data.size() > 0
  * postcondition: returns the minimum string
  * O(n) - traverses through all elements using reign-of-champion
  **********************************************************/
  public String peekMin(){
    String min = _data.get(0);
    for (int index = 1; index < _data.size(); index++){
      if ( _data.get(index).compareTo(min) < 0){
        min = _data.get(index);
      }
    }
    return min;
  }

  /**********************************************************
  * precondition:  _data.size() > 0
  * postcondition: removes the minimum string and returns the minimum string
  * O(n) - traverses through all elements using reign-of-champion
  **********************************************************/
  public String removeMin(){
    String min = _data.get(0);
    int indexMin = 0;

    for (int index = 1; index < _data.size(); index++){
      if ( _data.get(index).compareTo(min) < 0){
        min = _data.get(index);
        indexMin = index;
      }
    }
    _data.remove(indexMin);
    return min;

  }

  public static void main(String[] XD){
    ArrayPriorityQueue test = new ArrayPriorityQueue();

    test.add("foo");
    test.add("moo");
    test.add("goo");
    test.add("boo");

    System.out.println(test.peekMin());
    test.removeMin();

    System.out.println(test.peekMin());
    test.removeMin();

    System.out.println(test.peekMin());
    test.removeMin();

    System.out.println(test.peekMin());
    test.removeMin();

  }
}
