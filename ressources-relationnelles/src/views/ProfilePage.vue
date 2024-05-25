<template>
  <ion-content :fullscreen="true">
    <div id="container">
      <div>
        <UserForm titre="Mes données" button="Modifier" @submitHandler="submitUpdatedData" v-model:prenom="prenom" v-model:nom="nom" v-model:mail="mail" v-model:departement="departement"/>
        <ion-button @click="desactivateAccount">Désactiver le compte</ion-button>
        <ion-button @click="deleteAccount">Supprimer le compte</ion-button>

    </div>
      <div>Liste des ressources</div>
    </div>
  </ion-content>
</template>

<script setup lang="ts">
    // import { IonContent, IonHeader, IonTitle, IonToolbar } from '@ionic/vue';
    import UserForm from "../components/SubscriptionForm.vue";
    import { ref, onMounted, onBeforeMount } from 'vue';
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
                router.push('profil');
            }else{
                alert('erreur');
            }

        }catch (error) {
            console.error('Error update account:', error);
            alert('An error occurred. Please try again.');
        }

    }

    
    const desactivateAccount = async () => {
        alert("Desactivé")

        const userData = {
            dateDesactivation : '',
            estActive: false
        };

        function getDateTimeWithOffset(offsetHours) {
            const date = new Date();
            // Convert to UTC milliseconds, add the offset in milliseconds, and create a new Date object
            const utcTime = date.getTime() + date.getTimezoneOffset() * 60000;
            const newDate = new Date(utcTime + offsetHours * 3600000);

            // Format the date as ISO string and add the offset part
            const isoString = newDate.toISOString();
            const isoDate = isoString.slice(0, 19); // Get the date and time part
            const offset = offsetHours >= 0 ? `+${String(offsetHours).padStart(2, '0')}:00` : `-${String(Math.abs(offsetHours)).padStart(2, '0')}:00`;

            return `${isoDate}${offset}`;
            }

            // Mettre à jour userData avec la date actuelle et un décalage de 2 heures
            userData.dateDesactivation = getDateTimeWithOffset(2);


        const jsonString = JSON.stringify(userData, null, 2); // Beautify JSON output

        console.log(jsonString);

        try {
            const response = await axios.put(`${API_BASE_URL}/utilisateur/${idUser.value}`, jsonString, 
            { 
                headers: { 
                'Content-Type': 'application/json'
                }
            });
            if(response){
                router.push('profil');
            }else{
                alert('erreur');
            }

        }catch (error) {
            console.error('Error update account:', error);
            alert('An error occurred. Please try again.');
        }

    }

    const deleteAccount = async () => {
        alert("Suppression")

        try {
            const response = await axios.delete(`${API_BASE_URL}/utilisateur/${idUser.value}`, 
            { 
                
            });
            if(response){
                router.push('home');
            }else{
                alert('erreur');
            }

        }catch (error) {
            console.error('Error logging in:', error);
            alert('An error occurred. Please try again.');
        }
    }

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
  