// 442. Find All Duplicates in an Array

import java.util.*;

public class Leetcode_442 {
    public static void main(String[] args) {
        Solution_442 s = new Solution_442();
        int nums[] = {4,3,2,7,8,2,3,1};
        System.out.println(s.findDuplicates(nums));
    }
}

// Approach: Cyclic Sort
// TC: O(n) SC: O(1)
class Solution_442 {
    public List<Integer> findDuplicates(int[] nums) {
        for(int i=0;i<nums.length;){
            if(nums[i] != i+1 && nums[i] != nums[nums[i]-1]){
                int a = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = a;
            }
            else{
                i++;
            }
        }
        List<Integer> ar= new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                ar.add(nums[i]);
            }
        }
        return ar;
    }
}