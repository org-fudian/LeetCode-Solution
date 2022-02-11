package p1219;

import java.util.Arrays;

/**
 * 简单回溯
 * 39ms
 * 38.7MB
 * @author Timing
 * @since 2022/2/11 4:26 PM
 */
class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().getMaximumGold(new int[][]{new int[]{0,6,0},new int[]{5,8,7},new int[]{0,9,0}}));
	}

	int ans = 0;
	int[][] grid;
	public int getMaximumGold(int[][] grid) {
		ans = 0;
		this.grid = grid;
		int[][] newGrid = new int[grid.length][];
		for (int k = 0; k < newGrid.length;  k++){
			newGrid[k] = Arrays.copyOf(grid[k],grid[k].length);
		}
		for (int i = 0; i < grid.length; i++){
			for (int j = 0;  j < grid[0].length; j++){
				if (grid[i][j]!= 0){
					DFS(newGrid,i ,j, 0);
				}
			}
		}
		return ans;
	}

	public void DFS(int[][] grid, int row, int col, int sum){
		sum+=grid[row][col];
		grid[row][col] = 0;
		if (row+1 < grid.length && grid[row+1][col] != 0){
			DFS(grid,row+1 ,col, sum);
		}
		if (row-1 >= 0 && grid[row-1][col] != 0){
			DFS(grid,row-1 ,col, sum);
		}
		if (col+1 < grid[0].length && grid[row][col+1] != 0){
			DFS(grid,row ,col+1, sum);
		}
		if (col-1 >= 0 && grid[row][col-1] != 0){
			DFS(grid,row ,col-1, sum);
		}
		grid[row][col] = this.grid[row][col];
		ans = Math.max(ans,sum);
	}
}