public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        /*
        1. edges = nodes-1
        2.  n-1 edges connect the whole tree
        */
        if (n == 0) {
            return false;
        }
        if (edges.length != n - 1) {
            return false;
        }
        Map<Integer, Set<Integer>> graph = initializeGraph(n, edges);
        Queue<Integer> queue = new LinkedList<>();
        //存所有node，所有后面如果该node放过了，就不再加入了
        Set<Integer> hash = new HashSet<>();
        int visited = 0;
        //都添加了0，可能是题目默认root==0吧
        queue.offer(0);
        hash.add(0);
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            visited++;
            for(Integer neighbor: graph.get(node)){
                if(hash.contains(neighbor)) continue;
                hash.add(neighbor);
                queue.offer(neighbor);
            }
        }

        return n==visited;
    }
    private Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges){
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i = 0; i<n; i++){
            graph.put(i,new HashSet<Integer>());
        }
        for(int i = 0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
}