package practice.program.java.threads.mockdownloader

class DownloadRunnable(private val sharedObject : SharedObjectMT, val url: String) : Runnable {
    override fun run() {
        sharedObject.download(url)
    }
}