package p165;

/**
 * 1ms time:70.41%
 * 39.2MB memory:12.33%
 * step1:拆分版本号
 * step2:依次比较，如果有前导0去掉
 */
class Solution {
	public int compareVersion(String version1, String version2) {
		String[] version1Nums = version1.split("\\.");
		String[] version2Nums = version2.split("\\.");
		int min = Math.min(version1Nums.length,version2Nums.length);
		for (int i = 0; i < min; i++){
			int reversion1 = Integer.parseInt(version1Nums[i]);
			int reversion2 = Integer.parseInt(version2Nums[i]);
			if (reversion1 > reversion2){
				return 1;
			}
			if (reversion1 < reversion2){
				return -1;
			}
		}
		if (version1Nums.length > version2Nums.length){
			for (int i = min; i < version1.length(); i++){
				if (Integer.parseInt(version1Nums[i]) != 0){
					return 1;
				}
			}
		}
		if (version1Nums.length < version2Nums.length){
			for (int i = min; i < version2.length(); i++){
				if (Integer.parseInt(version2Nums[i]) != 0){
					return -1;
				}
			}
		}
		return 0;
	}
}