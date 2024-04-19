package com.ajmservices.javabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ajmservices.javabackend.DTO.RessourceUtilisateurDTO;
import com.ajmservices.javabackend.model.Utilisateur;
import com.ajmservices.javabackend.repository.UtilisateurRepository;



@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public Iterable<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id).orElse(null);
    }

    public Utilisateur updateUtilisateur(Long id, Utilisateur utilisateur) {
        utilisateur.setIdUtilisateur(id);
        return utilisateurRepository.save(utilisateur);
    }

    public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }

    public RessourceUtilisateurDTO getRessourceFavUtilisisateurbyIdUser(Long userId){

        String sql = "SELECT r.*, u.nom, u.prenom FROM ressource r" +
            "INNER JOIN _utilisateur_ressource_favoris fav ON r.id_utilisateur = fav.id_ressource" +
            "INNER JOIN utilisateur u ON fav.id_utilisateur = u.id_utilisateur" +
            "where u.id_utilisateur=?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            RessourceUtilisateurDTO dto = new RessourceUtilisateurDTO();
            dto.setIdRessource(rs.getLong("id_ressource"));
            dto.setTitre(rs.getString("titre"));
            dto.setDescription(rs.getString("description"));
            dto.setDatePublication(rs.getDate("date_publication"));
            dto.setNbConsultation(rs.getInt("nb_consultation"));
            dto.setNbRecherche(rs.getInt("nb_recherche"));
            dto.setNbPartage(rs.getInt("nb_partage"));
            dto.setNomUtilisateur(rs.getString("nomUser"));
            dto.setPrenomUtilisateur(rs.getString("prenomUser"));
            return dto;
        }, userId);
    }

}