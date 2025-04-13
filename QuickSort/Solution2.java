package QuickSort;

import java.util.concurrent.ThreadLocalRandom;

class Solution2 {
    // 主排序方法
    public int[] sortArray(int[] a) {
        quick(a, 0, a.length - 1); // 调用快速排序
        return a; // 返回已排序的数组
    }
    // 快速排序递归方法
    void quick(int[] a, int left, int right) {
        if (left >= right) { // 如果子数组长度为0或1，则无需排序
            return;
        }
        int p = partition(a, left, right); // 执行分区操作，返回基准位置
        quick(a, left, p - 1); // 对左子数组进行递归排序
        quick(a, p + 1, right); // 对右子数组进行递归排序
    }
    // 分区方法
    int partition(int[] a, int left, int right) {
        int idx = ThreadLocalRandom.current().nextInt(right - left + 1) + left; // 随机选择一个元素作为基准
        swap(a, left, idx); // 将基准移到最左边
        int pv = a[left]; // 基准值
        int i = left + 1; // 左指针
        int j = right; // 右指针
        while (i <= j) { // 当左指针不超过右指针时
            while (i <= j && a[i] < pv) { // 从左向右找到第一个大于等于基准的元素
                i++;
            }
            while (i <= j && a[j] > pv) { // 从右向左找到第一个小于等于基准的元素
                j--;
            }
            if (i <= j) { // 如果找到了这样的两个元素
                swap(a, i, j); // 交换它们
                i++; // 移动左指针
                j--; // 移动右指针
            }
        }
        swap(a, j, left); // 将基准放到最终位置
        return j; // 返回基准的位置
    }
    // 交换数组中的两个元素
    void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}




