
public class Rotation90 {

    public static void rotateMatrix(int[][] matrix, int size){

        for(int layer = 0; layer < size / 2; layer++){
            for(int i = layer; i < size - 1 - layer; i++){
                int temp = matrix[i][layer];
                matrix[i][layer] = matrix[size - 1 - layer][i];
                matrix[size - 1 - layer][i] = matrix[size - 1 - i][size - 1 - layer];
                matrix[size - 1 - i][size - 1 - layer] = matrix[layer][size - 1 - i];
                matrix[layer][size - 1 - i] = temp;
            }
        }

    }

    public static void printMatrix(int[][] matrix, int size){
        for(int i = 0; i < size; i++){
            System.out.println();
            for (int j = 0; j < size; j++){
                System.out.print(", " + matrix[i][j]);
            }
        }
    }

    public static void main(String[]args){
        int[][] matrix = new int[][]{{1, 2, 3, 4, 17}, {5, 6, 7, 8, 18}, {9, 10, 11, 12, 19}, {13, 14,15 ,16, 20},
                {20, 21, 22, 23, 24}};
        printMatrix(matrix, matrix.length);
        rotateMatrix(matrix, matrix.length);
        System.out.println();
        printMatrix(matrix, matrix.length);
    }

}
