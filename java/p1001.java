import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 88ms time:33.85%
 * 53.9M memory:75.38%
 */
class Pair{
	int row;
	int col;

	Pair(int row, int col){
		this.row = row;
		this.col = col;
	}
	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Pair pair = (Pair) o;
		return row == pair.row && col == pair.col;
	}

	@Override public int hashCode() {
		return Objects.hash(row, col);
	}
}

class Solution {

	HashMap<Integer, Integer> rowMap;
	HashMap<Integer, Integer> colMap;
	HashMap<Integer, Integer> diagonalMap;
	HashMap<Integer, Integer> antidiagonalMap;
	Set<Pair> pairs;

	public static void main(String[] args) {
//		6
//				[[2,5],[4,2],[0,3],[0,5],[1,4],[4,2],[3,3],[1,0]]
//[[4,3],[3,1],[5,3],[0,5],[4,4],[3,3]]
		System.out.println(Arrays.toString(new Solution().gridIllumination(6,
				new int[][] { new int[] { 2, 5 }, new int[] { 4, 2 } , new int[] { 0, 3 }, new int[] { 0, 5 }, new int[] { 1, 4 }, new int[] { 4, 2 }, new int[] { 3, 3 }, new int[] { 1, 0 }},
				new int[][] { new int[] { 4, 3 }, new int[] { 3, 1 }, new int[] { 5, 3 }, new int[] { 0, 5 }, new int[] { 4, 4 }, new int[] { 3, 3 } })));
	}
	public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
		int[] ans = new int[queries.length];
		//初始化数组
		//行标识<rowMap,count>
		rowMap = new HashMap<>();
		//列标识<col,count>
		colMap = new HashMap<>();
		//对角线<rowMap+col, count>
		diagonalMap = new HashMap<>();
		//反向对角线<rowMap-col, count>
		antidiagonalMap = new HashMap<>();
		//灯的集合
		pairs = new HashSet<>();
		//初始化各条线灯的数量统计
		for (int[] lamp : lamps){
			Pair pair = new Pair(lamp[0],lamp[1]);
			if (!pairs.contains(pair)) {
				rowMap.put(lamp[0], rowMap.getOrDefault(lamp[0], 0) + 1);
				colMap.put(lamp[1], colMap.getOrDefault(lamp[1], 0) + 1);
				diagonalMap.put(lamp[0] + lamp[1],
						diagonalMap.getOrDefault(lamp[0] + lamp[1], 0) + 1);
				antidiagonalMap.put(lamp[0] - lamp[1],
						antidiagonalMap.getOrDefault(lamp[0] - lamp[1], 0) + 1);
				pairs.add(pair);
			}
		}

		//开始查询
		int count =0 ;
		for (int[] query : queries){
			//判断该位置是否被照亮
			if (
					(rowMap.getOrDefault(query[0],0)>0) ||
							(colMap.getOrDefault(query[1],0)>0) ||
							(diagonalMap.getOrDefault(query[0]+query[1], 0)> 0) ||
							(antidiagonalMap.getOrDefault(query[0] - query[1], 0) > 0)
			){
				ans[count] = 1;
			}else {
				ans[count] = 0;
			}
			//如果被照亮，那么就可能四周有灯 开始删除四周的灯
			if (ans[count] == 1){
				deleteLamp(query[0], query[1]);
				//边界判断
				if (query[0] < n - 1) {
					deleteLamp(query[0] + 1, query[1]);
					if (query[1] > 0) {
						deleteLamp(query[0] + 1, query[1] - 1);
					}
					if (query[1] < n - 1) {
						deleteLamp(query[0] + 1, query[1] + 1);
					}
				}
				if (query[0] > 0) {
					deleteLamp(query[0] - 1, query[1]);
					if (query[1] > 0) {
						deleteLamp(query[0] - 1, query[1] - 1);
					}
					if (query[1] < n - 1) {
						deleteLamp(query[0] - 1, query[1] + 1);
					}
				}
				if (query[1] > 0) {
					deleteLamp(query[0], query[1] - 1);
				}
				if (query[1] < n - 1) {
					deleteLamp(query[0], query[1] + 1);
				}
			}
			count++;
		}
		return ans;
	}

	public void deleteLamp(int row, int col){
		//如果这个位置有灯
		Pair pair = new Pair(row,col);
		if (pairs.contains(pair)){
			rowMap.put(row, rowMap.getOrDefault(row,0) - 1);
			colMap.put(col, colMap.getOrDefault(col,0) - 1);
			diagonalMap.put(row+col, diagonalMap.getOrDefault(row+col,0) - 1);
			antidiagonalMap.put(row-col, antidiagonalMap.getOrDefault(row-col,0) - 1);
			pairs.remove(pair);
		}
	}
}
