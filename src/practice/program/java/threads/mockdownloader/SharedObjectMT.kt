package practice.program.java.threads.mockdownloader

import java.lang.Exception
import java.util.concurrent.Semaphore

class SharedObjectMT {
    companion object {
        private val syncMap = HashMap<String, Semaphore>()
    }

    @Throws(Exception::class)
    fun download(url: String) {
        var hasSomeExceptionOccurred = false

        synchronized(syncMap) {
            syncMap[url] ?: run {
                syncMap[url] = Semaphore(1)
            }
        }

        syncMap[url]?.let { semaphore ->
            val currentThread = Thread.currentThread().name
            println("$currentThread outside synchronized for url = $url")

            synchronized(semaphore) {
                try {

                    println("$currentThread url= $url entered synchronized")
                    println("$currentThread url= $url waiting to acquire semaphore")

                    semaphore.acquire()
//                    semaphore.acquireUninterruptibly()

                    println("$currentThread url= $url acquired semaphore")


                    DownloadThread(object : DownloadCallback {
                        override fun onDownloadComplete() {
                            println("$currentThread url= $url released semaphore. Work Done!!")
                            semaphore.release()
                        }

                    }).start()


                } catch (e: Exception) {
                    println("$currentThread url= $url catch block")

                    hasSomeExceptionOccurred = true
                } finally {
                    println("$currentThread url= $url finally block")

                    if (hasSomeExceptionOccurred)
                        semaphore.release()
                }
                println("$currentThread url= $url exit synchronized")
            }
        } ?: run {
            println("Can this ever happen?? !")
        }
    }

}