package day14_09;

public class LongestCommonPrefix_14 {
    public static void main(String[] args) {
        /**
         * 编写一个函数来查找字符串数组中的最长公共前缀。
         *
         * 如果不存在公共前缀，返回空字符串 ""。
         */
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        }

        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < result.length() && j < strs[i].length(); j++) {
                if (result.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            result = result.substring(0, j);
        }
        return result;

    }
}
