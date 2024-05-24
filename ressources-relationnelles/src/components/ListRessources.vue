<template>
  <IonContent>
    <div class="ion-padding">
      <p>Ce composant affichera la liste des ressources de l'utilisateur</p>
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
