<?php

namespace App\Controller;

use DateTime;
use DateTimeZone;
use App\Entity\Commentaire;
use App\Form\CommentaireType;
use App\Repository\RessourceRepository;
use Doctrine\ORM\EntityManagerInterface;
use App\Repository\CommentaireRepository;
use App\Repository\UtilisateurRepository;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Serializer\SerializerInterface;
use Symfony\Component\Routing\Generator\UrlGeneratorInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;

#[Route('/commentaire')]
class CommentaireController extends AbstractController
{
    #[Route('/', name: 'app_commentaire_index', methods: ['GET'])]
    public function index(CommentaireRepository $commentaireRepository, SerializerInterface $serializer): Response
    {
        
        $commentaires = $commentaireRepository->findAll();

        $json = $serializer->serialize($commentaires, 'json', ['groups' => 'Commentaire']);
        return new JsonResponse($json, Response::HTTP_OK, [], true);
    
    }

    #[Route('/{id}', name: 'app_commentaire_show', methods: ['GET'])]
    public function show(Commentaire $commentaire, SerializerInterface $serializer): Response
    {
        $jsonUser = $serializer->serialize($commentaire, 'json', ['groups' => 'Commentaire']);
        return new JsonResponse($jsonUser, Response::HTTP_OK, [], true);

        
    }

    #[Route('/', name: 'app_commentaire_new', methods: ['POST'])]
    public function new(Request $request, SerializerInterface $serializer, EntityManagerInterface $em, UtilisateurRepository $utilisateurRepository, RessourceRepository $ressourceRepository, UrlGeneratorInterface $urlGenerator): Response
    {
        $commentaire = $serializer->deserialize($request->getContent(), Commentaire::class, 'json');


        // Récupération de l'ensemble des données envoyées sous forme de tableau
        $content = $request->toArray();

        //on va chercher l'objet utilisateur
        $idUtilisateur = $content['id_utilisateur'];
        $idRessource = $content['id_ressource'];
        $dateTime = new DateTime('now', new DateTimeZone('Europe/Paris'));


        $commentaire->setUtilisateur($utilisateurRepository->find($idUtilisateur));
        $commentaire->setRessource($ressourceRepository->find($idRessource));
        $commentaire->setDateCommentaire($dateTime);

        $em->persist($commentaire);
        $em->flush();

        $json = $serializer->serialize($commentaire, 'json', ['groups' => 'Commentaire']);
        $location = $urlGenerator->generate('app_commentaire_show', ['id' => $commentaire->getId()], UrlGeneratorInterface::ABSOLUTE_URL);
        return new JsonResponse($json, Response::HTTP_CREATED, ["Location" => $location], true);
    }


    #[Route('/{id}', name: 'app_commentaire_delete', methods: ['DELETE'])]
    public function delete(Request $request, Commentaire $commentaire, EntityManagerInterface $entityManager): Response
    {

        $entityManager->remove($commentaire);
        $entityManager->flush();

        return new JsonResponse(null, Response::HTTP_NO_CONTENT);
    }
}
