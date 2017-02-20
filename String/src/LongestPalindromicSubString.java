public class LongestPalindromicSubString {

    private static void printMatrix(int[][] mat){
        for(int i = 0; i < mat.length; i++){
            System.out.println();
            for(int j = 0; j< mat[0].length; j ++){
                System.out.print(" " + mat[i][j]);
            }
        }
    }

    private static String findLongestPalindromicSubString(String s){
        int resMatrix[][] = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            resMatrix[i][i] = 1;
        }
        int len, startIndex, endIndex;
        for(len = 1; len < s.length(); len++){
            for(startIndex = 0; startIndex < s.length(); startIndex++){
                endIndex = startIndex + len;
                if(endIndex < s.length()){
                    if(s.charAt(startIndex) == s.charAt(endIndex)){
                        resMatrix[startIndex][endIndex] = resMatrix[startIndex + 1][endIndex - 1] + 2;
                    }
                    else{
                        resMatrix[startIndex][endIndex] = Math.max(resMatrix[startIndex][endIndex-1],
                                                                   resMatrix[startIndex + 1][endIndex]);
                    }
                }
            }
        }
        printMatrix(resMatrix);
        return "Hi";
    }
    public static void main(String[] args){
        String str = "babac";
        String res = findLongestPalindromicSubString(str);
    }
}
