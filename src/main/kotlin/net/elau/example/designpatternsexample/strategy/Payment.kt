package net.elau.example.designpatternsexample.strategy

import java.util.function.Consumer

class Payment(private val method: Consumer<String>) {

    fun apply(cardId: String) = method.accept(cardId)
}

class PaymentMethod {

    fun debit(cardId: String) = println("Making purchase with debit-card: $cardId")

    fun credit(cardId: String) = println("Making purchase with credit-card: $cardId")
}