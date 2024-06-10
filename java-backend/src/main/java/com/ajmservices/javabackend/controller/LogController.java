package com.ajmservices.javabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ajmservices.javabackend.model.Log;
import com.ajmservices.javabackend.service.LogService;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    @Autowired
    private LogService logService;

    @PostMapping
    public Log createLog(@RequestBody Log log) {
        return logService.createLog(log);
    }

    @GetMapping
    public Iterable<Log> getAllLogs() {
        return logService.getAllLogs();
    }

    @GetMapping("/{id}")
    public Log getLogById(@PathVariable Long id) {
        return logService.getLogById(id);
    }

    @PutMapping("/{id}")
    public Log updateLog(@PathVariable Long id, @RequestBody Log log) {
        return logService.updateLog(id, log);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        logService.deleteLog(id);
    }
}