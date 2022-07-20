// 90. Subsets II

import java.util.*;

public class Leetcode_90 {
    public static void main(String[] args) {
        Solution_90 s = new Solution_90();
        int []nums = {1,2,2};
        // int target = 7;
        List<List<Integer>> list = s.subsetsWithDup(nums);
        for (List<Integer> i : list) {
            System.out.println(i);
        }
    }
}

// Approach: BackTracking
class Solution_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backtrack(nums, 0, list, tempList);
        return list;
    }
    public void backtrack(int[] nums, int index, List<List<Integer>> list, List<Integer> tempList){
        list.add(new ArrayList<>(tempList));
        for(int i=index;i<nums.length;i++){
            if(i != index && nums[i] == nums[i-1]){
                continue;
            }
            tempList.add(nums[i]);
            backtrack(nums, i+1, list, tempList);
            tempList.remove(tempList.size()-1);
        }
    }
}