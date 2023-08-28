public class Calculator {
    Item[] expr;
    int ip;
    Stack stack;

    public Calculator(Item[] expr) {
        this.expr = expr;
        this.ip = 0;
        this.stack = new Stack();
    }

    public int run() {
        while (ip < expr.length) {
            step();
        }
        return stack.pop();
    }

    public void step() {
        Item nxt = expr[ip++];
        switch (nxt.getItemType()) {
            case ADD: {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x + y);
                break;
            }
            case SUB:{

            }
            case MUL:{

            }
            case DIV:{

            }
            case VALUE:{
                
            }
        }
    }
}
