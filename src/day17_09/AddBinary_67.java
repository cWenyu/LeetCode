package day17_09;

public class AddBinary_67 {
    public static void main(String[] args) {
        /**
         * 给你两个二进制字符串，返回它们的和（用二进制表示）。
         *
         * 输入为 非空 字符串且只包含数字 1 和 0。
         *
         *
         */
        System.out.println(addBinary("101", "110"));
    }

    public static String addBinary(String a, String b) {
        if (" ".equals(a) || " ".equals(b)) {
            throw new RuntimeException("非法字符串");
        }

        //循环
        int ca = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += (i >= 0 ? a.charAt(i) - '0' : 0);
            // 判断j>=0的含义是有可能两个数字长度不一致，如果j<0的话则将其当做0来处理，否则获取其值，也就是 b.charAt(j) - '0'
            sum += (j >= 0 ? b.charAt(j) - '0' : 0);
            // sum%2是在做二进制取模运算，比如sum=2，这时候将sum%2=0放入结果集中
            ans.append(sum % 2);
            // 这里是计算进位，比如sum=2，ca = 1，ca表示进位的意思，满2进1
            ca = sum / 2;
        }
        //这一步表示是不是最后还有进位，比如1+1 = 10，10前面的1就是最后留存的进位，需要将其放进去
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }
}
