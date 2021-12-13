package array.trap;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Solution {

    /**
     对于下标 i，下雨后水能到达的最大高度等于下标 i 两边的最大高度的最小值，
     下标 i 处能接的雨水量等于下标 i 处的水能到达的最大高度减去 height[i]。
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) {
            return 0;
        }

        // 1. 计算每个下标左边的最大值
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i=1; i<n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        // 2. 计算每个下标右边的最大值
        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];
        for (int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        // 3. 计算每个下标能装的雨水
        int ans = 0;
        for (int i=0; i<n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = new int[]{4,2,0,3,2,5};
        System.out.println(solution.trap(height));
    }
}
