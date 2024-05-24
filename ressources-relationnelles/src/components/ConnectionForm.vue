<template>
<h2>Se connecter</h2>
<form @submit.prevent="submitForm">
    <ion-input v-model="login" placeholder="Login" required></ion-input>
    <ion-input type="password" v-model="password" placeholder="Password" required></ion-input>
    <ion-button type="submit">Submit</ion-button>
  </form>
  <ion-button @click="clearCache" color="danger">Vider le cache</ion-button>
  <ion-button @click="checkStorage">Vérifier le stockage des données</ion-button>
  <ion-button router-link="inscription">Inscription</ion-button>
  <!-- Afficher les données récupérées -->
  <div v-if="userData">
    <h3>User Data:</h3>
    <pre>{{ userData }}</pre>
  </div>
</template>

<script setup lang="ts">
  import { IonInput, IonButton } from '@ionic/vue';
  import { ref } from 'vue';
  import { useRouter } from 'vue-router';
  import axios from 'axios';
  import { Preferences } from '@capacitor/preferences';
  import {API_BASE_URL} from '../config'

  // État pour les champs du formulaire
  const login = ref('');
  const password = ref('');

  // État pour les données utilisateur récupérées
  const userData = ref(null);

  // Utiliser le routeur de Vue pour la redirection après la connexion
  const router = useRouter();

  // Fonction pour gérer la soumission du formulaire
  const submitForm = async () => {
    try {
      const response = await axios.post(`${API_BASE_URL}/utilisateur/user/CheckUser`, {
          login: login.value,
          password: password.value      
      }, { headers: { 
        'Content-Type': 'multipart/form-data'
      }
      });
      // console.log(response.data)




      if (response.data) {
        console.log(response.data)
        userData.value = response.data.user;
        const data = response.data;
        for(const key in data){
          const value = data[key]
          Preferences.set({key, value})
          console.log("Saved data : ", key, value)
        }
        // Ajouter les infos utilisateur en storage
        router.push('/home');
      } else {
        alert(response.data.value);
      }
    } catch (error) {
      console.error('Error logging in:', error);
      alert('An error occurred. Please try again.');
    }
  };

  const clearCache = () => {
    Preferences.clear()
    console.log("Cache vidé")
  }

  const checkStorage = () => {
    console.log("test")
    console.log(Preferences.keys(), Preferences.keys)
    for(const key in Preferences.keys()){
      Preferences.get({key}).then(result => {
        console.log("retreived data : ", key, result.value)
      })
    }
  }
</script>
  














  <style scoped>

  #formulaire{
    padding: 10px;
    border: 1px solid #FFFFFF;
    width: 70%;
    margin-left: auto;
    margin-right: auto;
  }

  #title{
    font-size: 20px;
    line-height: 26px;
    
    color: #FFFFFF;
    margin-bottom: 5%;
  }
  
  </style>
  