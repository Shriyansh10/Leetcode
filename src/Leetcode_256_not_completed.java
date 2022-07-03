public class Leetcode_256_not_completed {
    public static void main(String[] args) {
        int ar[][] = {{3,5,3},{6,17,6},{7,13,18},{9,10,18}};
        Solution_256 s = new Solution_256();
        System.out.println(s.minCost(ar));
    }
}

class Solution_256 {
    public int minCost(int[][] costs) {
        int rgb = 0;
        if(costs[0][0]< costs[0][1]){
           rgb = 0;
        } 
        if(costs[0][1]< costs[0][2]){
            rgb = 1;
        }
        if(costs[0][2]< costs[0][0]){
            rgb = 2;
        }
        int minsum = costs[0][rgb] + findmin(costs, costs.length, 1, rgb);
        return minsum;
    }
    int findmin(int costs[][],int n,int i,int rgb){
        if(i==n-1){
            if(rgb == 2){
                if(costs[0][0]< costs[0][1]){
                    rgb = 0;
                } 
                else{
                    rgb = 1;
                }
            }
            else if(rgb == 1){
                if(costs[0][0]< costs[0][2]){
                    rgb = 0;
                } 
                else{
                    rgb = 2;
                }
            }
            else{
                if(costs[0][2]< costs[0][1]){
                    rgb = 2;
                } 
                else{
                    rgb = 1;
                }
            }
            return costs[i][rgb];
        }
        
        if(rgb == 2){
            if(costs[0][0]< costs[0][1]){
                rgb = 0;
            } 
            else{
                rgb = 1;
            }
        }
        else if(rgb == 1){
            if(costs[0][0]< costs[0][2]){
                rgb = 0;
            } 
            else{
                rgb = 2;
            }
        }
        else{
            if(costs[0][2]< costs[0][1]){
                rgb = 2;
            } 
            else{
                rgb = 1;
            }
        }
        return costs[i][rgb] + findmin(costs, n, ++i, rgb);
    }
}
