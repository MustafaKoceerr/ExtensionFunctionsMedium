package org.example

/**
 * APPLY:
 * The context object is available as a receiver (this).
 * The return value is the object itself.
 *
 * Apply objenin kendisini döndürdüğü için, objen üstünde işlemler yaptığın,
 * objenin property'lerini ve fonksiyonlarını kullandığın, fakat return yapmadığın durumlarda kullanmanı tavsiye ederiz.
 *
 * Apply'ın en çok kullanıldığı yer object configration'dur.
 * Böyle çağrılar şöyle okunabilir: Bu atamaları objeye uygula. ("apply the following assignments to the object.")
 *
 * Başka bir apply kullanımı da zincirleme çağırımlarda daha karmaşık işlemler yapmak için kullanılmasıdır.
 */

fun main(){
    val applyPerson = Person("Adam").apply {
        age = 32
        city = "Dusseldorf"
    }
    println(applyPerson) // Name: Adam, age: 32, city: Dusseldorf
}