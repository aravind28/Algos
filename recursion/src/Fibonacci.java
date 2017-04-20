/**
 * Created by aravindheswaran on 4/1/17.
 */

// o/p :  1 1 2 3 5 8 13 21 34 55
// n:     1 2 3 4 5 6 7  8  9  10
public class Fibonacci {

    public static int findNthFibonacci(int n){

        if(n == 0) return 0;
        if(n == 1) return 1;

        return findNthFibonacci(n-1) + findNthFibonacci(n-2);
    }

    public static void main(String[] args){
        int findNth = 10;
        System.out.println(findNthFibonacci(findNth));
    }
}
