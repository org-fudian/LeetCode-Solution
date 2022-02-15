package p1380;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟扫描
 * 1ms time:97.93%
 * 41.9M memory:6.9%
 */
class Solution {
	public List<Integer> luckyNumbers (int[][] matrix) {
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++){
			int posColMin = 0;
			//定位该行数字最小的列
			for (int col = 0; col < matrix[i].length; col++){
				if (matrix[i][col] < matrix[i][posColMin]){
					posColMin = col;
				}
			}
			//扫描该列该数字是否最大
			boolean flag = true;
			for (int row = 0; row<matrix.length; row++){
				if (i!= row && matrix[i][posColMin] < matrix[row][posColMin]){
					flag = false;
					break;
				}
			}
			if (flag){
				ans.add(matrix[i][posColMin]);
			}
		}
		return ans;
	}
}
