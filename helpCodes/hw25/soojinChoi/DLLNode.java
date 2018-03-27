/*****************************************************
 * class DLLNode
 * Implements a doubly-linked node,
 * for use in lists and other collection classes.
 * Stores data of type String
 *****************************************************/

public class DLLNode<T>
{
  private T _cargo;    //cargo may only be of type String
  private DLLNode<T> _nextNode, _prevNode; //pointers to next, prev DLLNodes

  public DLLNode(DLLNode<T> newPrev, T newCar, DLLNode<T> newNext){
    _cargo = newCar;
    _nextNode = newNext;
    _prevNode = newPrev;
  }
  //Accessors
  public T getCargo(){
    return _cargo;
  }
  public DLLNode<T> getNext(){
    return _nextNode;
  }
  public DLLNode<T> getPrev(){
    return _prevNode;
  }
  //Mutators
  public T setCargo(T newCargo){
    T temp = getCargo();
    _cargo = newCargo;
    return temp;
  }
  public DLLNode<T> setNext(DLLNode<T> newNext){
    DLLNode<T> temp = getNext();
    _nextNode = newNext;
    //newNext.setPrev(this);
    return temp;
  }
  public DLLNode<T> setPrev(DLLNode<T> newPrev){
    DLLNode<T> temp = getPrev();
    _prevNode = newPrev;
    //newPrev.setNext(this);
    return temp;
  }
  public String toString(){
    return _cargo.toString();
  }

}//end class DLLNode
