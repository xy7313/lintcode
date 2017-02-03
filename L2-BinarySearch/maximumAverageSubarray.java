public class Solution {
    /**
     * @param nums an array with positive and negative numbers
     * @param k an integer
     * @return the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        double l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < l)
                l = nums[i];
            if (nums[i] > r)
                r = nums[i];
        }
        //average of subarray的区间是在arr.min -- arr.max
        double[] sum = new double[n + 1];
        sum[0] = 0;
        //we assume r-l<1e-6 is eaual as r==l
        while (r - l >= 1e-6) {
            double mid = (l + r) / 2.0;
            double min_pre = 0;
            boolean check = false;
            for (int i = 1; i <= n; ++i) {
                sum[i] = sum[i - 1] + nums[i - 1] - mid;
                //假设每一个nums[i]都-mid，如果结果还>=0，说明ave还可以更大，所以l=mid
                if (i >= k && sum[i] - min_pre >= 0) {
                    check = true;
                    break;
                }
                //这里表示非常不懂
                if (i >= k)
                    min_pre = Math.min(min_pre, sum[i - k + 1]);
            }
            if (check)
                l = mid;
            else
                r = mid;
        }
        return l;
    }
}