/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */
public class Solution {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        if(root==null) return null;
        
        ArrayList<ParentTreeNode> left = pathToRoot(A);
        ArrayList<ParentTreeNode> right = pathToRoot(B);
        
        int idxl = left.size()-1;
        int idxr = right.size()-1;
        ParentTreeNode lca = null;
        
        while (idxl >= 0 && idxr >= 0) {
            if(left.get(idxl)!=right.get(idxr)) break;
            lca = left.get(idxl);
            idxl--;
            idxr--;
            
        }
        return lca;
    }
    private ArrayList<ParentTreeNode> pathToRoot(ParentTreeNode node){
        ArrayList<ParentTreeNode> path = new ArrayList<ParentTreeNode>();
        //理解思路情况下这里写错了，判断了parent并添加parent，不对。
        while(node!=null ){
            path.add(node);
            node = node.parent;
        }
        return path;
    }
}
