public class Main {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        // int A[] ={-533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322, -667, 673, -336, 141, 711, -747, -132, 547, 644, -338, -243, -963, -141, -277, 741, 529, -222, -684, 35}; 
        // int B = 48;
        int A[] = {2, 3, 4, 3, 4, 4, 1};
        int B= 6;
        System.out.println(s.solve(A, B));
        
    }
}
class Solution1 {
    public int solve(int[] A, int B) {
        // int ar[] = new int[A.length];
        int max = 0;
        int res = Integer.MIN_VALUE;
        for(int i=0; i<A.length;i++){
            max += A[i];
        }
        // int f=0;
        // int l = A.length-1;
        for(int i=0;i<=B;i++){
            int sum=0;
            
            for(int j=i;j<i+A.length-B;j++){
                sum += A[j];
                System.out.print(A[j]+" ");
            }System.out.println();
            // for(int j=A.length-B+i;j<=A.length-1;j++){
            //     max += A[j];
                // System.out.print(A[j]+" ");
                
            // }
            if(max-sum > res)
            res= max-sum;
        }
        return res;
    }
}

