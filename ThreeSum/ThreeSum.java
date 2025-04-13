package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 三数之和
 * @Author: wjh
 * @Date: 2025/4/11 下午3:53
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if (nums==null||nums.length<3){
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return result;
    }





    }

