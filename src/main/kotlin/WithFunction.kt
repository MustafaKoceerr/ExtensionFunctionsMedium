package org.example

/**
 * WITH
 * The context object is available as a receiver (this).
 * The return value is the lambda result.
 *
 * with bir extension function değildir, parametre olarak context object'i verirsin.
 * fakat lambda'nın içinde default receiver olarak this'i kullanırsın.
 *
 * Biz with'i döndürülen sonuç gerekmiyorsa ve fonksiyon kullanacaksan with'i kullanmanı öneririz.
 *
 * with'i bir yardımcıyı tanıtırken, object'in properties'ini veya function'u hesaplama yapmak için kullanacaksan öneririz.
 */

fun main(){
    val numbers = mutableListOf("one", "two", "three","four","five")

    with(numbers) {
        println("With is called with argument $this")
        println("it contains $size elements")
    }
    // with'i bir yardımcıyı tanıtırken, object'in properties'ini veya function'unu hesaplama yapmak için kullanacaksan öneririz.
    val firstAndLast = with(numbers) {
        "The first element is ${first()}," +
                "The last element is ${last()},"
    }
    println(firstAndLast)
}