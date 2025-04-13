package FindKthLargest;

import java.util.*;

public class Solution {
    private int quickSelect(List<Integer> nums, int k) {
        // 随机选择基准数
        Random rand = new Random();
        int pivot = nums.get(rand.nextInt(nums.size()));
        // 将大于、小于、等于 pivot 的元素划分至 big, small, equal 中
        List<Integer> big = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        for (int num : nums) {
            if (num > pivot)
                big.add(num);
            else if (num < pivot)
                small.add(num);
            else
                equal.add(num);
        }
        // 第 k 大元素在 big 中，递归划分
        if (k <= big.size())
            return quickSelect(big, k);
        // 第 k 大元素在 small 中，递归划分
        if (nums.size() - small.size() < k)
            return quickSelect(small, k - nums.size() + small.size());
        // 第 k 大元素在 equal 中，直接返回 pivot
        return pivot;
    }
    
    public int findKthLargest(int[] nums, int k) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        return quickSelect(numList, k);
    }

    public int findKthLargest2(int[] nums, int k)
    {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<>()
        {
            public int compare(Integer a, Integer b)
            {
                return b - a;
            }
        });

        for (int x : nums)
            maxHeap.offer(x);
        for (int ee = 0; ee < k - 1; ee ++)
            maxHeap.poll();
        return maxHeap.peek();
    }

    public int findKthLargest3(int[] nums, int k)
    {
        int n = nums.length;
        build_maxHeap(nums);
        for (int i = 0; i < k - 1; i ++)
        {
            int tmp = nums[0];
            nums[0] = nums[n-1-i];
            nums[n-1-i] = tmp;
            adjust_down(nums, 0, n-1-i - 1);
        }
        return nums[0];
    }


    public void build_maxHeap(int [] nums)
    {
        int n = nums.length;
        for (int root = n/2; root > -1; root --)
        {
            adjust_down(nums, root, n - 1);
        }
    }

    public void adjust_down(int [] nums, int root, int hi)
    {
        if (root > hi)
            return ;
        int t = nums[root];
        int child = 2 * root + 1;
        while (child <= hi)
        {
            if (child + 1 <= hi && nums[child] < nums[child + 1])
                child ++;
            if (t > nums[child])
                break;
            nums[root] = nums[child];
            root = child;
            child = 2 * root + 1;
        }
        nums[root] = t;
    }


    public int findKthLargest11(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();   // 将数组加入小顶堆，堆中维护当前值最大的k个数
        for(int num: nums){
            pq.offer(num);
            if(pq.size() > k){
                pq.poll();   // 堆中元素超过k个，弹出最小的那个
            }
        }
        return pq.peek();    // 最后堆顶的即为第k大的数
    }




}