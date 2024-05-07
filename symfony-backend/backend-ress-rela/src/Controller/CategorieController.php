<?php

namespace App\Controller;

use App\Entity\Categorie;
use App\Form\CategorieType;
use App\Repository\CategorieRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Serializer\SerializerInterface;
use Symfony\Component\Routing\Generator\UrlGeneratorInterface;
use Symfony\Component\Serializer\Normalizer\AbstractNormalizer;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;

#[Route('/categorie')]
class CategorieController extends AbstractController
{
    #[Route('/', name: 'app_categorie_index', methods: ['GET'])]
    public function index(CategorieRepository $categorieRepository, SerializerInterface $serializer): JsonResponse
    {
        
        $categorie = $categorieRepository->findAll();

        $jsonCategorie = $serializer->serialize($categorie, 'json', ['groups' => 'Categorie']);
        return new JsonResponse($jsonCategorie, Response::HTTP_OK, [], true);
    }



    #[Route('/{id}', name: 'app_categorie_show', methods: ['GET'])]
    public function show(Categorie $categorie, SerializerInterface $serializer): Response
    {
        $jsonCategorie = $serializer->serialize($categorie, 'json', ['groups' => 'Categorie']);
        return new JsonResponse($jsonCategorie, Response::HTTP_OK, [], true);

        
    }



    #[Route('/', name: 'app_categorie_new', methods: ['POST'])]
    public function new(Request $request, SerializerInterface $serializer, EntityManagerInterface $em, UrlGeneratorInterface $urlGenerator): JsonResponse
    {

        $categorie = $serializer->deserialize($request->getContent(), Categorie::class, 'json');
        
        $em->persist($categorie);
        $em->flush();

        $jsonCategorie = $serializer->serialize($categorie, 'json', ['groups' => 'Categorie']);
        $location = $urlGenerator->generate('app_categorie_show', ['id' => $categorie->getId()], UrlGeneratorInterface::ABSOLUTE_URL);
        return new JsonResponse($jsonCategorie, Response::HTTP_CREATED, ["Location" => $location], true);
    }

    

    #[Route('/{id}', name: 'app_categorie_edit', methods: ['PUT'])]
    public function edit(Request $request, SerializerInterface $serializer, Categorie $currentCategorie, EntityManagerInterface $em): JsonResponse 
    {
        $updatedRessource = $serializer->deserialize($request->getContent(), 
                Categorie::class, 
                'json', 
                [AbstractNormalizer::OBJECT_TO_POPULATE => $currentCategorie]);
        
        $em->persist($updatedRessource);
        $em->flush();
        
        return new JsonResponse(null, JsonResponse::HTTP_NO_CONTENT);
   }

    #[Route('/{id}', name: 'app_categorie_delete', methods: ['DELETE'])]
    public function delete(Request $request, Categorie $categorie, EntityManagerInterface $entityManager): Response
    {

        $entityManager->remove($categorie);
        $entityManager->flush();

        return new JsonResponse(null, Response::HTTP_NO_CONTENT);
    }
}
