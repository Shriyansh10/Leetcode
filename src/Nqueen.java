// N-queen based on row 

import java.util.*;

public class Nqueen {
    public static void main(String[] args) {
        int n=4;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list = Solution.nQueen(n);
        System.out.println(list);

    }
}

class Solution{
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        Solution s=new Solution();
        int [][] matrix = new int [n][n];
        ArrayList<ArrayList<Integer>> finalans = new ArrayList<>();
        s.solve(matrix, 0, 0, finalans);
        return finalans;
    }
    
    protected void solve(int[][] matrix, int row, int col, ArrayList<ArrayList<Integer>> finalans){
        if(col==matrix.length || row ==matrix.length){
            if(row==matrix.length){
                ArrayList<Integer> ans = new ArrayList<>();
                for(int i=0;i<matrix.length;i++){
                    for(int j=0;j<matrix.length;j++){
                        if(matrix[i][j] == 1){
                            ans.add(j+1);
                            break;
                        }
                    }
                }
                finalans.add(new ArrayList<>(ans));
            }
            return;
        }
        for(int i=0;i<matrix.length;i++){
            if(isSafe(matrix, row, i)){
                matrix[row][i] = 1;
                // ans.add(col+1);
                solve(matrix, row+1, i, finalans);
                // ans.remove(ans.size()-1);
                matrix[row][i]=0;
            }
            // return;
        }
    }
    
    protected boolean isSafe(int [][]matrix, int row, int col){
        // upper diagonal
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(matrix[i][j] == 1){
                return false;
            }
        }
        // up 
        for(int i=row,j=col;i>=0 ;i--){
            if(matrix[i][j] == 1){
                return false;
            }
        }
        // lower diagonal
        for(int i=row,j=col;i>=0 && j<matrix.length;i--,j++){
            if(matrix[i][j] == 1){
                return false;
            }
        }
        return true;
    }
}