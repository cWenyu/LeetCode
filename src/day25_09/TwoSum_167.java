package day25_09;

public class TwoSum_167 {
    public static void main(String[] args) {
        /**
         * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
         *
         * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
         *
         * 说明:
         *
         * 返回的下标值（index1 和 index2）不是从零开始的。
         * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
    }

    /**
     * 双指针
     *
     * @param numbers   是一个升序排列的数组
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int p = 0, q = numbers.length - 1, sum = 0;
        while (p < q) {
            sum = numbers[p] + numbers[q];
            if (target == sum) {
                return new int[]{p + 1, q + 1};
            } else if (target < sum) {
                q--;
            } else {
                p++;
            }
        }
        return null;
    }
}
