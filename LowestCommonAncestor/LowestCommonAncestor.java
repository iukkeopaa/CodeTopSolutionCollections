package LowestCommonAncestor;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
     // // 如果 right 为空，只需要看 left
        //        else if(left != null && right == null){
        //            return left;
        //        }
        //        // 如果 left 为空，只需要看 right
        //        else if(left == null && right != null){
        //            return right;
        //        }
        //        // 如果都为空，返回空
        //        else{
        //            return null;
        //        }
        //

        return left != null ? left : right;
    }

    public static void main(String[] args) {
        // 构建一个简单的二叉树
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        LowestCommonAncestor solution = new LowestCommonAncestor();
        TreeNode p = root.left; 
        TreeNode q = root.right;
        TreeNode result = solution.lowestCommonAncestor(root, p, q);
        System.out.println("最近公共祖先的值是: " + result.val);
    }
}    