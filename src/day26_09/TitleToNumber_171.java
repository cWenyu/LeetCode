package day26_09;

public class TitleToNumber_171 {
    public static void main(String[] args) {
        /**
         * 给定一个Excel表格中的列名称，返回其相应的列序号。
         */
        String s = "AB";
        System.out.println(titleToNumber(s));
    }


    public static int titleToNumber(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            num = num * 26 + (s.charAt(i) - 'A' + 1);
        }
        return num;
    }
}
