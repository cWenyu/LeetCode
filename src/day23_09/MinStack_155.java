package day23_09;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MinStack_155 {

}

class MinStack {
    /**
     * 用辅助栈： xStack存储data
     * minStack （push时候）存储当前最小值
     * pop时，xStack.peek = minStack.peek()相同时 xStack和minStack都要进行pop操作
     * getMin 操作时直接返回minStack.peek()即可
     */
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/*
2.借用节点，节点中存储 val(当前元素),min(当前最小值)，next节点
3.使用节点，链表形式
4.若不开辟额外空间，存储差值的形式
 */