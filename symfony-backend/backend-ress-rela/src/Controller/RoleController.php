<?php

namespace App\Controller;

use App\Entity\Role;
use App\Form\RoleType;
use App\Repository\RoleRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Serializer\SerializerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;

#[Route('/role')]
class RoleController extends AbstractController
{
    #[Route('/', name: 'app_role_index', methods: ['GET'])]
    public function index(RoleRepository $roleRepository, SerializerInterface $serializer): JsonResponse
    {

        $roles = $roleRepository->findAll();

        $jsonRole = $serializer->serialize($roles, 'json', ['groups' => 'Roles']);
        return new JsonResponse($jsonRole, Response::HTTP_OK, [], true);
    }



    #[Route('/{id}', name: 'app_role_show', methods: ['GET'])]
    public function show(Role $role, SerializerInterface $serializer): Response
    {
        $jsonRole = $serializer->serialize($role, 'json', ['groups' => 'Roles']);
        return new JsonResponse($jsonRole, Response::HTTP_OK, [], true);

        
    }



    // #[Route('/new', name: 'app_role_new', methods: ['GET', 'POST'])]
    // public function new(Request $request, EntityManagerInterface $entityManager): Response
    // {
    //     $role = new Role();
    //     $form = $this->createForm(RoleType::class, $role);
    //     $form->handleRequest($request);

    //     if ($form->isSubmitted() && $form->isValid()) {
    //         $entityManager->persist($role);
    //         $entityManager->flush();

    //         return $this->redirectToRoute('app_role_index', [], Response::HTTP_SEE_OTHER);
    //     }

    //     return $this->render('role/new.html.twig', [
    //         'role' => $role,
    //         'form' => $form,
    //     ]);
    // }






    





    // #[Route('/{id}/edit', name: 'app_role_edit', methods: ['GET', 'POST'])]
    // public function edit(Request $request, Role $role, EntityManagerInterface $entityManager): Response
    // {
    //     $form = $this->createForm(RoleType::class, $role);
    //     $form->handleRequest($request);

    //     if ($form->isSubmitted() && $form->isValid()) {
    //         $entityManager->flush();

    //         return $this->redirectToRoute('app_role_index', [], Response::HTTP_SEE_OTHER);
    //     }

    //     return $this->render('role/edit.html.twig', [
    //         'role' => $role,
    //         'form' => $form,
    //     ]);
    // }



    

    // #[Route('/{id}', name: 'app_role_delete', methods: ['DELETE'])]
    // public function delete(Request $request, Role $role, EntityManagerInterface $entityManager): Response
    // {

    //     $entityManager->remove($role);
    //     $entityManager->flush();

    //     return new JsonResponse(null, Response::HTTP_NO_CONTENT);
    // }
}
