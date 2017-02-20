
public class MatrixMultiplication {
    public static int[][] matrixMultiplication(int[][] matA, int[][] matB){
        int[][] result = new int[matA.length][matB[0].length];
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < matA[0].length; j++){
                for(int k = 0; k < matB[0].length; k++){
                    result[i][k] += matA[i][j] * matB[j][k];
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
//        int[][] matA = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] matB = {{1, 2,}, {4, 5}, {7, 8}};
//        int[][] matA = {{0, 1, 1, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1},
//                {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        int[][] matA = {{1, 1, 1, 1, 1}, {0, 1, 0, 1, 1}, {0, 0, 1, 1, 1},
                {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}};
        int[][] result = matrixMultiplication(matA, matA);
        System.out.println();
        for(int i = 0; i < result.length; i++){
            System.out.println();
            System.out.println();
            System.out.println();
            for(int j = 0; j < result[1].length; j++){
                System.out.print("     " + matA[i][j]);
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();

    }
}
