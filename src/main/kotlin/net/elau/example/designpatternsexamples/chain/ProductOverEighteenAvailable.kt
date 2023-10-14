package net.elau.example.designpatternsexamples.chain

import java.util.function.Consumer
import java.util.function.Predicate

class ProductOverEighteenAvailable : Consumer<ValidationParams>, Predicate<ValidationParams> {

    override fun accept(validationParams: ValidationParams) {
        throw RuntimeException("The product[productId=${validationParams.productOrder.productId}] cannot be consumed by anyone under 18 years of age")
    }

    override fun test(validationParams: ValidationParams): Boolean {
        println("c=ProductOverEighteenAvailable, m=test()")

        return takeIf { validationParams.productOrder.overEighteen }?.let {
            validationParams.customer.age < 18
        } ?: false
    }
}
