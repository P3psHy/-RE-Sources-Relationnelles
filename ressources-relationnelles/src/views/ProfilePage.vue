<template>
    <ion-content>
        <div id="container">
            <div>
                <ion-button @click="disconnect" color="danger">Se déconnecter</ion-button>

                <UserForm titre="Mes données" button="Modifier" @submitHandler="submitUpdatedData" v-model:prenom="prenom" v-model:nom="nom" v-model:mail="mail" v-model:departement="departement"/>
                <ion-button @click="goToRelation">Mes relations</ion-button>
                <hr/>
                <div>
                    <ion-button @click="desactivateAccount" color="warning">Désactiver le compte</ion-button>
                    <ion-button @click="deleteAccount" color="danger">Supprimer le compte</ion-button>
                </div>
            </div>
            <hr/>
            <h3>Liste des ressources</h3>
            <h4 v-if="ressources.length == 0">
                Aucune ressource publiée
            </h4>
            <Ressource v-for="ressource in ressources" :key="ressource.ids"
                :ressource="ressource" @click="navigateToRessource(ressource)"/>
        </div>
    </ion-content>
</template>

<script setup lang="ts">
    import { IonContent, IonButton } from '@ionic/vue';
    import UserForm from "../components/SubscriptionForm.vue";
    import { ref, onMounted, onBeforeMount } from 'vue';
    import axios from 'axios';
    import {API_BASE_URL} from '../config';
    import { useRouter } from 'vue-router';
    import { Preferences } from '@capacitor/preferences';
    import Ressource from '@/components/Ressource.vue';

    const idUser = ref('');
    const mail = ref('');
    const nom = ref('');
    const prenom = ref('');
    const departement = ref('');

    const ressources = ref([]);

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

                Preferences.set({key: "nom_utilisateur", value: userData.nom})
                Preferences.set({key: "prenom_utilisateur", value: userData.prenom})
                Preferences.set({key: "mail_utilisateur", value: userData.mail})
                Preferences.set({key: "departement_utilisateur", value: userData.departement})

                location.reload();
            }else{
                alert('erreur');
            }

        }catch (error) {
            console.error('Error update account:', error);
            alert('An error occurred. Please try again.');
        }

    }

    // Fonction pour naviguer vers la page de détails de la ressource
    const navigateToRessource = (ressource:any) => {
        router.push({ name: 'VoirRessource', params: { idRessource: ressource.idRessource } });
    };
    
    const goToRelation = async () => {
        router.push('relations');
    }

    const disconnect = async () => {
        Preferences.clear();
        router.push('home');
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
                Preferences.clear();
                router.push('home');
            }else{
                alert('erreur');
            }

        }catch (error) {
            console.error('Error logging in:', error);
            alert('An error occurred. Please try again.');
        }
    }

    const getUserIdAndRessources = async () => {
		try {
			const result = await Preferences.get({ key: "id_utilisateur" });
			console.log(JSON.stringify(result))
			if (result.value === null) {
				alert('Vous devez être connecté pour visualiser ce contenu');
				console.log("redirect")
				router.push('us/connexion');
			} else {
				idUser.value = parseInt(result.value);
                getUserData()
				console.log("Id utilisateur connecté : " + result.value);
				await getUserRessources(); // Ensure getUserRessources is called only after user ID is set
			}
		} catch (error) {
			console.error('Error fetching user ID:', error);
			alert('An error occurred. Please try again.');
		}
	}

    const getUserData = async () => {
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
    }

    const getUserRessources = async () => {
        try {
			if(idUser.value != null){
				const response = await axios.get(`${API_BASE_URL}/ressource/ressources-user/${idUser.value}`, 
					{ 
						headers: { 
						'Content-Type': 'application/json'
						}
					});
				console.log(response.data);
				ressources.value = response.data;
			}else{
				alert("Votre profil d'utilisateur n'est pas reconnu.")
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
        getUserIdAndRessources()
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
  