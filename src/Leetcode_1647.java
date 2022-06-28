// 1647. Minimum Deletions to Make Character Frequencies Unique

import java.util.Arrays; // for arrays.sort

public class Leetcode_1647 {
    public static void main(String[] args) {
        Solution_1647 s = new Solution_1647();
        System.out.println(s.minDeletions("bbcebab"));
        System.out.println(s.minDeletions("accdcdadddbaadbc"));
        System.out.println(s.minDeletions("adec"));
    }
}

class Solution_1647 {
    public int minDeletions(String s) {
        int ar[] = new int[26];

        // Step 1: finding all frequencies
        for(int i=0;i<s.length();i++){
            ar[s.charAt(i)-'a']++;
        }

        // Step 2: Sort the frequencies
        Arrays.sort(ar);

        int freq = ar[25];
        int count = 0;
        int i=25;
        
        // Step 3: Calculate the count based on maxpossible frequencies
        while (i>=0 && ar[i]!=0){
            if(ar[i]>freq){
                if(freq>0){
                    count += ar[i]-freq;
                }
                else{
                    count += ar[i];
                }
            }
            freq=Math.min(ar[i]-1, freq-1);
            i--;
        }
        
        return count;
    }
}