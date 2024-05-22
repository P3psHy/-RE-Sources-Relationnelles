<?php

namespace App\Controller;

use App\Entity\TypeRessource;
use App\Form\TypeRessourceType;
use Doctrine\ORM\EntityManagerInterface;
use App\Repository\TypeRessourceRepository;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Serializer\SerializerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;

#[Route('/TypeRessource')]
class TypeRessourceController extends AbstractController
{
    #[Route('/', name: 'app_type_ressource_index', methods: ['GET'])]
    public function index(TypeRessourceRepository $typeRessourceRepository,  SerializerInterface $serializer): Response
    {
        $typeRessource = $typeRessourceRepository->findAll();

        $json = $serializer->serialize($typeRessource, 'json', ['groups' => 'TypeRessource']);
        return new JsonResponse($json, Response::HTTP_OK, [], true);
    }


    #[Route('/{id}', name: 'app_type_ressource_show', methods: ['GET'])]
    public function show(TypeRessource $typeRessource, SerializerInterface $serializer): Response
    {
        $jsonRole = $serializer->serialize($typeRessource, 'json', ['groups' => 'TypeRessource']);
        return new JsonResponse($jsonRole, Response::HTTP_OK, [], true);

        
    }



    // #[Route('/new', name: 'app_type_ressource_new', methods: ['GET', 'POST'])]
    // public function new(Request $request, EntityManagerInterface $entityManager): Response
    // {
    //     $typeRessource = new TypeRessource();
    //     $form = $this->createForm(TypeRessourceType::class, $typeRessource);
    //     $form->handleRequest($request);

    //     if ($form->isSubmitted() && $form->isValid()) {
    //         $entityManager->persist($typeRessource);
    //         $entityManager->flush();

    //         return $this->redirectToRoute('app_type_ressource_index', [], Response::HTTP_SEE_OTHER);
    //     }

    //     return $this->render('type_ressource/new.html.twig', [
    //         'type_ressource' => $typeRessource,
    //         'form' => $form,
    //     ]);
    // }

    
    // #[Route('/{id}/edit', name: 'app_type_ressource_edit', methods: ['GET', 'POST'])]
    // public function edit(Request $request, TypeRessource $typeRessource, EntityManagerInterface $entityManager): Response
    // {
    //     $form = $this->createForm(TypeRessourceType::class, $typeRessource);
    //     $form->handleRequest($request);

    //     if ($form->isSubmitted() && $form->isValid()) {
    //         $entityManager->flush();

    //         return $this->redirectToRoute('app_type_ressource_index', [], Response::HTTP_SEE_OTHER);
    //     }

    //     return $this->render('type_ressource/edit.html.twig', [
    //         'type_ressource' => $typeRessource,
    //         'form' => $form,
    //     ]);
    // }

    // #[Route('/{id}', name: 'app_type_ressource_delete', methods: ['POST'])]
    // public function delete(Request $request, TypeRessource $typeRessource, EntityManagerInterface $entityManager): Response
    // {
    //     if ($this->isCsrfTokenValid('delete'.$typeRessource->getId(), $request->getPayload()->get('_token'))) {
    //         $entityManager->remove($typeRessource);
    //         $entityManager->flush();
    //     }

    //     return $this->redirectToRoute('app_type_ressource_index', [], Response::HTTP_SEE_OTHER);
    // }
}
