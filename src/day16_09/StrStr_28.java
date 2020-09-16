package day16_09;

public class StrStr_28 {
    public static void main(String[] args) {
        /**
         * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/implement-strstr
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
        System.out.println(strStr2("hello", "o"));
    }

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    //滑动窗口
    public static int strStr2(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();

        for (int start = 0; start < n - L + 1; ++start) {
            if (haystack.substring(start, start + L).equals(needle)) {
                return start;
            }
        }
        return -1;
    }
}

