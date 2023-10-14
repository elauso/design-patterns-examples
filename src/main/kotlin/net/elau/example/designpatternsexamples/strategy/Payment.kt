package net.elau.example.designpatternsexamples.strategy

import java.math.BigDecimal
import java.util.function.Consumer

class Payment(private val method: Consumer<PaymentParams>) {

    fun apply(paymentParams: PaymentParams) = method.accept(paymentParams)
}

class PaymentMethod {

    fun debit(paymentParams: PaymentParams) =
        println("Making purchase with debit-card[${paymentParams.cardId}] and value[${paymentParams.value}]")

    fun credit(paymentParams: PaymentParams) =
        println("Making purchase with credit-card[${paymentParams.cardId}] and value[${paymentParams.value}]")
}

data class PaymentParams(val cardId: String, val value: BigDecimal)