package com.grebski.cek

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc

/** Cassandra, Elasticsearch, Kotlin sample app **/
@SpringBootApplication
@EnableWebMvc
class CekApplication

fun main(args: Array<String>) {
    SpringApplication.run(CekApplication::class.java, *args)
}
