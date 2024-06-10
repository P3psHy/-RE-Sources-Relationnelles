<template>
  <div id="ressource-popup" v-if="ressource">
    <p><strong>Titre:</strong> {{ ressource.titre }}</p>
    <p><strong>Description:</strong> {{ ressource.description }}</p>
    <p><strong>Utilisateur:</strong> {{ ressource.utilisateur.nom }} {{ ressource.utilisateur.prenom }}</p>
    <p><strong>Catégorie:</strong> {{ ressource.categorie.nom }}</p>
    <p><strong>Date de publication:</strong> {{ formattedDate }}</p>
    <!--<ion-img src="https://data.by-night.fr/uploads/documents/2018/03/31/5ab6d8e4b0ccc689318332.jpg"></ion-img>--> 
    <!-- Ajoutez d'autres détails de la ressource ici -->
    <ion-button color="danger" @click="closePopUp">Fermer</ion-button>
  </div>
</template>
  
<script setup lang="ts">

  import { IonBackButton, IonContent, IonHeader, IonPage, IonTitle, IonToolbar, IonButtons } from '@ionic/vue';
  import { ref, computed } from 'vue';
  import axios from 'axios';
  import { useRoute } from 'vue-router';
  import { useRouter } from 'vue-router';

  import { API_BASE_URL } from '@/config';
    
  const router = useRouter();

  const route = useRoute();
  const ressource = ref(null);

  // Récupérer la ressource à partir des paramètres de l'URL
  const ressourceId = route.params.idRessource;

  // Simulez la récupération de la ressource depuis une source de données
  const fetchRessource = async () => {
    try {
      const response = await axios.get(`${API_BASE_URL}/ressource/${ressourceId}`, 
        { 
          headers: { 
          'Content-Type': 'application/json'
          }
        });
      ressource.value = response.data;
      console.log(response.data);
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

  const closePopUp = () => {
    router.push("/home")
  }
</script>
  
<style scoped>
/* Styles here */
  #ressource-popup {
    width: 70%;
    height: 70%;
    position: fixed;
    top: 15%;
    left: 15%;
    background-color: white;
    box-shadow: 0px 0px 5px black;
    overflow-y: auto;
  }
</style>
  