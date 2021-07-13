package ds;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintName {
    public static void main(String[] args) {
//        PrintName printName = new PrintName();
        long startTime = System.currentTimeMillis();

        // create thread
        ExecutorService service = Executors.newFixedThreadPool(5);


        // execute thread
        for(int i = 0; i < 5; i++) {
            PrintNameRunnable printSandeepRunnable = new PrintNameRunnable("sandeep", 2000);
            service.execute(printSandeepRunnable);
        }
//        printName.printNameNTimes("sandeep", 10000);
        System.out.println((System.currentTimeMillis() - startTime) + "ms");

        service.shutdown();
    }

    // sandeep

    static class PrintNameRunnable implements Runnable {

        String name;
        int N;

        public PrintNameRunnable(String name, int N) {
            this.name = name;
            this.N = N;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread() + " : "+N);
            printNameNTimes(name, N);
        }

        public void printNameNTimes(String name, int N) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++)
                sb.append(name);
            System.out.println(sb.toString());
        }
    }
}
