<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-img class="logo" src="../sources/Logo application.png"></ion-img>
        <ion-segment value="Accueil">
          <ion-segment-button value="Accueil">Accueil</ion-segment-button>
          <ion-segment-button router-link="/ressource" value="Publier">Publier</ion-segment-button>
          <ion-segment-button router-link="/connect" value="Se connecter">Se connecter</ion-segment-button>
          <ion-segment-button router-link="/profile" value="Mon profil">Mon profil</ion-segment-button>
        </ion-segment>
      </ion-toolbar>
    </ion-header>

    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Blank</ion-title>
        </ion-toolbar>
      </ion-header>

      <div id="container">
        <strong>Cette page est la page d'accueil, on y retrouvera les ressources publiques</strong>
        <p>Start with Ionic <a target="_blank" rel="noopener noreferrer" href="https://ionicframework.com/docs/components">UI Components</a></p>
      </div>
    </ion-content>

    <ion-footer collapse="fade">
      <ion-toolbar>
        <ion-img class="logo" src="../sources/gouvernement-logos-idpqhzX_Mk.png"></ion-img>
      </ion-toolbar>
    </ion-footer>

  </ion-page>
</template>

<script setup lang="ts">
  import { IonContent, IonImg, IonHeader, IonSegment, IonSegmentButton, IonFooter, IonPage, IonTitle, IonToolbar, IonButton } from '@ionic/vue';
</script>

<style scoped>
#container {
  text-align: center;
  
  position: absolute;
  left: 0;
  right: 0;
  top: 50%;
  transform: translateY(-50%);
}

#container strong {
  font-size: 20px;
  line-height: 26px;
}

#container p {
  font-size: 16px;
  line-height: 22px;
  
  color: #8c8c8c;
  
  margin: 0;
}

#container a {
  text-decoration: none;
}

.logo {
  max-width: 5vw;
}
</style>
