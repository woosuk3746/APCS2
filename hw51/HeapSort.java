/******************************************
 * Woosuk Lee                             *
 * APCS2 pd8                              *
 * HW51 -- Heaping Piles of Sordidness    *
 * 2018-5-21 M                            *
 * ****************************************
 * Class HeapSort                         *
 * Utilizes MinHeap to sort a given array *
 * Runtime: O(n log n)                    *
 ******************************************/
public class HeapSort{
    
    private static MinHeap _min = new MinHeap(); //instantiate a new MinHeap
    
    /****************************************
     * method sort(int[])
     * sorts an array using MinHeap
     * Big O: O(n log n)
     ****************************************/
    public static int[] sort(int[] arr){
        int[] retArr = new int[arr.length];
        for(int element: arr){
            _min.add(element); //heapify the given elements
        } // O(n)
        
        for(Integer i = 0; i < arr.length; i++){
            retArr[i] = _min.removeMin(); //add the heapified elements into the array
        } // O(log n) * n => O(n log n) *** removeMin takes O(log n), and it is done n times
        
        return retArr; //O(n + n log n) => O(n log n)
    }
    
    /****************************************
     * method printArr(int[])
     * prints an array
     * Big O: O(n)
     ****************************************/
    public static void printArr(int[] a){
        String s = "";
        for(int x: a){
            s += x + " ";
        }
        System.out.println(s);
    }
    
    public static void main( String[] args ){
        int[] a = {7,1,5,12,3}; //magic number
        System.out.print("array before heapsorting: "); // 7 1 5 12 3
        printArr(a);
        System.out.print("array after heapsorting: "); // 1 3 5 7 12
        printArr(sort(a));
    }
}//end class HeapSort
