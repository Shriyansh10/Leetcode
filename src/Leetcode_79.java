// 79. Word Search

public class Leetcode_79 {
    public static void main(String[] args) {
        Solution_79 s = new Solution_79();
        char [][]board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(s.exist(board, word));
    }
}

// Approach: BackTracking
// TC: O(N*3^L) SC: O(L) where N: no. of squares, L: Length of word  
class Solution_79 {
    public boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(backtrack(board, word, 0, visited, i, j)){
                    return true;
                }
            }
        }
        return false;
    }
                   
    boolean backtrack(char[][] board, String word, int index, int[][] visited, int i, int j){
        if(index == word.length()){
            return true;
        }
        if(j<0 || j>board[0].length-1 || i<0 || i>board.length-1 || visited[i][j] == 1 || word.charAt(index) != board[i][j]){
            return false;
        }
        visited[i][j] = 1;
        
        // left j-1
        boolean left = backtrack(board, word, index+1, visited, i, j-1);
        // right j+1
        boolean right = backtrack(board, word, index+1, visited, i,  j+1);
        // up i-1
        boolean up = backtrack(board, word, index+1, visited,  i-1,  j);
        // down i+1
        boolean down = backtrack(board, word, index+1, visited,  i+1,  j);

        visited[i][j] = 0;
        return (left || up || right || down);
    }
}