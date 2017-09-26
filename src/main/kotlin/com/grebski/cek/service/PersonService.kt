package com.grebski.cek.service

import com.google.common.base.Preconditions
import com.grebski.cek.domain.Person
import com.grebski.cek.repository.PersonRepository
import org.jfairy.Fairy
import org.springframework.stereotype.Service

@Service
class PersonService(val personRepository: PersonRepository) {

    companion object {
        val defaultPageSize = 10
    }

    fun generatePersons(noOfUsersToAdd: Int) {
        Preconditions.checkArgument(noOfUsersToAdd > 0, "noOfUsersToAdd must be greater than 0")

        val fairy = Fairy.create()
        val personsToSave = arrayListOf<Person>()
        IntArray(noOfUsersToAdd).map { i ->
            val fairyPerson = fairy.person()
            val personToSave = Person(
                    firstName = fairyPerson.firstName(),
                    lastName = fairyPerson.lastName(),
                    age = fairyPerson.age())

            personsToSave.add(personToSave)
        }

        personRepository.saveAll(personsToSave)
    }

    //TODO RGr: get real page from ElasticSearch (now getting from cassandra where paging is not yet supported in Spring Data Cassandra)
    fun getPage(pageNo: Int?, pageSize: Int?): List<Person> {
        val limit = pageSize ?: defaultPageSize
        return personRepository.findAllAndLimit(limit)
                .collectList()
                .block()
    }
}