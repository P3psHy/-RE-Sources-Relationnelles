<?php

namespace App\Tests\Controller;

use Symfony\Bundle\FrameworkBundle\Test\WebTestCase;

class MessageUtilisateurControllerTest extends WebTestCase
{

    public function testGetAllMessageUtilisateur(): void
    {
        $client = static::createClient();
        $client->request('GET', '/MessageUtilisateur/');

        $this->assertResponseIsSuccessful();

        $responseContent = $client->getResponse()->getContent();

        // Décoder le contenu JSON
        $data = json_decode($responseContent, true);
        $this->assertEquals(2,  sizeof($data));

    }


    public function testGetOneMessageUtilisateur(): void
    {
        $client = static::createClient();
        $client->request('GET', '/MessageUtilisateur/2');

        $this->assertResponseIsSuccessful();

        $responseContent = $client->getResponse()->getContent();

        // Décoder le contenu JSON
        $data = json_decode($responseContent, true);
        $this->assertEquals('2',  $data['id']);

    }

    public function testAddOneMessageUtilisateur(): void
    {

        $data = [
            'contenu' => 'ce message est destiné à l\'utilisateur 2',
            'id_utilisateur1' => 1,
            'id_utilisateur2' => 2
        ];
        $json = json_encode($data);

        $client = static::createClient();
        $client->request(
            'POST',
            '/MessageUtilisateur/',
            [],
            [],
            ['CONTENT_TYPE' => 'application/json'],
            $json
        );

        $this->assertResponseIsSuccessful();

        $responseContent = $client->getResponse()->getContent();

        // Décoder le contenu JSON
        $data = json_decode($responseContent, true);
        $this->assertEquals('ce message est destiné à l\'utilisateur 2',  $data['contenu']);

    }

    public function testEditMessageUtilisateur(): void
    {
        $data = [
            'contenu' => 'ce message est destiné à l\'utilisateur 2 et il est modifié par les test'
        ];
        $json = json_encode($data);

        $client = static::createClient();
        $client->request(
            'PUT',
            '/MessageUtilisateur/3',
            [],
            [],
            ['CONTENT_TYPE' => 'application/json'],
            $json
        );

        $this->assertResponseIsSuccessful();
    }

    public function testDeleteMessageUtilisateur()
    {
        $client = static::createClient();
        $client->request(
            'DELETE',
            '/MessageUtilisateur/1',
            [],
            [],
            ['CONTENT_TYPE' => 'application/json']
        );

        $this->assertResponseIsSuccessful();
    }



}