package A1v300.A231v240.A232ImplementQueueusingStacks;

import java.util.Stack;

class MyQueue {

    Stack<Integer> data = new Stack<>();
    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack<Integer> tmp = new Stack<>();
        while (!data.isEmpty()){
            tmp.add(data.pop());
        }
        tmp.add(x);
        while (!tmp.isEmpty()){
            data.add(tmp.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return data.pop();
    }

    /** Get the front element. */
    public int peek() {
        return data.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return data.isEmpty();
    }
}