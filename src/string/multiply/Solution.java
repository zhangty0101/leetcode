package string.multiply;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */

public class Solution {
    /**
     * 乘数 num1 位数为 M，被乘数 num2 位数为 N， num1 x num2 结果 res 最大总位数为 M+N
     * num1[i] x num2[j] 的结果为 tmp(位数为两位，"0x","xy"的形式)，其第一位位于 res[i+j]，第二位位于 res[i+j+1]。
     *
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0 || num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                int z = x * y + res[i + j + 1];
                res[i + j + 1] = z % 10;
                res[i + j] += z / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<res.length; i++) {
            if (i==0 && res[i]==0) continue;
            sb.append(res[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiply("25", "250"));
    }
}
