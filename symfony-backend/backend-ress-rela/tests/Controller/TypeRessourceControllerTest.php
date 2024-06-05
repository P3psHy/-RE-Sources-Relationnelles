<?php

namespace App\Tests\Controller;

use Symfony\Bundle\FrameworkBundle\Test\WebTestCase;

class TypeRessourceControllerTest extends WebTestCase
{

    public function testGetAllTypeRessource(): void
    {
        $client = static::createClient();
        $client->request('GET', '/TypeRessource/');

        $this->assertResponseIsSuccessful();

        $responseContent = $client->getResponse()->getContent();

        // Décoder le contenu JSON
        $data = json_decode($responseContent, true);
        $this->assertEquals(8,  sizeof($data));

    }


    public function testGetOneTypeRessource(): void
    {
        $client = static::createClient();
        $client->request('GET', '/TypeRessource/2');

        $this->assertResponseIsSuccessful();

        $responseContent = $client->getResponse()->getContent();

        // Décoder le contenu JSON
        $data = json_decode($responseContent, true);
        $this->assertEquals('Article',  $data['nom']);

    }

    // public function testAddOneTypeRessource(): void
    // {

    //     $data = [
    //         'nom' => 'test'
    //     ];
    //     $json = json_encode($data);

    //     $client = static::createClient();
    //     $client->request(
    //         'POST',
    //         '/categorie/',
    //         [],
    //         [],
    //         ['CONTENT_TYPE' => 'application/json'],
    //         $json
    //     );

    //     $this->assertResponseIsSuccessful();

    //     $responseContent = $client->getResponse()->getContent();

    //     // Décoder le contenu JSON
    //     $data = json_decode($responseContent, true);
    //     $this->assertEquals('test',  $data['nom']);

    // }

    // public function testEditTypeRessource(): void
    // {
    //     $data = [
    //         'nom' => 'testUpdate'
    //     ];
    //     $json = json_encode($data);

    //     $client = static::createClient();
    //     $client->request(
    //         'PUT',
    //         '/categorie/14',
    //         [],
    //         [],
    //         ['CONTENT_TYPE' => 'application/json'],
    //         $json
    //     );

    //     $this->assertResponseIsSuccessful();
    // }

    // public function testDeleteTypeRessource()
    // {
    //     $client = static::createClient();
    //     $client->request(
    //         'DELETE',
    //         '/categorie/14',
    //         [],
    //         [],
    //         ['CONTENT_TYPE' => 'application/json']
    //     );

    //     $this->assertResponseIsSuccessful();
    // }



}