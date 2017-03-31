
public class ReverseWords {
    public static String reverseWords(String s) {
        if(s == null || s.length() == 1) return s;
        char[] charArray = s.toCharArray();

        swap(charArray, 0, s.length() - 1);
        int leftIndex = 0;
        int noOfChar = 0;
        int noOfSpaces = 0;
        int index = 0;

        while(index < charArray.length){
            while(index < charArray.length && charArray[index] != ' '){
                noOfChar ++;
                index ++;
            }
            swap(charArray, leftIndex, leftIndex + noOfChar - 1);
            while(index < charArray.length && charArray[index] == ' '){
                noOfSpaces ++;
                index ++;
            }
            leftIndex += noOfChar + noOfSpaces;
            index = leftIndex;
            noOfChar = 0;
            noOfSpaces = 0;
        }

        return trimSpaces(charArray, charArray.length);

//        System.out.println(String.valueOf(charArray));
//        return String.valueOf(charArray);
    }

    public static String trimSpaces(char[] charArray, int length){
        int i = 0, j = 0;
        while(j < length){
            while(j < length && charArray[j] == ' ') j++;
            while(j < length && charArray[j] != ' ') charArray[i++] = charArray[j++];
            while(j < length && charArray[j] == ' ') j++;
            if(j < length) charArray[i++] = ' ';
        }
        String str = String.valueOf(charArray);
        return str.substring(0, i);
    }

    public static void swap(char[] charArray, int startIndex, int endIndex){
        while(startIndex < endIndex){
            char c = charArray[endIndex];
            charArray[endIndex] = charArray[startIndex];
            charArray[startIndex] = c;
            startIndex ++;
            endIndex --;
        }

        return;
    }

    public static void main(String[] args) {
        System.out.println(reverseWords(" "));
    }
}

