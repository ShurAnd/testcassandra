package org.andrey.testcassandra.repositories;

import org.andrey.testcassandra.domain.Log;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogCassandraRepository extends CassandraRepository<Log, String> {
}
