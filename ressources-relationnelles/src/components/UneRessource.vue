<template>
    <div id="container" v-if="ressource">
      <p><strong>Titre:</strong> {{ ressource.titre }}</p>
      <p><strong>Description:</strong> {{ ressource.description }}</p>
      <p><strong>Utilisateur:</strong> {{ ressource.utilisateur.nom }} {{ ressource.utilisateur.prenom }}</p>
      <p><strong>Catégorie:</strong> {{ ressource.categorie.nom }}</p>
      <p><strong>Date de publication:</strong> {{ formattedDate }}</p>
      <!--<ion-img src="https://data.by-night.fr/uploads/documents/2018/03/31/5ab6d8e4b0ccc689318332.jpg"></ion-img>--> 
      <!-- Ajoutez d'autres détails de la ressource ici -->
    </div>
  </template>
  
  <script setup lang="ts">

import { IonBackButton, IonContent, IonHeader, IonPage, IonTitle, IonToolbar, IonButtons } from '@ionic/vue';
import { ref, computed } from 'vue';
import axios from 'axios';
import { useRoute } from 'vue-router';

const route = useRoute();
const ressource = ref(null);

// Récupérer la ressource à partir des paramètres de l'URL
const ressourceId = route.params.idRessource;

// Simulez la récupération de la ressource depuis une source de données
const fetchRessource = async () => {
  try {
    const response = await axios.get('jsondb/Ressources.json');
    const ressourcesData = response.data;

    // Recherche de la ressource avec l'ID correspondant
    ressource.value = ressourcesData.find(r => r.idRessource === parseInt(ressourceId));
  } catch (error) {
    console.error('Erreur lors de la récupération de la ressource :', error);
  }
};

fetchRessource();

// Formater la date de publication
const formattedDate = computed(() => {
  if (ressource.value) {
    const date = new Date(ressource.value.datePublication);
    const day = date.getDate().toString().padStart(2, '0');
    const month = (date.getMonth() + 1).toString().padStart(2, '0');
    const year = date.getFullYear();
    return `${day}/${month}/${year}`;
  }
  return '';
});


  /* import { IonBackButton, IonContent, IonHeader, IonPage, IonTitle, IonToolbar } from '@ionic/vue';
  import { ref, computed } from 'vue';
  import axios from 'axios';
    import { useRouter } from 'vue-router';
  
  const router = useRouter();
  const ressource = ref(null);
  
  // Récupérer la ressource à partir des paramètres de l'URL
  const route = router.currentRoute.value;
  const ressourceId = route.params.idRessource;
  
  // Simulez la récupération de la ressource depuis une source de données
  // Vous devez récupérer la ressource à partir de votre backend ou de votre magasin de données approprié
  const fetchRessource = async () => {
  try {
    const response = await axios.get('jsondb/Ressources.json');
    const ressourcesData = response.data;
    const ressourceId = route.params.idRessource;
    
    // Recherche de la ressource avec l'ID correspondant
    ressource.value = ressourcesData.find(r => r.idRessource === parseInt(ressourceId));
  } catch (error) {
    console.error('Erreur lors de la récupération de la ressource :', error);
  }
};
  
  fetchRessource();
  
  // Formater la date de publication
  const formattedDate = computed(() => {
    if (ressource.value) {
      const date = new Date(ressource.value.datePublication);
      const day = date.getDate().toString().padStart(2, '0');
      const month = (date.getMonth() + 1).toString().padStart(2, '0');
      const year = date.getFullYear();
      return `${day}/${month}/${year}`;
    }
    return '';
  }); */
  </script>
  
  <style scoped>
  /* Styles here */
  p{ 
    color: white;
  }
  </style>
  