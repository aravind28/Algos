/**
 * Created by aravindheswaran on 4/1/17.
 */
public class Factorial {

    public static int findFactorial(int n){

        if(n == 1) return 1;

        return n * findFactorial(n - 1);
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(findFactorial(n));
    }
}
