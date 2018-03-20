//Woosuk Lee
//APCS2 pd8
//HW21c -- Rockin' Through the Night
//2018-3-20
/*******************************************
 * class LList
 * Use class LLNodes to create a LinkedList
 *******************************************/

public class LList implements List{
    //instance variable
    private LLNode _list;
    private int size;
    
    //constructor
    public LList(){
        _list = new LLNode();
        size = 0;
    }
    
    //add node to list, containing input String as its data
    //add the elements in the FRONT
    public boolean add( String x ){
        _list = new LLNode(x,_list);
        size++;
        return true;
    } 

    //return data in element at position i
    public String get( int i ){
        if(i==0) return _list.getCargo();
        LLNode temp = _list.getNext();
        for(int k = 1; k < i; k++){
            temp= temp.getNext();            
        }
        return temp.getCargo();
    } 

    //overwrite data in element at position i
    public String set( int i, String x ){
        if(i==0){
            String retStr = _list.getCargo();
            _list = new LLNode(x,_list.getNext());
            return retStr;
        }
        
        String[] stuff = new String[i]; //holds all the items before index i  
        for(int k = 0; k < i; k++){ 
            stuff[k] = _list.getCargo();
            _list = _list.getNext();
        }
        
        String retStr = _list.getCargo(); //store the old value
        _list.setCargo(x); //replace to new value
        
        //add all the items back in the front
        for(int j = i-1; j >= 0; j--){
            _list = new LLNode(stuff[j],_list);
        }
        return retStr; //return the old value
        
        
    } 

    //return length of list
    public int size(){
        return size;
    }
    
    //toString
    public String toString(){
        String retStr = "[" + _list.getCargo();
        LLNode temp = _list.getNext();
        for(int i = 1; i < size; i++){
            retStr+= "," + temp.getCargo();
            temp = temp.getNext();
        }
        return retStr + "]";
    }
    
    public static void main( String[] args ){
        LList l = new LList();
        l.add("foo");
        l.add("moo");
        l.add("boo");
        l.add("goo");
        
        System.out.println(l);
        System.out.println(l.size());
        
        System.out.println("l.get(0): " + l.get(0)); //goo
        System.out.println("l.get(2): " + l.get(2)); //moo
        
        l.set( 3, "zoo" );
        System.out.println("l.set(3,\"zoo\"): " + l);
    }
}