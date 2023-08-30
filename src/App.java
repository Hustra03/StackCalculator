public class App {
    // Below is to run calculator
    /*
     * public static void main(String[] args) throws Exception {
     * // 10 + 2 * 5
     * // 10 2 5 * + in reversed Polish notation
     * Item[] expr = {
     * Item.Value(10),
     * Item.Value(2),
     * Item.Value(5),
     * Item.Mul(),
     * Item.Add(),
     * Item.Value(5),
     * Item.Value(5),
     * Item.Value(5),
     * Item.Value(5),
     * Item.Value(5),
     * Item.Value(5),
     * Item.Value(5),
     * Item.Value(5),
     * Item.Value(5),
     * Item.Value(5),
     * Item.Value(5),
     * Item.Value(5),
     * Item.Value(5),
     * Item.Value(5),
     * Item.Mul(),
     * Item.Mul(),
     * Item.Mul(),
     * Item.Mul(),
     * Item.Mul(),
     * Item.Mul(),
     * Item.Mul(),
     * Item.Mul(),
     * Item.Mul(),
     * Item.Mul(),
     * Item.Mul(),
     * Item.Mul()
     * };
     * 
     * boolean UseDynamicStack=true;
     * Calculator calc = new Calculator(expr,UseDynamicStack);
     * int res = calc.run();
     * System.out.println(" Calculator: res = " + res);
     * }
     */
    // Below is to run stack benchmark
    public static void main(String[] args) throws Exception {

        StaticStack testStaticStack = new StaticStack(1024);
        DynamicStack testDynamicStack = new DynamicStack(4);

        for (int i = 0; i < 1000; i++) {
            testStaticStack.push(10);
        }
        
        for (int i = 0; i < 1000; i++) {
            testStaticStack.pop();
        }

        for (int i = 0; i < 1000; i++) {
            testDynamicStack.push(10);
        }

        for (int i = 0; i < 1000; i++) {
            testDynamicStack.pop();
        }

    }
}
