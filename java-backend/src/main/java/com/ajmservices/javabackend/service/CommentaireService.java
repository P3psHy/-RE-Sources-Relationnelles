package com.ajmservices.javabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajmservices.javabackend.model.Commentaire;
import com.ajmservices.javabackend.repository.CommentaireRepository;

@Service
public class CommentaireService {

    @Autowired
    private CommentaireRepository commentaireRepository;

    public Commentaire createCommentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    public Iterable<Commentaire> getAllCommentaires() {
        return commentaireRepository.findAll();
    }

    public Commentaire getCommentaireById(Long id) {
        return commentaireRepository.findById(id).orElse(null);
    }

    public Commentaire updateCommentaire(Long id, Commentaire commentaire) {
        commentaire.setIdCommentaire(id);
        return commentaireRepository.save(commentaire);
    }

    public void deleteCommentaire(Long id) {
        commentaireRepository.deleteById(id);
    }
}