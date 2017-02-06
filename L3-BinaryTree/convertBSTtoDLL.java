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
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */ 
 class Result {
    DoublyListNode first, last;
    
    public Result(DoublyListNode first, DoublyListNode last) {
        this.first = first;
        this.last = last;
    }
}
public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {  
        if (root == null) {
            return null;
        }
        
        Result r = convert(root);
        return r.first;   
    }
    private Result convert(TreeNode root){
        if(root==null) return null;
        
        Result left = convert(root.left);
        Result right = convert(root.right);
        DoublyListNode node = new DoublyListNode(root.val);
        //cur.left: left.first==all the first,cur.right==right.last==all the last这个变量是在拼接node的时候找到拼接在谁后面或者谁前面
        Result cur = new Result(null,null);
        
        if(left==null){
            cur.first = node;
        }else{
            cur.first=left.first;
            //double linked list, left.last<-->node(node==root)
            left.last.next = node;
            node.prev = left.last;
        }
        if(right==null){
            cur.last = node;
        }else {
            cur.last = right.last;
            right.first.prev = node;
            node.next = right.first;
        }
        
        return cur;
       
    }
}










