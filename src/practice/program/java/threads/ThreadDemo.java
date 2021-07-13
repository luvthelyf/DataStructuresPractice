
package practice.program.java.threads;

import java.util.Queue;
import java.util.UUID;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().isDaemon()); // false

    }
}


class MyThread extends Thread {
    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }
    public void run() {

    }
}











class Producer extends Thread {
    static int count = 0;
    Queue<String> queue;

    public Producer(Queue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            produce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void produce() throws InterruptedException {
        int i = 0;
        Thread.sleep(100);
        while (i < 5) {
            synchronized (queue) {
                String val = UUID.randomUUID() + "";
                System.out.println("Produced : " + val);
                queue.add(val);
                queue.notify();
            }
            i++;
        }

    }
}

class Consumer extends Thread {
    Queue<String> queue;

    public Consumer(Queue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        consume();
    }

    public void consume() {
        int i = 0;
        while (i < 5) {
            synchronized (queue) {
                if (queue.isEmpty()) {
                    System.out.println("waiting .... ");
                    try {
                        i--;
                        queue.wait();
                    } catch (InterruptedException e) {
                        System.out.println("interrupted");
                    }
                } else {
                    System.out.println("Consume : " + queue.remove());
                }

            }
            i++;
        }
    }
}

//class Display {
//
//    public synchronized void wish (String name) {
//        /// Display object lock
//        for(int i = 0; i < 5; i++) {
//            Integer k = i;
//            synchronized (k) {
//                // display objet lock + k lock
//                MyThread t = new MyThread(this, "");
//
//                synchronized (t) {
//                    // display object lock + k lock + t lock
//
//                }
//            }
//                System.out.print("Good morning message for "+ name +" delivered to : ");
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    System.out.println("Interrupted");
//                }
//                System.out.println(name);
//        }
//    }
//
//    // object level / class level
//    /// 6 thread
//    // t1 - > w0() -> holds class level lock
//    // t2 -> w0() -> waits for class level lock
//    // t3 -> w() -> waits for class level lock
//    // t4 -> w1() -> normal runs
//    // t5 -> w2() -> object level lock acquire
//    // t6 -> w2() -> wait for object level lock
//    // t7 -> w3() -> normal runs
//    /// current class object
//    // class level
//    // random object level
//
//    /// --------------------------------------- _ ------------------------------------------
//    public static synchronized void w0() {
//        /// critical section
//        System.out.println();
//    }
//    public static synchronized void w() {
//
//    }
//    public static void w1() {
//
//    }
//    public synchronized void w2() {
//
//    }
//    public void w3() {
//
//    }

//}


// yield() sleep() join()
/**
 * lifecycle without any other event :
 * new/born -----t.start() called -----> ready/runnable -----Thread Scheduler allocates CPU ----> Running -----if run() ends ---> dead/destroyed
 * new/born -----t.start() called -----> ready/runnable -----Thread Scheduler allocates CPU ----> Running -----if run() ends ---> dead/destroyed
 * <------------------if yield() is called ----------
 * <---- --- waiting <-----if t2.join(t) is called ----------
 * 1.t2 completes
 * 2. join time t expire
 * 3. interrupt
 * <p>
 * <p>
 * <p>
 * // MyRunnbale r = new MyRunnable();
 * // Thread t1 = new Thread();
 * // Thread t2 = new Thread(r);
 * <p>
 * // cases:
 * // 1. t1.start() - empty run() of JVM Thread class
 * // 2. t1.run() - normal method call no MT.
 * // 3. t2. start() - calls run() of MyRunnable after creating new thread.
 * // 4. t2.run() - normal method call no MT.
 * // 5. r.start() - Compile time error. no start()
 * // 6. r.run() - normal method call . no thread creation.
 */