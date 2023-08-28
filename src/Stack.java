public abstract class Stack {
    int stackPointer;
    Item[] stack;
    public Stack(){};
    abstract public int pop();
    abstract public void push(int item);
    abstract public void push(Item item);
}
