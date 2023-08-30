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
        int loopLength=1000;

        long t0=System.nanoTime();

        for (int i = 0; i < loopLength; i++) {
            testStaticStack.push(10);
        }
        long t1=System.nanoTime();


        for (int i = 0; i < loopLength; i++) {
            testStaticStack.pop();
        }

        long t2=System.nanoTime();

        for (int i = 0; i < loopLength; i++) {
            testDynamicStack.push(10);
        }

        long t3=System.nanoTime();

        for (int i = 0; i < loopLength; i++) {
            testDynamicStack.pop();
        }

        long t4=System.nanoTime();        
        System.out.println("Static Stack Push "+ loopLength +" total time:" + (t1-t0)+ " ns |" + (t1-t0)/loopLength+" ns per element");
        System.out.println("Static Stack Pop "+ loopLength +" total time:" + (t2-t1)+ " ns |"+ (t2-t1)/loopLength+" ns per element");
        System.out.println("Dynamic Stack Push "+ loopLength +" total time:" + (t3-t2)+ " ns |"+ (t3-t2)/loopLength+" ns per element");
        System.out.println("Dynamic Stack Pop "+ loopLength +" total time:" + (t4-t3)+ " ns |"+ (t4-t3)/loopLength+" ns per element");

    }
}
