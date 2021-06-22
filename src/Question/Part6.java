package Question;

import java.util.Stack;

public class Part6 {
    //用栈来模拟一个队列，实现基本操作，入队、出队
    private Stack<Integer> stackA = new Stack<>();
    private Stack<Integer> stackB = new Stack<>();

    public void enQueue(int element) {
        stackA.push(element);
    }

    public Integer deQueue() {
        if (stackB.isEmpty()) {
            if (stackA.isEmpty()) {
                return null;
            }
            transfer();

        }
        return stackB.pop();
    }

    private void transfer() {
        while (!stackA.isEmpty()) {
            stackB.push(stackA.pop());
        }
    }

    public static void main(String[] args) {
        Part6 part6 = new Part6();
        part6.enQueue(2);
        part6.enQueue(3);
        part6.enQueue(4);
        System.out.println(part6.deQueue());
    }

}
