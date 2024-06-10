<?php

namespace App\Tests\Controller;

use Symfony\Bundle\FrameworkBundle\Test\WebTestCase;

class RessourceControllerTest extends WebTestCase
{

    public function testGetAllRessource(): void
    {
        $client = static::createClient();
        $client->request('GET', '/ressource/');

        $this->assertResponseIsSuccessful();

        $responseContent = $client->getResponse()->getContent();

        // Décoder le contenu JSON
        $data = json_decode($responseContent, true);
        $this->assertEquals(3,  sizeof($data));

    }


    public function testGetOneRessource(): void
    {
        $client = static::createClient();
        $client->request('GET', '/ressource/1');

        $this->assertResponseIsSuccessful();

        $responseContent = $client->getResponse()->getContent();

        // Décoder le contenu JSON
        $data = json_decode($responseContent, true);
        $this->assertEquals('1',  $data['id']);

    }


    public function testGetAllRessourceFromUser(): void
    {
        $client = static::createClient();
        $client->request('GET', '/ressource/ressources-user/1');

        $this->assertResponseIsSuccessful();

        $responseContent = $client->getResponse()->getContent();

        // Décoder le contenu JSON
        $data = json_decode($responseContent, true);
        $this->assertEquals(2,  sizeof($data));

    }


    public function testAddOneRessource(): void
    {

        $data = [
            'titre' => 'Ressource venant d\'un test',
            'description' => 'pas grand chose à dire à part que c\'est un test',
            'id_utilisateur' => 2,
            'id_categorie' => 2,
            'id_type_ressource' => 3,
            'ids_type_relation'=> [2,3]
        ];
        $json = json_encode($data);

        $client = static::createClient();
        $client->request(
            'POST',
            '/ressource/',
            [],
            [],
            ['CONTENT_TYPE' => 'application/json'],
            $json
        );

        $this->assertResponseIsSuccessful();

        $responseContent = $client->getResponse()->getContent();

        // Décoder le contenu JSON
        $data = json_decode($responseContent, true);
        $this->assertEquals('Ressource venant d\'un test',  $data['titre']);

    }


    public function testEditRessource(): void
    {
        $data = [
            'titre' => 'J`ai modifié le titre pour voir'
        ];
        $json = json_encode($data);

        $client = static::createClient();
        $client->request(
            'PUT',
            '/ressource/4',
            [],
            [],
            ['CONTENT_TYPE' => 'application/json'],
            $json
        );

        $this->assertResponseIsSuccessful();
    }
    

    public function testDeleteRessource()
    {
        $client = static::createClient();
        $client->request(
            'DELETE',
            '/ressource/3',
            [],
            [],
            ['CONTENT_TYPE' => 'application/json']
        );

        $this->assertResponseIsSuccessful();
    }



}