package A1v300.A221v230.A225ImplementStackusingQueues;

import java.util.LinkedList;

class MyStack {

    public MyStack() {
    }

    private LinkedList<Integer> q1 = new LinkedList<>();

    public void push(int x) {
        q1.add(x);
        int sz = q1.size();
        while (sz > 1) {
            q1.add(q1.remove());
            sz--;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.remove();
    }

    /** Get the top element. */
    public int top() {
        return q1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}