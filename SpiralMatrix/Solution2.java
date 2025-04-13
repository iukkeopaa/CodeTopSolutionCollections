package SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上


    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int size = m * n;
        List<Integer> ans = new ArrayList<>(m * n); // 预分配空间
        int i = 0;
        int j = -1; // 从 (0, -1) 开始
        for (int di = 0; ans.size() < size; di = (di + 1) % 4) {
            for (int k = 0; k < n; k++) { // 走 n 步（注意 n 会减少）
                i += DIRS[di][0];
                j += DIRS[di][1]; // 先走一步
                ans.add(matrix[i][j]); // 再加入答案
            }
            int tmp = n;
            n = m - 1; // 减少后面的循环次数（步数）
            m = tmp;
        }
        return ans;
    }
}
