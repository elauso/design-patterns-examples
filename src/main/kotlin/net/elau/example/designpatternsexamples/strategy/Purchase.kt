package net.elau.example.designpatternsexamples.strategy

fun main(args: Array<String>) {

    val cardId = "55123"
    Payment(PaymentMethod()::credit).apply(cardId)
}