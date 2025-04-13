package LevelOrder;

import javax.swing.tree.TreeNode;
import java.util.*;


public class Solution {
	public List<List<Integer>> levelOrder(TreeNode1 root) {
		if(root==null) {
			return new ArrayList<List<Integer>>();
		}
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		LinkedList<TreeNode1> queue = new LinkedList<TreeNode1>();
		//将根节点放入队列中，然后不断遍历队列
		queue.add(root);
		while(queue.size()>0) {
			//获取当前队列的长度，这个长度相当于 当前这一层的节点个数
			int size = queue.size();
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			//将队列中的元素都拿出来(也就是获取这一层的节点)，放到临时list中
			//如果节点的左/右子树不为空，也放入队列中
			for(int i=0;i<size;++i) {
				TreeNode1 t = queue.remove();
				tmp.add(t.val);
				if(t.left!=null) {
					queue.add((TreeNode1) t.left);
				}
				if(t.right!=null) {
					queue.add((TreeNode1) t.right);
				}
			}
			//将临时list加入最终返回结果中
			res.add(tmp);
		}
		return res;
	}
}