public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        if(L==null||L.length==0) return 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i: L){
            if(max<i) max = i;
            sum+=i;
        }
        int start = 1, end = max;
        while(start+1<end){
            int mid = start+(end-start)/2;
            int piece=len(L,mid);
            if(piece>=k){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(len(L,end)>=k) return end;
        if(len(L,start)>=k) return start;
        return 0;
    }
    public int len(int[] L,int mid){
        int len = 0;
        for(int i:L){
            len+=(i/mid);
        }
        return len;
    }
}