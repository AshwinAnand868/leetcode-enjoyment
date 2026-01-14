class MyQueue {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        shiftStacks();
        return outStack.pop();
    }
    
    public int peek() {
        shiftStacks();
        return outStack.peek();
    }
    
    public boolean empty() {
        return outStack.empty() && inStack.empty();
    }

    private void shiftStacks() {
        if(outStack.empty()) {
            while(!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */