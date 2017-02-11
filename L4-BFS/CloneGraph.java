/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }

        // use dfs algorithm to traverse the graph and get all nodes.
        ArrayList<UndirectedGraphNode> nodes = getNodes(node);
        
        // store the old->new mapping information in a hash map
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        // copy nodes, 
        for(UndirectedGraphNode n : nodes){
            mapping.put(n, new UndirectedGraphNode(n.label));
        }
        
        // copy neighbors(edges), 这里比想象的复杂一点，map里的n-key是旧node，new UndirectedGraphNode(n.label)-value是新node，所以遍历旧node，对每个旧node，都找到他对应的新node，然后把旧node的neighbors挨个加到新node的neighbors中。
        for (UndirectedGraphNode n : nodes) {
            UndirectedGraphNode newNode = mapping.get(n);
            for (UndirectedGraphNode neighbor : n.neighbors) {
                //注意这里不能直接add neighbor，因为是旧点，必须从map中找到以前的neighbor对应的新neighbor，才能add
                UndirectedGraphNode newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        
        return mapping.get(node);    
        
    }
    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node){
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        
        queue.offer(node);
        set.add(node);
        while(!queue.isEmpty()){
            UndirectedGraphNode cur = queue.poll();
            for(UndirectedGraphNode n : cur.neighbors){
                if(!set.contains(n)){
                    queue.offer(n);
                    set.add(n);
                }
            }
        }
        // set convert to arraylist
        return new ArrayList<UndirectedGraphNode>(set);
    }
    
}