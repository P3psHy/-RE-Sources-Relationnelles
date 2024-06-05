<?php

namespace App\Tests\Controller;

use Symfony\Bundle\FrameworkBundle\Test\WebTestCase;

class EtatRessourceControllerTest extends WebTestCase
{

    public function testGetAllEtatRessourc(): void
    {
        $client = static::createClient();
        $client->request('GET', '/EtatRessource/');

        $this->assertResponseIsSuccessful();

        $responseContent = $client->getResponse()->getContent();

        // Décoder le contenu JSON
        $data = json_decode($responseContent, true);
        $this->assertEquals(4,  sizeof($data));

    }


    public function testGetOneEtatRessourc(): void
    {
        $client = static::createClient();
        $client->request('GET', '/EtatRessource/13');

        $this->assertResponseIsSuccessful();

        $responseContent = $client->getResponse()->getContent();

        // Décoder le contenu JSON
        $data = json_decode($responseContent, true);
        $this->assertEquals('Publiée',  $data['nom']);

    }

    // public function testAddOneEtatRessourc(): void
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

    // public function testEditEtatRessource(): void
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

    //     $this->assertResponseIsEtatRessourc();
    // }

    // public function testDeleteEtatRessourc()
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