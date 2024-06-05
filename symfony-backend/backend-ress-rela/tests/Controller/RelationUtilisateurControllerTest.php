<?php

namespace App\Tests\Controller;

use Symfony\Bundle\FrameworkBundle\Test\WebTestCase;

class RelationUtilisateurControllerTest extends WebTestCase
{

    // public function testGetAllRelationUtilisateur(): void
    // {
    //     $client = static::createClient();
    //     $client->request('GET', '/RelationUtilisateur/');

    //     $this->assertResponseIsSuccessful();

    //     $responseContent = $client->getResponse()->getContent();

    //     // Décoder le contenu JSON
    //     $data = json_decode($responseContent, true);
    //     $this->assertEquals(3,  sizeof($data));

    // }


    // public function testGetOneRelationUtilisateur(): void
    // {
    //     $client = static::createClient();
    //     $client->request('GET', '/RelationUtilisateur/2');

    //     $this->assertResponseIsSuccessful();

    //     $responseContent = $client->getResponse()->getContent();

    //     // Décoder le contenu JSON
    //     $data = json_decode($responseContent, true);
    //     $this->assertEquals('2',  $data['id']);

    // }

    public function testGetListUserRelations(): void
    {
        $client = static::createClient();
        $client->request('GET', '/RelationUtilisateur/user/1');

        $this->assertResponseIsSuccessful();

        $responseContent = $client->getResponse()->getContent();

        // Décoder le contenu JSON
        $data = json_decode($responseContent, true);
        $this->assertEquals(3,  sizeof($data));

    }

    // public function testAddOneRelationUtilisateur(): void
    // {

    //     $data = [
    //         'id_utilisateur1' => 1,
    //         'id_utilisateur2' => 2,
    //         'id_type_relation' => 2

    //     ];
    //     $json = json_encode($data);

    //     $client = static::createClient();
    //     $client->request(
    //         'POST',
    //         '/RelationUtilisateur/',
    //         [],
    //         [],
    //         ['CONTENT_TYPE' => 'application/json'],
    //         $json
    //     );

    //     $this->assertResponseIsSuccessful();

    //     $responseContent = $client->getResponse()->getContent();

    //     // Décoder le contenu JSON
    //     $data = json_decode($responseContent, true);
    //     $this->assertEquals('7',  $data['id']);

    // }

    // // public function testEditRelationUtilisateur(): void
    // // {
    // //     $data = [
    // //     ];
    // //     $json = json_encode($data);

    // //     $client = static::createClient();
    // //     $client->request(
    // //         'PUT',
    // //         '/RelationUtilisateur/3',
    // //         [],
    // //         [],
    // //         ['CONTENT_TYPE' => 'application/json'],
    // //         $json
    // //     );

    // //     $this->assertResponseIsSuccessful();
    // // }

    // public function testDeleteRelationUtilisateur()
    // {
    //     $client = static::createClient();
    //     $client->request(
    //         'DELETE',
    //         '/RelationUtilisateur/7',
    //         [],
    //         [],
    //         ['CONTENT_TYPE' => 'application/json']
    //     );

    //     $this->assertResponseIsSuccessful();
    // }



}