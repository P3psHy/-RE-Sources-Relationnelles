package com.ajmservices.javabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajmservices.javabackend.model.Log;
import com.ajmservices.javabackend.repository.LogRepository;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public Log createLog(Log log) {
        return logRepository.save(log);
    }

    public Iterable<Log> getAllLogs() {
        return logRepository.findAll();
    }

    public Log getLogById(Long id) {
        return logRepository.findById(id).orElse(null);
    }

    public Log updateLog(Long id, Log log) {
        log.setIdLog(id);
        return logRepository.save(log);
    }

    public void deleteLog(Long id) {
        logRepository.deleteById(id);
    }
}