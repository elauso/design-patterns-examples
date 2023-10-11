package net.elau.example.designpatternsexample.strategy

fun main(args: Array<String>) {

    val cardId = "55123"
    Payment(PaymentMethod()::credit).apply(cardId)
}