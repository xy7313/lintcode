class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
     if(nums==null||nums.length==0||target<0||target>nums[nums.length-1]) return -1;
       int start = 0, end = nums.length-1;
       while(start<end){
           int mid = start+(end-start)/2;
           //下面两句可以合并成 if (nums[mid]>=target) end = mid;
           if(nums[mid]==target) end=mid;
           else if (nums[mid]>target) end = mid-1;
           else start = mid+1;
       }
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }
}