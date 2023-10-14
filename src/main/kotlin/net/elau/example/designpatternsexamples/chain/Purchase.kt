package net.elau.example.designpatternsexamples.chain

import net.elau.example.designpatternsexamples.chain.model.Customer
import net.elau.example.designpatternsexamples.chain.model.Order
import net.elau.example.designpatternsexamples.chain.validation.PurchaseValidation

fun main(args: Array<String>) {

    val order = Order(productId = "222", overEighteen = true, quantity = 2)
    val customer = Customer(id = "123", firstName = "Anna", lastName = "Miller", age = 25, address = "St Andover, n555")

    val purchaseValidation = PurchaseValidation()
    purchaseValidation.validate(customer, order)
}