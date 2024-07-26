package org.example

/**
 * LET:
 * The context object is available as an argument (it).
 * The return value is the lambda result.
 *
 * "let", çağrı zincirlerinin sonuçları üzerinde bir veya daha fazla fonksiyon çağırmak için kullanılabilir.
 * Eğer kullanacağımız fonksiyon bir taneyse HOF özelliği olarak ::funname ile fonksiyonu passlayabiliriz.
 *
 * Genelde nullable bir objemiz varsa (?.) safe call operatörü ile birlikle
 * obje üzerinde işlemler yaparken kullanılır
 */

fun main(){
    val numbers = mutableListOf("one", "two", "three")
    val resultList = numbers.map { it.length }.filter { it > 3 }
    println(resultList)
// Burada buna gerek yok let kullanarak yeni bir değişkene atamamız gerekmeyebilirdi
    numbers.map { it.length }.filter { it > 3 }.let {
        println(it)
        // and more function calls if needed
    }
// Eğer kullanacağımız fonksiyon bir taneyse HOF özelliği olarak ::funname ile fonksiyonu passlayabiliriz.
    numbers.map { it.length }.filter { it > 3 }.let(::println)

    val str2: String? = "Hello"
    val lenght: Int? = str2?.let {
        println("let() called on $it")
        // processNonNullString(it) // some functions need non null parameter
        it.length
    }
//    başka bir örnek
    val modifiedFirstItem = numbers.first().let { firstItem ->
        println("The first item of the list is $firstItem")
        if (firstItem.length >= 5) firstItem else ("!$firstItem!")
    }.uppercase()
    println("First item after modifications: $modifiedFirstItem")

}