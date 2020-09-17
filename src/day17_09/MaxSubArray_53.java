package day17_09;

public class MaxSubArray_53 {
    public static void main(String[] args) {
        /**
         * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
         *
         * 示例:
         *
         * 输入: [-2,1,-3,4,-1,2,1,-5,4]
         * 输出: 6
         * 解释:连续子数组 [4,-1,2,1] 的和最大，为 6。
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/maximum-subarray
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int result = nums[0];
        for (int num : nums) {
            if (sum > 0) {
                //sum > 0 时累加
                sum += num;
            } else {
                //sum<0时，直接替换为当前数值
                sum = num;
            }
            //比较之前累加的result和sum的大小
            result = Math.max(result, sum);
        }
        return result;
    }
}
