<template>
    <ion-card id="ressource">
      <ion-card-title v-if="ressource">{{ ressource.utilisateur.prenom }} {{ ressource.utilisateur.nom }}</ion-card-title>
      <ion-card-subtitle v-if="ressource">{{ formattedDate }}</ion-card-subtitle>
      <h4 v-if="ressource" id="titre_ressource">{{ ressource.titre }} </h4>
      <ion-card-subtitle v-if="ressource">{{ ressource.categorie.nom }}</ion-card-subtitle>
      <ion-card-content v-if="ressource" id="description">{{ truncatedDescription }}</ion-card-content>
      <!--<ion-img v-if="ressource" src="https://data.by-night.fr/uploads/documents/2018/03/31/5ab6d8e4b0ccc689318332.jpg"></ion-img> -->
      </ion-card>
</template>

<script setup lang="ts">
import { IonButton, IonCard, IonCardContent, IonCardHeader, IonCardSubtitle, IonCardTitle, IonImg } from '@ionic/vue';
import { computed, defineProps } from 'vue';
import Vue from 'vue';

const props = defineProps({
  ressource: {
    type: Object,
    required: true
  }
});

// Limite de caractères pour la description
const descriptionLimit = 100;

// Computed property pour tronquer la description
const truncatedDescription = computed(() => {
  if (props.ressource.description.length > descriptionLimit) {
    return props.ressource.description.slice(0, descriptionLimit) + '...';
  }
  return props.ressource.description;
});
// Computed property pour formater la date
const formattedDate = computed(() => {
  const date = new Date(props.ressource.datePublication);
  const day = date.getDate().toString().padStart(2, '0');
  const month = (date.getMonth() + 1).toString().padStart(2, '0');
  const year = date.getFullYear();
  return `${day}/${month}/${year}`;
});

/* import { IonButtons, IonContent, IonHeader, IonMenuButton, IonPage, IonTitle, IonToolbar } from '@ionic/vue';
import { onMounted, ref } from 'vue';
import axios from "axios";

const ressource = ref(null);

const fetchData = async () => {
  ressource.value = null;
  try {
    const response = await axios.get("jsondb/ressource.json");
    ressource.value = response.data;
    console.log(ressource.value)
  } catch (error) {
    console.error('Error fetching ressource:', error);
  }
};

onMounted(() => {
  fetchData();
}); */
</script>

<style scoped>

</style>