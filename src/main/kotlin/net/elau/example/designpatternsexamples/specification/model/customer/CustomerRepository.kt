package net.elau.example.designpatternsexamples.specification.model.customer

import java.util.*
import java.util.UUID.randomUUID
import java.util.function.Predicate

class CustomerRepository {

    private val repository = hashMapOf<UUID, Customer>()

    fun create(customer: Customer): UUID =
        randomUUID().apply { repository[this] = customer.copy(id = this) }

    fun delete(id: UUID) = repository.remove(id)

    fun findById(id: UUID) = repository[id]

    fun find(criteria: Predicate<Customer>) =
        repository.values.filter { criteria.test(it) }
}

data class Customer(val id: UUID? = null, val name: String, val age: Int, val region: Region)

enum class Region {
    NORTH, EAST, SOUTH, WEST
}