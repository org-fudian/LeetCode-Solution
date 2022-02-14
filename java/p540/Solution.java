package p540;

/**
 * 两种方法，
 * 1.异或所有数字，因为只有一个不一样，所以一定结果就是那个不一样的 其他一样的都会变成0
 * 2.二分搜索，根据相同数字出现的位置判断顺序
 * 异或的时间空间复杂度 o(n) o(1)
 * 1ms time:22.98%
 * 46.7MB memory:18%
 * 二分的时间空间复杂度 o(logn) o(1)
 * 0ms time:100.00%
 * 46.8MB memory:15.76%
 */
class Solution {
	public int singleNonDuplicate(int[] nums) {
		for (int i = 1; i < nums.length; i++){
			nums[0]^=nums[i];
		}
		return nums[0];
	}
}
//二分
//class Solution {
//	public static void main(String[] args) {
//		System.out.println(new Solution().singleNonDuplicate(new int[]{1,1,3,4,4}));
//	}
//	public int singleNonDuplicate(int[] nums) {
//		int left = 0;
//		int right = nums.length-1;
//		int mid = (right+left)/2;
//		while (mid!= 0 && mid!= nums.length-1){
//			if (mid%2 == 0){
//				if (nums[mid] == nums[mid+1]){
//					left = mid+1;
//				}else if (nums[mid] == nums[mid-1]){
//					right = mid-1;
//				}else {
//					break;
//				}
//			}else {
//				if (nums[mid] == nums[mid+1]){
//					right = mid-1;
//				}else if (nums[mid] == nums[mid-1]){
//					left = mid+1;
//				}else {
//					break;
//				}
//			}
//			mid = (right+left)/2;
//		}
//		return nums[mid];
//	}
//
//}