//Soojin Choi
//APCS2 pd08
//HW24b -- On the DLL
//2018-03-25
public class LList<T> implements List<T>{
  private DLLNode<T> _head;
  private DLLNode<T> _tail;
  int size;
  public LList(){
    _head = null;
    _tail = null;
    size = 0;
  }
  public boolean add (T x){
    DLLNode<T> holder = new DLLNode<T>(_tail , x, null);
    if (size() == 0){
      _head = holder;
      _tail = holder;
    }
    else{
      _tail.setNext(holder);
      _tail = holder;
    }
    size++;
    return true;
  }
  public void add(int i, T s){
    if(i < 0 || i >= size()){
      throw new IndexOutOfBoundsException();
    }
    DLLNode<T> tmp;
    DLLNode<T> temp = _head;
    for (int b = 1; b < i; b++){
      temp = temp.getNext();
    }
    DLLNode<T> holder = temp.getNext();
    tmp = new DLLNode<T>(temp, s, holder);
    temp.setNext(tmp);
    holder.setPrev(tmp);
    size++;
  }
  public T remove (int i){
    if(i < 0 || i >= size()){
      throw new IndexOutOfBoundsException();
    }
    T oldVal;
    DLLNode<T> temp;
    if (i == 0){
      oldVal = _head.getCargo();
      DLLNode<T> holder = _head.getPrev();
      _head = _head.getNext();
      size--;
      return oldVal;
    }
    if (i == size() - 1){
      oldVal = _tail.getCargo();
      DLLNode<T> holder = _tail.getNext();
      _tail = _tail.getPrev();
      _tail.setNext(holder);
      size--;
      return oldVal;
    }
    if (i <= (size()/2)){
      temp = _head;
      for (int b = 0; b < i; b++){
        temp = temp.getNext();
      }
    }
    else{
      temp = _tail;
      for (int c = size() - 1; c > i; c--){
        temp = temp.getPrev();
      }
    }
    DLLNode<T> holder = temp.getNext();
    oldVal = temp.getCargo();
    holder.setPrev(temp.getPrev());
    temp.getPrev().setNext(holder);
    size--;
    return oldVal;

  }
  public T get( int i){
    if(i < 0 || i >= size()){
      throw new IndexOutOfBoundsException();
    }
    DLLNode<T> temp;
    if (i <= (size() / 2)){
      temp = _head;
      for (int jk = 0; jk < i; jk++){
        temp = temp.getNext();
      }
    }
    else{
      temp = _tail;
      for (int j = size(); j > i; j--){
        temp = temp.getPrev();
      }
    }
    return temp.getCargo();
  }
  public T set(int i, T x){
    if(i < 0 || i >= size()){
      throw new IndexOutOfBoundsException();
    }
    DLLNode<T> holder;
    if (i <= (size() / 2)){
      holder = _head;
      for (int jk = 0; jk < i; jk++){
        holder = holder.getNext();
      }
    }
    else{
      holder = _tail;
      for (int j = size(); j > i; j--){
        holder = holder.getPrev();
      }
    }
    T oldVal = holder.getCargo();
    holder.setCargo( x );
    return oldVal;
  }
  public int size(){
    return size;
  }
  public String toString(){
    String retStr = "HEAD->";
    DLLNode<T> tmp = _head; //init tr
    while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
    }
    retStr += "NULL";
    return retStr;
  }
}
