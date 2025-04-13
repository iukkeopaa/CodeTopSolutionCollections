package sumNumbers;



class Solution2 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int x) {
        if (node == null) {
            return 0;
        }
        x = x * 10 + node.val;
        if (node.left == node.right) { // node 是叶子节点
            return x;
        }
        return dfs(node.left, x) + dfs(node.right, x);
    }
}