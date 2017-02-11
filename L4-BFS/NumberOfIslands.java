class Coordinate {
    int x, y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int row = grid.length;
        int col = grid[0].length;
        int isIsland = 0;
        
        for(int i = 0; i< row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j]){
                    bfs(grid,i,j);
                    isIsland++;
                }
            }
        }
        return isIsland;

    }
    private void bfs(boolean[][] grid, int x, int y){
        //coordinate matrix, to find four direction element.
        int[] deltaX = {1,0,0,-1};
        int[] deltaY = {0,1,-1,0};
        
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(x, y));
        grid[x][y]=false;
        
        while(!queue.isEmpty()){
            Coordinate cur = queue.poll();
            for(int i = 0; i<4; i++){
                Coordinate next = new Coordinate(cur.x+deltaX[i],cur.y+deltaY[i]);
                if(inBound(next,grid) && grid[next.x][next.y] ){
                    queue.offer(next);
                    grid[next.x][next.y]=false;
                }
            }
        }
    }
    //注意这里，是否超出边界，x y可以取到0
    private boolean inBound(Coordinate coor, boolean[][] grid){
        return coor.x >=0 && coor.y >=0 &&coor.x<grid.length &&coor.y<grid[0].length;
    }
}
