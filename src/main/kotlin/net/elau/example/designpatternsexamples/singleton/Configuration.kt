package net.elau.example.designpatternsexamples.singleton

enum class Configuration {
    INSTANCE;

    var properties: Map<String, Any>? = null
}