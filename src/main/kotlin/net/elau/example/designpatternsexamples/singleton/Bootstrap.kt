package net.elau.example.designpatternsexamples.singleton


fun main(args: Array<String>) {

    val configuration = Configuration.INSTANCE
    println("Empty configuration: ${configuration.properties}")

    configuration.properties = mapOf("xyz" to "blah", "abc" to "bleh")
    println("Loaded configuration: ${configuration.properties}")
}