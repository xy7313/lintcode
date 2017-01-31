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

    //recursive-traverse
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        traverse(root,result);
        return result;
    }
    private void traverse(TreeNode root, ArrayList<Integer> result){
        if(root==null) return;
        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }

    //recursive-divide and conquer
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root==null) return result;
        
        //divide
        ArrayList<Integer> left = preorderTraversal(root.left);
        ArrayList<Integer> right = preorderTraversal(root.right);
        //conquer
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        
        return result;
    }
}