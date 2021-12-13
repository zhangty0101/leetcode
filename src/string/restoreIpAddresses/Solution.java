package string.restoreIpAddresses;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        for(int i=0; i<3 && i<s.length(); i++) {
            String s1 = s.substring(0, i+1);
            if (!checkIp(s1)) {
                break;
            }
            for(int j=i+1; j<i+4 && j < s.length(); j++) {
                String s2 = s.substring(i+1, j+1);
                if(!checkIp(s2)) {
                    break;
                }
                for(int k=j+1; k<j+4 && k+1 < s.length(); k++) {
                    String s3 = s.substring(j+1, k+1);
                    String s4 = s.substring(k+1);
                    if(checkIp(s3) && checkIp(s4)) {
                        res.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        return res;
    }

    public boolean checkIp(String s) {
        if (s.length() == 0 || s.length() > 3 || Integer.parseInt(s) > 255) {
            return false;

        } else {
            return s.length() <= 1 || !s.startsWith("0");
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.restoreIpAddresses("25525511135"));
    }
}
