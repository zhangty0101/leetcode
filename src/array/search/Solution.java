package array.search;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class Solution {

    /**
     * 二分查找，找出最小值
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int minIndex = findMinIndex(nums);
        if (target < nums[nums.length - 1]) {
            return binarySearch(nums, minIndex, nums.length -1, target);
        } else {
            return binarySearch(nums, 0, minIndex, target);
        }

    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return -1;
    }

    public int findMinIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (mid + 1 <= right && nums[mid] > nums[mid+1]) {
                // 唯一的降序点
                mid = mid + 1;
                break;
            } else if (nums[mid] > nums[left]) {
                // 左边一直是升序， 则最小值在右边
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (nums[0] < nums[mid]) {
            mid = 0;
        }
        return mid;
    }

    public int search2(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] == target) return l;
            if (nums[r] == target) return r;
            if (l == r) break;
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;

            if (nums[l] < nums[mid]) {
                if (target < nums[mid] && target > nums[l]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target < nums[r] && target > nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0};
        System.out.println(solution.search(nums, 0));
    }
}
