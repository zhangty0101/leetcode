package string.lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */


public class Solution {

    /**
     * 用两个指针实现滑动窗口，如果cur所在的字符在cur和pre之间的字串中，则将pre指针指向重复字串的后一位
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int pre = 0;
        int cur = 1;
        int len = cur - pre;
        while (cur < s.length()) {
            String subStr = s.substring(pre, cur);
            char curChar = s.charAt(cur);
            if (subStr.contains(curChar + "")) {
                len = Math.max(len, cur - pre);
                pre = s.indexOf(curChar, pre) + 1;
            }
            cur++;
        }
        return len;
    }

    /**
     * 假设不重复的子串开始和结尾下标为 i, j
     * 如果 s[i]-s[j+1] 是重复的字符串，则说明 s[j+1] 与 s[i]-s[j] 中的字符有重复，找出重复的位置k, 则 s[k+1] - s[j+1] 肯定是非重复的
     * 利用 map 来检查是否有重复，key是字符，value 是下标，
     * 如果 map[s[j+1]] 存在，且value > i, 说明 s[j+1] 在 s[i]-s[j] 中已存在，且原下标是 value
     * 此时直接  i=value+1， 且将 map[key] 的value 更新为 j+1;
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring3(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int i = 0;
        int j = 0;
        int len = 1;
        Map<Character, Integer> map = new HashMap<>();
        while (j < s.length()) {
            if (map.containsKey(s.charAt(j)) && map.get(s.charAt(j)) >= i) {
                i = map.get(s.charAt(j)) + 1;
            }
            map.put(s.charAt(j), j);
            len = Math.max(len, j - i + 1);
            j++;
        }
        return len;
    }

    /**
     * 维护一个数组dp[]，dp[i]表示到以第i个字符结尾的不包含重复数组的子字符串的最大长度。
     * （我们并不保存最大不重复子字符串，只是存储其长度方便后续比较）
     *   状态转移：
     *      1. 第i个字符从未出现过，则dp[i] = dp[i-1] + 1；
     *      2. 第i个字符出现过， 这时我们找出第i个字符最近一次出现的位置index,记两个的距离为d= i-index：
     *       1） d<=dp[i-1],即这个字符出现在以第i-1个字符结尾的不包含重复数组的子字符串中，则dp[i] = d；
     *       2） d>dp[i-1], 即这个字符没有出现在以第i-1个字符结尾的不包含重复数组的子字符串中，则dp[i] = dp[i-1] + 1
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0)
            return 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < dp.length; i++) {
            String subStr = s.substring(0, i);
            char x = s.charAt(i);
            if (subStr.contains(x + "")) {
                int d = i - s.lastIndexOf(x, i - 1);
                if (d > dp[i - 1]) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = d;
                }
            } else {
                dp[i] = dp[i - 1] + 1;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        Solution solution = new Solution();
        System.out.println(Solution.lengthOfLongestSubstring3("abcabcbb"));
        System.out.println(Solution.lengthOfLongestSubstring3("pwwkew"));
        System.out.println(Solution.lengthOfLongestSubstring3("bbbbb"));
        System.out.println(Solution.lengthOfLongestSubstring3("ab"));
    }
}
