package MaximumSubarray;

public class MaximumSubarrayWithDP {
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        //dp[i] 代表以元素 nums[i] 为结尾的连续子数组最大和
        int[] dp = new int[n];
        dp[0] = nums[0];
        int maxSum = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

    public int maxSubArrayWithGoodSpace(int[] nums) {
        int n = nums.length;
        int prev = nums[0], max = nums[0];

        for (int i = 1; i < n; i++) {
            prev = Math.max(prev + nums[i], nums[i]);
            max = Math.max(max, prev);
        }

        return max;
    }


    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maxSubArray(nums);
        System.out.println("最大子数组和为: " + result);
    }
}    
