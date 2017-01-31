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
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> inorder = new ArrayList<>();
        TreeNode now = root;
        while (now != null || !stack.empty()) {
            while(now != null){
                stack.add(now);
                now = now.left;
            }
            //Stack peek(): Looks at the object at the top of this stack without removing it from the stack. return the object at the top of this stack; 
            //pop(): Removes the object at the top of this stack and returns that object as the value of this function
            // now = stack.peek();
            // stack.pop();
            now = stack.pop();
            inorder.add(now.val);
            now = now.right;
        }
        return inorder;
    }
}