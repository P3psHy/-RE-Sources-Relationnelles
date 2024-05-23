<template>
  <IonContent>
    <h2>OKOKOK</h2>
      <h1 v-if="ressources[0]">{{ressources[0].titre}}</h1> 
      <div id="relations">
        <label>Description</label>
        <p></p>
      </div>
        <label>Catégorie</label>
        <p></p>
      <ion-button router-link="/profile/data" value="Data">Mes informations</ion-button> 
  </IonContent>
</template>
  
<script>
    import { IonImg, IonHeader, IonSegment, IonSegmentButton, IonToolbar, IonButton, IonContent} from '@ionic/vue';
    import axios from 'axios';

    export default {
    components: { IonButton, IonContent },
    data() {
      return {
        ressources: []
      };
    },
    mounted() {
      this.fetchRessources();
    },
    methods: {
      async fetchRessources() {
        try {
          const response = await axios.get('jsondb/Ressources.json');
          console.log(response.data);
          this.ressources = response.data;
        } catch (error) {
          console.error('Erreur lors du chargement des ressources:', error);
        }
      }
    }
  };
    
</script>

<style scoped>
    ion-header {
        background-color: #03989E;
    }

    h1 {
      color: white;
      font-size: 3vw;
      font-weight: bold;
      text-align: center;
      margin-top: 10px;
    }

    #header-logo {
        max-width: 5vw;
        cursor: pointer;
    }
</style>
  