/**
 * 本代码由九章算法编辑提供。版权所有，转发请注明出处。
 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
 * - 现有的面试培训课程包括：九章算法班，系统设计班，算法强化班，Java入门与基础算法班，Android 项目实战班，Big Data 项目实战班，
 * - 更多详情请见官方网站：http://www.jiuzhang.com/?source=code
 */

// version 1 Traverse
public class Solution {
    private int lastVal = Integer.MIN_VALUE;
    private boolean firstNode = true;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (!firstNode && lastVal >= root.val) {
            return false;
        }
        firstNode = false;
        lastVal = root.val;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }
}

//divide conquer
class Result{
        boolean is_bst;
        int maxValue, minValue;
    
        Result(boolean is_bst, int maxValue, int minValue) {
            this.is_bst = is_bst;
            this.maxValue = maxValue;
            this.minValue = minValue;
        }
    }
public class Solution {
    
    public boolean isValidBST(TreeNode root) {
        Result r = validate(root);
        return r.is_bst;
    }
    private Result validate(TreeNode root){
        if(root==null ) return new Result(true,Integer.MIN_VALUE,Integer.MAX_VALUE);
        
        Result left = validate(root.left);
        Result right = validate(root.right);
        
        if(!left.is_bst || !right.is_bst){
            return new Result(false,0,0);
        }
        if(root.left!=null&& left.maxValue>=root.val){
            return new Result(false,0,0);
        }
        if(root.right!=null&& right.minValue<=root.val){
            return new Result(false,0,0);
   
        }
        return new Result(true,
                            // Math.max(left.maxValue,root.val),
                            // Math.min(right.minValue,root.val)
                            //每个点都保持的两个属性是当前点子树中可能足底啊和可能最小，所以可能最大从右边出，可能最小从左边出，上面的是我写错的代码，警示一下
                            Math.max(right.maxValue,root.val),
                            Math.min(left.minValue,root.val)
                            );
    }
}