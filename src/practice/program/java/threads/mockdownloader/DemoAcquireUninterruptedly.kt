package practice.program.java.threads.mockdownloader

import java.util.concurrent.Executors

object DemoAcquireUninterruptedly {
    @JvmStatic
    fun main(args: Array<String>) {

        var count = 0
        val service = Executors.newFixedThreadPool(4) { r ->
            val thread = Thread(r, "T" + count++)
            //thread.isDaemon = true
            thread
        }
        val listOfRunnable = listOf(
            DownloadRunnable(SharedObjectMT(), "1"),
            DownloadRunnable(SharedObjectMT(), "1"),
            DownloadRunnable(SharedObjectMT(), "2"),
            DownloadRunnable(SharedObjectMT(), "2"),
            DownloadRunnable(SharedObjectMT(), "1"),
            DownloadRunnable(SharedObjectMT(), "3")
        )

        for (runnable in listOfRunnable) {
            service.execute(runnable)
        }
//        val t1 = Thread(DownloadRunnable(SharedObjectMT(), "1"),"T1")
//        val t2 = Thread(DownloadRunnable(SharedObjectMT(),"1"),"T2")
//        val t3 = Thread(DownloadRunnable(SharedObjectMT(),"2"), "T3")
//        val t4 = Thread(DownloadRunnable(SharedObjectMT(),"2"), "T4")
//        val t5 = Thread(DownloadRunnable(SharedObjectMT(),"1"), "T5")
//        val t6 = Thread(DownloadRunnable(SharedObjectMT(),"3"), "T6")
//        val t7 = Thread(InterruptingRunnable(SharedObjectMT(), t2/*, t3*/), "T4")
//        t1.start()
//        t2.start()
//        t3.start()
//        t4.start()
//        t5.start()
//        t6.start()
//        t7.start()
        service.shutdown()
    }
}