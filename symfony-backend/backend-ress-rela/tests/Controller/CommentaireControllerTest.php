<?php

namespace App\Tests\Controller;

use Symfony\Bundle\FrameworkBundle\Test\WebTestCase;

class CommentaireControllerTest extends WebTestCase
{

    public function testGetAllCommentaire(): void
    {
        $client = static::createClient();
        $client->request('GET', '/commentaire/');

        $this->assertResponseIsSuccessful();

        $responseContent = $client->getResponse()->getContent();

        // Décoder le contenu JSON
        $data = json_decode($responseContent, true);
        $this->assertEquals(2,  sizeof($data));

    }


    public function testGetOneCommentaire(): void
    {
        $client = static::createClient();
        $client->request('GET', '/commentaire/1');

        $this->assertResponseIsSuccessful();

        $responseContent = $client->getResponse()->getContent();

        // Décoder le contenu JSON
        $data = json_decode($responseContent, true);
        $this->assertEquals('1',  $data['id']);

    }

    public function testAddOneCommentaire(): void
    {

        $data = [
            'contenu' => 'Ce commentaire vient des test application',
            'id_utilisateur' => 1,
            'id_ressource' => 1
        ];
        $json = json_encode($data);

        $client = static::createClient();
        $client->request(
            'POST',
            '/commentaire/',
            [],
            [],
            ['CONTENT_TYPE' => 'application/json'],
            $json
        );

        $this->assertResponseIsSuccessful();

        $responseContent = $client->getResponse()->getContent();

        // Décoder le contenu JSON
        $data = json_decode($responseContent, true);
        $this->assertEquals('contenu',  $data['Ce commentaire vient des test application']);

    }

    // public function testEditCommentaire(): void
    // {
    //     $data = [
    //         'contenu' => 'Ce commentaire vient des test application et il est modifié'
    //     ];
    //     $json = json_encode($data);

    //     $client = static::createClient();
    //     $client->request(
    //         'PUT',
    //         '/commentaire/3',
    //         [],
    //         [],
    //         ['CONTENT_TYPE' => 'application/json'],
    //         $json
    //     );

    //     $this->assertResponseIsSuccessful();
    // }

    public function testDeleteCommentaire()
    {
        $client = static::createClient();
        $client->request(
            'DELETE',
            '/commentaire/1',
            [],
            [],
            ['CONTENT_TYPE' => 'application/json']
        );

        $this->assertResponseIsSuccessful();
    }



}