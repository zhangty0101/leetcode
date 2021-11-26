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
     * 双指针，如果右指针一直往前走，如果遇到比左指针大的值，则停下，计算两个指针之间的雨水；
     * 如果一直没有比右指针大，则左右指针同时指向左指针的下一位
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int left = 0;
        int right = 1;
        int midSum = 0;
        int res = 0;
        while (left < height.length - 1) {
            if (right - left > 1) {
                midSum += height[right - 1];
            }
            if (height[right] >= height[left]) {
                res += (right - left - 1) * height[left] - midSum;
                left = right;
                right = left + 1;
                midSum = 0;
            } else {
                right++;
            }
            if (right == height.length - 1) {
                left++;
                right = left + 1;
                midSum = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap(height));
    }
}
