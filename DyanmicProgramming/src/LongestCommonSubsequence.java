import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void findLCS(int[] arr1, int [] arr2){
        int rowSize = arr2.length;
        int colSize = arr1.length;
        int[][] result = new int[rowSize + 1][colSize + 1];
        for(int row = 0; row < result.length; row++){
            result[row][0] = 0;
        }
        for(int col = 0; col < result[0].length; col++){
            result[0][col] = 0;
        }
        for(int row = 1; row < result.length; row ++){
            for(int col = 1; col < result[0].length; col++){
                if(arr2[row - 1] == arr1[col - 1]){
                    result[row][col] = 1 + result[row - 1][col - 1];
                }
                else{
                    result[row][col] = Math.max(result[row][col - 1], result[row-1][col]);
                }
            }
        }
        printMatrix(result);
    }

    private static void printMatrix(int[][] resultMatrix){
        for(int i = 0; i < resultMatrix.length; i++){
            System.out.println();
            System.out.print("| ");
            for(int j = 0; j < resultMatrix[0].length; j++){
                System.out.print(resultMatrix[i][j] + " | ");
            }
            System.out.println();
            for(int line = 0; line < resultMatrix[0].length; line++){
                System.out.print("----");
            }
        }
    }
    public static void main(String[] args) {
//        char arr1[] = {'a', 'b', 'c', 'd', 'e', 'f'};
//        char arr2[] = {'a', 'c', 'b', 'c', 'f'};
//        int arr1[] = {1, 0, 0, 1, 0, 1, 0, 1};
//        int arr2[] = {0, 1, 0, 1, 1, 0, 1, 1, 0};
        int[] arr1 = {5, 27, 14, 38, 66, 55, 86, 95, 98};
        int[] arr2 = arr1;
        Arrays.sort(arr2);
        findLCS(arr1, arr2);
    }
}
