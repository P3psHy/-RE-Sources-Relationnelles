<template>
    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Blank</ion-title>
        </ion-toolbar>
      </ion-header>
  
      <div id="container">
        <div id="title">
          <h2>Nouvelle Ressource</h2>
        </div>
        <form class="form" id="formulaire">
            <ion-input type="text" placeholder="Titre" id="input_titre"></ion-input>
            <ion-input type="text" placeholder="Type" id="input_type"></ion-input>
            <ion-input type="text" placeholder="Categorie" id="input_cetegorie"></ion-input>
            <ion-textarea placeholder="Description" id="input_description" rows=5></ion-textarea>
            <ion-input type="file" placeholder="Fichier" id="input_fichier"></ion-input>
            <ion-button type="submit" id="submit">Envoyer</ion-button>
        </form>
      </div>
    </ion-content>
  </template>
  
  <script setup lang="ts">
    import { IonContent, IonHeader, IonTitle, IonToolbar, IonTextarea } from '@ionic/vue';
  
  </script>
  
  <style scoped>
  #submit{
    width: 20%;
    margin: auto;
    display: flex;
    justify-content: center;
  }

  #title{
    display: flex;
    justify-content: center;
  }

  #container{
    margin: 10px;
  }

  #input_descritpion{
    overflow: hidden;
  }

  #formulaire{
    padding: 10px;
    border: 1px solid #FFFFFF;
    width: 70%;
    margin-left: auto;
    margin-right: auto;
  }
  </style>
    