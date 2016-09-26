
public class PairWithSumX {
    public void checkPair(int[] arr, int sum){
        boolean[] bool = new boolean[100000];


        for (int i = 0; i <= arr.length - 1; i++){
            int temp = sum - arr[i];
            if((temp >=0) & (bool[arr[i]])){

                System.out.println("Pair with sum " + sum + " is : " + arr[i] + ", " + temp);
            }
            bool[temp] = true;
        }
    }

    public static void main(String[] args){
        PairWithSumX pair = new PairWithSumX();
        int[] arr = new int[] {0, 1, 2, 3, 4};
        int sum = 5;
        pair.checkPair(arr, sum);
    }
}
