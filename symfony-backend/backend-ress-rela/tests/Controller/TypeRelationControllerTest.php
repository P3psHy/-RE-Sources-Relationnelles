<?php

namespace App\Tests\Controller;

use Symfony\Bundle\FrameworkBundle\Test\WebTestCase;

class TypeRelationControllerTest extends WebTestCase
{

    public function testGetAllTypeRelation(): void
    {
        $client = static::createClient();
        $client->request('GET', '/TypeRelation/');

        $this->assertResponseIsSuccessful();

        $responseContent = $client->getResponse()->getContent();

        // Décoder le contenu JSON
        $data = json_decode($responseContent, true);
        $this->assertEquals(6,  sizeof($data));

    }


    public function testGetOneTypeRelation(): void
    {
        $client = static::createClient();
        $client->request('GET', '/TypeRelation/1');

        $this->assertResponseIsSuccessful();

        $responseContent = $client->getResponse()->getContent();

        // Décoder le contenu JSON
        $data = json_decode($responseContent, true);
        $this->assertEquals('Soi',  $data['nom']);

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