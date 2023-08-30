public class DynamicStack extends Stack {

    int belowLengthDeadLine = 4; // Determines how many pops when below stack.length/belowLengthDivider before
                                 // reduce length by
    int belowLengthDivider = 2; // Deterimes how much the stack should be below max length before it decreases,
                                // aka current top<this.stack.length/belowLengthDivider
    int sizeIncreaseAndDecrease = 4; // Deterimes how many fractions the stack length will decrease, aka 4 => length
                                     // = 3/4 of original

    public DynamicStack(int stackLenth) {
        this.top = 0;
        this.stack = new int[stackLenth];
    }

    public int pop() {
        if (top < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            int returnValue = this.stack[top];
            top--;
            if (top < this.stack.length / belowLengthDivider) {
                belowLengthDeadLine -= 1;
            }
            if (belowLengthDeadLine <= 0) {

                int[] newStack = new int[stack.length - stack.length / sizeIncreaseAndDecrease];
                for (int i = 0; i < newStack.length; i++) {
                    newStack[i] = this.stack[i];
                }
            }
            return returnValue;
        }
    }

    public void push(int item) {
        if (top >= this.stack.length - 1) {
            int[] newStack = new int[stack.length + stack.length / sizeIncreaseAndDecrease];
            for (int i = 0; i < stack.length; i++) {
                newStack[i] = this.stack[i];
            }
            this.stack = newStack;
            belowLengthDeadLine = 4;
        }
        if (belowLengthDeadLine < 4) {
            belowLengthDeadLine++;
        }
        top++;
        this.stack[top] = item;

    }
}
