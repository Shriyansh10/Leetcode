// 268. Missing Number

// import java.util.Arrays;

public class Leetcode_268 {
    public static void main(String[] args) {
        Solution_268 s = new Solution_268();
        int nums[] = {9,6,4,2,3,5,7,0,1};
        System.out.println(s.missingNumber(nums));
    }
}

// Approach 1: Sort and check for next no. Return if not found
// TC: O(n*log(n)) SC: O(1)
// class Solution_268 {
//     public int missingNumber(int[] nums) {
//         Arrays.sort(nums);
//         if(nums[0]!=0) {
//             return 0;
//         }
//         for(int i=0;i<nums.length-1;i++){
//             if(nums[i]+1!=nums[i+1]) return nums[i]+1;
//         }
//         return nums[nums.length-1]+1;
//     }
// }

// Approach 1: Calculate total sum and array sum. Return difference.
// TC: O(n) SC: O(1)
class Solution_268 {
    public int missingNumber(int[] nums) {
        int total_sum = 0;
        int array_sum = 0;
        for(int i=0;i<nums.length;i++){
            total_sum += i+1;
            array_sum += nums[i];
        }
        return total_sum - array_sum;
    }
}