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
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
     //divide-conquer
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        
        //3. exit
        if(root==null) return paths;
        
        //leaf
        if(root.left == null && root.right == null){
            paths.add(root.val+"");
            return paths;
        }

        //2. split
        List<String> left =binaryTreePaths(root.left);
        List<String> right =binaryTreePaths(root.right);
        //left==[], skip for()
        for(String l : left){
            paths.add(root.val+"->"+l);
        }
        for(String r : right){
            paths.add(root.val+"->"+r);
        }
        return paths;
    }

    // helper-traverse
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root==null) return result;
        helper(root,String.valueOf(root.val),result);
        return result;
    }
    private void helper(TreeNode root, String path, List<String> result){
        if(root==null) return;
        if(root.left == null && root.right == null){
            result.add(path);
        }
        if(root.left!=null){
            helper(root.left, path+"->"+String.valueOf(root.left.val), result);
        }
        if(root.right!=null){
            helper(root.right, path+"->"+String.valueOf(root.right.val), result);
        }
    }
}