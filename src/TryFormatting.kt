import kotlin.math.max

//import kotlinx.coroutines.*
//
//fun main(args: Array<String>) = runBlocking {
//    // create a lot of coroutines and list their jobs
//    var count = 1000L
//    val jobs = launch(Dispatchers.IO) {
//        delay(count)
//        print(".")
//    }
//    jobs.join()
//    print("finished!")
//}

open class A{

}
class B:A() {
    val arr = arrayOf(1,2,3)
    fun chew() {

    }
    companion object{
    }
}
class TryFormatting {
    var some: String? = null
    fun display() {
        max(1,2)

    }


}



fun t() {
    var b: B? = null!!

    if (b != null) {
        b.chew()

    }
}
fun main() {
    //t()
//    val obj = TryFormatting()
//    obj.some = "asbdasfd"
//    print("greasss")
//    print(obj.some)

//    val listA = mutableListOf(1, 2, 3)
//
//    val listB = listA.add(4)
//
//
//    print(listB)
//    val a = "2700000000"
//    val f = a.toFloat()
//    val ss = String.format("%.1f",f)
//    println(ss)
//    println(DecimalFormat().format(f))
//    val dataList: ArrayList<String> = ArrayList()
//    dataList.add("Denis")
//    dataList.add("tutorials")
//    dataList.add("Instructor")
//    dataList.add("Android 10")

//    for (i in dataList.indices){
//        if(dataList[i] == "Denis"){
//            dataList[i]= "Denis Panjuta"
//        }
//    }
//    val x = 2.5
//    when(x) {
//        in listOf(1, 2,3) -> print("yes")
//        else -> print ("No")
//    }
//    println("Result : ${dataList[0]}")

print(numm(670))
    val arr = listOf(1,2,3)
    print(arr)
}
fun numm(N: Int) : Int{
    val numberInStringFormat = N.toString()
    var maxNumber = Int.MIN_VALUE
    var index = 0
    if (N < 0) {
        index = 1
    }
    for (i in index until numberInStringFormat.length) {
        val temp = Integer.parseInt(numberInStringFormat.substring(0, i) + 5 + numberInStringFormat.substring(i, numberInStringFormat.length))
        if (maxNumber < temp)
            maxNumber = temp;
    }
    return maxNumber
}