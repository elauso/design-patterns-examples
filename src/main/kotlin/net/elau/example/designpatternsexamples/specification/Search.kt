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

    repository.create(Customer(name = "Anna", age = 20, region = Region.NORTH))
    repository.create(Customer(name = "John", age = 34, region = Region.EAST))
    repository.create(Customer(name = "Thomas", age = 41, region = Region.SOUTH))

    return repository
}