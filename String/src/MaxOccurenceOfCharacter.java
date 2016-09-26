
public class MaxOccurenceOfCharacter {
    public void maxOccurence(String s){
        String str = s.toLowerCase();
        int[] arr = new int[26];
        for(int i = 0; i <= str.length()-1; i++){
            arr[str.charAt(i) - 'a']++ ;
        }
        int maxValue = 0, maxIndex = 0;
        for(int i = 0; i <= 25; i++){
            if(arr[i] > maxValue){
                maxValue = arr[i];
                maxIndex = i;
            }
        }
        char maxOccurence = (char) (maxIndex + 'a');

        System.out.println("Character " + maxOccurence + " has " + maxValue +  " occurences");
    }
}
