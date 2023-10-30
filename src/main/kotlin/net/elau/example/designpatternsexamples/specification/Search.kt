package net.elau.example.designpatternsexamples.specification

import net.elau.example.designpatternsexamples.specification.model.customer.Customer
import net.elau.example.designpatternsexamples.specification.model.customer.CustomerRepository
import net.elau.example.designpatternsexamples.specification.model.customer.Region
import net.elau.example.designpatternsexamples.specification.model.customer.selector.AgeGreaterThanSelector
import net.elau.example.designpatternsexamples.specification.model.customer.selector.RegionEqualSelector

fun main(args: Array<String>) {
    val repository = initRepo()

    val regionSelector = RegionEqualSelector(Region.NORTH)
    val ageGreaterThanSelector = AgeGreaterThanSelector(18)

    val filtered = repository.find(regionSelector.and(ageGreaterThanSelector))
    println("Selected customers=$filtered")
}

private fun initRepo(): CustomerRepository {

    val repository = CustomerRepository()

    repository.create(Customer("Anna", 20, Region.NORTH))
    repository.create(Customer("John", 34, Region.EAST))
    repository.create(Customer("Thomas", 41, Region.SOUTH))

    return repository
}