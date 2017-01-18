class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        long start = 1;
        long end = x;
        while(start<end){
            long mid = start+(end-start)/2;
            if(mid*mid==x) return (int)mid;
            else if(mid*mid>x) end = mid-1;
            else start = mid+1;
        }
        return start*start>x?(int)(start-1):(int)start;
    }
}