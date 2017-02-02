public class Solution {
    /**
     * @param A an integer array
     * @return void
     *///
     
    public void sortIntegers(int[] A) {
        if(A==null||A.length==0) return;
        int[] tmp = new int[A.length];
        mergeSort(A,0,A.length-1,tmp);
    }
    private void mergeSort(int[] A, int start, int end, int[] tmp){
        if(start>=end) return;
        
        mergeSort(A,start,(start+end)/2,tmp);
        mergeSort(A,(start+end)/2+1,end,tmp);
        merge(A,start,end,tmp);
    }
    private void merge(int[] A, int start, int end, int[] tmp){
        int mid = (start+end)/2;
        int left = start;
        int right = mid+1;
        int idx = left;
        
        while(left<=mid&&right<=end){
            if(A[left]<A[right]){
                tmp[idx++] = A[left++];
            }else{
                tmp[idx++] = A[right++];
            }
        }
        while(left<=mid){
            tmp[idx] = A[left];
            idx++;
            left++; 
        }
        while(right<=end){
            tmp[idx++] = A[right++];
        }
        for(int i = start; i<=end; i++){
            A[i] = tmp[i];
        }
    }
    

}