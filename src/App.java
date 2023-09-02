public class App {
    // Below is to run calculator
    public static void main(String[] args) throws Exception {
        /*
         * // 10 + 2 * 5
         * // 10 2 5 * + in reversed Polish notation
         * Item[] expr = {
         * Item.Value(10),
         * Item.Value(2),
         * Item.Value(5),
         * Item.Mul(),
         * Item.Add(),
         * };
         * 
         * boolean UseDynamicStack=true;
         * Calculator calc = new Calculator(expr,UseDynamicStack);
         * int res = calc.run();
         * System.out.println(" Calculator: res = " + res);
         */

        long timeStaticMin = Long.MAX_VALUE;
        long timeDynamicMin = Long.MAX_VALUE;

        for (int j = 0; j < 100; j++) {

            StaticStack testStaticStack = new StaticStack(1024);
            long t0 = System.nanoTime();
            for (int a = 0; a < 1000; a++) {
                for (int i = 0; i < 1000; i++) {
                    testStaticStack.push(i);
                }
                for (int i = 0; i < 1000; i++) {
                    testStaticStack.pop();
                }
            }
            long t1 = System.nanoTime();
            if (timeStaticMin > (t1 - t0)) {
                timeStaticMin = (t1 - t0);
            }

            DynamicStack testDynamicStack = new DynamicStack(4);
            t0 = System.nanoTime();
            for (int a = 0; a < 1000; a++) {

                for (int i = 0; i < 1000; i++) {
                    testDynamicStack.push(i);
                }
                for (int i = 0; i < 1000; i++) {
                    testDynamicStack.pop();
                }
            }
            t1 = System.nanoTime();
            if (timeDynamicMin > (t1 - t0)) {
                timeDynamicMin = (t1 - t0);
            }
        }

        System.out.println("Static Minimum Time:" + (timeStaticMin));
        System.out.println("Dynamic Minimum Time:" + (timeDynamicMin));
    }
}
