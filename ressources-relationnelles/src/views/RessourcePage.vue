<template>
  <ion-content :fullscreen="true">
    <div v-if="$grid.breakpoint.includes('l')" id="container-small">
      <RessourceForm />
    </div>
    <div v-if="!$grid.breakpoint.includes('l')" id="container">
      <RessourceForm />
    </div>
  </ion-content>
</template>

<script setup lang="ts">
  import { IonContent, IonHeader, IonTitle, IonToolbar, IonButton } from '@ionic/vue';
  import RessourceForm from '@/components/RessourceForm.vue';

  import { onMounted, ref } from 'vue';
  import axios from "axios";
  import { API_BASE_URL } from '../config';

  // Récupération des infos de l'utilisateur courant

  onMounted(() => {
    
  });

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

  #container-small {
    text-align: center;
    position: absolute;
    left: 25%;
    right: 0;
    top: 50%;
    transform: translateY(-50%);
    width: 50%;
  }

  #container strong {
    font-size: 20px;
    line-height: 26px;
  }

  #container-small strong {
    font-size: 20px;
    line-height: 26px;
  }

  #container p {
    font-size: 16px;
    line-height: 22px;
    color: #8c8c8c;
    margin: 0;
  }

  #container-small p {
    font-size: 16px;
    line-height: 22px;
    color: #8c8c8c;
    margin: 0;
  }

  #container a {
    text-decoration: none;
  }

  #container-small a {
    text-decoration: none;
  }

  body{
    color : white !important;
  }
</style>
  