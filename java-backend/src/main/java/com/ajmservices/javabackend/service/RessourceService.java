package com.ajmservices.javabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ajmservices.javabackend.DTO.RessourceUtilisateurDTO;
import com.ajmservices.javabackend.model.Ressource;
import com.ajmservices.javabackend.repository.RessourceRepository;

import java.util.List;
import java.util.Map;

@Service
public class RessourceService {

    @Autowired
    private RessourceRepository ressourceRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Ressource createRessource(Ressource ressource) {
        return ressourceRepository.save(ressource);
    }

    public Iterable<Ressource> getAllRessources() {
        return ressourceRepository.findAll();
    }

    public Ressource getRessourceById(Long id) {
        return ressourceRepository.findById(id).orElse(null);
    }

    public Ressource updateRessource(Long id, Ressource ressource) {
        ressource.setIdRessource(id);
        return ressourceRepository.save(ressource);
    }

    public void deleteRessource(Long id) {
        ressourceRepository.deleteById(id);
    }

    public RessourceUtilisateurDTO getRessourceUtilisateurByRessourceId(Long ressourceId) {
        String sql = "SELECT r.*, u.nom as nomUser, u.prenom as prenomUser " +
                     "FROM ressource r " +
                     "INNER JOIN utilisateur u ON r.id_utilisateur = u.id_utilisateur " +
                     "WHERE r.id_ressource = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            RessourceUtilisateurDTO dto = new RessourceUtilisateurDTO();
            dto.setIdRessource(rs.getLong("id_ressource"));
            dto.setTitre(rs.getString("titre"));
            dto.setDescription(rs.getString("description"));
            dto.setDatePublication(rs.getDate("date_publication"));
            dto.setNbConsultation(rs.getInt("nb_consultation"));
            dto.setNbRecherche(rs.getInt("nb_recherche"));
            dto.setNbPartage(rs.getInt("nb_partage"));
            dto.setNomUtilisateur(rs.getString("nomUtilisateur"));
            dto.setPrenomUtilisateur(rs.getString("prenomUtilisateur"));
            return dto;
        }, ressourceId);
    }

    // public RessourceUtilisateurDTO getRessourceFavUtilisisateurbyRessourceId(Long useId){

    //     String sql = "SELECT r.*, u.nom, u.prenom FROM ressource r" +
    //         "INNER JOIN _utilisateur_ressource_favoris fav ON r.id_utilisateur = fav.id_ressource" +
    //         "INNER JOIN utilisateur u ON fav.id_utilisateur = u.id_utilisateur" +
    //         "where u.id_utilisateur=?";
    //     return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
    //         RessourceUtilisateurDTO dto = new RessourceUtilisateurDTO();
    //         dto.setIdRessource(rs.getLong("id_ressource"));
    //         dto.setTitre(rs.getString("titre"));
    //         dto.setDescription(rs.getString("description"));
    //         dto.setDatePublication(rs.getDate("date_publication"));
    //         dto.setNbConsultation(rs.getInt("nb_consultation"));
    //         dto.setNbRecherche(rs.getInt("nb_recherche"));
    //         dto.setNbPartage(rs.getInt("nb_partage"));
    //         dto.setNomUser(rs.getString("nomUser"));
    //         dto.setPrenomUser(rs.getString("prenomUser"));
    //         return dto;
    //     }, ressourceId);
    // }
}