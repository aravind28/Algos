
public class LongestPalindromicSubSequence {
    // A utility function to get max of two integers
    static int max (int x, int y) { return (x > y)? x : y; }

    // Returns the length of the longest palindromic subsequence in seq
    static int lps(String seq)
    {
        int n = seq.length();
        int i, j, cl;
        int L[][] = new int[n][n];  // Create a table to store results of subproblems

        // Strings of length 1 are palindrome of lentgh 1
        for (i = 0; i < n; i++)
            L[i][i] = 1;

        // Build the table. Note that the lower diagonal values of table are
        // useless and not filled in the process. The values are filled in a
        // manner similar to Matrix Chain Multiplication DP solution (See
        // http://www.geeksforgeeks.org/archives/15553). cl is length of
        // substring
        for (cl=2; cl<=n; cl++)
        {
            for (i=0; i<n-cl+1; i++)
            {
                j = i+cl-1;
                if (seq.charAt(i) == seq.charAt(j) && cl == 2)
                    L[i][j] = 2;
                else if (seq.charAt(i) == seq.charAt(j))
                    L[i][j] = L[i+1][j-1] + 2;
                else
                    L[i][j] = max(L[i][j-1], L[i+1][j]);
            }
        }

        for(i = 0; i < L.length; i++){
            System.out.println();
            System.out.print("| ");
            for(j = 0; j < L[0].length; j++){
                System.out.print(L[i][j] + " | ");
            }
            System.out.println();
            for(int line = 0; line < L[0].length; line++){
                System.out.print("----");
            }
        }
        System.out.println();
        int col = L.length - 1;
        int row = 0;
        char[] res = new char[L[0][n-1]];
        int last = res.length - 1;
        int first = 0;
        if(L[row][col] == 1){
            System.out.println("The is no palindromic sub sequence");
            return 0;
        }
        while(L[row][col] != 0){
            if(L[row][col] == L[row][col - 1]){
                col --;
            }else if(L[row][col] == L[row + 1][col]){
                row ++;
            }
            else{
                res[last] = seq.charAt(col);
                res[first] = seq.charAt(row);
                last--;
                first++;
                col--;
                row++;
            }
        }
        for (int x = 0; x < res.length; x++){
            System.out.print(" " + res[x]);
        }
        System.out.println();
        return L[0][n-1];
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
//        String seq = "character";
        String seq = "rrc";
        int n = seq.length();
        System.out.println("The length of the lps is "+ lps(seq));
    }
}
