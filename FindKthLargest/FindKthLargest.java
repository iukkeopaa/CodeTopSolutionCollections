package FindKthLargest;

import java.util.Arrays;

/**
 * @Description: 数组中的第K个最大元素
 * @Author: wjh
 * @Date: 2025/4/10 下午5:08
 */
public class FindKthLargest {

    public static int Solution(int[] nums, int k){

        Arrays.sort(nums);

        return nums[nums.length-k];

    }

    public static int Solution2(int[] nums,int k){

        int left = 0;
        int right = nums.length - 1;
        int target = nums.length - k;

        while (left < right) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == target) {
                return nums[pivotIndex];
            } else if (pivotIndex < target) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
        return nums[left];

    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(Solution2(nums, k));
    }
}
