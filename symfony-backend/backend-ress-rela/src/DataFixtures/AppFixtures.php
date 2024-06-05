<?php

namespace App\DataFixtures;

use DateTime;
use DateTimeZone;
use App\Entity\Role;
use App\Entity\Categorie;
use App\Entity\Utilisateur;
use App\Entity\TypeRelation;
use App\Entity\EtatRessource;
use App\Entity\TypeRessource;
use Doctrine\Persistence\ObjectManager;
use Doctrine\Bundle\FixturesBundle\Fixture;

class AppFixtures extends Fixture
{
    public function load(ObjectManager $manager): void
    {

        //Ajout catégorie
        $array = array(
            'Communication',
            'Cultures',
            'Développement personnel',
            'Intelligence émotionnelle',
            'Loisirs',
            'Monde professionnel',
            'Parentalité',
            'Qualité de vie',
            'Recherche de sens',
            'Santé physique',
            'Santé psychique',
            'Spiritualité',
            'Vie affective'
        );
        foreach($array as $elem){
            $categorie = new Categorie();
            $categorie->setNom($elem);

            $manager->persist($categorie);
        }


        //Ajout Type Relation
        $array = array(
            array('Soi', null),
            array('Conjoints', null),
            array('Famille', 'enfants / parents / fratrie'),
            array('Professionnelle', 'collègues, collaborateurs et managers'),
            array('Amis et communautés', null),
            array('Inconnus', null)
        );
        
        foreach ($array as $values) {
            $typeRelation = new TypeRelation();
            $typeRelation->setNom($values[0]);
            $typeRelation->setCommentaire($values[1]);

            $manager->persist($typeRelation);
        }

        //Ajout Type Ressource
        $array = array(
            'Activité / Jeu à réaliser',
            'Article',
            'Carte défi',
            'Cours au format PDF',
            'Exercice / Atelier',
            'Fiche de lecture',
            'Jeu en ligne',
            'Vidéo'
        );
    
        foreach ($array as $value) {
            $typeRessource = new TypeRessource();
            $typeRessource->setNom($value);
        
            $manager->persist($typeRessource);
        }



        $array = array(
            'Publiée',
            'En cours de traitement',
            'Refusée',
            'Archivée'
        );
        
        // Parcourir le tableau et assigner les valeurs aux objets EtatRessource
        foreach ($array as $value) {
            $etatRessource = new EtatRessource();
            $etatRessource->setNom($value);

            $manager->persist($etatRessource);
        }


        $array = array(
            'Utilisateur',
            'Modérateur',
            'Administrateur',
            'Super-Administrateur'
        );
        // Parcourir le tableau et assigner les valeurs aux objets Role
        foreach ($array as $value) {
            $role = new Role();
            $role->setNom($value);

            $manager->persist($role);
        }

        $manager->flush();



        // $dateTime = new DateTime('now', new DateTimeZone('Europe/Paris'));

        // $utilisateur = new Utilisateur();
        // $utilisateur->setPrenom('Michel')
        //     ->setNom('Patrick')
        //     ->setMail('m.p@gmail.com')
        //     ->setMotDePasse('123')
        //     ->setDepartement('Loiret')
        //     ->setDateCreation($dateTime)
        //     ->setEstActive(true)
        // ;

        // $utilisateur->setPrenom('Michel')
        //     ->setNom('Patrick')
        //     ->setMail('m.p@gmail.com')
        //     ->setMotDePasse('123')
        //     ->setDepartement('Loiret')
        //     ->setDateCreation($dateTime)
        //     ->setEstActive(true)

        // ;
        // $utilisateur->setPrenom('Michel')
        //     ->setNom('Patrick')
        //     ->setMail('m.p@gmail.com')
        //     ->setMotDePasse('123')
        //     ->setDepartement('Loiret')
        //     ->setDateCreation($dateTime)
        //     ->setEstActive(true)

        // ;

        // $manager->flush();
    }
}
