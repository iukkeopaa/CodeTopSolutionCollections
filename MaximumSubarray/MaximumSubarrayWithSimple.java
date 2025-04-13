package MaximumSubarray;

/**
 * @Description: 最简单的思路
 * @Author: wjh
 * @Date: 2025/4/11 下午4:09
 */
public class MaximumSubarrayWithSimple {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

}
