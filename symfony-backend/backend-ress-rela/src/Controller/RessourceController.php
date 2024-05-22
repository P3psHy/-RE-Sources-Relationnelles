<?php

namespace App\Controller;

use App\Entity\Ressource;
use App\Form\RessourceType;
use App\Repository\CategorieRepository;
use App\Repository\EtatRessourceRepository;
use App\Repository\RessourceRepository;
use App\Repository\TypeRelationRepository;
use App\Repository\TypeRessourceRepository;
use Doctrine\ORM\EntityManagerInterface;
use App\Repository\UtilisateurRepository;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Serializer\SerializerInterface;
use Symfony\Component\Routing\Generator\UrlGeneratorInterface;
use Symfony\Component\Serializer\Normalizer\AbstractNormalizer;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;

#[Route('/ressource')]
class RessourceController extends AbstractController
{
    #[Route('/', name: 'app_ressource_index', methods: ['GET'])]
    public function index(RessourceRepository $ressourceRepository, SerializerInterface $serializer): Response
    {

        $ressources = $ressourceRepository->findAll();

        $jsonUsers = $serializer->serialize($ressources, 'json', ['groups' => 'Ressource']);
        return new JsonResponse($jsonUsers, Response::HTTP_OK, [], true);
    }



    #[Route('/{id}', name: 'app_ressource_show', methods: ['GET'])]
    public function show(Ressource $ressource, SerializerInterface $serializer): Response
    {
        $jsonUser = $serializer->serialize($ressource, 'json', ['groups' => 'Ressource']);
        return new JsonResponse($jsonUser, Response::HTTP_OK, [], true);

        
    }



    #[Route('/', name: 'app_ressource_new', methods: ['POST'])]
    public function new(Request $request, SerializerInterface $serializer, EntityManagerInterface $em, UrlGeneratorInterface $urlGenerator, UtilisateurRepository $utilisateurRepository, CategorieRepository $categorieRepository, TypeRelationRepository $typeRelationRepository, EtatRessourceRepository $etatRessourceRepository, TypeRessourceRepository $typeRessource): JsonResponse
    {

        $ressource = $serializer->deserialize($request->getContent(), Ressource::class, 'json');


        // Récupération de l'ensemble des données envoyées sous forme de tableau
        $content = $request->toArray();

        //on va chercher l'objet utilisateur
        $idUtilisateur = $content['id_utilisateur'];
        $idCategorie = $content['id_categorie'];
        $idTypeRessource = $content['id_type_ressource'];
        $idEtatRessource = 2;
        $idsTypeRelation = $content['ids_type_relation'];


        $ressource->setUtilisateur($utilisateurRepository->find($idUtilisateur));
        $ressource->setCategorie($categorieRepository->find($idCategorie));
        $ressource->setTypeRessource($typeRessource->find($idTypeRessource));
        $ressource->setEtatRessource($etatRessourceRepository->find($idEtatRessource));

        foreach($idsTypeRelation as $idTypeRelation){
            $ressource->addTypeRelation($typeRelationRepository->find($idTypeRelation));
        }

        $em->persist($ressource);
        $em->flush();

        $jsonRessource = $serializer->serialize($ressource, 'json', ['groups' => 'Ressource']);
        $location = $urlGenerator->generate('app_ressource_show', ['id' => $ressource->getId()], UrlGeneratorInterface::ABSOLUTE_URL);
        return new JsonResponse($jsonRessource, Response::HTTP_CREATED, ["Location" => $location], true);
    }


    #[Route('/{id}', name: 'app_ressource_edit', methods: ['PUT'])]
    public function edit(Request $request, SerializerInterface $serializer, Ressource $currentRessource, EntityManagerInterface $em, UtilisateurRepository $utilisateurRepository, CategorieRepository $categorieRepository, TypeRelationRepository $typeRelationRepository, EtatRessourceRepository $etatRessourceRepository, TypeRessourceRepository $typeRessourceRepository): JsonResponse 
    {
        $updatedRessource = $serializer->deserialize($request->getContent(), 
                Ressource::class, 
                'json',
                [AbstractNormalizer::OBJECT_TO_POPULATE => $currentRessource])
        ;
        
        $content = $request->toArray();

        //On récupère les ids à manipuler
        if(isset($content['id_utilisateur'])){
            $idUtilisateur = $content['id_utilisateur'];
            $updatedRessource->setUtilisateur($utilisateurRepository->find($idUtilisateur));

        }
        if(isset($content['id_categorie'])){
            $idCategorie = $content['id_categorie'];
            $updatedRessource->setCategorie($categorieRepository->find($idCategorie));

        }

        if(isset($content['id_type_ressource'])){
            $idTypeRessource = $content['id_type_ressource'];
            $updatedRessource->setTypeRessource($typeRessourceRepository->find($idTypeRessource));

        }

        if(isset($content['id_etat_ressource'])){
            $idEtatRessource = $content['id_etat_ressource'];
            $updatedRessource->setEtatRessource($etatRessourceRepository->find($idEtatRessource));
    
        }
        

        if(isset($content['ids_type_relation'])){
            $idsTypeRelation = $content['ids_type_relation'];
            foreach($idsTypeRelation as $idTypeRelation){
                $updatedRessource->addTypeRelation($typeRelationRepository->find($idTypeRelation));
            }
        }

        $em->persist($updatedRessource);
        $em->flush();
        
        return new JsonResponse(null, JsonResponse::HTTP_NO_CONTENT);
   }





    #[Route('/{id}', name: 'app_ressource_delete', methods: ['DELETE'])]
    public function delete(Request $request, Ressource $ressource, EntityManagerInterface $entityManager): Response
    {

        $entityManager->remove($ressource);
        $entityManager->flush();

        return new JsonResponse(null, Response::HTTP_NO_CONTENT);
    }
}
