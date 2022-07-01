// 448. Find All Numbers Disappeared in an Array

import java.util.*;

public class Leetcode_448 {
    public static void main(String [] args){
        Solution_448 s = new Solution_448();
        int nums[] = {4,3,2,7,8,2,3,1};
        List<Integer> l = s.findDisappearedNumbers(nums);
        for (int i : l) {
            System.out.println(i+" ");
        }
    }
}

// Approach 1: Sorting and using counter and matching the values in array.
// TC: O(n*log(n)) SC: O(1)
// class Solution_448 {
//     public List<Integer> findDisappearedNumbers(int[] nums) {
//         List<Integer> l=new ArrayList<>();
//         int len=nums.length;
//         Arrays.sort(nums);
//         int counter = 1;

//         // Matching every value in array with the counter if not found then add in list and continue checking for further values
//         for(int i=0;i<len;i++){
//             if(nums[i]==counter){
//                 counter++;
//             }
//             else if(nums[i]>counter){
//                 l.add(counter);    
//                 counter++;
//                 i--;
//             }
//         }

//         // If counter does not reaches len means there are missing values towards the end of the array
//         while(counter<=len){
//             l.add(counter);
//             counter++;
//         }
//         return l;
//     }
// }


// Approach 1: Sorting and using counter and matching the values in array.
// TC: O(n*log(n)) SC: O(1)
class Solution_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<nums.length;){
            if(nums[i] != (i+1) && nums[i]!=nums[nums[i]-1]){
                int a = nums[nums[i]-1];
                int b = nums[i];
                a=a+b;
                b=a-b;
                a=a-b;
                nums[nums[i]-1] = a;
                nums[i] = b;
            }
            else{
                i++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                l.add(i+1);
            }
        }
        return l;
    } 
}