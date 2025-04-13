package ThreeSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution4{
    // 定义 threeSum 方法找到所有不重复的三元组，它们的和为 0
    public List<List<Integer>> threeSum(int[] nums) {
        // 先对数组进行排序
        Arrays.sort(nums);
        // 创建一个列表来保存结果
        List<List<Integer>> res = new LinkedList<>();
        // 遍历数组，注意我们要停在倒数第三个数，因为我们至少需要三个数
        for (int i = 0; i < nums.length - 2; i++) {
            // 如果当前数字大于0，则后面不可能有三个数加和等于0，直接返回结果
            if (nums[i] > 0) break;
            // 跳过数组中重复的元素
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                // 开始两数之和的双指针搜索
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        // 找到一组解
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        // 跳过重复值
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++; hi--;
                    } else if (nums[lo] + nums[hi] < sum) {
                        // 如果和小于 sum，移动左指针
                        lo++;
                    } else {
                        // 如果和大于 sum，移动右指针
                        hi--;
                    }
                }
            }
        }
        // 返回结果
        return res;
    }
}