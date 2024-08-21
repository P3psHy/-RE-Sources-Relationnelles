<?php

namespace App\Controller;

use App\Entity\TypeRelation;
use App\Form\TypeRelationType;
use Doctrine\ORM\EntityManagerInterface;
use App\Repository\TypeRelationRepository;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Serializer\SerializerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;

#[Route('/TypeRelation')]
class TypeRelationController extends AbstractController
{
    #[Route('/', name: 'app_type_relation_index', methods: ['GET'])]
    public function index(TypeRelationRepository $typeRelationRepository, SerializerInterface $serializer): JsonResponse
    {

        $categorie = $typeRelationRepository->findAll();

        $json = $serializer->serialize($categorie, 'json', ['groups' => 'TypeRelation']);
        return new JsonResponse($json, Response::HTTP_OK, [], true);
    }

    #[Route('/{id}', name: 'app_type_relation_show', methods: ['GET'])]
    public function show(TypeRelation $typeRelation, SerializerInterface $serializer): Response
    {
        $json = $serializer->serialize($typeRelation, 'json', ['groups' => 'TypeRelation']);
        return new JsonResponse($json, Response::HTTP_OK, [], true);

        
    }




    // #[Route('/new', name: 'app_type_relation_new', methods: ['GET', 'POST'])]
    // public function new(Request $request, EntityManagerInterface $entityManager): Response
    // {
    //     $typeRelation = new TypeRelation();
    //     $form = $this->createForm(TypeRelationType::class, $typeRelation);
    //     $form->handleRequest($request);

    //     if ($form->isSubmitted() && $form->isValid()) {
    //         $entityManager->persist($typeRelation);
    //         $entityManager->flush();

    //         return $this->redirectToRoute('app_type_relation_index', [], Response::HTTP_SEE_OTHER);
    //     }

    //     return $this->render('type_relation/new.html.twig', [
    //         'type_relation' => $typeRelation,
    //         'form' => $form,
    //     ]);
    // }

    

    // #[Route('/{id}/edit', name: 'app_type_relation_edit', methods: ['GET', 'POST'])]
    // public function edit(Request $request, TypeRelation $typeRelation, EntityManagerInterface $entityManager): Response
    // {
    //     $form = $this->createForm(TypeRelationType::class, $typeRelation);
    //     $form->handleRequest($request);

    //     if ($form->isSubmitted() && $form->isValid()) {
    //         $entityManager->flush();

    //         return $this->redirectToRoute('app_type_relation_index', [], Response::HTTP_SEE_OTHER);
    //     }

    //     return $this->render('type_relation/edit.html.twig', [
    //         'type_relation' => $typeRelation,
    //         'form' => $form,
    //     ]);
    // }

    // #[Route('/{id}', name: 'app_type_relation_delete', methods: ['POST'])]
    // public function delete(Request $request, TypeRelation $typeRelation, EntityManagerInterface $entityManager): Response
    // {
    //     if ($this->isCsrfTokenValid('delete'.$typeRelation->getId(), $request->getPayload()->get('_token'))) {
    //         $entityManager->remove($typeRelation);
    //         $entityManager->flush();
    //     }

    //     return $this->redirectToRoute('app_type_relation_index', [], Response::HTTP_SEE_OTHER);
    // }
}
