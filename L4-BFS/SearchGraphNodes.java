public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param values a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node an Undirected graph node
     * @param target an integer
     * @return the a node
     */
     //graph useless因为本题是从给定node开始做BFS，所以遇到的第一个==target一定是距离给定node最近的
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        UndirectedGraphNode re = null;
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        queue.offer(node);
        set.add(node);
        
        while(!queue.isEmpty()){
            re = queue.poll();
            //There is a mapping store the nodes' values in the given parameters.
            if(values.get(re)==target) return re;
            for(UndirectedGraphNode all: re.neighbors){
                if(!set.contains(all)){
                    queue.offer(all);
                    set.add(all);
                }
            }
        }
        
        return null;
    }
}