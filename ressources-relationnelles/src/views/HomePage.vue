<template>
	<ion-content>
		<div id="container">
			<ion-list>
						<!-- Loop over each ressource -->
				<Ressource
				v-for="r in ressources" :key="r.id" :ressource="r">
				</Ressource>
			</ion-list>
			<router-view></router-view>
		</div>
	</ion-content>
</template>

<script setup lang="ts">
	import { IonButtons, IonContent, IonHeader, IonMenuButton, IonPage, IonTitle, IonToolbar, IonList, useIonRouter } from '@ionic/vue';
	import Ressource from "../components/Ressource.vue";
	import { onMounted, ref } from 'vue';
	import axios from "axios";
	import { API_BASE_URL } from '../config';

	const ressources = ref(null);

	const fetchRessources = async () => {
		try {
			const response = await axios.get(`${API_BASE_URL}/ressource`);
			ressources.value = response.data;
		} catch (error) {
			console.error('Erreur lors de la récupération des ressources :', error);
		}
	};

	interface Utilisateur {
	idUtilisateur: number;
	nom: string;
	prenom: string;
	mail: string;
	motDePasse: string;
	departement: string;
	status: boolean;
	dateDesactivation: string | null;
	dateCreation: string;
	role: {
		idRole: number;
		typeRole: string;
	};
	ressources: any[];
	}

	interface Categorie {
	idCategorie: number;
	nom: string;
	}

	interface TypeRessource {
	idTypeRessource: number;
	nom: string;
	}

	interface Ressource {
	idRessource: number;
	titre: string;
	description: string;
	datePublication: string;
	nbConsultation: number;
	nbRecherche: number;
	nbPartage: number;
	utilisateur: Utilisateur;
	categorie: Categorie;
	typeRessource: TypeRessource;
	fichier: string | null;
	commentaires: any[];
	}

	/*const typeRelations = ref(null);

	const fetchData = async () => {
	typeRelations.value = null;
	try {
		const response = await axios.get(`${API_BASE_URL}/TypeRelation`);
		console.log(response.data)
		typeRelations.value = response.data;
		console.log(typeRelations.value)
	} catch (error) {
		console.error('Error fetching type relations:', error);
	}
	}; */

	onMounted(() => {
		fetchRessources();
	});


</script>

<style scoped>
	/* Styles here */
	ion-content {
		overflow-y: auto
	}

	#container {
		text-align: center;
		padding: 5%;
		max-width: 600px;
		margin: auto;
	}

	#ressource {
	margin: 1em;
	padding: 1em;
	border: 2px solid rgb(189, 160, 160);
	}

	#titre_ressource {
	color: #e4e4e4 !important;
	}
</style>
