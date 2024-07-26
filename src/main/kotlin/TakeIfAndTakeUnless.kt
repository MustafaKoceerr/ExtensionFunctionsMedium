package org.example

import kotlin.random.Random

/**
 * TAKELF AND TAKEUNLESS:
 *
 * Bu fonksiyonlar scope functions değillerdir, fakat scope functionslarla uyumlu çalışırlar.
 * Standart Kotlin kütüphanesi takeIf ve takeUnless fonksiyonlarını içerir.
 * Bu fonksiyonlar, bir nesnenin durumunu çağrı zincirlerinde kontrol etmenize olanak tanır.
 *
 * takeIf eğer verilen koşulu sağlıyorsa objeyi döner, sağlamıyorsa null döner.
 * Yani aslında tek bir obje için filtreleme fonksiyonudur.
 *
 * takeUnless tam tersi bir logic'e sahiptir. Verilen koşul sağlanıyorsa null döner, sağlanmıyorsa objeyi döner.
 *
 * takeIf veya takeUnless kullanırken, obje lambda'da it argumanı olarak verilir.
 *
 * takeIf veya takeUnless fonksiyonlarını zincilemede kullanıyorsan, safe call (?.) işaretini kullanmayı unutma.
 * Çünkü bu fonksiyonlar null değer döndürebilirler.
 */

fun main(){
    val randNumber = Random.nextInt(100)

    val evenOrNull = randNumber.takeIf { it % 2 == 0 }
    val oddOrNull = randNumber.takeUnless { it % 2 == 0 }

    println("number: $randNumber, even: $evenOrNull, odd: $oddOrNull")

    val helloMessage = "Hello"
    val caps = helloMessage.takeIf { it.isNotEmpty() }?.uppercase()
//    val caps2 = helloMessage.takeIf { it.isNotEmpty() }.uppercase() // compile error alırsın
    println(caps)

    /**
     * takeIf ve takeUnless, scope funcitons'larla beraber oldukça kullanışlıdırlar.
     * Örneğin, takeIf veya takeUnless ile let fonksiyonunu kullanarak, verilen koşula göre bir blok yazabilirsin.
     * Bunu yapmak için let'i safe call (?.) ile çağırman gerekli.
     * Eğer obje koşulu sağlamazsa takeIf sağlarsa takeUnless null döndürecektir ve let bloğundaki işlemler yapılmayacaktır.
     */

    displaySubstringPosition("010000011", "11")
    displaySubstringPosition("010000011", "12")

    displaySubstringPositionSecond("010000011", "11")
    displaySubstringPositionSecond("010000011", "12")
}

fun displaySubstringPosition(input:String, sub:String){
    input.indexOf(sub).takeIf { it>0 }?.let {
        println("The substring $sub is found in $input.")
        println("Its start position is $it.")
    }
}

fun displaySubstringPositionSecond(input:String, sub: String){
    input.indexOf(sub).takeIf { it>0 }?.let {
        println("The substring $sub is found in $input.")
        println("Its start position is $it.")
    }
}