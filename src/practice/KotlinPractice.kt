package practice

// by default classes are public and final
// no semicolon required
// there is no primary data type in kotlin

// type inference automatic

// 2 keywords are only used val/var with any variable

//String s = "sandeep"
val s = "sandeep"
var ss = "sandeep"
lateinit var ar: String // variable should not be of primitive type
fun myMethod(): Int { // void equivalent is Unit class
    ss = "gupta"
    ar = "asdfasdfs"
    singleLineExamplse()
    return 1
}

fun singleLineExample(): Int {
    return 5
}

fun singleLineExamplse() = print(singleLineExample())

// marker interface
interface Marks {
    val marks: Int
    fun getPercentage(): Float
//    fun displayPercent() {
//        getPercentage()
//    }
}

// reflection serialization internal work in implemented class
// default primary secondary
class Student constructor(private val name: String, private val age: Int) : Marks {
//    init {
////        print("$name * $age")
//    }
////    constructor(abc: String) : this("adf",23) {
////
////    }
//    fun printDetails() {
//        print("${name.substring(1)}  $age")
//    }

    override val marks = 195

    var sum = 0
    var num = 1
    override fun getPercentage(): Float {
        return marks / 200f * 100
    }

    fun putExtra(key: String, value: String) {
        print("$key $value")
    }
}

class FirstStandard(private val student: Student?) {

    fun displayData() {
        var s: Student? = null
        s?.let {
            print(it)
        }
        // nullable type object's var or method cannot be directly accessed
        // if alternative flow is available in case null object is present then use elvis operator ?:
        print(student?.getPercentage() ?: run {
            "null passed"

        })


//        layout.setOnClickListener {
//            //st1
//        }
//        layout.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                // st1
//            }
//        })

        // if(student != null)
        student?.let {
            println(it)
            it.getPercentage()
        }
        student?.also { }  // TODO("sdf")
        student?.apply {
            putExtra("a", "1")
            putExtra("3", "2")
            putExtra("a", "1")
            putExtra("a", "1")
            putExtra("a", "1")

        }
    }
}
public fun getMax(array: Array<Int>) {
    var len = array.size

    for(i in array) {

    }
}
fun main() {
//    myMethod()
// >= 1
    for (i in 5 downTo 1) {
        print("$i ")
    }

    var i = 0

    while(i < 30) {

    }
    println()
    // by default every variable is non-null in kotlin
    var student: Student? = Student("sandeep", 32)

//    student = null

//    FirstStandard(student).displayData()
}

