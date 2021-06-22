package Question;

import java.util.Stack;

public class Part2MinStack {
    //实现一个栈，该栈带有出栈、入栈、取最小元素 三个方法  保证这三个方法的时间复杂度是O(1)
    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    /**
     * 入栈
     * @param element
     */
    public void push(int element) {
        mainStack.push(element);
        if (minStack.empty() || element <= minStack.peek()) {
            minStack.push(element);
        }
    }

    /**
     * 出栈
     * @return
     */
    public Integer pop() {
        if (mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return mainStack.pop();
    }


    /**
     * 取最小值
     * @return
     * @throws Exception
     */
    public int getMin() throws Exception {
        if (mainStack.empty()) {
            throw new Exception("stack is empty");
        }
        return minStack.peek();
    }

    public static void main(String[] args) throws Exception {
        Part2MinStack minStack = new Part2MinStack();
        minStack.push(2);
        minStack.push(4);
        minStack.push(5);
        minStack.push(1);
        minStack.push(6);
        int min = minStack.getMin();
        System.out.println(min);
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.getMin());

    }
 }
