// 128. Longest Consecutive Sequence

import java.util.*;

public class Leetcode_128 {
    public static void main(String[] args) {
        Solution_128 s = new Solution_128();
        int nums[] = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(s.longestConsecutive(nums));
    }
}

// Approach: Use Sorted set as sorting is not allowed and check for next no in the set continue to inc the count reset if not found calculate the max
// TC: O(n) SC: O(n)
class Solution_128 {
    public int longestConsecutive(int[] nums) {
        SortedSet<Integer> ss = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            ss.add(nums[i]);
        }
        int count =1;
        int maxCount = 0;
        for(int i:ss){
            if(ss.contains(i+1)){
                count++;
            }
            else{
                maxCount = Math.max(count,maxCount);
                count = 1;
            }
        }
        return maxCount;
    }
}