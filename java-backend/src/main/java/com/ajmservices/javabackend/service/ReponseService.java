package com.ajmservices.javabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajmservices.javabackend.model.Reponse;
import com.ajmservices.javabackend.repository.ReponseRepository;

@Service
public class ReponseService {

    @Autowired
    private ReponseRepository reponseRepository;

    public Reponse createReponse(Reponse reponse) {
        return reponseRepository.save(reponse);
    }

    public Iterable<Reponse> getAllReponses() {
        return reponseRepository.findAll();
    }

    public Reponse getReponseById(Long id) {
        return reponseRepository.findById(id).orElse(null);
    }

    public Reponse updateReponse(Long id, Reponse reponse) {
        reponse.setIdReponse(id);
        return reponseRepository.save(reponse);
    }

    public void deleteReponse(Long id) {
        reponseRepository.deleteById(id);
    }
}