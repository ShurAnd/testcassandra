package org.andrey.testcassandra.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.andrey.testcassandra.domain.Log;
import org.andrey.testcassandra.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    private LogService service;
    private ObjectMapper objectMapper;

    @Autowired
    public LogController(LogService service,
                         ObjectMapper objectMapper) {
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findOneById(@PathVariable String id) throws Exception {
        Log log = service.getById(id);

        return ResponseEntity
                .ok()
                .header("Content-Type", "application/json")
                .body(objectMapper.writeValueAsString(log));
    }

    @GetMapping
    public ResponseEntity<String> findAll() throws Exception {
        List<Log> logs = service.getAll();

        return ResponseEntity
                .ok()
                .header("Content-Type", "application/json")
                .body(objectMapper.writeValueAsString(logs));
    }

    @PostMapping
    public ResponseEntity<String> createOne(@RequestBody String json) throws Exception {
        Log log = service.save(objectMapper.readValue(json, Log.class));

        return ResponseEntity
                .created(null)
                .header("Content-Type", "application/json")
                .body(objectMapper.writeValueAsString(log));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody String json) throws Exception {
        Log log = service.save(objectMapper.readValue(json, Log.class));

        return ResponseEntity
                .ok()
                .header("Content-Type", "application/json")
                .body(objectMapper.writeValueAsString(log));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOneById(@PathVariable String id) throws Exception {
        service.deleteById(id);

        return ResponseEntity
                .noContent()
                .build();
    }
}
