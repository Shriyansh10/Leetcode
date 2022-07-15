// 46. Permutations

import java.util.*;

public class Leetcode_46 {
    public static void main(String[] args) {
        Solution_46 s = new Solution_46();
        int []nums = {1,2,3};
        // int target = 7;
        List<List<Integer>> list = s.permute(nums);
        for (List<Integer> i : list) {
            System.out.println(i);
        }
    }
}

// Approach: BackTracking
// 
// class Solution_46 {
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> list = new ArrayList();
//         List<Integer> tempList = new ArrayList();
//         boolean []visited = new boolean[nums.length];
//         backtrack(nums, visited, list, tempList);
//         return list;
//     }
    
//     public void backtrack(int[] nums,boolean[] visited, List<List<Integer>> list, List<Integer> tempList){
//         if(tempList.size() == nums.length){
//             list.add(new ArrayList(tempList));
//             return;
//         }
//         for(int i=0;i<nums.length;i++){
//             if(!visited[i]){
//                 visited[i]= true;
//                 tempList.add(nums[i]);
//                 backtrack(nums, visited, list, tempList);
//                 visited[i] = false;
//                 tempList.remove(tempList.size()-1);
//             }
//         }
//     }
// }

// Approach: BackTracking without any extra space
//
class Solution_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        backtrack(nums, 0, list);
        return list;
    }
    
    public void swap(int i, int j, int nums[]){
        int t= nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    
    public void backtrack(int[] nums, int index, List<List<Integer>> list){
        if(index == nums.length){
            List<Integer> tempList = new ArrayList();
            for(int j=0;j<nums.length;j++){
                tempList.add(nums[j]);
            }
            list.add(new ArrayList(tempList));
            return;
        }
        for(int i=index;i<nums.length;i++){
            swap(index, i, nums);
            backtrack(nums, index+1, list);
            swap(index, i, nums);
        }
    }
}