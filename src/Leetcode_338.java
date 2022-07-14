// 338. Counting Bits

public class Leetcode_338 {
    public static void main(String[] args) {
        Solution_338 s = new Solution_338();
        int nums[] = s.countBits(10);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}

// Approach 1: Bit Manipulation, Store previous ans and derive bigger problems with smaller problems
// TC: O(n) SC: O(1)
class Solution_338 {
    public int[] countBits(int n) {
        int ar[] = new int[n+1];
        for(int i=1;i<=n;i++){
            // ar[i&(i-1)] it is getting previous ans from dp array
            ar[i] = ar[i&(i-1)]+1;
        }
        return ar;
    }
}