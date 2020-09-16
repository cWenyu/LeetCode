package day12_09;

public class reverseInt_7 {
    public static void main(String[] args) {
        //给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 [−2^31,  2^31 − 1]
        System.out.println(-32%10);
        reverse2(52);
    }

    public int reverse(int x) {
        /*
        如果用string转换的话无法考虑到换位时就溢出的问题，并且引入多个包，考虑用数学方法解决
         */
        int result;
        StringBuilder strbuilder = new StringBuilder();
        if (x >= 0) {
            result = Integer.parseInt(strbuilder.append(x + "").reverse().toString());
        } else {
            result = 0 - Integer.parseInt(strbuilder.append(Math.abs(x) + "").reverse().toString());
        }

        if ((result > Math.pow(2, 31) - 1) || (result < (0 - Math.pow(2, 31)))) {
            return 0;
        } else {
            return result;
        }
    }

    public static int reverse2(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            ans = ans * 10 + pop;
            System.out.println("ans: "+ans);
            x /= 10;
        }
        return ans;

//        作者：guanpengchn
//        链接：https://leetcode-cn.com/problems/reverse-integer/solution/hua-jie-suan-fa-7-zheng-shu-fan-zhuan-by-guanpengc/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}
