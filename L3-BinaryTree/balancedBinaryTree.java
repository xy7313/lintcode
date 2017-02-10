//other method
public static boolean isAVLRec(TreeNode root) {
    if(root == null){			// 如果二叉树为空，返回真
        return true;
    }
    // 如果左子树和右子树高度相差大于1，则非平衡二叉树, getDepthRec()是前面实现过的求树高度的方法
    if(Math.abs(getDepthRec(root.left) - getDepthRec(root.right)) > 1){
        return false;
    }		
    // 递归判断左子树和右子树是否为平衡二叉树
    return isAVLRec(root.left) && isAVLRec(root.right);
}

//lintcode
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root)!=-1;
    }
    private int maxDepth(TreeNode root){
        if(root==null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if(left==-1 || right==-1 || Math.abs(left-right)>1){
            return -1;
        }
        return Max.max(left,right)+1;
    }
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