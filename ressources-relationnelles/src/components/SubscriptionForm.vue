<template>
    <h2>{{titre}}</h2>
    <form @submit.prevent="submitForm">
        <ion-input v-model="localPrenom" @input="updatePrenom" type="text" placeholder="Prénom" id="input_F_name"></ion-input>
        <ion-input v-model="localNom" @input="updateNom" type="text" placeholder="Nom" id="input_name"></ion-input>
		<ion-select placeholder="Département" v-model="localDepartement" @input="updateDepartement">
			<div slot="label">Département <ion-text color="danger">(Requis)</ion-text></div>
			<ion-select-option 
				v-for="option in departements" 
				:key="option.id" 
				:value="option.nom">
					{{option.nom}}
			</ion-select-option>
		</ion-select>
        <ion-input v-model="localMail" type="text" @input="updateMail" placeholder="Adresse mail" id="input_login"></ion-input>
        <ion-input v-model="password" type="password" placeholder="Mot de passe" id="input_password"></ion-input>
        <ion-input v-model="confirmPSW" type="password" placeholder="Confirmer le mot de passe" id="input_confirm_password"></ion-input>
        <ion-button type="submit" id="submit">{{button}}</ion-button>
    </form>
</template>

<script setup lang="ts">
	import { IonInput, IonButton, IonSelect, IonSelectOption, IonText } from '@ionic/vue';
	import { ref, defineProps, defineEmits, watch, onMounted } from 'vue';
	// import { useRouter } from 'vue-router';
	import axios from 'axios';
	// import {API_BASE_URL} from '../config'
	
	const emit = defineEmits(['update:prenom', 'update:nom', 'update:mail', 'update:departement', 'update:sumbit', 'submitHandler' ]);
	

	const props = defineProps({
		titre: String,
		button: String,
		prenom: {
			type: String,
			required: true
		},
		nom: {
			type: String,
			required: true
		},
		mail: {
			type: String,
			required: true
		},
		departement: {
			type: String,
			required: true
		}
		
	})
	const localMail = ref(props.mail);
	const localNom = ref(props.prenom);
	const localPrenom = ref(props.prenom);
	const localDepartement = ref(props.departement);
	const password = ref('');
	const confirmPSW = ref('');

	watch(props, (newValues) => {
		localPrenom.value = newValues.prenom;
		localNom.value = newValues.nom;
		localMail.value= newValues.mail;
		localDepartement.value = newValues.departement;
	});

	const updatePrenom = () => {
		emit('update:prenom', localPrenom.value)
	}
	const updateNom = () => {
		emit('update:nom', localNom.value)
	}
	const updateMail = () => {
		emit('update:mail', localMail.value)
	}
	const updateDepartement = () => {
		emit('update:departement', localDepartement.value)
	}
	const submitForm = () => {
		emit('submitHandler', localNom.value, localPrenom.value, localMail.value, password.value, localDepartement.value)
	}

	const departements = ref([])
	const getDepartements = async () => {
		try {
			const response = await axios.get("jsondb/Departements.json");
			departements.value = response.data;
		} catch (error) {
			console.error('Error fetching departements:', error);
		}
	};

	onMounted(() => {
		getDepartements()
	})

	// Utiliser le routeur de Vue pour la redirection après la connexion

	// const submitForm = async () => {

	// 	const userData = {
	// 		nom: localNom.value,
	// 		prenom: localPrenom.value,
	// 		mail: localMail.value,
	// 		motDePasse: password.value,
	// 		departement: localDepartement.value,
	// 	};
	// 	const jsonString = JSON.stringify(userData, null, 2); // Beautify JSON output

	// 	try {
	// 	const response = await axios.post(`${API_BASE_URL}/utilisateur/`, jsonString, 
	// 	{ 
	// 		headers: { 
	// 		'Content-Type': 'application/json'
	// 		}
	// 	});
	// 	if(response){
	// 		router.push('connexion');
	// 	}else{
	// 		alert('erreur');
	// 	}

	// 	}catch (error) {
	// 		console.error('Error logging in:', error);
	// 		alert('An error occurred. Please try again.');
	// 	}


	// }
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
      