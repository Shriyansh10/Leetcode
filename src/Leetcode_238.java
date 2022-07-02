public class Leetcode_238 {
    public static void main(String[] args) {
        Solution_238 s = new Solution_238();
        int nums[] = {9,6,4,2,3,5,7,0,1};
        int pf[] = s.productExceptSelf(nums);
        for (int i = 0; i < pf.length; i++) {
            System.out.println(pf[i]);
        }
    }
}

// Approach : Use resultant array to store left prefix sum and right prefix sum is stored using a variable.
// TC: O(n) SC: O(1)
class Solution_238 {
    public int[] productExceptSelf(int[] nums) {
        int pf[] = new int[nums.length];
        int rightproduct = 1;
        pf[0] = 1;
        for(int i=1;i<nums.length;i++){
            pf[i] = nums[i-1]*pf[i-1]; 
        }
        for(int i=nums.length-1;i>=0;i--){
            pf[i] = pf[i]*rightproduct;
            rightproduct *= nums[i];
        }
        return pf;
    }
}