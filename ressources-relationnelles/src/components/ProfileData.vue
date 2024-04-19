<template>
  <IonContent>
    <div class="ion-padding">
        <p v-if="premierUtilisateur">Nom: {{ premierUtilisateur.nom }}</p>
        <p v-if="premierUtilisateur">Prénom: {{ premierUtilisateur.prenom }}</p>
        <p v-if="premierUtilisateur">Email: {{ premierUtilisateur.mail }}</p>
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
    computed: {
      premierUtilisateur() {
        return this.utilisateurs.length > 0 ? this.utilisateurs[0] : null;
      }
    },
    mounted() {
      this.fetchUtilisateurs();
    },
    methods: {
      async fetchUtilisateurs() {
        try {
          const response = await axios.get('jsondb/Utilisateurs.json');
          this.utilisateurs = response.data;
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
