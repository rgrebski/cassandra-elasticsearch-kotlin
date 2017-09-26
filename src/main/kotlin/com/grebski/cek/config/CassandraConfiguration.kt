package com.grebski.cek.config

import org.springframework.boot.autoconfigure.cassandra.CassandraProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.cassandra.config.CassandraCqlClusterFactoryBean
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification
import java.util.Collections.singletonList


@Configuration
class CassandraConfiguration {

    @Bean
    fun cassandraCqlClusterFactoryBean(cassandraProperties: CassandraProperties): CassandraCqlClusterFactoryBean {
        val cqlClusterFactoryBean = CassandraCqlClusterFactoryBean()
        //create cassandra keyspace if does not exist
        cqlClusterFactoryBean.keyspaceCreations = singletonList(CreateKeyspaceSpecification.createKeyspace(cassandraProperties.keyspaceName).ifNotExists())

        return cqlClusterFactoryBean
    }
}