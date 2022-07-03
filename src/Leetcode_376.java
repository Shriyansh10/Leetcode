// 376. Wiggle Subsequence

public class Leetcode_376 {
    public static void main(String[] args) {
        Solution_376 s = new Solution_376();
        int nums[] = {1,17,5,10,13,15,10,5,16,8};
        System.out.println(s.wiggleMaxLength(nums));
    }
}

// Approach: Count all the highs and the lows
// TC: O(n) SC:O(1)
class Solution_376 {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }
        int count = 2;
        int prev = nums[1] - nums[0];
        if(prev == 0){
            count = 1;
        }
        int diff = 0;
        for(int i=2;i<nums.length;i++){
            diff = nums[i] - nums[i-1];
            if(diff<0 && prev>=0 || diff>0 && prev<=0){
                count++;
                prev = diff;
            }
        }
        return count;
    }
}