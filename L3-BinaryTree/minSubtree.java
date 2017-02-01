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

//only divide-conquer?

public class Solution {
    class Result{
        int sum;
        int min;
        TreeNode minroot;
        public Result(int sum,  TreeNode minroot,int min){
            this.sum = sum;
            this.minroot=minroot;
            this.min = min;
        }
    }
    
    public TreeNode findSubtree(TreeNode root){
        return helper(root).minroot;
    }
    private Result helper(TreeNode root){
        if(root==null) return new Result(0,null,Integer.MAX_VALUE);
        //divide
        Result left = helper(root.left);
        Result right = helper(root.right);
        //conquer
        Result r = new Result(root.val,root,root.val);
        r.sum = root.val+left.sum+right.sum;
        if(r.sum<left.min&&r.sum<right.min){
            return new Result(r.sum,r.minroot,r.sum);
        }else if(r.sum>left.min&&left.min<right.min){
            return new Result(r.sum,left.minroot,left.min);
        }else{
            return new Result(r.sum,right.minroot,right.min);
        }
    }
}