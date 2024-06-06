<?php

namespace App\Tests\Controller;

use Symfony\Bundle\FrameworkBundle\Test\WebTestCase;

class ReponseControllerTest extends WebTestCase
{

    public function testGetAllReponse(): void
    {
        $client = static::createClient();
        $client->request('GET', '/reponse/');

        $this->assertResponseIsSuccessful();

        $responseContent = $client->getResponse()->getContent();

        // Décoder le contenu JSON
        $data = json_decode($responseContent, true);
        $this->assertEquals(1,  sizeof($data));

    }


    public function testGetOneReponse(): void
    {
        $client = static::createClient();
        $client->request('GET', '/reponse/1');

        $this->assertResponseIsSuccessful();

        $responseContent = $client->getResponse()->getContent();

        // Décoder le contenu JSON
        $data = json_decode($responseContent, true);
        $this->assertEquals('1',  $data['id']);

    }


    public function testAddOneReponse(): void
    {

        $data = [
            'contenu' => 'reponse venant des test',
            'id_utilisateur' => 1,
            'id_commentaire' => 2
        ];
        $json = json_encode($data);

        $client = static::createClient();
        $client->request(
            'POST',
            '/reponse/',
            [],
            [],
            ['CONTENT_TYPE' => 'application/json'],
            $json
        );

        $this->assertResponseIsSuccessful();

        $responseContent = $client->getResponse()->getContent();

        // Décoder le contenu JSON
        $data = json_decode($responseContent, true);
        $this->assertEquals('reponse venant des test',  $data['contenu']);

    }

    // // public function testEditReponse(): void
    // // {
    // //     $data = [
    // //         'contenu' => 'ce message est destiné à l\'utilisateur 2 et il est modifié par les test'
    // //     ];
    // //     $json = json_encode($data);

    // //     $client = static::createClient();
    // //     $client->request(
    // //         'PUT',
    // //         '/MessageUtilisateur/3',
    // //         [],
    // //         [],
    // //         ['CONTENT_TYPE' => 'application/json'],
    // //         $json
    // //     );

    // //     $this->assertResponseIsSuccessful();
    // // }

    public function testDeleteReponse()
    {
        $client = static::createClient();
        $client->request(
            'DELETE',
            '/reponse/2',
            [],
            [],
            ['CONTENT_TYPE' => 'application/json']
        );

        $this->assertResponseIsSuccessful();
    }



}