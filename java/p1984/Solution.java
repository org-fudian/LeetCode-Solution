package p1984;

import java.util.Arrays;

/**
 * 4ms time:100%
 * 41.3M memory:8.28%
 * @author Timing
 * @since 2022/2/11 10:36 AM
 */
/*
   k的最小差值，易得当有序时，滑动窗口长度为k的左端点数字和右端点数字的最小差为解
   增加k == 1的特判
 */
class Solution {
	public static void main(String[] args) {
		System.out.println(new Solution().minimumDifference(new int[]{90},1));
		System.out.println(new Solution().minimumDifference(new int[]{9,4,1,7},2));

	}
	public int minimumDifference(int[] nums, int k) {
		if (k == 1){
			return 0;
		}
		Arrays.sort(nums);
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i <= nums.length-k; i++){
			ans = Math.min(nums[i+k-1]-nums[i], ans);
		}
		return ans;
	}
}