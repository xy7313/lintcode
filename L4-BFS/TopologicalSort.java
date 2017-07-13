/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
 public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();

        //collect indegree
        HashMap<DirectedGraphNode, Integer> map = getIndegree(graph);

        //put all node with indegree==0
        for (DirectedGraphNode node : graph) {
            if (map.get(node)==0) {
                q.offer(node);
                result.add(node);
            }
        }
        //based on the node in queue, update indegrees of their neighbors        
        while (!q.isEmpty()) {
            DirectedGraphNode node = q.poll();
            for (DirectedGraphNode n : node.neighbors) {
                map.put(n, map.get(n) - 1);
                if (map.get(n) == 0) {
                    result.add(n);
                    q.offer(n);
                }
            }
        }
        return result;
    }
    private HashMap<DirectedGraphNode, Integer> getIndegree(ArrayList<DirectedGraphNode> graph){
        HashMap<DirectedGraphNode, Integer> map = new HashMap();
        for (DirectedGraphNode node : graph) {
             map.put(node, 0);
        }
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                    map.put(neighbor, map.get(neighbor) + 1);
            }
        }
        return map;
    }
}

//dfs
for(n:cur.neighbors){
    if(!visited[u]){
        visited[u]= true;
        dfs(n);
    }
}
res.add(cur)