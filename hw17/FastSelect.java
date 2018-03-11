//Woosuk Lee
//APCS2 pd8
//hw17 -- So so fast
//3-12-2018

public class FastSelect{
    
    //helper method for swapping.
    public static void swap( int[] arr, int index1, int index2 ){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    
    //method to print the array. This is to compare how the array is changed after all the swappings.
    public static void printArr( int[] arr ){
        String retStr = "[";
        for(int i: arr){
            retStr += i + ",";
        }
        retStr += "\b]";
        System.out.println(retStr);
    }
    
    //paritioning
    public static int partition(int a, int b, int c, int[] arr){
        int v = arr[c];
        swap(arr,c,b);
        int s = a;
        for(int i = a; i < b; i++){
            if(arr[i] < v){
                swap(arr,s,i);
                s+=1;
            }
        }
        swap(arr,b,s);
        return s;
    }
    
    //find yth smallest number in an unsorted array
    /*
      The runtime of this algorithm is O(n lg n). The way this algorithm works is kind of like a binary search, which has a runtime of O(lg n), but each partition has a runtime of O(n). Multiplying the two runtimes would give O(n lg n).
    */
    public static int find(int y, int[] arr){
        int a = 0;
        int b = arr.length-1;
        int c = y-1;
        while(partition(a,b,c,arr) != y-1){
            if(partition(a,b,c,arr) > y-1){
                b = partition(a,b,c,arr);
                c = (a+b)/2;
            }
            else if( partition(a,b,c,arr) < y-1 ){
                a = partition(a,b,c,arr);
                c = (a+b+1)/2;
            }
        }
        return arr[c];
    }
    
    public static void main( String[] args){
        
        //example of O(n lg n), which is the "worst" case
        //the code will call the method partition lg n times.
        int[] a = {7,3,5,12,1,4,2};
        printArr(a);
        System.out.println(find(4,a));
        
        //example of O(n), the best case.
        //the code will terminate after calling the method partition once.
        int[] b = {1,8,2,3,9,11};
        printArr(b);
        System.out.println(find(1,b));        
    }
}