package org.example

/**
 * RUN:
 * The context object is available as a receiver (this).
 * The return value is the lambda result.
 *
 * run with ile aynı çalışır fakat extension function'dur. Yani with gibi parametre olarak vermezsin de
 * nokta (.) ile objenin sonunda çalıştırırsın.
 *
 * run lambda returnu yapar, objeyle işlem yapıp, value return'lemek için kullanışlıdır.
 *
 * Ayrıca run'ı non-extension function olarak da kullanabilirsin.
 * Non-extension varyantı context objesine ihtiyaç duymaz fakat lambda result dönmeye devam eder.
 * Non-extesinon run bir açıklamanın, ifadenin gerekli olduğu durumlarda birden fazla ifadeyi içeren
 * bir blok çalıştırmanıza olanak tanır.
 * Kod bloğunda "run the code block and compute the result." olarak düşünülebilir.
 */

fun main(){
    val service = MultiportService("https://example.kotlinlang.org", 80)
    val runResult = service.run {
        port = 8080
        query(prepareRequest() + " for port $port")
    }
    println("run Service result $runResult")

    // the same code written with let() function:
    val letResult = service.let {
        it.port
        it.query(it.prepareRequest() + " for port ${it.port}")
    }
    println("let Service result $runResult")

    // Non-extension varyantı
    val hexNumberRegex = run {
        val digits = "0-9"
        val hexDigits = "A-Fa-f"
        val sign = "+-"

        Regex("[$sign]?[$digits$hexDigits]+")
    }

    for (match in hexNumberRegex.findAll("123 -FFF !%*& 99 XYZ")) {
        println(match.value)
    }
}

class MultiportService(var URL: String, var port: Int) {
    fun query(queryString: String) {
        println("Querry sended. Query: $queryString ")
    }

    fun prepareRequest(): String {
        // pseudo code
        // pseudo code
        return "Prepared"
    }
}