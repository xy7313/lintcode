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
 //traverse+divide-conquer
public class Solution {
    private TreeNode sub = null;
    private int subSum = Integer.MAX_VALUE;
    /**
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        helper(root);
        return sub;
    }
    private int helper(TreeNode root){
        if(root==null) return 0;
        int sum = helper(root.left)+helper(root.right)+root.val;
        if(sum<subSum){
            subSum = sum;
            sub=root;
        }
        return sum;
    }
}