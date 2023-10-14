package net.elau.example.designpatternsexamples.chain.validation

import java.util.function.Consumer
import java.util.function.Predicate

class ProductDeliveryAvailable : Consumer<ValidationParams>, Predicate<ValidationParams> {

    override fun accept(validationParams: ValidationParams) {
        val exception =
            RuntimeException("The product[productId=${validationParams.order.productId}] can not be delivered to address[${validationParams.customer.address}]")
        println("Validation fail: ${exception.message}")
        throw exception
    }

    override fun test(validationParams: ValidationParams): Boolean {
        println("c=ProductDeliveryAvailable, m=test()")

        val address = validationParams.customer.address
        val productId = validationParams.order.productId

        return checkDeliveryNotAvailable(productId, address)
    }

    private fun checkDeliveryNotAvailable(productId: String, address: String): Boolean {
        // Checking whether the product can not be delivered to the address
        return false
    }
}
