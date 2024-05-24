<template>
  <ion-content :fullscreen="true">
    <div id="container">
      <div>
        <UserForm titre="Mes données" button="Modifier" @submitHandler="submitUpdatedData" v-model:prenom="prenom" v-model:nom="nom" v-model:mail="mail" v-model:departement="departement"/>
      </div>
      <div>Liste des ressources</div>
    </div>
  </ion-content>
</template>

<script setup lang="ts">
  import { IonContent, IonHeader, IonTitle, IonToolbar } from '@ionic/vue';
  import UserForm from "../components/SubscriptionForm.vue";
  import { ref, onMounted } from 'vue';
  import axios from 'axios';
	import {API_BASE_URL} from '../config';
  import { useRouter } from 'vue-router';
  import { Preferences } from '@capacitor/preferences';

  const idUser = ref('');
  const mail = ref('');
	const nom = ref('');
	const prenom = ref('');
	const departement = ref('');

    // Utiliser le routeur de Vue pour la redirection après la connexion
	const router = useRouter();

    const submitUpdatedData = async (nom: string, prenom: string, mail: string, password: string, departement: string) => {
        console.log('Hello', nom, prenom, mail, departement);

        const userData = {
            nom: nom,
            prenom: prenom,
            mail: mail,
            motDePasse: password,
            departement: departement,
        };

        const jsonString = JSON.stringify(userData, null, 2); // Beautify JSON output

        try {
        const response = await axios.put(`${API_BASE_URL}/utilisateur/${idUser.value}`, jsonString, 
        { 
            headers: { 
            'Content-Type': 'application/json'
            }
        });
        if(response){
            router.push('connexion');
        }else{
            alert('erreur');
        }

        }catch (error) {
            console.error('Error logging in:', error);
            alert('An error occurred. Please try again.');
        }

    }

    onMounted(() => {
        Preferences.get({key: "nom_utilisateur"}).then(result => {
            nom.value = result.value;
        })
        Preferences.get({key: "prenom_utilisateur"}).then(result => {
            prenom.value = result.value;
        })
        Preferences.get({key: "mail_utilisateur"}).then(result => {
            mail.value = result.value;
        })
        Preferences.get({key: "departement_utilisateur"}).then(result => {
            departement.value = result.value;
        })
        Preferences.get({key: "id_utilisateur"}).then(result => {
            idUser.value = result.value;
        })
    })

</script>

<style scoped>
#container {
text-align: center;

position: absolute;
left: 0;
right: 0;
top: 50%;
transform: translateY(-50%);
}

#container p {
font-size: 16px;
line-height: 22px;

color: #8c8c8c;

margin: 0;
}

#container a {
text-decoration: none;
}
</style>
  