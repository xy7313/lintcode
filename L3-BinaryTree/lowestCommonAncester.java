/**
 * 本代码由九章算法编辑提供。版权所有，转发请注明出处。
 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
 * - 现有的面试培训课程包括：九章算法班，系统设计班，算法强化班，Java入门与基础算法班，Android 项目实战班，Big Data 项目实战班，
 * - 更多详情请见官方网站：http://www.jiuzhang.com/?source=code
 */

//Version : Divide & Conquer

public class Solution {
    // 在root为根的二叉树中找A,B的LCA:
    // 如果找到了就返回这个LCA
    // 如果只碰到A，就返回A
    // 如果只碰到B，就返回B
    // 如果都没有，就返回null
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || root == node1 || root == node2) {
            return root;
        }
        
        // Divide
        TreeNode left = lowestCommonAncestor(root.left, node1, node2);
        TreeNode right = lowestCommonAncestor(root.right, node1, node2);
        
        // Conquer
        if (left != null && right != null) {
            return root;
        } 
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }
}

/**   一个更好理解的递归方法 
	 * 11. 求二叉树中两个节点的最低公共祖先节点 
	 * 递归解法： 
	 * （1）如果两个节点分别在根节点的左子树和右子树，则返回根节点
	 * （2）如果两个节点都在左子树，则递归处理左子树；如果两个节点都在右子树，则递归处理右子树
	 */
	public static TreeNode getLastCommonParentRec(TreeNode root, TreeNode n1, TreeNode n2) {
		if (findNodeRec(root.left, n1)) {				// 如果n1在树的左子树
			if (findNodeRec(root.right, n2)) { 		// 如果n2在树的右子树
				return root; 								// 返回根节点
			} else { 			// 如果n2也在树的左子树
				return getLastCommonParentRec(root.left, n1, n2); // 递归处理
			}
		} else { 				// 如果n1在树的右子树
			if (findNodeRec(root.left, n2)) { 			// 如果n2在左子树
				return root;
			} else {				 // 如果n2在右子树
				return getLastCommonParentRec(root.right, n1, n2); // 递归处理
			}
		}
	}

	// 帮助方法，递归判断一个点是否在树里
	private static boolean findNodeRec(TreeNode root, TreeNode node) {
		if (root == null || node == null) {
			return false;
		}
		if (root == node) {
			return true;
		}

		// 先尝试在左子树中查找
		boolean found = findNodeRec(root.left, node);
		if (!found) { 		// 如果查找不到，再在右子树中查找
			found = findNodeRec(root.right, node);
		}
		return found;
	}

    /**
	 * 非递归解法： (比较像lintcode中LCA2的解法)
	 * 先求从根节点到两个节点的路径，然后再比较对应路径的节点就行，最后一个相同的节点也就是他们在二叉树中的最低公共祖先节点
	 */
	public static TreeNode getLastCommonParent(TreeNode root, TreeNode n1, TreeNode n2) {
		if (root == null || n1 == null || n2 == null) {
			return null;
		}

		ArrayList<TreeNode> p1 = new ArrayList<TreeNode>();
		boolean res1 = getNodePath(root, n1, p1);
		ArrayList<TreeNode> p2 = new ArrayList<TreeNode>();
		boolean res2 = getNodePath(root, n2, p2);

		if (!res1 || !res2) {
			return null;
		}

		TreeNode last = null;
		Iterator<TreeNode> iter1 = p1.iterator();
		Iterator<TreeNode> iter2 = p2.iterator();

		while (iter1.hasNext() && iter2.hasNext()) {
			TreeNode tmp1 = iter1.next();
			TreeNode tmp2 = iter2.next();
			if (tmp1 == tmp2) {
				last = tmp1;
			} else { // 直到遇到非公共节点
				break;
			}
		}
		return last;
	}

	// 把从根节点到node路径上所有的点都添加到path中
	private static boolean getNodePath(TreeNode root, TreeNode node, ArrayList<TreeNode> path) {
		if (root == null) {
			return false;
		}
		
		path.add(root);		// 把这个节点加到路径中
		if (root == node) {
			return true;
		}

		boolean found = false;
		found = getNodePath(root.left, node, path); // 先在左子树中找
		
		if (!found) { 				// 如果没找到，再在右子树找
			found = getNodePath(root.right, node, path);
		}
		if (!found) { 				// 如果实在没找到证明这个节点不在路径中，说明刚才添加进去的不是路径上的节点，删掉！
			path.remove(root);	
		}

		return found;
	}