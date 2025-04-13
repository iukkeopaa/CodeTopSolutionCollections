package BinaryTreeMaxWidth;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    class Pair {
        TreeNode node;
        int index;
        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxWidth = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 1));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int left = queue.peek().index;
            int right = left;
            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                TreeNode node = current.node;
                right = current.index;
                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * right));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * right + 1));
                }
            }
            maxWidth = Math.max(maxWidth, right - left + 1);
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        Solution solution = new Solution();
        int maxWidth = solution.widthOfBinaryTree(root);
        System.out.println("二叉树的最大宽度是: " + maxWidth);
    }
}    