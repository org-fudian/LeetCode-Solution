package p2006;

/**
 * 1 ms time:85.00%
 * 41M memory:6.00%
 */
class Solution {
	public int countKDifference(int[] nums, int k) {
		int[] count = new int[201];
		int ans = 0;
		for (int i = 0; i < nums.length; i++){
			int a = nums[i] - k;
			int b = nums[i] + k;
			if (a >= 0 && a < 200 && count[a] > 0){
				ans+=count[a];
			}
			if (b >= 0 && b < 200 && count[b] > 0){
				ans+=count[b];
			}
			count[nums[i]]++;
		}
		return ans;
	}
}
