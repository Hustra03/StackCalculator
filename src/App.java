import java.util.Arrays;

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

        int repeatAmount = 1000;
        long[] timeStaticPush = new long[repeatAmount];
        long[] timeStaticPop = new long[repeatAmount];
        long[] timeDynamicPush = new long[repeatAmount];
        long[] timeDynamicPop = new long[repeatAmount];
        int loopLength = 1000;

        StaticStack testStaticStack = new StaticStack(1024); 
        DynamicStack testDynamicStack = new DynamicStack(4);
        for (int j = 0; j < repeatAmount; j++) {

            long t0 = System.nanoTime();

            for (int a = 0; a < loopLength; a++) {
                testStaticStack.push(120);
            }
            long t1 = System.nanoTime();

            for (int b = 0; b < loopLength; b++) {
                testStaticStack.pop();
            }

            long t2 = System.nanoTime();

            for (int c = 0; c < loopLength; c++) {
                testDynamicStack.push(120);
            }

            long t3 = System.nanoTime();

            for (int d = 0; d < loopLength; d++) {
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


            testStaticStack = new StaticStack(1024);
            testDynamicStack = new DynamicStack(4);
        }

        Arrays.sort(timeStaticPush);
        Arrays.sort(timeStaticPop);
        Arrays.sort(timeDynamicPush);
        Arrays.sort(timeDynamicPop);

        long minimumStaticPush = timeStaticPush[0];
        long minimumStaticPop = timeStaticPop[0];
        long minimumDynamicPush = timeDynamicPush[0];
        long minimumDynamicPop = timeDynamicPop[0];

        long averageStaticPush = 0;
        long averageStaticPop = 0;
        long averageDynamicPush = 0;
        long averageDynamicPop = 0;

        long medianStaticPush = timeStaticPush[0];
        long medianStaticPop = timeStaticPop[0];
        long medianDynamicPush = timeDynamicPush[0];
        long medianDynamicPop = timeDynamicPop[0];

        for (int j = 0; j < repeatAmount; j++) {

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

        System.out.println("Median Static Push: " + medianStaticPush);
        System.out.println("Median Static Pop: " + medianStaticPop);
        System.out.println("Median Dynamic Push: " + medianDynamicPush);
        System.out.println("Median Dynamic Pop: " + medianDynamicPop);

    }
}
