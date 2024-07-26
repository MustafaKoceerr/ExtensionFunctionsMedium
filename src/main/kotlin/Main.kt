package org.example

/**
 *  * Kotlin standart kütüphanesi, nesne bağlamında bir kod bloğu çalıştırma amacına sahip birkaç fonksiyon içerir.
 *  Obje üzerinde lambda bir fonksiyon çalıştırmak, geçici bir scope oluşturur.
 *  Bu scope içinde objeye ismini kullanmadan ulaşabilirsin.
 *  Böyle fonksiyonlara scope functions denir.
 *  5 tane scope functions vardır: let, run, with, apply ve also
 *
 * Basitçe bu fonksiyonlar, bir blok kodu obje üzerinden çalıştırırlar.
 * Fonksiyonlar arasındaki farklar, block içinde objeyi nasıl temsil ettiği ve döndürdüğü değerlerle alakalıdır.
 *
 * Scope functions'lar yeni bir teknik kapasite sunmazlar, fakat kodu daha kısa ve okunabilir yaparlar.
 * Hangisini seçeceğin çoğunlukla niyetine ve projedeki tutarlılığa bağlıdır.
 *
 */

/**
 * Aşağıda bu fonksiyonların farklarını ve kullanım yerlerini detaylıca açıkladık
 *
 * Fonksiyon Seçimi:
 *  * Function - Object refreance - Return Value    -     Is Extension Function            -              How to Use
 *  *
 *  *  Let         it               Lambda Result           Yes                                          object.let{ }
 *  *  run         this             Lambda Result           Yes                                          object.run{ }
 *  *  run         -                Lambda Result           No: called without the context object        run(object){  }
 *  *  with        this             Lambda Result           No: takes the context object as an argument  with(object){  }
 *  *  apply       this             Context Object          Yes                                          object.apply{ }
 *  *  also        it               Context Object          yes                                          object.also{ }
 *  *
 *
 *  NEYE GORE HANGI FONKSIYONU SECMELIYIM?
 *
 *  *
 *  *  -Executing a lambda on non-nullable objects: let
 *  *  -Introducing an expression as a variable in local scope: let
 *  *  -Object configuration: apply
 *  *  -Object configuration and computing the result: run
 *  *  -Running statements where an expression is required: non-extension run
 *  *  -Additional effects: also
 *  *  -Grouping function calls on an object: with
 *
 *  Kullanımları birbirleriyle örtüşebilir. Bu yüzden projede nasıl kullanıldığına veya takımının nasıl kullandığına göre birini tercih edebilirsin.
 *
 *  Scope function'lar kodu daha anlaşılabilir yapsa da, aşırı kullanmamaya çalış. Çünkü aşırı kullanım kodun okunmasını zor hale getirebilir ve hatalara yol açabilir.
 *
 *  Ayrıca scope functions'ların iç içe kullanılmamasını ve zincirleme kullanırken dikkatli kullanılmasını tavsiye ediyoruz.
 *  İç içe kullanırsan ve zincirleme fonksiyonları karıştırırsan, anlaşılabilirlik yerine karmaşıklık yaratırsın.
 */


/**
 * Farklılıklar:
 *
 * Scope functions'lar doğası gereği birbirine benzerler fakat önemli olan farklılıkları anlamaktır.
 * Her bir scope function'da 2 temel fark vardır.
 * 1- Kullandığın objeji nasıl temsil ettiği,
 * 2- Döndürdükleri değeri.
 */

/**
 * Context object: this or it:
 *
 * Her bir lambda ifadesinde context obje (scope function uygulanan obje) this veya it adında bir lamda temsiline sahip oluyor.
 * İkisi de aynı kapasiteye sahip,
 * Bu nedenle, her birinin farklı kullanım senaryoları için avantaj ve dezavantajlarını açıklıyor ve kullanımları için önerilerde bulunuyoruz.
 */



fun main() {
    Person("Alice",21,"Amsterdam").let {
        println(it)
        it.moveTo("Berlin")
        it.incrementAge()
        println(it)
    }
    // If you write the same without let, you'll have to introduce a new variable and repeat its name whenever you use it.
    val alice = Person("Alice", 20, "Amsterdam")
    println(alice)
    alice.moveTo("London")
    alice.incrementAge()
    println(alice)

    println("--------------------------------------------------------->")


    // This ve It kullanımı farkı
    val str = "Hello"
    str.run {
        println("The string's lenght : $length")
//        println("The string's lenght : ${this.length}")  // does the same, you dont need to use this.
    }

    // it
    str.let {
        println("The string's lenght : ${it.length}")
    }
}