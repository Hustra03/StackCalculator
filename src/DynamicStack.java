public class DynamicStack extends Stack {

    int belowLengthDeadLineNumber=4;
    int belowLengthDeadLine = belowLengthDeadLineNumber; // Determines how many pops when below stack.length/belowLengthDivider before
                                 // reduce length by 1/sizeIncreaseAndDecrease
    int belowLengthDivider = 2; // Deterimes how much the stack should be below max length before it decreases,
                                // aka current top<this.stack.length/belowLengthDivider
    int sizeIncreaseAndDecrease = 3; // Deterimes how many fractions the stack length will decrease, aka 4 => length
                                     // = 3/4 of original and increase to 5/4 +1, with the +1 in order to avoid
                                     // problems with stacks which are very small and thus length/4 < 1, and thus =0
                                     // when considering int
    int timesReduced=0; //Used to find optimal numbers, comment away this part
    int timesIncreased=0; //Used to find optimal numbers, comment away this part                             

//Includera discussion om sizeIncreaseAndDecrease, lägre leder till större steg => färre antal kopieringar, men också större stack ändringar

    public DynamicStack(int stackLenth) {
        this.top = -1;
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
                belowLengthDeadLine=belowLengthDeadLineNumber;
                //timesReduced++;
                //System.out.println("Decreasing Stack length nr. "+timesReduced+", new length: " + this.stack.length);//Used to find optimal numbers for above, comment away this part
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
            belowLengthDeadLine = belowLengthDeadLineNumber;
            timesIncreased++;
            System.out.println("Increasing Stack length nr. "+timesIncreased+", new length: " + this.stack.length);//Used to find optimal numbers for above, comment away this part
        }
        if (belowLengthDeadLine < belowLengthDeadLineNumber) {
            belowLengthDeadLine++;
        }
        top++;
        this.stack[top] = item;

    }
}
