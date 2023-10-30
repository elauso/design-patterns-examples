package net.elau.example.designpatternsexamples.specification.model.customer.selector

import net.elau.example.designpatternsexamples.specification.model.customer.Customer
import java.util.function.Predicate

class AgeGreaterThanSelector(private val age: Int) : Predicate<Customer> {

    override fun test(customer: Customer): Boolean = customer.age > age
}