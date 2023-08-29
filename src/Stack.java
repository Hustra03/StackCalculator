public abstract class Stack {
    int top;
    int[] stack;
    public Stack(){};
    abstract public int pop();
    abstract public void push(int item);
}
