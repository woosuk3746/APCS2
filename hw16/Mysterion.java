//Woosuk Lee
//APCS2 pd8
//HW16 -- About Face
//2018-03-08

public class Mysterion{
	/*
	(a = 0, b = 4, c = 2)

	function Mysterion(a, b, c, arr)
   		v = arr[c]
   		swap arr[c], arr[b]
   		s = a
   		for i in [a ... b-1]
      			if arr[i] < v
         			swap arr[s], arr[i]
         			s += 1
   		swap arr[b], arr[s]
   		return s
	*/
    
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
    
    //the MysTeRiOn
    /*
     The name I would give this function is subarrayIndexFinder.
     a => lower bound (low)
     b => upper bound (high)
     c => the index of the number to insert within subarray from index a to b (insert)
     Essentially, the code treats all the numbers from index a to b as a subarray and checks to see where arr[c] would fit within that subarray. In the end, it will return the proper index in relation to the entire given array. 
    */
    public static int mysterion(int a, int b, int c, int[] arr){
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
    
    public static void main( String[] args){
        //stuff done in class
        int[] arr = {7,1,5,12,3}; //magic number
        System.out.print("arr before Mysterion: "); printArr(arr);
        System.out.println("mysterion(0,4,2,arr) returns: " + mysterion(0,4,2,arr));
        System.out.print("arr after Mysterion: "); printArr(arr);
        
        System.out.println("\n");
        
        int[] arr1 = {7,1,5,12,3};
        System.out.print("arr 1 before Mysterion: "); printArr(arr1);
        System.out.println("mysterion(1,4,2,arr1) returns: " + mysterion(1,4,2,arr1));
        System.out.print("arr1 after Mysterion: "); printArr(arr1);
        
        System.out.println("\n");
        
        int[] arr2 = {7,1,5,12,3};
        System.out.print("arr2 before Mysterion: "); printArr(arr2);
        System.out.println("mysterion(2,4,2,arr2) returns: " + mysterion(2,4,2,arr2));
        System.out.print("arr2 after Mysterion: "); printArr(arr2);
        
        System.out.println("\n");
        
        int[] arr3 = {7,1,5,12,3};
        System.out.print("arr3 before Mysterion: "); printArr(arr3);
        System.out.println("mysterion(0,3,2,arr3) returns: " + mysterion(0,3,2,arr3));
        System.out.print("arr3 after Mysterion: "); printArr(arr3);
        
        System.out.println("\n");
        
        int[] arr4 = {7,1,5,12,3};
        System.out.print("arr4 before Mysterion: "); printArr(arr4);
        System.out.println("mysterion(0,2,2,arr4) returns: " + mysterion(0,2,2,arr4));
        System.out.print("arr4 after Mysterion: "); printArr(arr4);
        
        System.out.println("\n");
        
        int[] arr5 = {7,1,5,12,3};
        System.out.print("arr5 before Mysterion: "); printArr(arr5);
        System.out.println("mysterion(0,4,1,arr5) returns: " + mysterion(0,4,1,arr5));
        System.out.print("arr5 after Mysterion: "); printArr(arr5);
        
        System.out.println("\n");
        
        int[] arr6 = {7,1,5,12,3};
        System.out.print("arr6 before Mysterion: "); printArr(arr6);
        System.out.println("mysterion(0,4,3,arr6) returns: " + mysterion(0,4,3,arr6));
        System.out.print("arr6 after Mysterion: "); printArr(arr6);
        
        System.out.println("\n");
        
        int[] arr7 = {7,1,5,12,3};
        System.out.print("arr7 before Mysterion: "); printArr(arr7);
        System.out.println("mysterion(0,2,3,arr7) returns: " + mysterion(0,2,3,arr7));
        System.out.print("arr7 after Mysterion: "); printArr(arr7);
        
        System.out.println("\n");
        
        int[] arr8 = {7,1,5,12,3};
        System.out.print("arr8 before Mysterion: "); printArr(arr8);
        System.out.println("mysterion(3,4,0,arr8) returns: " + mysterion(3,4,0,arr8));
        System.out.print("arr8 after Mysterion: "); printArr(arr8);
        
        System.out.println("\n");
        
        int[] arr9 = {7,1,5,12,3};
        System.out.print("arr9 before Mysterion: "); printArr(arr9);
        System.out.println("mysterion(2,4,3,arr9) returns: " + mysterion(2,4,3,arr9));
        System.out.print("arr9 after Mysterion: "); printArr(arr9);
        
        System.out.println("\n");
        
        int[] arr10 = {1,3,5,7,12};
        System.out.print("arr10 before Mysterion: "); printArr(arr10);
        System.out.println("mysterion(2,4,0,arr10) returns: " + mysterion(2,4,0,arr10));
        System.out.print("arr10 after Mysterion: "); printArr(arr10);
        
        System.out.println("\n");
        
        int[] arr11 = {7,1,5,12,3};
        System.out.print("arr11 before Mysterion: "); printArr(arr11);
        System.out.println("mysterion(1,2,3,arr11) returns: " + mysterion(1,2,3,arr11));
        System.out.print("arr11 after Mysterion: "); printArr(arr11);
        
        System.out.println("\n");
        
        int[] arr12 = {4,7,8,1,2,5};
        System.out.print("arr12 before Mysterion: "); printArr(arr12);
        System.out.println("mysterion(2,5,1,arr12) returns: " + mysterion(2,5,1,arr12));
        System.out.print("arr12 after Mysterion: "); printArr(arr12);
    }
}