public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if(A==null||A.length==0) return -1;
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for(int i = 0; i<A.length; i++){
            if(A[i]<min){
                min = A[i];
                idx = i;
            } 
        }
        int subMin = -1;
        subMin= BS(idx, A.length-1, A, target);
        if(subMin ==-1) subMin = BS(0, idx, A, target);
        return subMin;
    }
    public int BS(int start, int end, int[] B,int target){
        while(start+1<end){
            int mid = start+(end-start)/2;
            if(B[mid]==target){
                return mid;
            }else if(B[mid]<target){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(B[start]==target) return start;
        if(B[end]==target) return end;
        return -1;
    }
}
