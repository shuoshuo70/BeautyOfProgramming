package Chapter3;

import java.util.Stack;

/**
 * Created by shuoshu on 2018/1/7.
 */
public class MaxQueue {
    MaxStack stack1, stack2;
    MaxQueue() {
        stack1 = new MaxStack();
        stack2 = new MaxStack();
    }

    public void add(int val) {
        stack1.push(val);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                return Integer.MIN_VALUE;
            }

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pull());
            }
        }

        return stack2.pull();
    }

    public int max() {
        return Math.max(stack1.max(), stack2.max());
    }

    public static void main(String[] args) {
        MaxQueue solution = new MaxQueue();
        solution.add(1);
        System.out.println(solution.max());
        solution.add(4);
        System.out.println(solution.max());
        solution.add(2);
        System.out.println(solution.max());
        solution.pop();
        System.out.println(solution.max());
        solution.pop();
        System.out.println(solution.max());
    }
}

class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxStack;

    MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        if (maxStack.isEmpty() || maxStack.peek() <= val) {
            maxStack.push(val);
        }
    }

    public int pull() {
        if (stack.isEmpty()) {
            return Integer.MIN_VALUE;
        }

        int val = stack.pop();
        if (!maxStack.isEmpty() && val == maxStack.peek()) {
            maxStack.pop();
        }

        return val;
    }

    public int max() {
        if (maxStack.isEmpty()) {
            return Integer.MIN_VALUE;
        }

        return maxStack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
