public class Solution {
    /**
     * @param A an integer array
     * @return void
     *///
     
    public void sortIntegers(int[] A) {
        if(A==null||A.length==0) return;
         helper(A,0,A.length-1);
    }
    private void helper(int[] a, int start, int end){
        if(start>=end) return;
        int left = start, right = end;
        int pivot = a[(start+end)/2];
        
        while(left<=right) {
            //a[left]<pivot是为了确保指针停在a[left]>=pivot的位置
            while(left<=right && a[left]<pivot){
                left++;
            }
            while(left<=right && a[right]>pivot){
                right--;
            }
            if(left<=right){
                int tmp = a[left];
                a[left]=a[right];
                a[right]=tmp;
                left++;
                right--;
            }
        }
        helper(a,start,right);
        helper(a,left,end);
    }
}