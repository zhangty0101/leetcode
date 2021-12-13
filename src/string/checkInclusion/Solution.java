package string.checkInclusion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/explore/featured/card/bytedance/242/string/1016/
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 */

public class Solution {
    /**
     * 找出s1的所有排列
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Set<String> permutationOfS1 = permutation(s1);
        for (String str: permutationOfS1) {
            if (s2.contains(str)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 滑动窗口，在s1长度的窗口范围内，各自的字母数量应该要相等
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion2(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) {
            return false;
        }

        int[] chs1 = new int[26];
        int[] chs2 = new int[26];
        for (char c: s1.toCharArray()) {
            chs1[c - 'a'] ++;
        }

        for(int i=0; i<s2.length(); i++) {
            if (i >= len1) {
                chs2[s2.charAt(i - len1) - 'a']--;
            }
            chs2[s2.charAt(i) - 'a']++;
            if (Arrays.equals(chs1, chs2)) {
                return true;
            }
        }
        return false;
    }

    public Set<String> permutation(String str) {
        Set<String> res = new HashSet<>();
        if (str.length() == 0) {
            return res;
        }
        findPermutation(res, str.toCharArray(), 0);
        return res;
    }

    public void findPermutation(Set<String> res, char[] chs, int index) {
        if (index == chs.length - 1) {
            res.add(String.valueOf(chs));
        } else {
            for (int i=index; i<chs.length; i++) {
                char temp = chs[index];
                chs[index] = chs[i];
                chs[i] = temp;
                findPermutation(res, chs, index+1);
                temp = chs[index];
                chs[index] = chs[i];
                chs[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkInclusion2("abc", "eidbcaooo"));
    }
}
