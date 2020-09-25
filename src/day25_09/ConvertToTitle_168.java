package day25_09;

public class ConvertToTitle_168 {
    public static void main(String[] args) {
        /**
         * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
         *
         * 例如，
         *
         *     1 -> A
         *     2 -> B
         *     3 -> C
         *     ...
         *     26 -> Z
         *     27 -> AA
         *     28 -> AB
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */


        System.out.println(convertToTitle(28));
    }

    public static String convertToTitle(int n) {
        StringBuilder strBuilder = new StringBuilder();
        while (n > 0) {
            n--;
            strBuilder.append((char) ('A' + (n) % 26));
            n /= 26;
        }
        return strBuilder.reverse().toString();
    }
}
