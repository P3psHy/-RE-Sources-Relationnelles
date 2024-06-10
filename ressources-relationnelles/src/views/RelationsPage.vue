<template>
	<ion-content>
		<div id="container">
			<form @submit.prevent="getUsersFromName">
				<ion-label>Chercher un utilisateur</ion-label>
				<ion-input v-model="prenom" type="text" placeholder="Prénom" id="input_F_name"></ion-input>
				<ion-input v-model="nom" type="text" placeholder="Nom" id="input_F_name"></ion-input>
				<ion-button type="submit" id="submit">Rechercher</ion-button>
			</form>
			<div>
				<ion-list>
					<ion-list-header>
						<ion-label>Utilisateurs à ajouter</ion-label>
					</ion-list-header>
					<ion-item v-if="fetchedUsers.length == 0">
						<ion-label>Aucun utilisateur correspondant</ion-label>
					</ion-item>
					<ion-item v-for="user in fetchedUsers" :key="user.id">
						<form @submit.prevent="addRelation(user)">
							<ion-label>{{ user.nom }} {{ user.prenom }} - {{ user.departement }} - {{ user.email }}</ion-label>
							<ion-select placeholder="Sélectionner le type de relation" v-model="typeRelation">
								<div slot="label">Types de relation</div>
								<ion-select-option 
									v-for="option in optionsTypeRelation" 
									:key="option.id" 
									:value="option.id">
										{{option.nom}}
								</ion-select-option>
							</ion-select>
							<ion-button type="submit" id="submit">Ajouter</ion-button>
						</form>
					</ion-item>
				</ion-list>
			</div>
			<br/>
			<div class="relations-list">
				<ion-list>
					<ion-list-header>
						<ion-label>Mes demandes en attente :</ion-label>
						<ion-button>Tout voir</ion-button>
					</ion-list-header>
					<ion-item v-if="listMesRelationEnAttente.length == 0">
						<ion-label>Aucune relation</ion-label>
					</ion-item>
					<ion-item v-for="relation in listMesRelationEnAttente" :key="relation.idUser">
						<ion-label>{{ relation.nomUser }} {{ relation.prenomUser }} - <i>{{ relation.departementUser }}</i> - {{ relation.nomTypeRelation }}</ion-label>
						<ion-button color="danger" @click="supprimerRelation(relation.idRelationUtilisateur)">Annuler</ion-button>
					</ion-item>
				</ion-list>
			</div>
			<br/>
			<div class="relations-list">
				<ion-list>
					<ion-list-header>
						<ion-label>	 En attente de réponse :</ion-label>
						<ion-button>Tout voir</ion-button>
					</ion-list-header>
					<ion-item v-if="listRelationEnAttente.length == 0">
						<ion-label>Aucune relation</ion-label>
					</ion-item>
					<ion-item v-for="relation in listRelationEnAttente" :key="relation.idUser">
						<ion-label>{{ relation.nomUser }} {{ relation.prenomUser }} - <i>{{ relation.departementUser }}</i> - {{ relation.nomTypeRelation }}</ion-label>
						<ion-button @click="accepterRelation(relation.idRelationUtilisateur)">Accepter</ion-button>
						<ion-button color="danger" @click="supprimerRelation(relation.idRelationUtilisateur)">Refuser</ion-button>
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
					<ion-item v-for="relation in listRelation" :key="relation.idUser">
						<ion-label>{{ relation.nomUser }} {{ relation.prenomUser }} - <i>{{ relation.departementUser }}</i> - {{ relation.nomTypeRelation }}</ion-label>
						<ion-button color="danger" @click="supprimerRelation(relation.idRelationUtilisateur)">Supprimer</ion-button>
					</ion-item>
				</ion-list>
			</div>
		</div>
	</ion-content>
</template>

