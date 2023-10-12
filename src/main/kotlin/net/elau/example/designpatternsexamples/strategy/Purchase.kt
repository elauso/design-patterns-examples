package net.elau.example.designpatternsexamples.strategy

import java.math.BigDecimal

fun main(args: Array<String>) {

    PaymentParams(cardId = "55123", value = BigDecimal.valueOf(12.5))
        .let { params ->
            Payment(PaymentMethod()::credit).apply(params)
        }
}