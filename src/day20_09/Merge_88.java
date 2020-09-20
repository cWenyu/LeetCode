package day20_09;

import java.util.Arrays;

public class Merge_88 {
    public static void main(String[] args) {
        /**
         * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
         *
         *  
         *
         * 说明:
         *
         * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
         * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/merge-sorted-array
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */

        int[] nums1 = {2, 0};
        int[] nums2 = {1};
        merge(nums1, 1, nums2, 1);
        System.out.println("main: " + Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while (len2 >= 0) {
            //len1 >= 0 防止nums1是个空数组
            if (len1 >= 0 && nums1[len1] > nums2[len2]) {
                // 注意--符号在后面，表示先进行计算再减1，这种缩写缩短了代码
                nums1[len--] = nums1[len1--];
            } else {
                nums1[len--] = nums2[len2--];
            }
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, p3 = m + n - 1;
        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p3--] = nums1[p1--];
            } else {
                nums1[p3--] = nums2[p2--];
            }
        }
    }
}
