<template>
  <ion-card id="ressource">
    <ion-card-header>
      <ion-card-title >{{ ressource.utilisateur.prenom }} {{ ressource.utilisateur.nom }}</ion-card-title>
      <ion-card-subtitle >{{ formattedDate }}</ion-card-subtitle>
    </ion-card-header>
    <ion-card-content @click="navigateToRessource(ressource)">
      <h4 id="titre_ressource">{{ ressource.titre }} </h4>
      <ion-card-subtitle>{{ ressource.categorie.nom }}</ion-card-subtitle>
      <ion-card-content id="description">{{ truncatedDescription }}</ion-card-content>
      <!--<ion-img src="https://data.by-night.fr/uploads/documents/2018/03/31/5ab6d8e4b0ccc689318332.jpg"></ion-img>--> 
    </ion-card-content>
    <ion-button>
      <ion-icon :icon="starOutline"></ion-icon>
      <ion-label v-if="$grid.breakpoint.includes('l')">&nbsp; J'aime</ion-label>
    </ion-button>
    <ion-button>
      <ion-icon :icon="chatbubbleOutline"></ion-icon>
      <ion-label v-if="$grid.breakpoint.includes('l')">&nbsp; Commenter</ion-label>
    </ion-button>
    <ion-button>
      <ion-icon :icon="arrowRedoOutline"></ion-icon>
      <ion-label v-if="$grid.breakpoint.includes('l')">&nbsp; Partager</ion-label>
    </ion-button>
  </ion-card>
</template>

<script setup lang="ts">
  import { IonButton, IonCard, IonCardContent, IonCardHeader, IonCardSubtitle, IonCardTitle, IonImg, IonNavLink, IonLabel, useIonRouter } from '@ionic/vue';
  import { computed, defineProps } from 'vue';
  import { starOutline, chatbubbleOutline, arrowRedoOutline } from 'ionicons/icons';
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

  // Utiliser le router d'Ionic Vue
	const router = useIonRouter();

  // Fonction pour naviguer vers la page de détails de la ressource
  const navigateToRessource = (ressource:any) => {
    router.push({ name: 'VoirRessource', params: { idRessource: ressource.id } });
  };

</script>

<style scoped>

  ion-nav-link {
    height: fit-content;
  }

</style>