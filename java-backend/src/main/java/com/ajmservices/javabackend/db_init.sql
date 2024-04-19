DELETE from categorie WHERE 1;
ALTER TABLE categorie AUTO_INCREMENT=1;
INSERT INTO categorie (nom) VALUES
    ('Communication'),
    ('Cultures'),
    ('Développement personnel'),
    ('Intelligence émotionnelle'),
    ('Loisirs'),
    ('Monde professionnel'),
    ('Parentalité'),
    ('Qualité de vie'),
    ('Recherche de sens'),
    ('Santé physique'),
    ('Santé psychique'),
    ('Spiritualité'),
    ('Vie affective');

DELETE from type_relation WHERE 1;
ALTER TABLE type_relation AUTO_INCREMENT=1;
INSERT INTO type_relation (nom, commentaire) VALUES 
    ('Soi', null),
    ('Conjoints', null),
    ('Famille', 'enfants / parents / fratrie'),
    ('Professionnelle', 'collègues, collaborateurs et managers'),
    ('Amis et communautés', null),
    ('Inconnus', null);

DELETE from type_ressource WHERE 1;
ALTER TABLE type_ressource AUTO_INCREMENT=1;
INSERT INTO type_ressource (nom) VALUES 
    ('Activité / Jeu à réaliser'),
    ('Article'),
    ('Carte défi'),
    ('Cours au format PDF'),
    ('Exercice / Atelier'),
    ('Fiche de lecture'),
    ('Jeu en ligne'),
    ('Vidéo');

DELETE from etat_ressource WHERE 1;
ALTER TABLE etat_ressource AUTO_INCREMENT=1;
INSERT INTO etat_ressource (nom) VALUES 
    ('Publiée'),
    ('En cours de traitement'),
    ('Refusée'),
    ('Archivée');



DELETE from role WHERE 1;
ALTER TABLE role AUTO_INCREMENT=1;
INSERT INTO role (nom) VALUES
    ('Utilisateur'),
    ('Modérateur'),
    ('Administrateur'),
    ('Super-Administrateur');