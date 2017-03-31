import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by aravindheswaran on 3/29/17.
 */
class Solution {

    public String[] sortString(String alphabet, String[] words){

        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

        for(int i = 0; i < 26; i++){ //assumption count = 26
            hm.put(alphabet.charAt(i), i);
        }

        Arrays.sort(words, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){

                int compareLength = Math.min(s1.length(), s2.length());
                int i = 0;

                while(compareLength >= 0){
                    if(i >= s1.length()) return -1;
                    if(i >= s2.length()) return 1; // I had made the error here. Should have been >= instead of <

                    if(s1.charAt(i) != s2.charAt(i)){
                        return hm.get(s2.charAt(i)) > hm.get(s1.charAt(i))? -1 : 1;
                    }
                    else{
                        i ++;
                        compareLength --;
                    }
                }
                return 1; //default return value
            }
        });

        return words;
    }

    public static void main(String[] args) {
        Solution sort = new Solution();
        String[] inputs = {"dogs", "cat", "dog", "turtle", "boy","boys", "girl"};
        String[] outputs = sort.sortString("dehjkblmtcxyafginopqrsuvwz", inputs);
        for(String str : outputs){
            System.out.println(str);
        }
    }
}
