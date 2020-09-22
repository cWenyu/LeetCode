package day22_09;

public class IsPalindrome_125 {
    public static void main(String[] args) {
        /**
         * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
         *
         * 说明：本题中，我们将空字符串定义为有效的回文串。
         */
        String s = "ab2a";
        boolean result = isPalindrome(s);

        System.out.println(result);
    }

    public static boolean isPalindrome(String s) {
        if (s == "") return true;
        s = s.toLowerCase();
        int p = 0, q = s.length() - 1;
        while ((p < q)) {
            //找出p,q 只考虑字母和数字字符
            while (p < q) {
                if (s.charAt(p) >= 'a' && s.charAt(p) <= 'z' || (s.charAt(p) >= '0' && s.charAt(p) <= '9')) {
                    break;
                }
                p++;
            }

            while (q > p) {
                if (s.charAt(q) >= 'a' && s.charAt(q) <= 'z' || (s.charAt(q) >= '0' && s.charAt(q) <= '9')) {
                    break;
                }
                q--;
            }

            if (s.charAt(p) != s.charAt(q)) {
                return false;
            }
            p++;
            q--;
        }

        return true;
    }


    public static boolean isPalindrome2(String s) {
        if (s == "") return true;
        s = s.toLowerCase();
        int p = 0, q = s.length() - 1;
        while ((p < q)) {
            //找出p,q 只考虑字母和数字字符 Character.isLetterOrDigit(s.charAt(p) 用于判断char是字符或者是数字
            while (p < q && !Character.isLetterOrDigit(s.charAt(p))) {
                p++;
            }

            while (q > p && !Character.isLetterOrDigit(s.charAt(q))) {
                q--;
            }

            if (s.charAt(p) != s.charAt(q)) {
                return false;
            }
            p++;
            q--;
        }

        return true;
    }
}
