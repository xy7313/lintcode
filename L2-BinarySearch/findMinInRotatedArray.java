public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int start = 0, end = nums.length-1;    
        while(start+1<end){
            int mid = start + (end-start)/2;
            if(nums[mid]<=nums[nums.length-1]){
                end=mid;
            }else{
                start=mid;
                
            }
        }
        if(nums[start]<nums[end]) return nums[start];
        return nums[end];
    }
}