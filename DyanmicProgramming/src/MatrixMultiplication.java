public class MatrixMultiplication {
    public static int findCost(int[] matrixDimensions){
        int size = matrixDimensions.length;
        int result[][] = new int[size + 1][size + 1];
        for (int i = 0; i < size; i++) {
            result[i][i] = 0;
        }
        int j, q;
        for(int length = 2; length <= size; length++){
            for(int i = 1; i <= size - length; i++){
                j = i + length - 1;
                if(j == size){
                    continue;
                }
                result[i][j] = Integer.MAX_VALUE;
                for(int k = i; k < j; k++){
                    q = result[i][k] + result[k + 1][j] + matrixDimensions[i - 1] * matrixDimensions[k] * matrixDimensions[j];
                    if(q < result[i][j]){
                        result[i][j] = q;
                    }
                }
            }
        }
        return result[1][size - 1];
    }
    public static void main(String[] args){
        int[] matrixDimensions = {5, 10, 3, 12, 5, 50, 6};
//        int[] matrixDimensions = {1, 2, 3, 4};
        int cost = findCost(matrixDimensions);
        System.out.println("Cost is:" + cost);
    }
}
