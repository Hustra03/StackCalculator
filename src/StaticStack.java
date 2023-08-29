public class StaticStack extends Stack {

    public StaticStack(int stackLenth) {
        this.top = 0;
        this.stack = new int[stackLenth];
    }

    public int pop() {
        if (top == 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {

            top--;
            return this.stack[top];
        }
    }

    public void push(int item) {
        if (top == this.stack.length) {
            throw new ArrayIndexOutOfBoundsException();

        } else {

            this.stack[top] = item;
            top++;
        }
    }
}
