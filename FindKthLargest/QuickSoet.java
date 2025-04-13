package FindKthLargest;

/**
 * @Description: 快排
 * @Author: wjh
 * @Date: 2025/4/10 下午5:22
 */
public class QuickSoet
{
    public int findKthLargest(int[] nums, int k)
    {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (true)
        {
            int idx = partition(nums, l, r);
            if (idx == k - 1)
                return nums[idx];
            else if (idx < k - 1)
                l = idx + 1;
            else
                r = idx - 1;
        }

    }

    //----左右交换
    public int partition(int [] nums, int l, int r)
    {
        int pivot = nums[l];
        int begin = l;
        while (l < r)
        {
            while (l < r && nums[r] <= pivot)
                r --;
            while (l < r && nums[l] >= pivot)
                l ++ ;
            if (l < r)
            {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }
        }

        int tmp = nums[begin];
        nums[begin] = nums[l];
        nums[l] = tmp;
        return l;
    }

    //----左右挖坑互填
    public int partition2(int [] nums, int l, int r)
    {
        int pivot = nums[l];
        while (l < r)
        {
            while (l < r && nums[r] <= pivot)
                r --;
            nums[l] = nums[r];
            while (l < r && nums[l] >= pivot)
                l ++;
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }

    //----左右挖坑互填
    public int partition3(int [] nums, int l, int r)
    {
        int pivot = nums[l];
        int idx = l;
        for (int i = l + 1; i < r + 1; i ++)
        {
            if (nums[i] >= pivot)
            {
                idx ++;
                int tmp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = tmp;
            }
        }
        int tmp = nums[l];
        nums[l] = nums[idx];
        nums[idx] = tmp;
        return idx;
    }






}
