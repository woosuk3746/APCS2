//Team B
//Mohtasim Howlader, Woosuk Lee
//APCS2 pd8
//HW07 -- A Man, A Plan, A Canal: Panama!
//2018-02-14
public class Resrever{
    //O(n)
    public static String linearFunction( String s ){
        String retStr = "";
        for(int i = s.length() - 1; i >=0; i--){
            retStr += s.substring(i,i+1);
        }
        return retStr;
        //this implementation is O(n) because it goes through the string n number of times but backwards.
    }
    
    /*
    I think that making a logarithmic method for string reverse is not possible to implement. According to the QAF post, everyone seemed to have been trying use the merge method in order to reverse the string. According to Jerry, the splitting itself has a constant runtime, but it is done approximately n/2 number of times, so it will result in the total splitting runtime of O(n) which already fails the mission of making a O(log n) runtime implementation. Reversing a string completely requires checking all characters one way or another. Having a runtime of O(log n) in a code that reverses the characters of the string seems impractical because it means that not every character is checked for its correct position, which may not guarantee the complete functionality of the code.
    */
    
    public static void main( String[] args){
        String a = "stressed";
        System.out.println(linearFunction(a));
    }
}