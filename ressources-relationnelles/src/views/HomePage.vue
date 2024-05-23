<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-buttons slot="start">
          <ion-menu-button color="primary"></ion-menu-button>
        </ion-buttons>
        <ion-title>TITRE</ion-title>
      </ion-toolbar>
    </ion-header>
    
    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Titre</ion-title>
        </ion-toolbar>
      </ion-header>
    
      <div id="container">
        <!-- Loop over each relation type -->
        <div v-for="relation in typeRelations" :key="relation.id">
          <p>{{ relation.nom }}</p>
        </div>
      </div>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { IonButtons, IonContent, IonHeader, IonMenuButton, IonPage, IonTitle, IonToolbar } from '@ionic/vue';
import Ressource from "../components/Ressource.vue";
import { onMounted, ref } from 'vue';
import axios from "axios";
import { API_BASE_URL } from '../config';

const typeRelations = ref(null);

const fetchData = async () => {
  typeRelations.value = null;
  try {
    const response = await axios.get(`${API_BASE_URL}/TypeRelation`);
    console.log(response.data)
    typeRelations.value = response.data;
    console.log(typeRelations.value)
  } catch (error) {
    console.error('Error fetching type relations:', error);
  }
};

onMounted(() => {
  fetchData();
});
</script>

<style scoped>
/* Styles here */
</style>
