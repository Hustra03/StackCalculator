public class DynamicStack extends Stack {

    int belowLengthDeadLine = 4; // Determines how many pops when below stack.length/belowLengthDivider before
                                 // reduce length by
    int belowLengthDivider = 2; // Deterimes how much the stack should be below max length before it decreases,
                                // aka current top<this.stack.length/belowLengthDivider
    int sizeIncreaseAndDecrease = 4; // Deterimes how many fractions the stack length will decrease, aka 4 => length
                                     // = 3/4 of original and increase to 5/4 +1, with the +1 in order to avoid
                                     // problems with stacks which are very small and thus length/4 < 1, and thus =0
                                     // when considering int

    public DynamicStack(int stackLenth) {
        this.top = 0;
        this.stack = new int[stackLenth];
    }

    public int pop() {
        if (top < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            if (top < (stack.length - stack.length / belowLengthDivider)) {
                belowLengthDeadLine -= 1;
            }
            if (belowLengthDeadLine <= 0) {

                int[] newStack = new int[stack.length - stack.length / sizeIncreaseAndDecrease];
                for (int i = 0; i < newStack.length; i++) {
                    newStack[i] = this.stack[i];
                }
                this.stack = newStack;
                belowLengthDeadLine=4;
                System.out.println("Decreasing Stack length, new length: " + this.stack.length);
            }
            int returnValue = this.stack[top];
            top--;
            return returnValue;
        }
    }

    public void push(int item) {
        if (top >= this.stack.length - 1) {
            int[] newStack = new int[stack.length + stack.length / sizeIncreaseAndDecrease + 1];
            for (int i = 0; i < stack.length; i++) {
                newStack[i] = this.stack[i];
            }
            this.stack = newStack;
            belowLengthDeadLine = 4;
            System.out.println("Increasing Stack length, new length: " + this.stack.length);
        }
        if (belowLengthDeadLine < 4) {
            belowLengthDeadLine++;
        }
        top++;
        this.stack[top] = item;

    }
}
