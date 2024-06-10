<template>
<h2>Se connecter</h2>
<form @submit.prevent="submitForm">
    <ion-input v-model="login" placeholder="Email" required></ion-input>
    <ion-input type="password" v-model="password" placeholder="Mot de passe" required></ion-input>
    <ion-button type="submit">Se connecter</ion-button>
  </form>
  <hr/>
  <!-- <ion-button @click="clearCache" color="danger">Vider le cache</ion-button>
  <ion-button @click="checkStorage">Vérifier le stockage des données</ion-button> -->
  <ion-button router-link="inscription">Inscription</ion-button>
  <!-- Afficher les données récupérées -->
  <div v-if="userData">
    <h3>User Data:</h3>
    <pre>{{ userData }}</pre>
  </div>
</template>

<script setup lang="ts">
  import { IonInput, IonButton } from '@ionic/vue';
  import { onMounted, ref } from 'vue';
  import { useRouter } from 'vue-router';
  import axios from 'axios';
  import { Preferences } from '@capacitor/preferences';
  import {API_BASE_URL} from '../config'
  import { Device } from '@capacitor/device';

  // État pour les champs du formulaire
  const login = ref('');
  const password = ref('');

  // État pour les données utilisateur récupérées
  const userData = ref(null);

  // Utiliser le routeur de Vue pour la redirection après la connexion
  const router = useRouter();

  const deviceType = ref(null);

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
        if(data.role.id != 1 && (deviceType.value == "android" || deviceType.value == "iPhone")){
          alert("Vous ne pouvez pas vous connecter en tant qu'administrateur ou modérateur depuis ce type d'appareil.")
          return;
        }
        Preferences.set({key: "id_utilisateur", value: data.id})
        Preferences.set({key: "nom_utilisateur", value: data.nom})
        Preferences.set({key: "prenom_utilisateur", value: data.prenom})
        Preferences.set({key: "mail_utilisateur", value: data.mail})
        Preferences.set({key: "departement_utilisateur", value: data.departement})
        Preferences.set({key: "est_active_utilisateur", value: data.est_active})
        Preferences.set({key: "role_utilisateur", value: data.role.id})
        // Ajouter les infos utilisateur en storage
        router.push('/home');
      } else {
        alert(response.data.value);
      }

    } catch (error) {
      // console.error('Error logging in:', error);
      alert('Adresse mail ou mot de passe incorrect. Veuillez réessayer');
    }
  };

  // const clearCache = () => {
  //   Preferences.clear()
  //   console.log("Cache vidé")
  // }

  // const checkStorage = () => {
  //   console.log("test")
  //   console.log(Preferences.keys(), Preferences.keys)
  //   for(const key in Preferences.keys()){
  //     Preferences.get({key}).then(result => {
  //       console.log("retreived data : ", key, result.value)
  //     })
  //   }
  // }
  const logDeviceInfo = async () => {
    const info = await Device.getInfo();

    deviceType.value = info.operatingSystem
  };

  onMounted(() => {
    logDeviceInfo();
  })
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
  