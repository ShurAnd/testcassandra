package org.andrey.testcassandra.services;

import org.andrey.testcassandra.domain.Log;
import org.andrey.testcassandra.repositories.LogCassandraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LogService {

    private final LogCassandraRepository repository;

    @Autowired
    public LogService(LogCassandraRepository repository){
        this.repository = repository;
    }

    public Log save(Log log){
        if (log.getId() == null){
            log.setId(UUID.randomUUID());
        }
        System.out.println(log.getLogLevel());
        System.out.println(log.getLogSource());
        return repository.save(log);
    }

    public Log getById(String id){
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Log not found"));
    }

    public List<Log> getAll(){
        return repository.findAll();
    }

    public void deleteById(String id){
        repository.deleteById(id);
    }
}
