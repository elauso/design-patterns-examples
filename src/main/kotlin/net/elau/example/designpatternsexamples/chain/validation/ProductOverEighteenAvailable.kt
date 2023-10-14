package net.elau.example.designpatternsexamples.chain.validation

import java.util.function.Consumer
import java.util.function.Predicate

class ProductOverEighteenAvailable : Consumer<ValidationParams>, Predicate<ValidationParams> {

    override fun accept(validationParams: ValidationParams) {
        val exception =
            RuntimeException("The product[productId=${validationParams.order.productId}] cannot be consumed by anyone under 18 years of age")
        println("Validation fail: ${exception.message}")
        throw exception
    }

    override fun test(validationParams: ValidationParams): Boolean {
        println("c=ProductOverEighteenAvailable, m=test()")

        return takeIf { validationParams.order.overEighteen }?.let {
            validationParams.customer.age < 18
        } ?: false
    }
}
