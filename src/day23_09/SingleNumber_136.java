package day23_09;

public class SingleNumber_136 {
    public static void main(String[] args) {
        /**
         * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
         *
         * 说明：
         *
         * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/single-number
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */

        /*
        0⊕0=0，1⊕0=1，0⊕1=1，1⊕1=0（同为0，异为1），
        这些法则与加法是相同的，只是不带进位，所以异或常被认作不进位加法
         */
        //异或运算 XOR
        int a = 1;
        //1. a⊕0 = a
        System.out.println(a ^= 0); // 等于 1

        //2. a⊕a = 0
        System.out.println(a ^= a); // 等于 2

        //3. 运算满足交换律和结合律：a⊕b⊕a = (a⊕a)⊕b = 0⊕b = b
        int b = 2;
        System.out.println(a ^= b ^= a); // 等于 b = 2

        System.out.println("singleNumber: ");
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }

    /**
     * 本题根据题意，线性时间复杂度 O(n)O(n)，很容易想到使用 Hash 映射来进行计算，遍历一次后结束得到结果，但是在空间复杂度上会达到 O(n)O(n)，需要使用较多的额外空间
     * 既满足时间复杂度又满足空间复杂度，就要提到位运算中的异或运算 XOR，主要因为异或运算有以下几个特点：
     * 一个数和 0 做 XOR 运算等于本身：a⊕0 = a
     * 一个数和其本身做 XOR 运算等于 0：a⊕a = 0
     * XOR 运算满足交换律和结合律：a⊕b⊕a = (a⊕a)⊕b = 0⊕b = b
     * 故而在以上的基础条件上，将所有数字按照顺序做抑或运算，最后剩下的结果即为唯一的数字
     * 时间复杂度：O(n)O(n)，空间复杂度：O(1)O(1)
     * <p>
     * 作者：guanpengchn
     * 链接：https://leetcode-cn.com/problems/single-number/solution/hua-jie-suan-fa-136-zhi-chu-xian-yi-ci-de-shu-zi-b/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
            System.out.print(result+" ,");
        }
        System.out.println();
        return result;
    }
}
