import java.util.Scanner;

public class NearestPowerOf2 {

    public void findNextNearestPower(int n){
        int position = 0;
        int positionOfFirstOne = 0;
        while(n != 0){
            if((n & 1) == 1){
                positionOfFirstOne = position;
            }
            position++;
            n >>= 1;
        }
        int output = 1 << (positionOfFirstOne + 1);
        System.out.println("The next nearest power is: " + output);
    }

    public static void main(String[] args){
        System.out.print("Enter a number: ");
        Scanner inputReader = new Scanner(System.in);
        int input = inputReader.nextInt();
        NearestPowerOf2 objName = new NearestPowerOf2();
        objName.findNextNearestPower(input);
    }
}
