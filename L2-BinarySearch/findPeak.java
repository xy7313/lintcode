class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        if(A==null||A.length<3) return 0;
        int start = 0, end = A.length-1;
        while(start+1<end){
            int mid = start+(end-start)/2;
            if(A[mid]>A[mid-1]&&A[mid+1]>A[mid]){
                start = mid;
            }else if(A[mid]>A[mid-1]&&A[mid+1]<A[mid]){
                return mid;   
            }else{
                end = mid;
            }
        }
        return 0;
    }
}
