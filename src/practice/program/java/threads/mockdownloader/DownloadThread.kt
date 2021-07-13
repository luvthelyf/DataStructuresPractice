package practice.program.java.threads.mockdownloader

class DownloadThread(private val callback: DownloadCallback) : Thread() {
    override fun run() {
        for (i in 1 until 50000L) {
            tryUtil(i)
        }
        callback.onDownloadComplete()
    }

    private fun tryUtil( i : Long) {
        var k = i
        while(k > 0) {
            //print(k)
            k -= 1
        }
    }
}