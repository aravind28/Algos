
public class CoinChange {
    public static int calculateCoinsReqd(int[] coins, int target){
        int[] result = new int[target + 1];
        for(int x = 1; x <= target; x++){
            result[x] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < coins.length; i++){
            for(int j = 0; j < result.length; j++){
                if(coins[i] <= j){
                    result[j] = Math.min(result[j], 1 + result[j - coins[i]]);
                }
            }
        }
        return result[target];
    }
    public static void main(String[] args){
        int[] coins = new int[]{1, 5, 6, 8};
        int target = 11;
        int minCoins = calculateCoinsReqd(coins, target);
        System.out.println("Minimum Coins required to form " + target + " is : " + minCoins);
    }
}
