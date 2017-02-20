public class OptimalBST {

    public static int optimalBST(int[] p, int[] q, int n){
        int[][] e = new int[n + 2][n + 1];
        int[][] w = new int[n + 2][n + 1];
        int[][] root = new int[n + 2][n + 1];

        int i, j, l, r, t;

        for(i = 0; i <= n; i++){
            e[i + 1][i] = q[i];
            w[i + 1][i] = q[i];
        }

        for (i = 1; i <= n + 1; i++){
            root[i][i - 1] = i - 1;
        }
        for(l = 1; l <= n; l++){
            for(i = 1; i <= n - l + 1; i++) {
                j = i + l - 1;
                e[i][j] = Integer.MAX_VALUE;
                w[i][j] = w[i][j - 1] + p[j] + q[j];

                for (r = i; r <= j; r++) {
                    t = e[i][r - 1] + e[r + 1][j] + w[i][j];
                    if (t < e[i][j]) {
                        e[i][j] = t;
                        root[i][j] = r;
                    }
                }
            }
        }
        return 1;
    }

    public static void main(String[] args){
        int[] p = {0, 15, 10, 5, 10, 20};
        int[] q = {5, 10, 5, 5, 5, 10};
        int n = 5;

        optimalBST(p, q, n);
    }
}
