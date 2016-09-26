import java.util.ArrayList;

public class StringPermutation {
    public static void recursivePermute(String currentString, String remainingString){
        if(remainingString.isEmpty()){
            System.out.println(currentString);
        }
        else{
            for(int i = 0; i < remainingString.length(); i++){
                String next = currentString + remainingString.charAt(i);
                String rem = remainingString.substring(0, i) + remainingString.substring(i+1);
                recursivePermute(next, rem);
            }
        }
    }

    public static void main(String[] args){
        String str = "ab";
        recursivePermute("", str);
    }
}
