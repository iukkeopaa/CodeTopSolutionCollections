package LevelOrder;

import javax.swing.tree.TreeNode;

class TreeNode1 {
      int val;
     TreeNode left;
    TreeNode right;
     TreeNode1() {}

    TreeNode1(int val) { this.val = val; }
	TreeNode1(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
      }
  }