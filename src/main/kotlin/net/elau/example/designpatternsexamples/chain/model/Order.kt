package net.elau.example.designpatternsexamples.chain.model

data class Order(
    val productId: String,
    val overEighteen: Boolean,
    val quantity: Long
)
