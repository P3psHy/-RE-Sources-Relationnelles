<template>
	<ion-content :fullscreen="true">
		<div id="container">
			<div class="relations-list">
				<ion-list>
					<ion-list-header>
						<ion-label>Relations en attente :</ion-label>
						<ion-button>Tout voir</ion-button>
					</ion-list-header>
					<ion-item v-if="listRelationEnAttente.length == 0">
						<ion-label>Aucune relation</ion-label>
					</ion-item>
					<ion-item v-for="relation in listRelationEnAttente" :key="relation.id">
						<ion-label>{{ relation.nom }} {{ relation.prenom }}</ion-label>
					</ion-item>
				</ion-list>
			</div>
			<br/>
			<div class="relations-list">
				<ion-list>
					<ion-list-header>
						<ion-label>Vos relations :</ion-label>
						<ion-button>Tout voir</ion-button>
					</ion-list-header>
					<ion-item v-if="listRelation.length == 0">
						<ion-label>Aucune relation</ion-label>
					</ion-item>
					<ion-item v-for="relation in listRelation" :key="relation.id">
						<ion-label>{{ relation.nom }} {{ relation.prenom }}</ion-label>
					</ion-item>
				</ion-list>
			</div>
		</div>
	</ion-content>
</template>

<script setup lang="ts">
  import { IonContent} from '@ionic/vue';
	import { Preferences } from '@capacitor/preferences';
	import { useRouter } from 'vue-router';
	import {API_BASE_URL} from '../config'
	import axios from 'axios';
	import { ref, onMounted, onBeforeMount } from 'vue';

	const router = useRouter();

	const idUser = ref(null);
	const listRelationEnAttente= ref([]);
	const listRelation= ref([]);

	const getRelations = async () => {
		try {
			if(idUser.value != null){
				const response = await axios.get(`${API_BASE_URL}/RelationUtilisateur/user/${idUser.value}`, 
					{ 
						headers: { 
						'Content-Type': 'application/json'
						}
					});
				let relationsEnAttente = []
				let relationsAcceptees = []
				for(let relation in response.data){
					if(relation.estAcceptee){
						relationsAcceptees.push(relation)
					}else{
						relationsEnAttente.push(relation)
					}
				}
				listRelation.value = relationsAcceptees;
				listRelationEnAttente.value = relationsEnAttente;
			}else{
				alert("Votre profil d'utilisateur n'est pas reconnu.")
			}
		
		}catch (error) {
            console.error('Error logging in:', error);
            alert('An error occurred. Please try again.');
        }
	}

	const getUserIdAndRelations = async () => {
		try {
			const result = await Preferences.get({ key: "id_utilisateur" });
			console.log(JSON.stringify(result))
			if (result.value === null) {
				alert('Vous devez être connecté pour visualiser ce contenu');
				console.log("redirect")
				router.push('us/connexion');
			} else {
				idUser.value = result.value;
				console.log("Id utilisateur connecté : " + result.value);
				await getRelations(); // Ensure getRelations is called only after user ID is set
			}
		} catch (error) {
			console.error('Error fetching user ID:', error);
			alert('An error occurred. Please try again.');
		}
	}

	onMounted(() => {
		getUserIdAndRelations();
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

#container strong {
font-size: 20px;
line-height: 26px;
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

.relations-list {
	min-height: 25%;
	min-width: 50%;
}
</style>
  