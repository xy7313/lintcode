public class Solution {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return true if can finish all courses or false
     */
       public boolean canFinish(int numCourses, int[][] prerequisites) {
        //idx of edges: node, element(arraylist) of edges: node.neighbors
        List[] edges = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        
        // initialization: each node has a list to store its neighbors
        for (int i = 0;i < numCourses; i++){
            edges[i] = new ArrayList<Integer>();
        }
            
        //get indegree eg:pair[0,1] means to take course 0 you have to first take course 1, 
        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]] ++ ;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Queue queue = new LinkedList();
        for(int i = 0; i < degree.length; i++){
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        
        int count = 0;
        while(!queue.isEmpty()){
            int course = (int)queue.poll();
            count ++;
            int n = edges[course].size();
            for(int i = 0; i < n; i++){
                int pointer = (int)edges[course].get(i);
                degree[pointer]--;
                if (degree[pointer] == 0) {
                    queue.add(pointer);
                }
            }
        }
        //if it has cycle, there will be some node with indegree>0 left, return false, and count<numCourse
        return count == numCourses;
    }
}