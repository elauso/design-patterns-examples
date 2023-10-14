package net.elau.example.designpatternsexamples.chain

fun main(args: Array<String>) {

    val productOrder = ProductOrder(productId = "222", overEighteen = true, quantity = 2)
    val customer = Customer(id = "123", firstName = "Anna", lastName = "Miller", age = 25, address = "St Andover, n555")

    runCatching { ProductBuyValidation().validate(customer, productOrder) }
        .onSuccess { println("Product buy validations were successful") }
        .onFailure { println("Error: ${it.message}") }
}