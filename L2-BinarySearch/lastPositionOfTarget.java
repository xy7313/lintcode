//answer
public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public int lastPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                //注意这里！！
                start = mid;
            } else if (nums[mid] < target) {
                start = mid;
                // or start = mid + 1
            } else {
                end = mid;
                // or start = mid - 1
            }
        }
        
        if (nums[end] == target) {
            return end;
        }
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }
}
//xy7313
public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public int lastPosition(int[] nums, int target) {
        // Write your code here
        //代码一直跑不过，有个超时错误，就想这个可能要二分查找了，可是题目一点线索都没有，真坑，查了下答案，果然是要二分查找的。。。
       if(nums==null||nums.length==0||target<0||target>nums[nums.length-1]) return -1;
       int start = 0, end = nums.length-1;
       while(start<end){
           int mid = start+(end-start)/2;
           if(nums[mid]==target&&(mid==(nums.length-1)||nums[mid+1]!=target)) return mid;
           else if (nums[mid]>target) end = mid-1;
           else start = mid+1;
       }
       if (nums[end] == target) {
            return end;
        }
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }
}