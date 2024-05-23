<template>
  <IonContent>
    <div class="ion-padding">
      <p v-if="utilisateurs.length > 0">Nom: {{ utilisateurs[0].nom }}</p>
      <p v-if="utilisateurs.length > 0">Prénom: {{ utilisateurs[0].prenom }}</p>
      <p v-if="utilisateurs.length > 0">Email: {{ utilisateurs[0].mail }}</p>
        <ion-button>Changer le mot de passe</ion-button>
        <p></p>
        <ion-button>Supprimer le compte</ion-button>
    </div>
  </IonContent>
</template>

<script>
  import axios from 'axios';

  import { IonButton, IonContent } from '@ionic/vue';
  import { defineComponent } from 'vue';

  export default {
    components: { IonButton, IonContent },
    data() {
      return {
        utilisateurs: []
      };
    },
    mounted() {
      this.fetchUtilisateurs();
    },
    methods: {
      fetchUtilisateurs() {
        try {
          axios.get('jsondb/Utilisateurs.json').then(response => {
            this.utilisateurs = response.data;
          });
        } catch (error) {
          console.error('Erreur lors du chargement des utilisateurs:', error);
        }
      }

    }
  };
</script>

<style scoped>
  .ion-padding {
      text-align: center;
      padding: 1rem;
      margin-left: auto;
      margin-right: auto;
  }
</style>
