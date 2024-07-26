package org.example

/**
 * ALSO:
 * The context object is available as an argument (it).
 * The return value is the object itself.
 *
 * Yan İşlemler: also, bir nesne üzerinde işlemler yaparken aynı zamanda bazı yan işlemler (loglama, doğrulama) yapmak için kullanılır.
 * Also, context objeyi parametre olarak alıp, bir kaç actions uygulamak için kullanışlıdır.
 * Objenin properties'lerine ve fonksiyonlarına çok ihtiyaç duymadığında ama obje üzerinde işlem yapacağında also kullanabilirsin.
 * Also, it kullandığı için üst scope'da this varsa also kullanabilirsin. Böylelikle this ile kafa karışıklığı yaşanmamış olur.
 *
 * Also'yu kodunda gördüğünde şöyle okuyabilirsin: Ve ayrıca objeyle şunları da yap. "and also do the following with the object."
 */

fun main(){
    val numbers = mutableListOf("one", "two", "three","four","five")
    numbers
        .also { println("The list elements before adding new one $it") }
        .add("six")
    println("The list elements after adding new one $numbers")

}