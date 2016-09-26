
public class MaxSumRectangularSubMatrix {

    public static void findMaxRect(int[][] mat){
        int[] arr;
        int leftColumn = 0, rightColumn = 0;
        int leftIndex = 0, topIndex = 0, rightIndex = 0, bottomIndex = 0;
        int maxSum = 0;
        int matrixColumns = mat[0].length;
        while(leftColumn < matrixColumns){
            rightColumn = leftColumn;
            arr = new int[mat.length];
            while(rightColumn < matrixColumns){
                for(int i = 0; i < mat.length; i++) {
                    arr[i] += mat[i][rightColumn];
                }
                int maxEndingHere = 0;
                int maxTillNow = 0;
                int maxSubArrayStartIndex = 0;
                int maxSubArrayEndIndex = 0;
                for(int j = 0; j < arr.length; j++){
                    if((maxTillNow + arr[j] <= 0)){
                        maxSubArrayStartIndex = j + 1;
                    }
                    maxEndingHere = Math.max(arr[j], (arr[j] + maxEndingHere));
                    if(maxTillNow < maxEndingHere){
                        maxTillNow = maxEndingHere;
                        maxSubArrayEndIndex = j;
                    }
                }
                if(maxSum < maxTillNow){
                    maxSum = maxTillNow;
                    leftIndex = leftColumn;
                    rightIndex = rightColumn;
                    topIndex = maxSubArrayStartIndex;
                    bottomIndex = maxSubArrayEndIndex;
                }

                rightColumn++;
            }
            leftColumn++;
        }
        System.out.println(maxSum);
        System.out.println("Left Index: " + leftIndex);
        System.out.println("Right Index: " + rightIndex);
        System.out.println("Top Index: " + topIndex);
        System.out.println("Bottom Index: " + bottomIndex);
    }

    public static void main(String[] args){
        int[][] mat = new int[][]{{2, 1, -3, -4, 5}, {0, 6, 3, 4, 1}, {2, -2, -1, 4, -5}, {-3, 3, 1, 0, 3}};
        findMaxRect(mat);
    }
}
