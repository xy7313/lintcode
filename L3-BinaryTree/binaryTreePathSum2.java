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
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
   public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        //buffer这名字意味着这个东西是起辅助作用的,帮助记录path，从而在得到target的时候可以在buffer中倒推找到validpath
        ArrayList<Integer> buffer = new ArrayList<Integer>();
        if (root == null)
            return results;
        findSum(root, target, buffer, 0, results);
        return results;
    }
//递归的定义：level的意思显而易见，但不太知道为什么用level
    public void findSum(TreeNode head, int sum, ArrayList<Integer> buffer, int level, List<List<Integer>> results) {
        if (head == null) return;
            //因为后面还要传入sum，所以copy一个sum值来操作而不在原数据上操作。这里对tmp sum的操作是-=，target-=nodes.vals直到等于0时，就说明这几个nodes sum==target
        int tmp = sum;
        buffer.add(head.val);
        for (int i = level;i >= 0; i--) {
            tmp -= buffer.get(i);
            if (tmp == 0) {
                //在buf中回找validPath
                List<Integer> validPath = new ArrayList<Integer>();
                for (int j = i; j <= level; ++j)
                    validPath.add(buffer.get(j));
                results.add(validPath);
            }
        }
        findSum(head.left, sum, buffer, level + 1, results);
        findSum(head.right, sum, buffer, level + 1, results);
        buffer.remove(buffer.size() - 1);
    }
}