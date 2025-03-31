package org.andrey.testcassandra.config;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.cql.CqlTemplate;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.net.InetSocketAddress;

@Configuration
@EnableCassandraRepositories(basePackages = "org.andrey.repositories.*")
public class CassandraConfig {
    @Bean
    public CqlSession cqlSession() {
        return CqlSession.builder()
                .withLocalDatacenter("datacenter1")
                .withKeyspace("andrey_keyspace") // Укажите Ваше ключевое пространство
                .addContactPoint(new InetSocketAddress("localhost", 9042)) // Укажите адрес и порт Вашего кластера
                .build();
    }

    @Bean
    public CassandraTemplate cassandraTemplate(CqlSession cqlSession) {
        return new CassandraTemplate(cqlSession);
    }

    @Bean
    public CqlTemplate cassandraCqlTemplate(CqlSession cqlSession) {
        return new CqlTemplate(cqlSession);
    }
}
