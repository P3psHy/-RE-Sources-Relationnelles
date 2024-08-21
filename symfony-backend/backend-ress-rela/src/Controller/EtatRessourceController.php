<?php

namespace App\Controller;

use App\Entity\EtatRessource;
use App\Form\EtatRessourceType;
use Doctrine\ORM\EntityManagerInterface;
use App\Repository\EtatRessourceRepository;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Serializer\SerializerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;

#[Route('/EtatRessource')]
class EtatRessourceController extends AbstractController
{
    #[Route('/', name: 'app_etat_ressource_index', methods: ['GET'])]
    public function index(EtatRessourceRepository $etatRessourceRepository, SerializerInterface $serializer): Response
    {

        $roles = $etatRessourceRepository->findAll();

        $jsonRole = $serializer->serialize($roles, 'json', ['groups' => 'EtatRessource']);
        return new JsonResponse($jsonRole, Response::HTTP_OK, [], true);
    
    }

    #[Route('/{id}', name: 'app_etat_ressource_show', methods: ['GET'])]
    public function show(EtatRessource $etatRessource, SerializerInterface $serializer): Response
    {
        $json = $serializer->serialize($etatRessource, 'json', ['groups' => 'EtatRessource']);
        return new JsonResponse($json, Response::HTTP_OK, [], true);

    }

    // #[Route('/new', name: 'app_etat_ressource_new', methods: ['GET', 'POST'])]
    // public function new(Request $request, EntityManagerInterface $entityManager): Response
    // {
    //     $etatRessource = new EtatRessource();
    //     $form = $this->createForm(EtatRessourceType::class, $etatRessource);
    //     $form->handleRequest($request);

    //     if ($form->isSubmitted() && $form->isValid()) {
    //         $entityManager->persist($etatRessource);
    //         $entityManager->flush();

    //         return $this->redirectToRoute('app_etat_ressource_index', [], Response::HTTP_SEE_OTHER);
    //     }

    //     return $this->render('etat_ressource/new.html.twig', [
    //         'etat_ressource' => $etatRessource,
    //         'form' => $form,
    //     ]);
    // }



    // #[Route('/{id}/edit', name: 'app_etat_ressource_edit', methods: ['GET', 'POST'])]
    // public function edit(Request $request, EtatRessource $etatRessource, EntityManagerInterface $entityManager): Response
    // {
    //     $form = $this->createForm(EtatRessourceType::class, $etatRessource);
    //     $form->handleRequest($request);

    //     if ($form->isSubmitted() && $form->isValid()) {
    //         $entityManager->flush();

    //         return $this->redirectToRoute('app_etat_ressource_index', [], Response::HTTP_SEE_OTHER);
    //     }

    //     return $this->render('etat_ressource/edit.html.twig', [
    //         'etat_ressource' => $etatRessource,
    //         'form' => $form,
    //     ]);
    // }

    // #[Route('/{id}', name: 'app_etat_ressource_delete', methods: ['POST'])]
    // public function delete(Request $request, EtatRessource $etatRessource, EntityManagerInterface $entityManager): Response
    // {
    //     if ($this->isCsrfTokenValid('delete'.$etatRessource->getId(), $request->getPayload()->get('_token'))) {
    //         $entityManager->remove($etatRessource);
    //         $entityManager->flush();
    //     }

    //     return $this->redirectToRoute('app_etat_ressource_index', [], Response::HTTP_SEE_OTHER);
    // }
}
