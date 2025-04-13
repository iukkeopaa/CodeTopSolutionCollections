package LongestCommonSubarray;

public class LongestCommonSubarraySlidingWindow {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int maxLength = 0;

        // 让 nums2 在 nums1 上滑动
        for (int i = 0; i < m + n - 1; i++) {
            int start1 = Math.max(0, m - 1 - i);
            int start2 = Math.max(0, i - (m - 1));
            int len = 0;
            for (int j = 0; start1 + j < m && start2 + j < n; j++) {
                if (nums1[start1 + j] == nums2[start2 + j]) {
                    len++;
                    maxLength = Math.max(maxLength, len);
                } else {
                    len = 0;
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestCommonSubarraySlidingWindow solution = new LongestCommonSubarraySlidingWindow();
        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 4, 7};
        int result = solution.findLength(nums1, nums2);
        System.out.println("最长公共子数组的长度是: " + result);
    }
}    