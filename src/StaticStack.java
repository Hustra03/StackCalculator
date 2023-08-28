public class StaticStack extends Stack{
    
    public StaticStack(int stackLenth){
        this.stackPointer=0;
        this.stack= new Item[stackLenth];
    }
    public int pop()
    {
        return this.stack[0].getValue();
    }

    public void push(int item)
    {
        
    }
    public void push(Item item)
    {
        
    }
}
