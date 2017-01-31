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
     * @return: Postorder in ArrayList which contains node values.
     */
     //iteration
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> postorder = new ArrayList<>();
        TreeNode prev = null;
        TreeNode curr = root;
        
        if(root == null) return postorder;
        
        stack.push(root);
        while(!stack.empyt()){
            curr = stack.peek();
            // traverse down the tree
            if(prev == null || prev.left==curr || prev.right==curr){
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            }else if (curr.left == prev){//traverse up from left
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            }else{// traverse up from right
                postorder.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }
        
        return postorder;
    }
    //recursive-divide and conquer
     public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> postorder = new ArrayList<>();
        if(root==null) return postorder;
        postorder.addAll(postorderTraversal(root.left));
        postorder.addAll(postorderTraversal(root.right));
        postorder.add(root.val);
        return postorder;
    }
}