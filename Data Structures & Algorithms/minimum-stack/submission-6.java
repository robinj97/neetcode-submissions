class MinStack {
    Stack<Integer> stack;

    public MinStack() {
        this.stack = new Stack<Integer>();
        
    }
    
    public void push(int val) {
        this.stack.push(val);
    }
    
    public void pop() {
        this.stack.pop();
    }
    
    public int top() {
        return this.stack.peek();
        
    }
    
    public int getMin() {
        Stack<Integer> tempStack = new Stack<>();
        tempStack.addAll(this.stack);
        int minValFound = Integer.MAX_VALUE;
        while (!tempStack.isEmpty()) {
            minValFound = Math.min(tempStack.pop(),minValFound);
        }
        return minValFound;
    }
}
