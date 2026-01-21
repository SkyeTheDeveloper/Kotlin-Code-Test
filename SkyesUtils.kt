import kotlin.system.exitProcess

fun disp(text: String, question: Boolean) {
    for (c in text) {
        print(c)
        sleep(0.05)
    }
    if (!question) {
        println()
    }
}

fun progressBar(length: Int) {
    clear()
    print("<")
    sleep(0.05)
    for (i in 0..length - 2) {
        print("#")
        sleep(0.05)
    }
    println(">")
    sleep(2.0)
}

fun sleep(seconds: Double) {
    val time: Long = (seconds * 1000).toLong()
    try {
        Thread.sleep(time)
    } catch (e: InterruptedException) {
        println("ERR: Thread interrupted")
        exitProcess(1)
    }
}

fun clear() {
    try {
        print("\u001b[H\u001b[2J")
        System.out.flush();
    } catch (e: Exception) {
        println("ERR: Couldn't clear terminal, ANSI codes not supported")
        exitProcess(1)
    }
}