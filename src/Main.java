import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        // int B = 48;
        // int A[] = {10,20};
        // int B[] = {2,17,18,19};
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2 );
        arr.add(5  );
        arr.add(8  );
        arr.add(11 );
        arr.add( 13);
        ArrayList<Integer> l1 = s.subsetSums(arr,5);
        Collections.sort(l1);
        // for (int i = 0; i < ar.length; i++) {
            System.out.println(l1);
        // }
        
    }
}
class Solution1{
    // ArrayList<Integer> l = new ArrayList<>();
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> l = new ArrayList<>();
        solve(arr, N, 0 ,l);
        return l;
    }
    
    public void solve(ArrayList<Integer> arr, int N, int i, ArrayList<Integer> l){
        int sum = 0;
        if(i==N){
            l.add(0);
            return;
        }
        for( int j=i;j<N;j++){
            sum = 0;
            for(int k= i;k<=j;k++){
                sum += arr.get(k);
            }
            l.add(sum);
            
        }
        solve(arr, N, i+1 ,l);
    }
}




