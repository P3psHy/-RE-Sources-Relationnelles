<template>
  <ion-content :fullscreen="true">
    <div id="container">
      <strong>Cette page affichera les relations</strong>
    </div>
	<div v-for="relation in listRelation" :key="relation.id">
		<span>{{ relation.nom }} {{ relation.prenom }}</span>
	</div>
  </ion-content>
</template>

<script setup lang="ts">
  import { IonContent, IonHeader, IonTitle, IonToolbar } from '@ionic/vue';
	import { Preferences } from '@capacitor/preferences';
	import { useRouter } from 'vue-router';
	import {API_BASE_URL} from '../config'
	import axios from 'axios';
	import { ref, onMounted, onBeforeMount } from 'vue';

	

	const router = useRouter();

	const idUser = ref('');
	const listRelation= ref([]);

	const getRelations = async () => {
		try {
		const response = await axios.get(`${API_BASE_URL}/RelationUtilisateur/user/16?relationAccepte=0`, 
            { 
                headers: { 
                'Content-Type': 'application/json'
                }
            });
		
			listRelation.value = response.data;
		
	}catch (error) {
            console.error('Error logging in:', error);
            alert('An error occurred. Please try again.');
        }

	}












	onMounted(() => {
		getRelations();
        
        Preferences.get({key: "id_utilisateur"}).then(result => {
            idUser.value = result.value;
        })
    })

	onBeforeMount(() => {
		Preferences.get({key: "id_utilisateur"}).then(result => {
			console.log(JSON.stringify(result))
			if(result.value === null){
				alert('Vous devez être connecté pour visualiser ce contenu');
				console.log("redirect")
				router.push('us/connexion');
			}
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
</style>
  