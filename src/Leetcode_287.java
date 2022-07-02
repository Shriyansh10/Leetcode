public class Leetcode_287 {
    public static void main(String[] args) {
        Solution_287 s = new Solution_287();
        int nums[] = {1,3,4,2,2};
        System.out.println(s.findDuplicate(nums));
    }
}

// Approach: Cycle Sort
// TC: O(n) SC: O(1)
class Solution_287 {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;){
            if(nums[i] != i+1 && nums[i]!=nums[nums[i]-1]){
                int a=nums[i];
                int b = nums[nums[i]-1];
                a = a+b;
                b = a-b;
                a = a-b;
                nums[nums[i]-1] = b;
                nums[i] = a;
            }
            else{
                i++;
            }
        }
        return nums[nums.length-1];
    }
}