
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root)!=-1;
    }
    private int maxDepth(TreeNode root){
        if(root==null) return 0;
    }
    
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    if(left==-1 || right==-1 || Math.abs(left-right)>1){
        return -1;
    }
    return Max.max(left,right)+1;
}

//with Result
public class Solution {
    class Result{
        int maxdepth;
        boolean isBalanced;
        public Result(boolean isBalanced, int maxdepth){
            this.isBalanced = isBalanced;
            this.maxdepth = maxdepth;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }
    private Result helper(TreeNode root){
        if(root==null) return new Result(true,0);
    
    
        Result left = helper(root.left);
        Result right = helper(root.right);
        if(!left.isBalanced || !right.isBalanced || Math.abs(left.maxdepth-right.maxdepth)>1){
            return new Result(false,0);
        }
        return new Result(true,Math.max(left.maxdepth,right.maxdepth)+1);
    }
}