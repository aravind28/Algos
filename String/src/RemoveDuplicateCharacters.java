import java.util.LinkedHashSet;

public class RemoveDuplicateCharacters {
    public String removeDuplicates(String str){
        StringBuilder sb = new StringBuilder();
        LinkedHashSet<Character> hs = new LinkedHashSet<Character>();
        for(int i = 0; i <= str.length()-1; i++){
            hs.add(str.charAt(i));
        }
        for(char c : hs){
            sb.append(c);
        }
        return sb.toString();
    }

    public String removeDuplicates2(String str2){
        String str = str2.toLowerCase();
        boolean[] seen = new boolean[256];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length() - 1; i++){
            char c = str.charAt(i);
            int index = c;
            if(!seen[index]){
                seen[index] = true;
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
