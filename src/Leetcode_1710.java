// 1710. Maximum Units on a Truck

public class Leetcode_1710 {
    public static void main(String[] args) {
        Solution_1710 s = new Solution_1710 ();
        int nums[][] = {{1,3},{2,2},{3,1}};
        int truckSize = 4;
        System.out.println(s.maximumUnits(nums,truckSize));
    }
}


class Solution_1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Arrays.sort(boxTypes, Comparator.comparingInt(o -> -o[1]));
        QuickSort(boxTypes,0,boxTypes.length-1);
        int count=0;
        for(int i=0;i<boxTypes.length;i++){
            int m = boxTypes[i][0]*boxTypes[i][1];
            if(boxTypes[i][0]<=truckSize){
                count += m;
                truckSize -= boxTypes[i][0];
            }
            else{
                count += boxTypes[i][1] * truckSize;
                break;
            }
        }
        return count;
    }
    
    void QuickSort(int boxTypes[][],int start,int end){
        if(start<end){
            int k=partition(boxTypes, start, end);
            QuickSort(boxTypes, start, k-1);
            QuickSort(boxTypes, k-1, end);
        }
    }
    
    int partition(int boxTypes[][], int start, int end){
        int k=boxTypes[start][1];
        int i = start;
        int j = end;
        while(i<j){
            while(boxTypes[i][1]<=k && i<end){
                i++;
            }
            while(boxTypes[j][1]>k && j>start){
                --j;
            }
            if(i<j){
                boxTypes[1][i] = boxTypes[1][i] + boxTypes[1][j];
                boxTypes[1][j] = boxTypes[1][i] - boxTypes[1][j];
                boxTypes[1][i] = boxTypes[1][i] - boxTypes[1][j];
            }
        }
        boxTypes[1][start] = boxTypes[1][start] + boxTypes[1][j];
        boxTypes[1][j] = boxTypes[1][start] - boxTypes[1][j];
        boxTypes[1][start] = boxTypes[1][start] - boxTypes[1][j];
        return j;
    }
}