package IsSubtree;

import IsCompleteTree.TreeNode;

/**
 * @Description:
 * @Author: wjh
 * @Date: 2025/4/13 下午2:18
 */
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        if(isSame(s, t))
            return true;
        else
            return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode p, TreeNode q){
        if(q == null && p == null) return true;
        if(q == null || p == null) return false;
        if(q.val != p.val) return false;
        else return isSame(q.left, p.left) && isSame(q.right, p.right);
    }
}
