package net.elau.example.designpatternsexamples.specification.model.customer.selector

import net.elau.example.designpatternsexamples.specification.model.customer.Customer
import net.elau.example.designpatternsexamples.specification.model.customer.Region
import java.util.function.Predicate

class RegionEqualSelector(private val region: Region) : Predicate<Customer> {

    override fun test(customer: Customer): Boolean = customer.region == region
}