package dynamic.maximalSquare;

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 */

public class Solution {

    /**
     * 动态规划 dp[i][j]表示以i，j为右下角的正方形的最大边长
     * dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxWidth = 0;

        // 第一行赋值
        for (int i=0; i<m; i++) {
            dp[0][i] = matrix[0][i] - '0';
            maxWidth = Math.max(maxWidth, dp[0][i]);
        }

        // 第一列赋值
        for (int i=0; i<n; i++) {
            dp[i][0] = matrix[i][0] - '0';
            maxWidth = Math.max(maxWidth, dp[i][0]);
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                dp[i][j] = matrix[i][j] == 1 ? 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) : 0;
                maxWidth = Math.max(maxWidth, dp[i][j]);
            }
        }

        return maxWidth * maxWidth;
    }
}
