package sumTwo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class sumTwo {
    public static void main(String[] args) {
        /**
         * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
         *
         * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
         *
         *  
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/two-sum
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */

//        try {
//            int[] results = twoSum2(new int[]{2, 2, 7, 11, 15}, 9);
//        } catch (Exception e) {
//            System.out.println(e);
//        }

        int[] results = twoSum3(new int[]{2, 2, 7, 11, 15}, 13);
        System.out.println(Arrays.toString(results));
    }

    //解法1
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    //解法2
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //将元素放入hashmap中
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        System.out.println(map);

        //查看表中是否有值 = target-当前元素的值
        for (int i = 0; i < nums.length; i++) {
            int compare = target - nums[i];

            if (map.containsKey(compare) && map.get(compare) != i) {
                return new int[]{map.get(compare), i};
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSum3(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //查看表中是否有值 = target-当前元素的值
        for (int i = 0; i < nums.length; i++) {
            int compare = target - nums[i];

            if (map.containsKey(compare)) {
                return new int[]{map.get(compare), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[]{};
    }
}
