package LevelOrder;


import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

class Solution3 {
    public List<List<Integer>> levelOrder(TreeNode1 root) {
        if (root == null) return List.of();
        List<List<Integer>> ans = new ArrayList<>();
        List<TreeNode1> cur = List.of(root);
        while (!cur.isEmpty()) {
            List<TreeNode1> nxt = new ArrayList<>();
            List<Integer> vals = new ArrayList<>(cur.size()); // 预分配空间
            for (TreeNode1 node : cur) {
                vals.add(node.val);
                if (node.left != null)  nxt.add((TreeNode1) node.left);
                if (node.right != null) nxt.add((TreeNode1) node.right);
            }
            cur = nxt;
            ans.add(vals);
        }
        return ans;
    }
}