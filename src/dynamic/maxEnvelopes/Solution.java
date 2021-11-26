package dynamic.maxEnvelopes;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * <p>
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * <p>
 * 说明:
 * 不允许旋转信封。
 * <p>
 * 示例:
 * <p>
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 */
public class Solution {

    /**
     * 按照宽度排序，只有后面的可以套在前面的信封上。同时长度也要满足后面的大于前面的，及求长度的最长上升子序列。
     * 考虑宽度相等的情况，为了防止宽度相等而被同时选中的问题，将长度降序排列
     * dp[i] 表示以i结尾的长度
     *
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {

        if (envelopes.length <= 1) {
            return envelopes.length;
        }
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0] != 0 ? a[0] - b[0] : b[1] - a[1]);
        int[] dp = new int[envelopes.length];
        int res = 0;
        for (int i=0; i<envelopes.length; i++) {
            dp[i] = 1;
            for (int j=0; j<i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
