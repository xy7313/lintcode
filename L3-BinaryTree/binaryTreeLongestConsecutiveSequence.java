/**
 * 本代码由九章算法编辑提供。版权所有，转发请注明出处。
 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
 * - 现有的面试培训课程包括：九章算法班，系统设计班，算法强化班，Java入门与基础算法班，Android 项目实战班，Big Data 项目实战班，
 * - 更多详情请见官方网站：http://www.jiuzhang.com/?source=code
 */

// version 1: Traverse + Divide Conquer
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int longest;
    
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        longest = 0;
        helper(root);
        return longest;
    }
    
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        int subtreeLongest = 1; // at least we have root
        if (root.left != null && root.val + 1 == root.left.val) {
            subtreeLongest = Math.max(subtreeLongest, left + 1);
        }
        if (root.right != null && root.val + 1 == root.right.val) {
            subtreeLongest = Math.max(subtreeLongest, right + 1);
        }
        
        if (subtreeLongest > longest) {
            longest = subtreeLongest;
        }
        return subtreeLongest;
    }
}

// version 2: Another Traverse + Divide Conquer 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int longest;
    
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        return helper(root, null, 0);
    }
    
    private int helper(TreeNode root, TreeNode parent, int lengthWithoutRoot) {
        if (root == null) {
            return 0;
        }
        int length = (parent != null && parent.val + 1 == root.val)
            ? lengthWithoutRoot + 1
            : 1;
        int left = helper(root.left, root, length);
        int right = helper(root.right, root, length);
        return Math.max(length, Math.max(left, right));
    }
}


//divide Conquer
public class Solution {
    
    private class Result {
        private int subMax;
        private int rootMax;
        public Result(int subMax, int rootMax){
            this.subMax = subMax;
            this.rootMax = rootMax;
        }
    }
    
    public int longestConsecutive(TreeNode root) {
        //通过这个返回值可以看出，subMax要一直保存的是当前root最大，之所以叫sub是他是自己parent的sub,
       return helper(root).subMax;
    }
    private Result helper(TreeNode root){
        if(root==null) return new Result(0,0);
        
        Result left = helper(root.left);
        Result right = helper(root.right);
        Result curRoot = new Result(0,1);
        
        if(root.left!=null && root.val + 1 == root.left.val){
            curRoot.rootMax = Math.max(curRoot.rootMax,left.rootMax+1);
        }
        if(root.right!=null && root.val + 1 == root.right.val){
            curRoot.rootMax = Math.max(curRoot.rootMax,right.rootMax+1);
        }
         curRoot.subMax = Math.max(curRoot.rootMax, Math.max(left.subMax,right.subMax));

        return curRoot;
    }
}

















