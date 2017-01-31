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
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
     //iteration
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> preorder = new ArrayList<Integer>();
        
        if(root == null) return preorder;
        
        stack.push(root);
        while(!stack.empty()){
            TreeNode now = stack.pop();
            preorder.add(now.val);
            // stack-first in last out
            if(now.right!=null){
                stack.push(now.right);
            }
            if(now.left!=null){
                stack.push(now.left);   
            }
        }
        return preorder;
    }
}