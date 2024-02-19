<template>
    <ion-page>
      <Header></Header>

      <ion-content :fullscreen="true">
        <ion-header collapse="condense">
          <ion-toolbar>
            <ion-title size="large">Blank</ion-title>
          </ion-toolbar>
        </ion-header>
  
        <div id="container">
          <strong>Cette page servira à se connecter ou à créer son compte d'utilisateur</strong>
        </div>
      </ion-content>

      <Footer></Footer>
    </ion-page>
  </template>
  
  <script setup lang="ts">
    import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar, IonButton } from '@ionic/vue';
    import Header from '@/components/Header.vue'
    import Footer from '@/components/Footer.vue'

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
  </style>
  