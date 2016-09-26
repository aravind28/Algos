import java.util.Arrays;

public class ShiftOperators {
    public static void main(String[] args){
        int a = 0100;
        System.out.println(a);
        System.out.println(Integer.toString(a, 2));
        System.out.println(String.format("%16s", Integer.toBinaryString(a)).replace(' ', '0'));
    }
}
