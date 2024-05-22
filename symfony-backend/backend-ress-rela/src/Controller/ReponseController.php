<?php

namespace App\Controller;

use DateTime;
use DateTimeZone;
use App\Entity\Reponse;
use App\Form\ReponseType;
use App\Repository\ReponseRepository;
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

#[Route('/reponse')]
class ReponseController extends AbstractController
{
    #[Route('/', name: 'app_reponse_index', methods: ['GET'])]
    public function index(ReponseRepository $reponseRepository, SerializerInterface $serializer): Response
    {
        
        $reponses = $reponseRepository->findAll();

        $json = $serializer->serialize($reponses, 'json', ['groups' => 'Reponse']);
        return new JsonResponse($json, Response::HTTP_OK, [], true);
    
    }



    #[Route('/{id}', name: 'app_reponse_show', methods: ['GET'])]
    public function show(Reponse $reponse, SerializerInterface $serializer): Response
    {
        $json = $serializer->serialize($reponse, 'json', ['groups' => 'Reponse']);
        return new JsonResponse($json, Response::HTTP_OK, [], true);

        
    }



    #[Route('/', name: 'app_reponse_new', methods: ['POST'])]
    public function new(Request $request, SerializerInterface $serializer, EntityManagerInterface $em, UtilisateurRepository $utilisateurRepository, CommentaireRepository $commentaireRepository, UrlGeneratorInterface $urlGenerator): Response
    {
        $reponse = $serializer->deserialize($request->getContent(), Reponse::class, 'json');


        // Récupération de l'ensemble des données envoyées sous forme de tableau
        $content = $request->toArray();

        //on va chercher l'objet utilisateur
        $idUtilisateur = $content['id_utilisateur'];
        $idCommentaire = $content['id_commentaire'];
        $dateTime = new DateTime('now', new DateTimeZone('Europe/Paris'));


        $reponse->setUtilisateur($utilisateurRepository->find($idUtilisateur));
        $reponse->setCommentaire($commentaireRepository->find($idCommentaire));
        $reponse->setDateReponse($dateTime);

        $em->persist($reponse);
        $em->flush();

        $json = $serializer->serialize($reponse, 'json', ['groups' => 'Reponse']);
        $location = $urlGenerator->generate('app_reponse_show', ['id' => $reponse->getId()], UrlGeneratorInterface::ABSOLUTE_URL);
        return new JsonResponse($json, Response::HTTP_CREATED, ["Location" => $location], true);
    }

    

    #[Route('/{id}/edit', name: 'app_reponse_edit', methods: ['GET', 'POST'])]
    public function edit(Request $request, Reponse $reponse, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(ReponseType::class, $reponse);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('app_reponse_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('reponse/edit.html.twig', [
            'reponse' => $reponse,
            'form' => $form,
        ]);
    }

    #[Route('/{id}', name: 'app_reponse_delete', methods: ['DELETE'])]
    public function delete(Request $request, Reponse $reponse, EntityManagerInterface $entityManager): Response
    {

        $entityManager->remove($reponse);
        $entityManager->flush();

        return new JsonResponse(null, Response::HTTP_NO_CONTENT);
    }
}
