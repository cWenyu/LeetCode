package day26_09;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MajorityElement_169 {
    public static void main(String[] args) {
        /**
         * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
         *
         * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/majority-element
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */

        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        majorityElement(nums);

    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, (map.get(num) + 1));
            } else {
                map.put(num, 1);
            }
        }

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> set = (Map.Entry<Integer, Integer>) it.next();
            if (set.getValue() > nums.length / 2) {
                return set.getKey();
            }
        }
        return 0;
    }

    /**
     * 排序后返回下标为n/2的元素
     */
    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 摩尔投票找众数
     * candidate表示当前 mode值，count表示vote投票数，当当前值==candidate vote++，否则--，
     * 若vote ==0，则将candidate替换为当前值
     *
     * @param nums
     * @return
     */
    public static int majorityElement3(int[] nums) {
        int candidate = nums[0], count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

}
