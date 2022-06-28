// 217. Contains Duplicate

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leetcode_217 {
    public static void main(String[] args) {
        Solution_217 s = new Solution_217();
        int nums[] = {1,2,3,1};
        System.out.println(s.containsDuplicate(nums));
    }
}

// Approach 1: Sorting and checking with next index.
// TC: O(nlog(n)) SC: O(1)
class Solution_217 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
}

// Approach 2: Hashing
// TC: O(n) SC: O(n)
class Solution_217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>(); 
        for(int i=0;i<nums.length;i++){
            if(s.contains(nums[i])){
                return true;
            }
            s.add(nums[i]);
        }
        return false;
    }
}