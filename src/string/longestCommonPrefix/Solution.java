package string.longestCommonPrefix;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */

public class Solution {
    /**
     * 暴力破解，时间复杂度O(nm),其中n为数组长度，m为最小字符串的长度
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String baseStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (baseStr.length() > strs[i].length()) {
                baseStr = strs[i];
            }
        }

        if (baseStr.length() == 0) {
            return "";
        }

        int commonPrefixIndex = 0;
        boolean stop = false;
        for (int i = 0; i < baseStr.length(); i++) {
            char baseChar = baseStr.charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != baseChar) {
                    stop = true;
                    break;
                }
            }
            commonPrefixIndex = i;
            if (stop) {
                break;
            }
        }

        if (commonPrefixIndex == 0) {
            return "";
        } else {
            return baseStr.substring(0, commonPrefixIndex);
        }
    }

    /**
     * 暴力破解2
     * 两两比较，找出公共前缀
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String res = strs[0];
        for (int i=1; i<strs.length; i++) {
            while (strs[i].indexOf(res) != 0) {
                res = res.substring(0, res.length()-1);
                if (res.length() == 0) {
                    return "";
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        Solution solution = new Solution();
        System.out.print(solution.longestCommonPrefix2(strs));
    }
}
