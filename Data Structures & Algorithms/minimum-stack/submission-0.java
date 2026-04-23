class MinStack {
    int top, capacity;
    int[] stack;

    public MinStack() {
        top = -1;
        stack = new int[1];
        capacity = 1;
    }
    
    public void push(int val) {
        if (top == capacity - 1) { // if stack is full
            this.resize();
        }
        stack[top + 1] = val;
        top++;
    }
    
    public void pop() {
        if (top >= 0) top--;
    }
    
    public int top() {
        return stack[top];
    }
    
    public int getMin() {
        int min = stack[0];

        for (int i=0; i <= top; i++) {
            if (stack[i] < min) {
                min = stack[i];
            }
        } // for

        return min;
    }

    // Added functions:
    public void resize() {
        capacity = capacity * 2;
        int[] resizedArray = new int[capacity];

        // copy values
        for (int i=0; i<stack.length; i++) {
            resizedArray[i] = stack[i];
        } // for

        stack = resizedArray;
    }
}
