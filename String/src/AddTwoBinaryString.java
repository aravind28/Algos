
public class AddTwoBinaryString {
    public static String addBinary(String a, String b) {
        int lengthOfA = a.length() - 1;
        int lengthOfB = b.length() - 1;
        int maxLoops = Math.max(lengthOfA, lengthOfB);
        int carry = 0;
        StringBuilder result = new StringBuilder("");
        for(int i = 0; i <= maxLoops; i++){
            int bitA = getBit(a, lengthOfA - i);
            int bitB = getBit(b, lengthOfB - i);
            int sum = bitA + bitB + carry;
            result.append(sum % 2);
            carry = sum/2;
        }
        if(carry == 1){
            result.append(1);
        }
        return result.reverse().toString();
    }

    private static int getBit(String str, int index){
        if(index < 0 || index >= str.length()){
            return 0;
        }
        if(str.charAt(index) == '0'){
            return 0;
        }
        else{
            return 1;
        }
    }

    public static void main(String[] args) {
        String output = addBinary("110", "110");
        System.out.println(output);
    }
}
