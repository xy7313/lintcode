public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix==null||matrix.length==0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int x = n-1;
        int y = 0;
        int count = 0;
        
        while(x>=0&&y<m){
            if(matrix[x][y]>target){
                x--;
            }else if(matrix[x][y]<target){
                y++;
            }else{
                count++;
                x--;
                y++;
            }
        }
        
        return count;
    }
}
