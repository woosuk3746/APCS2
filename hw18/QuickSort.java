//Woosuk Lee
//APCS2 pd8
//HW18 -- QuickSort
//2018-03-13 t
  
/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): 
 * A) Choose a pivot point from the array and partition the whole array from the beginning to the end. (In my case, I always chose the rightmost number as the pivot) 
 * B) After the pivot point is placed in its right position, repeat step A for the 2 created subarrays.
 *
 * 2a. Worst pivot choice and associated runtime: 
 * The worst pivot choice is choosing one of the extremes in the array every time. If this is the case, it will have to perform the partition method n times, resulting * in a runtime of O(n^2).
 *
 * 2b. Best pivot choice and associated runtime:
 * The best pivot choice is always choosing the number in the middle. In that case, it will perform the partition only log n times, resulting in a runtime of O(nlogn)  *
 * 3. Approach to handling duplicate values in array:
 * The code still works on duplicate values, and the reason lies in the implementation of partition method. In partition, only the numbers less than the chosen pivot 
 * point is moved to the left, meaning the number that is the same as the pivot will always stay in its original pivot. However, by the end of the recursion, the 
 * numbers of the same value will end up together.  
 *****************************************************/

public class QuickSort
{
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }


    //paritioning
    public static int partition(int[] arr,int a, int b, int c){
        int v = arr[c];
        swap(c,b,arr);
        int s = a;
        for(int i = a; i < b; i++){
            if(arr[i] < v){
                swap(s,i,arr);
                s+=1;
            }
        }
        swap(b,s,arr);
        return s;
    }
    
    //pivotchooser
    
    //--------------^  HELPER METHODS  ^--------------



    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qsort( int[] d, int left, int right )
    {
	if(left < right){
	    int pvtIndex = partition(d,left,right, /* THIS IS PIVOT */right);
	    qsort(d,left,pvtIndex-1);
	    qsort(d,pvtIndex+1,right);
	}
    }

    public static void qsort(int [] d)
    {
	qsort( d, 0, d.length-1);
    }

    //you may need a helper method...


    //main method for testing
    public static void main( String[] args )
    {
	/*
	int[] t = {7,1,5,12,3};
	printArr(t);
	qsort(t,0,t.length-1);
	printArr(t);
	*/
	
	//get-it-up-and-running, static test case:
	int [] arr1 = {7,1,5,12,3};
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);
	

	qsort( arr1 );	
	System.out.println("arr1 after qsort: " );
	printArr(arr1);
	
	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	arrN[i] = i;
       
	System.out.println("\narrN init'd to: " );
	printArr(arrN);

	shuffle(arrN);
	System.out.println("arrN post-shuffle: " );
	printArr(arrN);

	qsort( arrN );
	System.out.println("arrN after sort: " );
	printArr(arrN);
	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


	
	//get-it-up-and-running, static test case w/ dupes:
	int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);

	qsort( arr2 );	
	System.out.println("arr2 after qsort: " );
	printArr(arr2);


	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	arrMatey[i] = (int)( 48 * Math.random() );
       
	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);

	shuffle(arrMatey);
	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);

	qsort( arrMatey );
	System.out.println("arrMatey after sort: " );
	printArr(arrMatey);
	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 

	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main

}//end class QuickSort
