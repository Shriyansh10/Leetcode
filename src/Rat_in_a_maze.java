import java.util.ArrayList;

public class Rat_in_a_maze {
    public static void main(String[] args) {
        // Solution1 s = new Solution1();
        // int[][] m = {{1, 0, 0, 0} ,{1, 1, 0, 1}, {1, 1, 0, 0,}, {0, 1, 1, 1}};
        int[][] m = {{0, 0} ,{1, 0}};
        int n = 2;
        ArrayList<String> list = findPath(m, n);
        System.out.println(list);
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> list = new ArrayList<>();
        String tempString= "";
        int[][] visited = new int[n][n];
        backtrack(m, n, 0, 0, list, tempString, visited);
        return list;
    }
    
    private static void backtrack(int[][] m, int n, int i, int j, ArrayList<String> list,
                            String tempString, int[][] visited){
        if(i==n-1 && j==n-1 && m[i][j] == 1){
            list.add(tempString);
            return;
        }                      
        if(i<0 || i==n || j<0 || j==n || visited[i][j] == 1 || m[i][j] == 0){
            return;
        }
        visited[i][j] = 1;
        
        // left ;
        backtrack(m, n, i, j-1, list, tempString+ "L", visited);
        // right
        backtrack(m, n, i, j+1, list, tempString + "R", visited);
        // up
        backtrack(m, n, i-1, j, list, tempString + "U", visited);
        // down
        backtrack(m, n, i+1, j, list, tempString + "D", visited);
        visited[i][j] = 0;
    }
}