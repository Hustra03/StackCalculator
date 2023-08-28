public class StaticStack extends Stack{
    
    public StaticStack(int stackLenth){
        this.stackPointer=0;
        this.stack= new Item[stackLenth];
    }
    public Item pop()
    {
        return this.stack[0];
    }

    public void push(Item item)
    {
        
    }
}
