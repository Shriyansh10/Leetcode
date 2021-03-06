// N-queen based on row 

import java.util.*;

public class Nqueen {
    public static void main(String[] args) {
        int n=4;
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        list = Solution.nQueen(n);
        System.out.println(list);

    }
}

class Solution{
    static ArrayList<ArrayList<String>> nQueen(int n) {
        Solution s=new Solution();
        int [][]matrix = new int [n][n];
        int []colhash = new int [n];
        int []leftdiagonalhash = new int[2*n-1];
        int []rightdiagonalhash = new int[2*n-1];
        ArrayList<ArrayList<String>> finalans = new ArrayList<>();
        s.solve(matrix, 0, 0, finalans, colhash, leftdiagonalhash, rightdiagonalhash);
        return finalans;
    }
    
    protected void solve(int[][] matrix, int row, int col, ArrayList<ArrayList<String>> finalans, int []colhash, int []leftdiagonalhash, int []rightdiagonalhash){
        if(col==matrix.length || row ==matrix.length){
            if(row==matrix.length){
                ArrayList<String> ans = new ArrayList<>();
                String s =new String();
                for(int i=0;i<matrix.length;i++){
                    for(int j=0;j<matrix.length;j++){
                        if(matrix[i][j] == 1){
                            s +="Q";
                        }else{
                            s += ".";
                        }
                    }
                    ans.add(s);
                    s = "";
                }
                // for(int i=0;i<matrix.length;i++){
                //     for(int j=0;j<matrix.length;j++){
                //         if(matrix[i][j] == 1){
                //             ans.add(j+1);
                //             break;
                //         }
                //     }
                // }
                finalans.add(new ArrayList<>(ans));
            }
            return;
        }
        for(int i=0;i<matrix.length;i++){
            if(isSafe(matrix, row, i, colhash, leftdiagonalhash, rightdiagonalhash)){
                matrix[row][i] = 1;
                colhash[i] = 1;
                leftdiagonalhash[row - i + matrix.length -1] = 1;
                rightdiagonalhash[2*matrix.length -2 - row - i] = 1;
                solve(matrix, row+1, i, finalans, colhash, leftdiagonalhash, rightdiagonalhash);
                matrix[row][i]=0;
                colhash[i] = 0;
                leftdiagonalhash[row - i + matrix.length -1] = 0;
                rightdiagonalhash[2*matrix.length -2 - row - i] = 0;
            }
        }
    }
    
    protected boolean isSafe(int [][]matrix, int row, int col, int []colhash, int []leftdiagonalhash, int []rightdiagonalhash){
        // left diagonal
        if(leftdiagonalhash[row - col + matrix.length -1] == 1){
            return false;
        }
        // up 
        if(colhash[col] == 1){
            return false;
        }
        // right diagonal
        if(rightdiagonalhash[2*matrix.length -2 - row - col] == 1){
            return false;
        }
        return true;
    }
}