
class Coordinate {
    int x, y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public int PEOPLE = 0;
    public int ZOMBIE = 1;
    public int WALL = 2;
    
    public int[] deltaX = {1, 0, 0, -1};
    public int[] deltaY = {0, 1, -1, 0};
    /**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path 
     */
    public int zombie(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int row = grid.length;
        int col = grid[0].length;
        int people = 0;
        Queue<Coordinate> queue = new LinkedList<>();
        
        //和island不一样的地方，1，people的计数，2，把已知zombie都放进去
        for(int i = 0; i< row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j]==PEOPLE){
                    people++;
                } else if(grid[i][j]==ZOMBIE){
                    queue.offer(new Coordinate(i, j));
                }
            }
        }
        
        if(people==0) return 0;
        
        int day = 0;
        while(!queue.isEmpty()){
            day++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinate cur = queue.poll();
                for(int dir = 0; dir<4; dir++){
                    Coordinate next = new Coordinate(cur.x+deltaX[dir],cur.y+deltaY[dir]);
                    if(inBound(next,grid) && grid[next.x][next.y]==PEOPLE ){
                        grid[next.x][next.y]=ZOMBIE;
                        people--;
                        if(people==0) return day;
                        queue.offer(next);
                    }
                }
            }
        } 
        return -1;
    }

    //注意这里，是否超出边界，x y可以取到0
    private boolean inBound(Coordinate coor, int[][] grid){
        return coor.x >=0 && coor.y >=0 &&coor.x<grid.length &&coor.y<grid[0].length;
    }
}