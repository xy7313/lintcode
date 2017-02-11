/**
 * Definition for a point.
 * public class Point {
 *     publoc int x, y;
 *     public Point() { x = 0; y = 0; }
 *     public Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    
    //knight走日字
    int[] deltaX = {1, 1, 2, 2, -1, -1, -2, -2};
    int[] deltaY = {2, -2, 1, -1, 2, -2, 1, -1};
    /**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
 
        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
        int steps = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size; i++){
                Point cur = queue.poll();
                if(cur.x==destination.x && cur.y==destination.y) return steps;
                for(int dir = 0; dir<8; dir++){
                    Point next = new Point(
                        cur.x+deltaX[dir],
                        cur.y+deltaY[dir]
                        );
                    if(inBound(next,grid) && grid[next.x][next.y]==false){
                        queue.offer(next);
                        grid[next.x][next.y]=true;
                    }
                }
            }
            //each level--one step
            steps++;
        }
        return -1;
    }
       //注意这里，是否超出边界，x y可以取到0
    private boolean inBound(Point coor, boolean[][] grid){
        return coor.x >=0 && coor.y >=0 &&coor.x<grid.length &&coor.y<grid[0].length;
    }
}