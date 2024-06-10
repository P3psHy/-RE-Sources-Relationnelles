<template>
  <UserForm titre="Créer mon compte" @submitHandler="submitForm" button="S'inscrire" prenom="" nom="" mail="" departement=""/>
</template>
  
    <script setup lang="ts">
    // import { IonContent, IonHeader, IonTitle, IonToolbar } from '@ionic/vue';
    import UserForm from '@/components/SubscriptionForm.vue';
    import axios from 'axios';
	import {API_BASE_URL} from '../config';
    import { useRouter } from 'vue-router';

    
    // Utiliser le routeur de Vue pour la redirection après la connexion
	const router = useRouter();

    const submitForm = async (nom: string, prenom: string, mail: string, password: string, departement: string) => {

        const userData = {
            nom: nom,
            prenom: prenom,
            mail: mail,
            motDePasse: password,
            departement: departement,
        };
        const jsonString = JSON.stringify(userData, null, 2); // Beautify JSON output

        try {
        const response = await axios.post(`${API_BASE_URL}/utilisateur/`, jsonString, 
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
  