<?php

namespace App\Controller;

use App\Entity\RelationUtilisateur;
use App\Form\RelationUtilisateurType;
use Doctrine\ORM\EntityManagerInterface;
use App\Repository\UtilisateurRepository;
use App\Repository\TypeRelationRepository;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;
use App\Repository\RelationUtilisateurRepository;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Serializer\SerializerInterface;
use Symfony\Component\Routing\Generator\UrlGeneratorInterface;
use Symfony\Component\Serializer\Normalizer\AbstractNormalizer;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;


#[Route('/RelationUtilisateur')]
class RelationUtilisateurController extends AbstractController
{
    #[Route('/', name: 'app_relation_utilisateur_index', methods: ['GET'])]
    public function index(RelationUtilisateurRepository $relationUtilisateurRepository, SerializerInterface $serializer): Response
    {
        $relationUtilisateur = $relationUtilisateurRepository->findAll();

        $json = $serializer->serialize($relationUtilisateur, 'json', ['groups' => 'RelationUtilisateur']);
        return new JsonResponse($json, Response::HTTP_OK, [], true);
    }

    

    #[Route('/{id}', name: 'app_relation_utilisateur_show', methods: ['GET'])]
    public function show(RelationUtilisateur $relationUtilisateur, SerializerInterface $serializer): Response
    {
        $json = $serializer->serialize($relationUtilisateur, 'json', ['groups' => 'RelationUtilisateur']);
        return new JsonResponse($json, Response::HTTP_OK, [], true);

    }

    #[Route('/user/{id}', name: 'app_list_relations_utilisateur_show', methods: ['GET'])]
    public function showUserRelation(UtilisateurRepository $utilisateurRepository, RelationUtilisateurRepository $relationUtilisateurRepository, int $id,SerializerInterface $serializer){



        $listUserRelation = [];

        //On récupère l'utilisateur et la liste des Relation
        $user = $utilisateurRepository->find($id);
        $listRelationsUtilisateur= $relationUtilisateurRepository->findByUserId($id);
        
        //On vérifie dans la liste des relations l'emplacement de l'utilisateur pour ajouter l'autre (ne pas avoir NOTRE utilisateur dans la liste)
        foreach($listRelationsUtilisateur as $userRela){
            if($userRela->getIdUtilisateur1() == $user){
                $relationUser = [
                    "idRelationUtilisateur" => $userRela->getId(),
                    "estAccepte" => $userRela->isEstAccepte(),
                    "idTypeRelation" => $userRela->getIdTypeRelation()->getId(),
                    "nomTypeRelation" => $userRela->getIdTypeRelation()->getNom(),
                    "commentaireTypeRelation" => $userRela->getIdTypeRelation()->getCommentaire(),
                    "idUser" =>$userRela->getIdUtilisateur2()->getId(),
                    "nomUser" => $userRela->getIdUtilisateur2()->getNom(),
                    "prenomUser" => $userRela->getIdUtilisateur2()->getPrenom(),
                    "departementUser" => $userRela->getIdUtilisateur2()->getDepartement(),
                    "estReceveur"=>false
                ];
            }else{
                $relationUser = [
                    "idRelationUtilisateur" => $userRela->getId(),
                    "estAccepte" => $userRela->isEstAccepte(),
                    "idTypeRelation" => $userRela->getIdTypeRelation()->getId(),
                    "nomTypeRelation" => $userRela->getIdTypeRelation()->getNom(),
                    "commentaireTypeRelation" => $userRela->getIdTypeRelation()->getCommentaire(),
                    "idUser" =>$userRela->getIdUtilisateur1()->getId(),
                    "nomUser" => $userRela->getIdUtilisateur1()->getNom(),
                    "prenomUser" => $userRela->getIdUtilisateur1()->getPrenom(),
                    "departementUser" => $userRela->getIdUtilisateur2()->getDepartement(),
                    "estReceveur"=>true

                ];
            }
            $listUserRelation[] = $relationUser;
        }
        


        $json = $serializer->serialize($listUserRelation, 'json');
        return new JsonResponse($json, Response::HTTP_OK, [], true);
    }



