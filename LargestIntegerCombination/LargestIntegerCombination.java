package LargestIntegerCombination;

import java.util.Arrays;
import java.util.Comparator;

public class LargestIntegerCombination {
    public String largestNumber(int[] nums) {
        // 将整数数组转换为字符串数组
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // 自定义比较器
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }
        });

        // 如果最大的数是 0，则直接返回 "0"
        if (strs[0].equals("0")) {
            return "0";
        }

        // 将排序后的字符串拼接成结果
        StringBuilder result = new StringBuilder();
        for (String str : strs) {
            result.append(str);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        LargestIntegerCombination solution = new LargestIntegerCombination();
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(solution.largestNumber(nums));
    }
}    