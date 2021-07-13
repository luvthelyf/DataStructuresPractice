package practice.program.java.threads.mockdownloader

class InterruptingRunnable(val sharedObjectMT: SharedObjectMT, private val secondThread: Thread/*, private val thirdThread: Thread*/) : Runnable {
    override fun run() {
        //sharedObjectMT.download("third")
        Thread.sleep(1000)
        secondThread.interrupt()
//        thirdThread.interrupt()
    }
}