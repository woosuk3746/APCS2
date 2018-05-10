public interface PriorityQueue{
  
  //adds the new element
  public void add(String obj);
    
  //checks for emptiness
  public boolean isEmpty();

  //peek the minimum value
  public String peekMin();
  
  //remove the minimum value
  public String removeMin();
}
