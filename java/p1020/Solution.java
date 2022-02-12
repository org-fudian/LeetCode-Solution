package p1020;
/**
 * 从边缘出发 对每个点进行DFS染色，最后求未被染色的格子数量
 * 3ms time:97.43%
 * 49.1M memory:11.79%
 */
class Solution {

  public int numEnclaves(int[][] grid) {
    for (int i = 0; i < grid.length; i++){
      DFS(grid,i,0);
      DFS(grid,i,grid[0].length-1);
    }
    for (int i = 0; i < grid[0].length; i++){
      DFS(grid,0,i);
      DFS(grid,grid.length-1,i);
    }
    int ans = 0;
    for (int[] i : grid){
      for(int j : i){
        if (j == 1){
          ans++;
        }
      }
    }
    return ans;
  }

  public void DFS(int[][] grid,int row, int col){
    if (row>=grid.length || row< 0 || col >= grid[0].length || col < 0 || grid[row][col] == 0){
      return;
    }else {
      grid[row][col] = 0;
      DFS(grid, row+1, col);
      DFS(grid, row-1, col);
      DFS(grid, row, col+1);
      DFS(grid, row, col-1);
    }
  }
}