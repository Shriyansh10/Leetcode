// 73. Set Matrix Zeroes

public class Leetcode_73 {
    public static void main(String[] args) {
        Solution_73 s = new Solution_73();
        int matrix[][] = {{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};
        for(int i= 0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j] + " ");      
            }
            System.out.println();
        }
        s.setZeroes(matrix);
        for(int i= 0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j] + " ");      
            }
            System.out.println();
        }
    }
}

// Approach: Use Flags on 1st row and 1st column for refrence.
// TC: O(m*n) SC: O(1)
class Solution_73 {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean rowflag = false;
        boolean colflag = false;
        for(int i= 0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j] == 0){
                    if(i !=0 && j != 0){
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                    else{
                        if(i==0){
                            rowflag = true;
                        }
                        if(j==0){
                            
                            colflag = true;
                        }
                    }
                }
            }
        }
        for(int i= 1;i<rows;i++){
            if(matrix[i][0] == 0){
                for(int j=0;j<cols;j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int i= 1;i<cols;i++){
            if(matrix[0][i] == 0){
                for(int j=0;j<rows;j++){
                    matrix[j][i] = 0;
                }
            }
        }
        if(colflag == true) {
            for(int j=0;j<rows;j++){
                matrix[j][0] = 0;
            }
            
        }
        if(rowflag == true) {
            for(int j=0;j<cols;j++){
                matrix[0][j] = 0;
            }
        }
    }
}