package net.elau.example.designpatternsexamples.singleton


fun main(args: Array<String>) {

    val config1 = Configuration.INSTANCE

    val config2 = Configuration.INSTANCE
    config2.properties = mapOf("xyz" to "blah", "abc" to "bleh")

    if (config1 == config2) {
        println("Two objects are same")
    } else {
        println("Two objects are not same")
    }

    println("config1: ${config1.properties}")
    println("config2: ${config2.properties}")
}