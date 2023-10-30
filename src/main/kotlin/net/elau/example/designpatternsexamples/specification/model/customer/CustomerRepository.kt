package net.elau.example.designpatternsexamples.specification.model.customer

import java.util.*
import java.util.UUID.randomUUID
import java.util.function.Predicate

class CustomerRepository {

    private val repository = hashMapOf<UUID, Customer>()

    fun findById(id: UUID) = repository[id]

    fun find(criteria: Predicate<Customer>) =
        repository.values.filter { criteria.test(it) }

    fun create(customer: Customer): UUID {
        if (validateIllegalAge().or(validateNotAllowedRegion()).test(customer)) {
            throw RuntimeException("Create customer[$customer] is not allowed.")
        }
        return randomUUID().apply { repository[this] = customer.copy(id = this) }
    }

    fun delete(id: UUID) = repository.remove(id)

    private fun validateIllegalAge(): Predicate<Customer> =
        Predicate { customer -> customer.age < 18 }

    private fun validateNotAllowedRegion(): Predicate<Customer> =
        Predicate { customer -> customer.region == Region.WEST }
}

data class Customer(val id: UUID? = null, val name: String, val age: Int, val region: Region)

enum class Region {
    NORTH, EAST, SOUTH, WEST
}
