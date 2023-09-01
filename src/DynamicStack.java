public class DynamicStack extends Stack {

    public DynamicStack(int stackLenth) {
        this.top = 0;
        this.stack = new int[stackLenth];
    }

    public int[] getStack() {
        return this.stack;
    }

    public int pop() {

        if (top < 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (top < (stack.length / 2)) {
            int[] newStack = new int[stack.length - stack.length / 3];
            for (int i = 0; i < newStack.length; i++) {
                newStack[i] = this.stack[i];
            }
            this.stack = newStack;
            // System.out.println("Decreasing Stack length, new length: " +
            // this.stack.length);
        }
        top--;
        return this.stack[top];

    }

    public void push(int item) {
        if (top >= this.stack.length) {
            int[] newStack = new int[stack.length * 2];
            for (int i = 0; i < stack.length; i++) {
                newStack[i] = this.stack[i];
            }
            this.stack = newStack;
            // System.out.println("Increasing Stack length, new length: " +
            // this.stack.length);
        }
        this.stack[top] = item;
        top++;
    }
}
