// 39. Combination Sum

import java.util.*;

public class Leetcode_39 {
    public static void main(String[] args) {
        Solution_39 s = new Solution_39();
        int []candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> list = s.combinationSum(candidates, target);
        for (List<Integer> i : list) {
            System.out.println(i);
        }
    }
}

// Approach: BackTracking
class Solution_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> tempList = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
            backtrack(candidates, target, tempList, list, 0, 0);
        return list;
    }
    private void backtrack(int[] candidates, int target, List<Integer> tempList, List<List<Integer>> list, int i, int sum){
        // base condition
        if(sum>target){
            return;
        }
        if(sum == target){
            list.add(new ArrayList<>(tempList));
            return;
        }
        for(int j = i;j<candidates.length;j++){
            sum += candidates[j];
            tempList.add(candidates[j]);
            backtrack(candidates, target, tempList, list, j, sum);
            sum -= candidates[j];
            tempList.remove(tempList.size()-1);
        }
    }
}