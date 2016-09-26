
public class StringMainClass {
    public static void main(String[] args){
        MaxOccurenceOfCharacter maxOccurenceObj = new MaxOccurenceOfCharacter();
        maxOccurenceObj.maxOccurence("maaaax");

        RemoveDuplicateCharacters removeDups = new RemoveDuplicateCharacters();
        String removedDuplicates = removeDups.removeDuplicates2("mobile phone");
        System.out.println(removedDuplicates);
    }
}
