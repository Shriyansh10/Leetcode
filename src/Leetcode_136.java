// 136. Single Number

public class Leetcode_136 {
    public static void main(String[] args) {
        Solution_136 s = new Solution_136();
        int nums[] = {4,1,2,1,2};
        System.out.println(s.singleNumber(nums));
    }
}

// Approach: Bit Manipulations
// TC: O(n) SC: O(1)
class Solution_136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i= 0;i<nums.length;i++){
            ans ^= nums[i];
        }
        return ans;
    }
}