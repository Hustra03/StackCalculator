public class DynamicStack extends Stack{

public DynamicStack(int stackLenth)
{}

public int pop()
{
    top--;
    return this.stack[top];
}

public void push(int item)
{
    this.stack[top]=item;
    top++;
}
}
