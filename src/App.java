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
        
        int repeatAmount=1000;
        long[] timeStaticPush = new long[repeatAmount];
        long[] timeStaticPop = new long[repeatAmount];
        long[] timeDynamicPush = new long[repeatAmount];
        long[] timeDynamicPop = new long[repeatAmount];
        int loopLength = 1000;
        

        for (int j = 0; j < repeatAmount; j++) {

            StaticStack testStaticStack = new StaticStack(1024);
            DynamicStack testDynamicStack = new DynamicStack(4);

            long t0 = System.nanoTime();

            for (int i = 0; i < loopLength; i++) {
                testStaticStack.push(10);
            }
            long t1 = System.nanoTime();

            for (int i = 0; i < loopLength; i++) {
                testStaticStack.pop();
            }

            long t2 = System.nanoTime();

            for (int i = 0; i < loopLength; i++) {
                testDynamicStack.push(10);
            }

            long t3 = System.nanoTime();

            for (int i = 0; i < loopLength; i++) {
                testDynamicStack.pop();
            }

            long t4 = System.nanoTime();

            System.out.println("Static Stack Push " + loopLength + " total time:" + (t1 - t0) + " ns |"
                    + (t1 - t0) / loopLength + " ns per element");
            System.out.println("Static Stack Pop " + loopLength + " total time:" + (t2 - t1) + " ns |"
                    + (t2 - t1) / loopLength + " ns per element");
            System.out.println("Dynamic Stack Push " + loopLength + " total time:" + (t3 - t2) + " ns |"
                    + (t3 - t2) / loopLength + " ns per element");
            System.out.println("Dynamic Stack Pop " + loopLength + " total time:" + (t4 - t3) + " ns |"
                    + (t4 - t3) / loopLength + " ns per element");
            timeStaticPush[j] = (t1 - t0);
            timeStaticPop[j] = (t2 - t1);
            timeDynamicPush[j] = (t3 - t2);
            timeDynamicPop[j] = (t4 - t3);
        }

        long minimumStaticPush = 0;
        long minimumStaticPop = 0;
        long minimumDynamicPush = 0;
        long minimumDynamicPop = 0;

        long averageStaticPush = 0;
        long averageStaticPop = 0;
        long averageDynamicPush = 0;
        long averageDynamicPop = 0;

        for (int j = 0; j < repeatAmount; j++) {
            if (j == 0) {
                minimumStaticPush = timeStaticPush[j];
                minimumStaticPop = timeStaticPop[j];
                minimumDynamicPush = timeDynamicPush[j];
                minimumDynamicPop = timeDynamicPop[j];
            } else {
                if (timeStaticPush[j] < minimumStaticPush) {
                    minimumStaticPush = timeStaticPush[j];
                }
                if (timeStaticPop[j] < minimumStaticPop) {
                    minimumStaticPop = timeStaticPop[j];
                }
                if (timeDynamicPush[j] < minimumDynamicPush) {
                    minimumDynamicPush = timeDynamicPush[j];
                }
                if (timeDynamicPop[j] < minimumDynamicPop) {
                    minimumDynamicPop = timeDynamicPop[j];
                }
            }
            averageStaticPush += timeStaticPush[j];
            averageStaticPop += timeStaticPop[j];
            averageDynamicPush += timeDynamicPush[j];
            averageDynamicPop += timeDynamicPop[j];
        }
        averageStaticPush /= repeatAmount;
        averageStaticPop /= repeatAmount;
        averageDynamicPush /= repeatAmount;
        averageDynamicPop /= repeatAmount;

        System.out.println("Minimum Static Push: " + minimumStaticPush);
        System.out.println("Minimum Static Pop: " + minimumStaticPop);
        System.out.println("Minimum Dynamic Push: " + minimumDynamicPush);
        System.out.println("Minimum Dynamic Pop: " + minimumDynamicPop);
        System.out.println("Average Static Push: " + averageStaticPush);
        System.out.println("Average Static Pop: " + averageStaticPop);
        System.out.println("Average Dynamic Push: " + averageDynamicPush);
        System.out.println("Average Dynamic Pop: " + averageDynamicPop);

    }
}
