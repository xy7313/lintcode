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
 
class Result {
    public boolean a_exist, b_exist;
    public TreeNode node;
    Result(boolean a, boolean b, TreeNode n) {
        a_exist = a;
        b_exist = b;
        node = n;
    }
}
public class Solution {
    
    /**
     * @param root The root of the binary tree.
     * @param A and B two nodes
     * @return: Return the LCA of the two nodes.
     */
     //divide-conquer
     public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) { 
        Result re = help(root,A,B);
        if(re.a_exist && re.b_exist) return re.node;
        else return null;
    }
    private Result help(TreeNode root, TreeNode A, TreeNode B){
        if(root==null) return new Result(false, false, null);
        
        Result left = help(root.left, A, B);
        Result right = help(root.right, A, B);
        
        boolean aexi = left.a_exist || right.a_exist || root==A;
        boolean bexi = left.b_exist || right.b_exist || root==B;
        
        if(root==A || root==B || (left.node!=null && right.node!=null)){
            return new Result(aexi, bexi, root);
        }
        if(left.node!=null) return new Result(aexi, bexi, left.node);
        if(right.node!=null) return new Result(aexi, bexi, right.node);
        
        return new Result(aexi, bexi, null);
    }
}




