    #[Route('/', name: 'app_relation_utilisateur_new', methods: ['POST'])]
    public function new(Request $request, SerializerInterface $serializer, EntityManagerInterface $em, UrlGeneratorInterface $urlGenerator, UtilisateurRepository $utilisateurRepository, TypeRelationRepository $typeRelationRepository): JsonResponse
    {

        // $relationUtilisateur = $serializer->deserialize($request->getContent(), RelationUtilisateur::class, 'json');

        $relationUtilisateur = new RelationUtilisateur();

        // Récupération de l'ensemble des données envoyées sous forme de tableau
        $content = $request->toArray();

        //on va chercher les objets
        $idUtilisateur1 = $content['id_utilisateur1'];
        $idUtilisateur2 = $content['id_utilisateur2'];
        $idTypeRelation = $content['id_type_relation'];

        $utilisateur1 = $utilisateurRepository->find($idUtilisateur1);
        $utilisateur2 = $utilisateurRepository->find($idUtilisateur2);
        $typeRelation = $typeRelationRepository->find($idTypeRelation);

    


        $relationUtilisateur->setIdUtilisateur1($utilisateur1);
        $relationUtilisateur->setIdUtilisateur2($utilisateur2);
        $relationUtilisateur->setIdTypeRelation($typeRelation);
        $relationUtilisateur->setEstAccepte(false);



        $utilisateur1->addRelationUtilisateur($relationUtilisateur);
        $typeRelation->addRelationUtilisateur($relationUtilisateur);



        $em->persist($utilisateur1);
        $em->persist($typeRelation);
        $em->persist($relationUtilisateur);
        $em->flush();

        $json = $serializer->serialize($relationUtilisateur, 'json', ['groups' => 'RelationUtilisateur']);
        $location = $urlGenerator->generate('app_relation_utilisateur_show', ['id' => $relationUtilisateur->getId()], UrlGeneratorInterface::ABSOLUTE_URL);
        return new JsonResponse($json, Response::HTTP_CREATED, ["Location" => $location], true);
    }

    


    

    #[Route('/{id}', name: 'app_relation_utilisateur_edit', methods: ['PUT'])]
    public function edit(Request $request, SerializerInterface $serializer, RelationUtilisateur $currentRelationUtilisateur, EntityManagerInterface $em): JsonResponse 
    {
        $updatedRelationUtilisateur = $serializer->deserialize($request->getContent(), 
                RelationUtilisateur::class, 
                'json', 
                [AbstractNormalizer::OBJECT_TO_POPULATE => $currentRelationUtilisateur])
        ;
        
        // $content = $request->toArray();

        // //On récupère les ids à manipuler
        // $idUtilisateur = $content['id_utilisateur'];
        // $idCategorie = $content['id_categorie'];
        // $idsTypeRelation = $content['ids_type_relation'];


        // $updatedRessource->setUtilisateur($utilisateurRepository->find($idUtilisateur));
        // $updatedRessource->setCategorie($categorieRepository->find($idCategorie));

        // foreach($idsTypeRelation as $idTypeRelation){
        //     $updatedRessource->addTypeRelation($typeRelationRepository->find($idTypeRelation));
        // }

        $em->persist($updatedRelationUtilisateur);
        $em->flush();
        
        return new JsonResponse(null, JsonResponse::HTTP_NO_CONTENT);
   }



    

    #[Route('/{id}', name: 'app_relation_utilisateur_delete', methods: ['DELETE'])]
    public function delete(Request $request, RelationUtilisateur $relationUtilisateur, EntityManagerInterface $entityManager): Response
    {

        $entityManager->remove($relationUtilisateur);
        $entityManager->flush();

        return new JsonResponse(null, Response::HTTP_NO_CONTENT);
    }
}
