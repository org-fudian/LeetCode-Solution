package p1414;

/**
 * 直接贪心 每次取刚好小于当前k的第一个斐波那契数，然后不断递减，每递减一次 次数+1
 * 0ms time:100%
 * 38.2M memory:95.09%
 */
class Solution {
	public int findMinFibonacciNumbers(int k) {
		int count = 0;
		while (k!=0){
			count++;
			int f1 = 1;
			int f2 = 1;
			while (f2<k){
				int temp = f2;
				f2 = f1+f2;
				f1 = temp;
			}
			if (f2 == k){
				break;
			}else {
				k-=f1;
			}
		}
		return count;
	}
}