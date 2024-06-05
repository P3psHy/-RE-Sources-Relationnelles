<?php

namespace App\Tests\Controller;

use Symfony\Bundle\FrameworkBundle\Test\WebTestCase;

class CategorieControllerTest extends WebTestCase
{

    public function testGetAllCategorie(): void
    {
        $client = static::createClient();
        $client->request('GET', '/categorie/');

        $this->assertResponseIsSuccessful();

        $responseContent = $client->getResponse()->getContent();

        // Décoder le contenu JSON
        $data = json_decode($responseContent, true);
        $this->assertEquals(13,  sizeof($data));

    }


    public function testGetOneCategorie(): void
    {
        $client = static::createClient();
        $client->request('GET', '/categorie/1');

        $this->assertResponseIsSuccessful();

        $responseContent = $client->getResponse()->getContent();

        // Décoder le contenu JSON
        $data = json_decode($responseContent, true);
        $this->assertEquals('Communication',  $data['nom']);

    }

    public function testAddOneCategorie(): void
    {

        $data = [
            'nom' => 'test'
        ];
        $json = json_encode($data);

        $client = static::createClient();
        $client->request(
            'POST',
            '/categorie/',
            [],
            [],
            ['CONTENT_TYPE' => 'application/json'],
            $json
        );

        $this->assertResponseIsSuccessful();

        $responseContent = $client->getResponse()->getContent();

        // Décoder le contenu JSON
        $data = json_decode($responseContent, true);
        $this->assertEquals('test',  $data['nom']);

    }

    public function testEditCategorie(): void
    {
        $data = [
            'nom' => 'testUpdate'
        ];
        $json = json_encode($data);

        $client = static::createClient();
        $client->request(
            'PUT',
            '/categorie/14',
            [],
            [],
            ['CONTENT_TYPE' => 'application/json'],
            $json
        );

        $this->assertResponseIsSuccessful();
    }

    public function testDeleteCategorie()
    {
        $client = static::createClient();
        $client->request(
            'DELETE',
            '/categorie/14',
            [],
            [],
            ['CONTENT_TYPE' => 'application/json']
        );

        $this->assertResponseIsSuccessful();
    }



}