<script setup lang="ts">
  import { IonContent, IonLabel, IonInput, IonButton, IonSelect, IonSelectOption, IonList, IonListHeader, IonItem } from '@ionic/vue';
	import { Preferences } from '@capacitor/preferences';
	import { useRouter } from 'vue-router';
	import {API_BASE_URL} from '../config'
	import axios from 'axios';
	import { ref, onMounted, onBeforeMount } from 'vue';

	const router = useRouter();

	const idUser = ref(null);
	const listRelationEnAttente= ref([]);
	const listMesRelationEnAttente= ref([]);
	const listRelation= ref([]);

	const prenom = ref('');
	const nom = ref('');

	const optionsTypeRelation = ref([]);
	const typeRelation = ref('');

	const fetchedUsers = ref([]);

	const getUsersFromName = async () => {
		// console.log("prenom.value", prenom.value)
		// console.log("nom.value", nom.value)
		const userData = {
			prenom: prenom.value,
			nom: nom.value,
		};
		// console.log("userData", userData)
		const jsonString = JSON.stringify(userData, null, 2); // Beautify JSON output

		// console.log(jsonString);

		try {
		const response = await axios.post(`${API_BASE_URL}/utilisateur/user/SearchUser`, jsonString, { 
			headers: {'Content-Type': 'application/json'}
		});

			if(response){
				// On réinitialise la liste des utilisateurs trouvé
				fetchedUsers.value = [];
				let idUserList = [];
				// Utiliser forEach pour itérer sur chaque élément et ajouter idUser à idUserList
				listRelationEnAttente.value.forEach(item => {
				idUserList.push(item.idUser);
				});
				listMesRelationEnAttente.value.forEach(item => {
				idUserList.push(item.idUser);
				});
				listRelation.value.forEach(item => {
				idUserList.push(item.idUser);
				});

				for(let data of response.data){
					if(!idUserList.includes(data.id)){
						fetchedUsers.value.push(data);
					}
				}

				
			}else{
				alert('Erreur lors de la récupération des utilisateurs. Veuillez réessayer ultérieurement.');
			}

		}catch (error) {
			console.error('Error logging in:', error);
			alert('Erreur lors de la récupération des utilisateurs. Veuillez réessayer ultérieurement.');
		}
	}

	const addRelation = async (user) => {
		const relationData = {
			id_utilisateur1: idUser.value,
			id_utilisateur2: user.id,
			id_type_relation: typeRelation.value,
		};
		const jsonString = JSON.stringify(relationData, null, 2); // Beautify JSON output

		// console.log(jsonString);

		try {
		const response = await axios.post(`${API_BASE_URL}/RelationUtilisateur/`, jsonString, { 
			headers: {'Content-Type': 'application/json'}
		});
			if(response){
				typeRelation.value = ""
				location.reload();
			}else{
				alert("Erreur lors de l'ajout de la relation. Veuillez réessayer ultérieurement.");
			}

		}catch (error) {
			console.error('Error logging in:', error);
			alert("Erreur lors de l'ajout de la relation. Veuillez réessayer ultérieurement.");
		}
	}

	const accepterRelation = async (id) => {

		try {

			const data = {
				estAccepte : true
        };

			const response = await axios.put(`${API_BASE_URL}/RelationUtilisateur/${id}`, data, {
			headers: {'Content-Type': 'application/json'}
		});
			if(response){
				// alert('Relation Ajouté')
				location.reload();
			}else{
				alert('Erreur ?')

			}
		} catch (error) {
			console.error('Error accept relation in:', error);
			alert("Erreur. Veuillez réessayer ultérieurement.");
		}
		console.log('Utilisateur Accepte', id)
	}


	const supprimerRelation = async (id) => {

		try {
			const response = await axios.delete(`${API_BASE_URL}/RelationUtilisateur/${id}`);

			if(response){
				// alert('relation supprimé')
				location.reload();

			}else{
				alert('Erreur ?')
			}

		} catch (error) {
			console.error('Error accept relation in:', error);
			alert("Erreur. Veuillez réessayer ultérieurement.");
		}
		console.log('Utilisateur Accepte', id)

	}


	const getRelations = async () => {
		try {
			if(idUser.value != null){
				const response = await axios.get(`${API_BASE_URL}/RelationUtilisateur/user/${idUser.value}`, 
					{ 
						headers: { 
						'Content-Type': 'application/json'
						}
					});
				// console.log(response.data);
				let relationsEnAttente = []
				let mesRelationsEnAttente = []
				let relationsAcceptees = []

				for(let relation of response.data){
					if(relation['estAccepte'] === true){	
						relationsAcceptees.push(relation)
					}else{
						if(relation['estReceveur'] === false){
							mesRelationsEnAttente.push(relation)
						}else{
							relationsEnAttente.push(relation)
						}
					}
				}

				console.log('listeMesRelationEnAttente', mesRelationsEnAttente)
				listRelation.value = relationsAcceptees;
				listRelationEnAttente.value = relationsEnAttente;
				listMesRelationEnAttente.value = mesRelationsEnAttente;
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
			// console.log(JSON.stringify(result))
			if (result.value === null) {
				alert('Vous devez être connecté pour visualiser ce contenu');
				console.log("redirect")
				router.push('us/connexion');
			} else {
				idUser.value = parseInt(result.value);
				// console.log("Id utilisateur connecté : " + result.value);
				await getRelations(); // Ensure getRelations is called only after user ID is set
			}
		} catch (error) {
			console.error('Error fetching user ID:', error);
			alert('An error occurred. Please try again.');
		}
	}

	const getTypeRelations = async () => {
		try {
			const response = await axios.get(`${API_BASE_URL}/TypeRelation`);
			// console.log(response.data)
			optionsTypeRelation.value = response.data;
			// console.log(optionsTypeRelation.value)
		} catch (error) {
			console.error('Error fetching type relations:', error);
		}
	};

	onMounted(() => {
		getUserIdAndRelations();
		getTypeRelations();
    })

</script>

<style scoped>

	ion-content {
		overflow-y: auto
	}

	#container {
		text-align: center;
		padding: 5%;
		max-width: 600px;
		margin: auto;
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

	ion-item {
		
	}

</style>
  