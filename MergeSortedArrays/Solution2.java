package MergeSortedArrays;

class Solution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail = nums1.length - 1;
        int i1 = m - 1;
        int i2 = n - 1;

        // 个人经常用 while true，然后在循环内部列出所有情况
        while (true) {
            // 都左移到头，退出
            if (i1 == -1 && i2 == -1) break;
            // 一方左移到头，选取另一方赋值，然后左移
            if (i1 == -1) {
                nums1[tail] = nums2[i2--];
            } else if (i2 == -1) {
                nums1[tail] = nums1[i1--]; // 也可以直接 i1--;
            } 
            // 选取大的元素赋值，然后左移
            else if (nums1[i1] > nums2[i2]) {
                nums1[tail] = nums1[i1--];
            } else {
                nums1[tail] = nums2[i2--];
            }
            tail--;
        }
    }
}

