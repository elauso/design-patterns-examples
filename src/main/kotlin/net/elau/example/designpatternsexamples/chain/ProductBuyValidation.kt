package net.elau.example.designpatternsexamples.chain

import java.util.stream.Stream

class ProductBuyValidation {

    fun validate(customer: Customer, productOrder: ProductOrder) =
        ValidationParams(customer, productOrder)
            .let { validationParams ->
                Stream.of(ProductDeliveryAvailable(), ProductOverEighteenAvailable(), ProductQuantityAvailable())
                    .filter { it.test(validationParams) }
                    .findFirst()
                    .ifPresent { it.accept(validationParams) }
            }
}

data class ValidationParams(val customer: Customer, val productOrder: ProductOrder)

data class ProductOrder(val productId: String, val overEighteen: Boolean, val quantity: Long)

data class Customer(val id: String, val firstName: String, val lastName: String, val age: Int, val address: String)