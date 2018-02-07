/*======================================
  Woosuk Lee
  APCS2 pd8
  HW05 -- Step 1: Split, Step 2: ?, Step 3: Sorted!
  2018-02-07
  
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:
  Step 1: Split them into subarrays until there is only one element in each of them (do this recursively in the sort() method)
  Step 2: Merge these subarrays back together (just like you sort cards using the table)
  Step 3: SORTED!
  ======================================*/

public class MergeSort
{
  /******************************************************
   * int[] merge(int[],int[])
   * Merges two input arrays
   * Precond:  Input arrays are sorted in ascending order
   * Postcond: Input arrays unchanged, and
   * output array sorted in ascending order.
   ******************************************************/
  private static int[] merge( int[] a, int[] b )
  {
      int[] retArr = new int[a.length + b.length];
      int aCounter = 0;
      int bCounter = 0;
      while( aCounter < a.length && bCounter < b.length){
          if(a[aCounter]<b[bCounter]){
              retArr[aCounter+bCounter] = a[aCounter];
              aCounter++;
          }
          else{
              retArr[aCounter+bCounter] = b[bCounter];
              bCounter++;
          }
      }
      if( aCounter == a.length ){
          for(int i = bCounter; i < b.length; i++){
              retArr[aCounter+i] = b[i];
          }
      }
      else if (bCounter == b.length ){
          for(int i = aCounter; i < a.length; i++){
              retArr[i+bCounter] = a[i];
          }
      }
      return retArr;
  }//end merge()


  /******************************************************
   * int[] sort(int[])
   * Sorts input array using mergesort algorithm
   * Returns sorted version of input array (ascending)
   ******************************************************/
  public static int[] sort( int[] arr )
  {
      //Credits to Bill Ni pd2 for helping
      if(arr.length > 1){
          int middle = arr.length/2;
          int[] a1 = new int[middle];
          int[] a2 = new int[arr.length - middle];
          
          for(int i = 0; i < arr.length; i++){
              if(i >= middle){
                  a2[i - middle] = arr[i];
              }
              else{
                  a1[i]= arr[i];
              }
          }
          return merge(sort(a1),sort(a2));
      }
      else{
      return arr;      
      }
  }//end sort()



  //-------------------HELPERS-------------------------
  //tester function for exploring how arrays are passed
  //usage: print array, mess(array), print array. Whaddayasee?
  public static void mess( int[] a ){
    for( int i = 0 ; i<a.length; i++ )
      a[i] = 0;
  }

  //helper method for displaying an array
  public static void printArray( int[] a ){
    System.out.print("[");
    for( int i : a )
      System.out.print( i + ",");
    System.out.print("\b");
    System.out.println("]");
  }
  //---------------------------------------------------


  //main method for testing
  public static void main( String [] args ) {

    
      int[] arr0 = {0};
      int[] arr1 = {1};
      int[] arr2 = {1,2};
      int[] arr3 = {3,4};
      int[] arr4 = {1,2,3,4};
      int[] arr5 = {4,3,2,1};
      int[] arr6 = {9,42,17,63,0,512,23};
      int[] arr7 = {9,42,17,63,0,9,512,23,9};

      System.out.println("\nTesting mess-with-array method...");
      printArray( arr3 );
      mess(arr3);
      printArray( arr3 );

      System.out.println("\nMerging arr1 and arr0: ");
      printArray( merge(arr1,arr0) );

      System.out.println("\nMerging arr4 and arr2: ");
      printArray( merge(arr4,arr2) );

      System.out.println("\nSorting arr4-7...");
      printArray( sort( arr4 ) );
      printArray( sort( arr5 ) );
      printArray( sort( arr6 ) );
      printArray( sort( arr7 ) );
      /*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class MergeSort
