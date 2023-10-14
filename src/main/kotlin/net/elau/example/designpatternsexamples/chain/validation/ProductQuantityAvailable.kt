package net.elau.example.designpatternsexamples.chain.validation

import java.util.function.Consumer
import java.util.function.Predicate

class ProductQuantityAvailable : Predicate<ValidationParams>, Consumer<ValidationParams> {

    override fun test(validationParams: ValidationParams): Boolean {
        println("Validating whether the stock has quantity available for sale")

        val stockId = getStockByAddress(validationParams.customer.address)

        val order = validationParams.order
        return checkStockIsNotAvailable(order.productId, order.quantity, stockId)
    }

    override fun accept(validationParams: ValidationParams) {
        val exception =
            RuntimeException("There is not enough stock for the product[productId=${validationParams.order.productId}]")
        println("Validation fail: ${exception.message}")
        throw exception
    }

    private fun getStockByAddress(address: String): String {
        // Searching for stock at the address provided
        return "123" // stockId
    }

    private fun checkStockIsNotAvailable(productId: String, productQuantity: Long, stockId: String): Boolean {
        // Checking if there is not enough product in stock
        return false
    }
}
