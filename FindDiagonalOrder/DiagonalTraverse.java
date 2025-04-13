package FindDiagonalOrder;

import java.util.ArrayList;
import java.util.List;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        List<Integer> list = new ArrayList<>();
        boolean up = true;
        int row = 0, col = 0;
        while (row < m && col < n) {
            list.add(mat[row][col]);
            if (up) {
                if (col == n - 1) {
                    row++;
                    up = false;
                } else if (row == 0) {
                    col++;
                    up = false;
                } else {
                    row--;
                    col++;
                }
            } else {
                if (row == m - 1) {
                    col++;
                    up = true;
                } else if (col == 0) {
                    row++;
                    up = true;
                } else {
                    row++;
                    col--;
                }
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        DiagonalTraverse dt = new DiagonalTraverse();
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] result = dt.findDiagonalOrder(mat);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}