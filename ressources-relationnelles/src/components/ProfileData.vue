<template>
  <IonContent>
      <div class="ion-padding">
          <h1>Mon profil</h1>
          <label>Prénom</label>
          <p>{{ jsonData.prenom}}</p>
          <label>Nom</label>
          <p>{{ jsonData.nom }}</p>
          <label>Email</label>
          <p>{{ jsonData.mail }}</p>
          <ion-button>Changer le mot de passe</ion-button>
          <p></p>
          <ion-button>Supprimer le compte</ion-button>
      </div>
  </IonContent>
</template>

<script setup lang="ts">
import { IonContent } from '@ionic/vue';
import axios from 'axios';
import {reactive, onMounted} from 'vue';

const jsonData = reactive({
  nom: '',
  prenom: '',
  mail: ''
});

axios.get('jsondb/Utilisateurs.json')
    .then((response) => {
      console.log(response.data[0]);
      jsonData.nom = response.data[0].nom;
      jsonData.prenom = response.data[0].prenom;
      jsonData.mail = response.data[0].mail;
    });

</script>

<style scoped>
.ion-padding {
text-align: center;
padding: 1rem;
margin-left: auto;
margin-right: auto;
}
</style>
