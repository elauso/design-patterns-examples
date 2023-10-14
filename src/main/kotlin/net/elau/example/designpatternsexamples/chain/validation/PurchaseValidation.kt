package net.elau.example.designpatternsexamples.chain.validation

import net.elau.example.designpatternsexamples.chain.model.Customer
import net.elau.example.designpatternsexamples.chain.model.Order
import java.util.stream.Stream

class PurchaseValidation {

    fun validate(customer: Customer, order: Order) =
        ValidationParams(customer, order).let { params ->
            Stream.of(ProductDeliveryAvailable(), ProductOverEighteenAvailable(), ProductQuantityAvailable())
                .filter { it.test(params) }.findFirst().ifPresent { it.accept(params) }
        }
}

data class ValidationParams(val customer: Customer, val order: Order)