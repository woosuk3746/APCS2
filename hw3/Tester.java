public class Tester{
    public static void main( String[] args ){
        int[][] a = {{1,2,3},{5,6,7},{8,9,10}};
        System.out.println(MatrixFinder.find(a,11));
        System.out.println(MatrixFinder.find(a,2));
        System.out.println(MatrixFinder.find(a,1));
        System.out.println(MatrixFinder.find(a,7));
        System.out.println(MatrixFinder.find(a,3));
    }
}