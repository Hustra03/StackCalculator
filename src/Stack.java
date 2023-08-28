public abstract class Stack {
    int stackPointer;
    Item[] stack;
    public Stack(){};
    abstract public Item pop();
    abstract public void push(Item item);
}
