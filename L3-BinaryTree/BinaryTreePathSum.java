/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {

    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        ArrayList<Integer> path = new ArrayList<Integer>();
        //A valid path is from root node to any of the leaf nodes. So we always need to add root in each path.
        path.add(root.val);
        helper(root, path, root.val, target, result);
        return result;
    }
    //preorder、DFS + backtracking
    private void helper(TreeNode root,
                        ArrayList<Integer> path,
                        int sum,
                        int target,
                        List<List<Integer>> result) {
                            
        // 递归的出口：meet leaf && sum==target
        if (root.left == null && root.right == null) {
            if (sum == target) {
                result.add(new ArrayList<Integer>(path));
            }
            return;
        }
        //递归的拆解：分别去左右子树，用来算sum
        if (root.left != null) {
            path.add(root.left.val);
            helper(root.left, path, sum + root.left.val, target, result);
            //back-tracking, delete the last elementm of path to contruct new path
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.right.val);
            helper(root.right, path, sum + root.right.val, target, result);
            path.remove(path.size() - 1);
        }
    }
}