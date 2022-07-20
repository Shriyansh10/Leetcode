// 22. Generate Parentheses

import java.util.*;

public class Leetcode_22 {
    public static void main(String[] args) {
        Solution_22 s = new Solution_22();
        System.out.println(s.generateParenthesis(3));
    }
}

// Approach: BackTracking
class Solution_22 {
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(0, n, "", 0);
        return list;
    }
    
    protected void backtrack(int index, int n, String s, int remaining){
        if((index == n)&&(remaining == n)){
            list.add(new String(s));    
            return;
        }
        if(index <n){
            // s += "(";
            backtrack(index+1, n, s+ "(", remaining);
            // s = s.substring(0,s.length()-1);
        }
        if(index>remaining){
            // s += ")";
            backtrack(index, n, s+ ")", remaining+1);
            // s = s.substring(0,s.length()-1);
        }
    }
}