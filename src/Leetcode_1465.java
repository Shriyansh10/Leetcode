// 1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
import java.util.Arrays;

class Leetcode_1645 {
    public static void main(String[] args) {
        Solution_1645 s = new Solution_1645();
        int [] horizontalCuts = {2};
        int [] verticalCuts = {2};
        System.out.println(s.maxArea(1000000000 , 1000000000 , horizontalCuts, verticalCuts));
    }
}

class Solution_1645 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long hl = horizontalCuts[0];
        long vl = verticalCuts[0]; 
        hl = Math.max(horizontalCuts[0], h-horizontalCuts[horizontalCuts.length - 1]);
        vl = Math.max(verticalCuts[0], w-verticalCuts[verticalCuts.length - 1]);
        
        for(int i=1;i<horizontalCuts.length;i++){
            hl = Math.max(hl, horizontalCuts[i] - horizontalCuts[i-1]);
        }
        for(int j=1;j<verticalCuts.length;j++){
            vl = Math.max(vl, verticalCuts[j] - verticalCuts[j-1]);
        }
        return (int)((hl * vl) % 1000000007);
    }
}