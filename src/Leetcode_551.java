// 551. Student Attendance Record I

public class Leetcode_551 {
    public static void main(String [] args){
        Solution_551 s = new Solution_551();
        if(s.checkRecord("PPALLL")) System.out.println("True");
        else System.out.println("false");
    }
}


class Solution_551 {

    // Step 1: Function Calls for Recursion
    public  boolean checkRecord(String s) { 
        return check(s,0,0);
    }
    
    // Step 2: Check for every letter and increase corresponding counters
    public boolean check(String s,int a, int l){
        if(a>1 || l>2) {
            return false;
        }
        if(s.length()==0) return true;
        char c=s.charAt(0);
        if(c=='A'){
            a++;
        }
        if(c=='L'){
            l++;
        }
        else{
            l=0;
        }
        return check(s.substring(1),a,l);
    }
    
}
