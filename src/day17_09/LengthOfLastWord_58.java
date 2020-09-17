package day17_09;

import java.util.Arrays;

public class LengthOfLastWord_58 {
    public static void main(String[] args) {
        /**
         * 给定一个仅包含大小写字母和空格' '的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
         *
         * 如果不存在最后一个单词，请返回 0 。
         *
         * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/length-of-last-word
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
        System.out.println(lengthOfLastWord2("  hello wor ld "));
    }

    public static int lengthOfLastWord(String s) {
        if (s.contains(" ")) {
            String[] s1 = s.split(" ");
            return s1.length > 0 ? s1[s1.length - 1].length() : 0;
        } else {
            return s.length();
        }
    }

    //从后向前遍历
    public static int lengthOfLastWord2(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            System.out.println(end);
            end--;
        }
        if (end < 0) {
            return 0;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }
}
