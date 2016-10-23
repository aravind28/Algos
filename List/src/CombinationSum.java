// n: sum required
// k: number of elements required to form sum n
// only numbers from 1 to 9 are allowed
// only combination, no permutation

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    static List<List<Integer>> resultList;
    public static List<List<Integer>> findAllCombinations(int k, int n){
        resultList = new ArrayList<List<Integer>>();
        findAllCombinations(new ArrayList<Integer>(), 1, k, 0, n);
        return resultList;
    }

    private static void findAllCombinations(List<Integer> combination, int start, int k, int noOfCombinationSoFar, int n){

        if(noOfCombinationSoFar == k && n == 0){
            ArrayList<Integer> tempList = new ArrayList<Integer>(combination);
            resultList.add(tempList);
            return;
        }
        if(noOfCombinationSoFar > k || start > 9) {
            return;
        }

        for (int i = start; i <= 9; i++){
            combination.add(i);
            findAllCombinations(combination, i + 1, k, noOfCombinationSoFar + 1, n - i);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args){
        int k = 3;
        int n = 15;
        List<List<Integer>> result = findAllCombinations(k, n);
        System.out.println();
        System.out.print("All combinations that form sum " + n + " are: ");
        for (List list : result){
            System.out.print(list.toString());
        }
    }
}
