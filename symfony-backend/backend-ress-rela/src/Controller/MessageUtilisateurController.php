<?php

namespace App\Controller;

use DateTime;
use DateTimeZone;
use App\Entity\MessageUtilisateur;
use App\Form\MessageUtilisateurType;
use Doctrine\ORM\EntityManagerInterface;
use App\Repository\UtilisateurRepository;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;
use App\Repository\MessageUtilisateurRepository;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Serializer\SerializerInterface;
use Symfony\Component\Routing\Generator\UrlGeneratorInterface;
use Symfony\Component\Serializer\Normalizer\AbstractNormalizer;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;

#[Route('/MessageUtilisateur')]
class MessageUtilisateurController extends AbstractController
{
    #[Route('/', name: 'app_message_utilisateur_index', methods: ['GET'])]
    public function index(MessageUtilisateurRepository $messageUtilisateurRepository, SerializerInterface $serializer): Response
    {
        $messageUtilisateur = $messageUtilisateurRepository->findAll();

        $json = $serializer->serialize($messageUtilisateur, 'json', ['groups' => 'MessageUtilisateur']);
        return new JsonResponse($json, Response::HTTP_OK, [], true);
    }




    #[Route('/{id}', name: 'app_message_utilisateur_show', methods: ['GET'])]
    public function show(MessageUtilisateur $messageUtilisateur, SerializerInterface $serializer): Response
    {
        $json = $serializer->serialize($messageUtilisateur, 'json', ['groups' => 'MessageUtilisateur']);
        return new JsonResponse($json, Response::HTTP_OK, [], true);

    }


    #[Route('/userConversation/{id}', name: 'app_message_utilisateur_show_user_conversation', methods: ['GET'])]
    public function showListConversation(MessageUtilisateurRepository $messageUtilisateurRepository, SerializerInterface $serializer, int $id): Response
    {
        $listConversation = $messageUtilisateurRepository->getListConversation($id);

        $json = $serializer->serialize($listConversation, 'json');
        return new JsonResponse($json, Response::HTTP_OK, [], true);
    }


    #[Route('/userMessagesConversation/message', name: 'app_message_utilisateur_show_message_user_conversation', methods: ['GET'])]
    public function showMessagesConversation(Request $request, MessageUtilisateurRepository $messageUtilisateurRepository, SerializerInterface $serializer): Response
    {
        $idUser1 = intval($request->get('idUser1'));
        $idUser2 = intval($request->get('idUser2'));

        $listMessagesConversation = $messageUtilisateurRepository->getListMessagesConversation($idUser1,$idUser2);

        $json = $serializer->serialize($listMessagesConversation, 'json');
        return new JsonResponse($json, Response::HTTP_OK, [], true);
    }



    #[Route('/', name: 'app_message_utilisateur_new', methods: ['POST'])]
    public function new(Request $request, SerializerInterface $serializer, EntityManagerInterface $em, UrlGeneratorInterface $urlGenerator, UtilisateurRepository $utilisateurRepository): Response
    {
        $messageUtilisateur = $serializer->deserialize($request->getContent(), MessageUtilisateur::class, 'json');
    
        $content = $request->toArray();

        //on va chercher les objets
        $idUtilisateur1 = $content['id_utilisateur1'];
        $idUtilisateur2 = $content['id_utilisateur2'];
    
        $utilisateur1 = $utilisateurRepository->find($idUtilisateur1);
        $utilisateur2 = $utilisateurRepository->find($idUtilisateur2);
        $dateTime = new DateTime('now', new DateTimeZone('Europe/Paris'));


        $messageUtilisateur->setUtilisateur1($utilisateur1);
        $messageUtilisateur->setUtilisateur2($utilisateur2);
        $messageUtilisateur->setdateHeureEnvoi($dateTime);

        $utilisateur1->addMessageUtilisateur($messageUtilisateur);

        $em->persist($utilisateur1);
        $em->persist($messageUtilisateur);

        $em->flush();


        $json = $serializer->serialize($messageUtilisateur, 'json', ['groups' => 'MessageUtilisateur']);
        $location = $urlGenerator->generate('app_message_utilisateur_show', ['id' => $messageUtilisateur->getId()], UrlGeneratorInterface::ABSOLUTE_URL);
        return new JsonResponse($json, Response::HTTP_CREATED, ["Location" => $location], true);
    }

    

    #[Route('/{id}', name: 'app_message_utilisateur_edit', methods: ['PUT'])]
    public function edit(Request $request, SerializerInterface $serializer, MessageUtilisateur $currentMessageUtilisateur, EntityManagerInterface $em): Response
    {
        
        $updatedMessageUtilisateur = $serializer->deserialize($request->getContent(), 
                MessageUtilisateur::class, 
                'json', 
                [AbstractNormalizer::OBJECT_TO_POPULATE => $currentMessageUtilisateur])
        ;


        $em->persist($updatedMessageUtilisateur);
        $em->flush();
        
        return new JsonResponse(null, JsonResponse::HTTP_NO_CONTENT);


    }

    #[Route('/{id}', name: 'app_message_utilisateur_delete', methods: ['DELETE'])]
    public function delete(Request $request, MessageUtilisateur $messageUtilisateur, EntityManagerInterface $entityManager): Response
    {

        $entityManager->remove($messageUtilisateur);
        $entityManager->flush();

        return new JsonResponse(null, Response::HTTP_NO_CONTENT);
    }
}
