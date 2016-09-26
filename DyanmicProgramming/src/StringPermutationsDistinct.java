import java.util.ArrayList;

public class StringPermutationsDistinct {
    ArrayList<String> result;

    public StringPermutationsDistinct(){
        result = new ArrayList<>();
    }

    public ArrayList<String> getAllPermutations_Recursion(String s){

        if(s == null){
            return null;
        }

        ArrayList<String> perms = new ArrayList<>();
        if(s.length() == 0){
            perms.add("");
            return perms;
        }

        char firstCharacter = s.charAt(0);
        String remainingCharacters = s.substring(1);
        ArrayList<String> permutationOfRemainingCharacters = getAllPermutations_Recursion(remainingCharacters);

        for(String word : permutationOfRemainingCharacters){
            for(int i = 0; i <= word.length(); i++){
                String word2 = insertCharacterAt(word, firstCharacter, i);
                perms.add(word2);
            }
        }
        System.out.println(perms.toString());
        return perms;
    }

    private String insertCharacterAt(String word, char firstCharacter, int index){
        String firstSectionOfWord = word.substring(0, index);
        String secondSectionOfWord = word.substring(index, word.length());
        return firstSectionOfWord + firstCharacter + secondSectionOfWord;
    }

    public ArrayList<String> getAllPermutations_DP1(String s){
        if(s == null){
            return null;
        }

        ArrayList<String> resultDp = new ArrayList<>();
        if(s.length() == 1){
            resultDp.add("");
            return resultDp;
        }

        for(int i = 0; i < s.length(); i ++){
            String firstPart = s.substring(0, i);
            String secondPart = s.substring(i + 1, s.length());
            ArrayList<String> tempPerms = getAllPermutations_DP1(firstPart + secondPart);

            for(String word : tempPerms){
                resultDp.add(s.charAt(i) + word);
            }
        }
        System.out.println(resultDp.toString());
        return resultDp;
    }
    public static void main(String[] args){
        StringPermutationsDistinct spd = new StringPermutationsDistinct();
        String s = "new";
        spd.getAllPermutations_Recursion(s);
        s = "abc";
        spd.getAllPermutations_DP1(s);
    }
}
