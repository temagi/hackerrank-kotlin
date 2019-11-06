import kotlin.system.measureTimeMillis
import kotlinx.coroutines.*
import kotlin.system.*


//class AsyncAwait
fun maint() = runBlocking<Unit> {
//sampleStart
    val time = measureTimeMillis {

        /*val one = async { doSomethingUsefulOne() }
        //val two = async { doSomethingUsefulTwo() }
        doSomethingSync()
        println("sync started")
        one.await()
        println("sync in the middle")
        //two.await()
        println("sync ended")
        //println("The answer is ${one.await() + two.await()}")*/
    }
    //println("Completed in $time ms")
//sampleEnd
}

suspend fun returnValue(s: String) {
    //return
}

fun doSomethingSync() {
    println("first sync started")
    Thread.sleep(2000)
    println("first sync ended")
}

suspend fun doSomethingUsefulOne() {
    println("first started")
    delay(2000)
    println("first ended")
    /*delay(1000L) // pretend we are doing something useful here
    return 13*/
}

suspend fun doSomethingUsefulTwo() {
    println("second started")
    println("second ended")
    /*delay(1000L) // pretend we are doing something useful here, too
    return 29*/
}