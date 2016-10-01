
public class CuttingRod {

    public static int findMaxValue(int[] cuttingLength, int[] price, int target){
        int[] result = new int[target + 1];
        for(int targetWeight = 0; targetWeight < result.length; targetWeight++){
            for(int currLengthIndex = 0; currLengthIndex < cuttingLength.length; currLengthIndex++){
                if(cuttingLength[currLengthIndex] == targetWeight){
                    result[targetWeight] = Math.max(result[targetWeight], price[currLengthIndex]);
                }
                else if(cuttingLength[currLengthIndex] < targetWeight){
                    result[targetWeight] = Math.max(result[targetWeight],
                            price[currLengthIndex] +result[targetWeight - cuttingLength[currLengthIndex]]);
                }
            }
        }
        return result[target];
    }

    public static int findMaxValue2(int[] cuttingLength, int[] price, int target){
        int[] result = new int[target + 1];
        for(int lengthIndex = 0; lengthIndex < cuttingLength.length; lengthIndex++){
            for(int targetIndex = 0; targetIndex < result.length; targetIndex++){
                if(cuttingLength[lengthIndex] == targetIndex){
                    result[targetIndex] = Math.max(result[targetIndex], price[lengthIndex]);
                }
                else if(cuttingLength[lengthIndex] < targetIndex){
                    result[targetIndex] = Math.max(result[targetIndex],
                                    price[lengthIndex] + result[targetIndex - cuttingLength[lengthIndex]]);
                }
            }
        }
        return result[target];
    }


    public static void main(String[] args){
        int[] cuttingLength = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int[] price = new int[]{1 , 5, 8, 9, 10, 17, 17, 20};
        int target = 4;

        // Ans 10
        System.out.println();
        System.out.print("Maximum value for target " + target + " is (method 1): ");
        System.out.println(findMaxValue(cuttingLength, price, target));
        System.out.print("Maximum value for target " + target + " is (method 2): ");
        System.out.println(findMaxValue2(cuttingLength, price, target));
    }
}
