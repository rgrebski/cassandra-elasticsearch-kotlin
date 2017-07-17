package com.grebski.cek

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/** Cassandra, Elasticsearch, Kotlin sample app **/
@SpringBootApplication
class CekApplication

fun main(args: Array<String>) {
    SpringApplication.run(CekApplication::class.java, *args)
}
