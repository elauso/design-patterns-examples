package net.elau.example.designpatternsexamples.chain.validation

import java.util.function.Consumer
import java.util.function.Predicate

class ProductOverEighteenAvailable : Predicate<ValidationParams>, Consumer<ValidationParams> {

    override fun test(validationParams: ValidationParams): Boolean {
        println("Validating whether the product can be sold to the customer’s age group")

        return takeIf { validationParams.order.overEighteen }?.let {
            validationParams.customer.age < 18
        } ?: false
    }

    override fun accept(validationParams: ValidationParams) {
        val exception =
            RuntimeException("The product[productId=${validationParams.order.productId}] cannot be consumed by anyone under 18 years of age")
        println("Validation fail: ${exception.message}")
        throw exception
    }
}
