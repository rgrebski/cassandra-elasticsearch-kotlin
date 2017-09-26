package com.grebski.cek.domain

import com.datastax.driver.core.utils.UUIDs
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table
import java.util.*

@Table("Person")
data class Person(
        @PrimaryKey
        val id: UUID = UUIDs.timeBased(),

        var firstName: String,
        var lastName: String,
        var age: Int,
        var version: Int = 0
)