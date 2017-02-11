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
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
     //先是自己写的一个方法，BFS
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        List<ListNode> result = new ArrayList<ListNode>();
        if(root==null) return result;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            ListNode head = null;
            ListNode dummy = new ListNode(0);
            
            int size = queue.size();
            for(int i = 0; i<size; i++){
                TreeNode cur = queue.poll();
                ListNode ln = new ListNode(cur.val);
                
                if(head==null){
                    head = ln;
                    dummy.next = head;
                }  
                else if (head!=null){
                    head.next = ln;
                    head = head.next;
                }

                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
            }
            result.add(dummy.next);
        }
        return result;
    }
}

//DFS-jiuzhang
public class Solution {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        List<ListNode> result = new ArrayList<ListNode>();
        if(root==null) return result;
        dfs(root,1,result);
        return result;
    }
    private void dfs(TreeNode root, int depth, List<ListNode> result){
        if(root==null) return;
        ListNode node = new ListNode(root.val);
        if(result.size()<depth){
            result.add(node);
        }else{
            node.next = result.get(depth-1);
            result.set(depth-1,node);
        }
        //先右后左，所以上面else里才能把当前的next设成之前的。
        dfs(root.right,depth+1,result);
        dfs(root.left,depth+1,result);
    }
}