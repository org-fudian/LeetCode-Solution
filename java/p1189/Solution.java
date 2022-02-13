package p1189;
/**
 * 直接统计不同字母的次数就好
 * 注意有的需要/2
 * 1ms time:100.00%
 * 39.9M memory:5.85%
 */
class Solution {
  public int maxNumberOfBalloons(String text) {
    int[] count = new int[26];
    for (char ch : text.toCharArray()){
      count[ch-'a']++;
    }
    int ans = count[0];
    ans = Math.min(ans,count['b'-'a']);
    ans = Math.min(ans,count['l'-'a']/2);
    ans = Math.min(ans,count['o'-'a']/2);
    ans = Math.min(ans,count['n'-'a']);
    return ans;
  }
}