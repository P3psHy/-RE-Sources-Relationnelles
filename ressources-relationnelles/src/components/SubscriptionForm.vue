<template>
    <h2>Créer un compte</h2>
	<form @submit.prevent="submitForm">
		<ion-input v-model="prenom" type="text" placeholder="Prénom" id="input_F_name"></ion-input>
		<ion-input v-model="nom" type="text" placeholder="Nom" id="input_name"></ion-input>
		<ion-input v-model="departement" type="text" placeholder="Département" id="input_login"></ion-input>
		<ion-input v-model="mail" type="text" placeholder="Adresse mail" id="input_login"></ion-input>
		<ion-input v-model="password" type="password" placeholder="Mot de passe" id="input_password"></ion-input>
		<ion-input v-model="confirmPSW" type="password" placeholder="Confirmer le mot de passe" id="input_confirm_password"></ion-input>
		<ion-button type="submit" id="submit">Continuer</ion-button>
	</form>
</template>
    
<script setup lang="ts">
	import { IonInput, IonButton } from '@ionic/vue';
	import { ref } from 'vue';
	import { useRouter } from 'vue-router';
	import axios from 'axios';
	import {API_BASE_URL} from '../config'
	
	const mail = ref('');
	const nom = ref('');
	const prenom = ref('');
	const departement = ref('');
	const password = ref('');
	const confirmPSW = ref('');


	// Utiliser le routeur de Vue pour la redirection après la connexion
	const router = useRouter();

	const submitForm = async () => {

	const userData = {
		nom: nom.value,
		prenom: prenom.value,
		mail: mail.value,
		motDePasse: password.value,
		departement: departement.value,
	};
	const jsonString = JSON.stringify(userData, null, 2); // Beautify JSON output

	try {
	const response = await axios.post(`${API_BASE_URL}/utilisateur/`, jsonString, 
	{ headers: { 
		'Content-Type': 'application/json'
		// 'Content-Type': 'multipart/form-data'

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
      