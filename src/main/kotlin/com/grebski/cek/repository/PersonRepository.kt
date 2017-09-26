package com.grebski.cek.repository

import com.grebski.cek.domain.Person
import org.springframework.data.cassandra.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import java.util.*

interface PersonRepository : ReactiveCrudRepository<Person, UUID> {

    @Query("SELECT * FROM person limit :limit")
    fun findAllAndLimit(@Param("limit") limit: Int): Flux<Person>
}