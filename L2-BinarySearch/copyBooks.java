public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        if (pages.length == 0) {
            return 0;  
        }
        //start = pages.max, end = pages.sum
        int max = Integer.MIN_VALUE, sum = 0;
        for(int p : pages){
            if(max<p) max = p;
            sum+=p;
        }
        int start = max;
        int end = sum;
        while(start+1<end){
            int mid = start+(end-start)/2;
            if(people(pages,mid)>k){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(people(pages,start)<=k) return start;
        return end;
    }
 private int people(int[] pages, int limit) {
        if (pages.length == 0) {
            return 0;
        }
        
        int copiers = 1;
        int sum = pages[0]; // limit is always >= pages[0]
        for (int i = 1; i < pages.length; i++) {
            if (sum + pages[i] > limit) {
                copiers++;
                sum = 0;
            }
            sum += pages[i];
        }
        
        return copiers;
    }    
}