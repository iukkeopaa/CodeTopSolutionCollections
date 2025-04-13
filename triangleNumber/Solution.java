package triangleNumber;

import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n - 2; ++i) {
            for (int j = i + 1; j < n - 1; ++j) {
                int s = nums[i] + nums[j];
                int l = j + 1, r = n - 1;
                while (l < r) {
                    int mid = l + r + 1 >>> 1;
                    if (nums[mid] < s) l = mid;
                    else r = mid - 1;
                }
                if (nums[r] < s) {
                    res += r - j;
                }
            }
        }
        return res;
    }
}