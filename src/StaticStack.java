public class StaticStack extends Stack {

    public StaticStack(int stackLenth) {
        this.top = 0;
        this.stack = new int[stackLenth];
    }

    public int pop() {
        if (top < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            int returnValue=this.stack[top];
            top--;
            return returnValue;
        }
    }

    public void push(int item) {
        if (top > this.stack.length-1) {
            throw new ArrayIndexOutOfBoundsException();

        } else {
            top++;
            this.stack[top] = item;
            /*for (int i = 0; i < stack.length; i++) {
                if (this.stack[i]!=0) {
                    
            System.out.println("Current Stack Position"+i+" : "+this.stack[i] );
                }
            }*/
        }
    }
}
