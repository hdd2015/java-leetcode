package medium._003lengthOfLongestSubstring;

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。 示例 1: 输入: "abcabcbb" 输出: 3 解释: 无重复字符的最长子串是
 * "abc"，其长度为 3。
 * 示例 2: 输入: "bbbbb" 输出: 1 解释: 无重复字符的最长子串是 "b"，其长度为 1。
 * 示例 3: 输入: "pwwkew" 输出: 3 解释: 无重复字符的最长子串是 "wke"，其长度为 3。 请注意，答案必须是一个子串，"pwke"
 * 是一个子序列 而不是子串。
 */
public class Solution {
	
	/**
	 * （假设字符集为 ASCII 128）
	 * 以前的我们都没有对字符串 s 所使用的字符集进行假设。
	 * 当我们知道该字符集比较小的时侯，我们可以用一个整数数组作为直接访问表来替换 Map。
	 * 常用的表如下所示：
	 * int [26] 用于字母 ‘a’ - ‘z’或 ‘A’ - ‘Z’ 
	 * int [128] 用于ASCII码  ASCII值0-127
	 * int [256] 用于扩展ASCII码
	 */
	public int lengthOfLongestSubstring(String s) {
		if(s != null && s.length() > 0) {
		    int preP = 0, max = 0;
		  //hash 数组来存储该字符上次出现的位置，比如 index[a] = 3 就是代表 a 字符前一次出现的索引在 3
	        int[] index = new int[128];
	        for (int i = 0; i < s.length(); ++i) {
	            char chatTaget = s.charAt(i);
	            if (index[chatTaget] > preP) {
	                preP = index[chatTaget];//chatTaget字符上次出现的最大索引 (最靠后) （下标是chatTaget对应的ASCII码）
	            }
	            int len = i - preP + 1;//上次出现的最大索引 (最靠后) preP与当前的索引i做差获取的就是本次所需长度
	            index[chatTaget] = i + 1;//chatTaget字符前一次出现的索引改为i + 1
				if (len > max) {
					max = len;
				}
	        }
	        return max;
		}
		return 0;
	}

	//-------------------以下是官网题解----------
	/**
	 * 方法一：暴力法
	 * 
	 */
	public int lengthOfLongestSubstring1(String s) {
		if(s != null && s.length() > 0) {
			
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "dvdf";
		System.out.println(solution.lengthOfLongestSubstring(s) + "");
	}
}
