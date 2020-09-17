package day16_09;

public class SearchInsert_35 {
    public static void main(String[] args) {
        /**
         * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
         *
         * 你可以假设数组中无重复元素。
         */

        int[] nums = new int[]{1, 3, 5, 6};

        System.out.println(searchInsert(nums, -1));
    }

    //暴力解法
    public static int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length - 1]) {
            return nums.length;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= target) {
                    return i;
                }
            }
        }
        return 0;
    }

    //二分查找
    public static int searchInsert2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            //中间的数等于target 返回mid
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                //target大于中间的数，target在后半部分，left=mid+1;
                left = mid + 1;
            } else {
                //target在前半部分
                right = mid - 1;
            }
        }
        return left;
    }
}
