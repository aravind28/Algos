//Matrix Chain Multiplication present in CLRS
class MatrixChainMultiplication
{
    static int MatrixChainOrder(int p[])
    {
        int size = p.length - 1;

        int m[][] = new int[size + 1][size + 1];
        int s[][] = new int[size + 1][size + 1];

        int i, j, k, l, q;

        for(i = 0; i < size + 1; i++){
            m[0][i] = 0;
        }

        for (i = 1; i < size; i++)
            m[i][i] = 0;

        for (l = 2; l <= size; l ++)
        {
            for (i = 1; i <= size - l + 1; i++)
            {
                j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (k = i; k <= j - 1; k++)
                {
                    q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]){
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
        System.out.println("The M matrix is: ");
        printMatrix(m);
        System.out.println();
        System.out.println("The S matrix is: ");
        printMatrix(s);
        return m[1][size];
    }

    public static void printMatrix(int[][] mat){
        System.out.println();
        System.out.println("----------------------------------------------------");
        for(int row = 0; row < mat.length; row++){
            System.out.print(row + "| ");
            for(int col = 0; col < mat[0].length; col++){
                System.out.printf("%4d", mat[row][col]);
                System.out.print(" | ");
            }
            System.out.println();
            System.out.println("----------------------------------------------------");
        }
    }

    public static void main(String args[])
    {
//        int arr[] = new int[] {1, 2, 3, 4};
        int arr[] = new int[] {5, 10, 3, 12, 5, 50, 6};
        int size = arr.length;
        System.out.println();
        System.out.println("Minimum number of multiplications required is "+  MatrixChainOrder(arr));
    }
}