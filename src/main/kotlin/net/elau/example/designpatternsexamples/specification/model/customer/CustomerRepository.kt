package net.elau.example.designpatternsexamples.specification.model.customer

import java.util.*
import java.util.UUID.randomUUID
import java.util.function.Predicate

class CustomerRepository {

    private val repository = hashMapOf<UUID, Customer>()

    fun create(customer: Customer) =
        randomUUID().apply { repository[this] = customer }

    fun delete(id: String) = repository.remove(UUID.fromString(id))

    fun findById(id: String) = repository.get(UUID.fromString(id))

    fun find(criteria: Predicate<Customer>) =
        repository.values.filter { customer -> criteria.test(customer) }
}

data class Customer(val name: String, val age: Int, val region: Region)

enum class Region {
    NORTH, EAST, SOUTH, WEST
}