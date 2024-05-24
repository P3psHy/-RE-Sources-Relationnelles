<template>
    <h2>Créer une nouvelle ressource</h2>
	<form @submit.prevent="submitForm">
		<ion-select placeholder="Sélectionner une catégorie" v-model="categorie">
			<div slot="label">Catégorie <ion-text color="danger">(Requis)</ion-text></div>
			<ion-select-option 
				v-for="option in optionsCategorie" 
				:key="option.id" 
				:value="option.id">
					{{option.nom}}
			</ion-select-option>
		</ion-select>
		<ion-select placeholder="Sélectionner un type de ressource" v-model="typeRessource">
			<div slot="label">Type de ressource <ion-text color="danger">(Requis)</ion-text></div>
			<ion-select-option 
				v-for="option in optionsTypeRessource" 
				:key="option.id" 
				:value="option.id">
					{{option.nom}}
			</ion-select-option>
		</ion-select>
		<ion-select placeholder="Sélectionner la ou les relation(s) avec qui partager cette ressource" 
		v-model="typeRelation" :multiple="true">
			<div slot="label">Type de relations</div>
			<ion-select-option 
				v-for="option in optionsTypeRelation" 
				:key="option.id" 
				:value="option.id">
					{{option.nom}}
			</ion-select-option>
		</ion-select>
		<ion-input v-model="titre" type="text" placeholder="Titre" id="input_F_name"></ion-input>
		<ion-textarea 
			v-model="description" 
			label="Description" 
			placeholder="Rédiger une description pour la ressource ici" 
			:auto-grow="true">
				<div slot="label">Description <ion-text color="danger">(Required)</ion-text></div>
		</ion-textarea>
		<ion-button type="submit" id="submit">Continuer</ion-button>
	</form>
</template>
    
<script setup lang="ts">
	import { IonInput, IonButton, IonText, IonSelect, IonSelectOption, IonTextarea } from '@ionic/vue';
	import { ref, onMounted } from 'vue';
	import axios from 'axios';
	import {API_BASE_URL} from '../config'
import { Preferences } from '@capacitor/preferences';
	
	const titre = ref('');
	const description = ref('');
	const categorie = ref('');
	const typeRessource = ref('');
	const typeRelation = ref([]);
	const id_utilisateur = ref('');

	const submitForm = async () => {
		const ressourceData = {
			titre: titre.value,
			description: description.value,
			id_categorie: categorie.value,
			id_type_ressource: typeRessource.value,
			ids_type_relation: typeRelation.value,
			id_utilisateur: id_utilisateur.value
		};
		const jsonString = JSON.stringify(ressourceData, null, 2); // Beautify JSON output

		console.log(jsonString);

		try {
		const response = await axios.post(`${API_BASE_URL}/ressource/`, jsonString, { 
			headers: {'Content-Type': 'application/json'}
		});
			if(response){
				alert("Ressource publiée")
				// router.push('connexion');
			}else{
				alert('erreur');
			}

		}catch (error) {
			console.error('Error logging in:', error);
			alert('An error occurred. Please try again.');
		}
	}

	const optionsTypeRelation = ref([]);
	const optionsTypeRessource = ref([]);
	const optionsCategorie = ref([]);

	const getTypeRelations = async () => {
		try {
		const response = await axios.get(`${API_BASE_URL}/TypeRelation`);
		console.log(response.data)
		optionsTypeRelation.value = response.data;
		console.log(optionsTypeRelation.value)
		} catch (error) {
		console.error('Error fetching type relations:', error);
		}
	};

	const getTypeRessources = async () => {
		try {
		const response = await axios.get(`${API_BASE_URL}/TypeRessource`);
		console.log(response.data)
		optionsTypeRessource.value = response.data;
		console.log(optionsTypeRessource.value)
		} catch (error) {
		console.error('Error fetching type ressources:', error);
		}
	};

	const getCategories = async () => {
		try {
		const response = await axios.get(`${API_BASE_URL}/categorie`);
		console.log(response.data)
		optionsCategorie.value = response.data;
		console.log(optionsCategorie.value)
		} catch (error) {
		console.error('Error fetching categories:', error);
		}
	};

	onMounted(() => {
		getTypeRelations();
		getTypeRessources();
		getCategories();
		Preferences.get({key: "id_utilisateur"}).then(result => {
			console.log("retreived data : ", id_utilisateur, result.value)
			id_utilisateur.value = result.value;
		})
	});

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
      