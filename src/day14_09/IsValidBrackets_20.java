package day14_09;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class IsValidBrackets_20 {
    public static void main(String[] args) {
        /*
        给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

        有效字符串需满足：

        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
        注意空字符串可被认为是有效字符串。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/valid-parentheses
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
        System.out.println(isValid2("([])}}"));
    }

    public static boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }

        if (s.length() % 2 != 0) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || !stack.peek().equals(map.get(ch))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
                System.out.println("after push: " + stack);
            }

        }

        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {
        //空字符串
        if (s.length() == 0) {
            return true;
        }

        //单个字符
        if (s.length() % 2 == 1) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != (map.get(ch))) {
                    //stack.isEmpty() 情况 "([])}}"
                    //以 )]}开头直接返回false !stack.peek().equals(map.get(ch))
                    //会减少一点内存空间占用
                    System.out.println(stack.isEmpty());
                    System.out.println(stack.peek() != (map.get(ch)));
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
                System.out.println("push： " + stack);
            }
        }
        return stack.isEmpty();
    }
}
