package org.example

class Person(val name: String, var age: Int = 22, var city: String = "Paris") {
    fun moveTo(newCity: String) {
        this.city = newCity
    }

    fun incrementAge() {
        this.age++
    }

    override fun toString(): String {
        return "Name: $name, age: $age, city: $city"
    }
}

