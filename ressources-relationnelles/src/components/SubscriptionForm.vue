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
        <ion-input v-model="localMail" type="text" placeholder="Adresse mail" id="input_login"></ion-input>
        
        <!-- Champ mot de passe -->
        <ion-input v-model="password" type="password" @input="validatePassword" placeholder="Mot de passe" id="input_password"></ion-input>
        <div v-if="passwordRulesVisible" class="password-rules">
            <p :class="{ valid: passwordContainsUppercase }">Au moins une majuscule</p>
            <p :class="{ valid: passwordContainsLowercase }">Au moins une minuscule</p>
            <p :class="{ valid: passwordContainsNumber }">Au moins un chiffre</p>
            <p :class="{ valid: passwordContainsSpecialChar }">Au moins un caractère spécial</p>
            <p :class="{ valid: passwordIsLongEnough }">Au moins 12 caractères</p>
        </div>

        <ion-input v-model="confirmPSW" type="password" placeholder="Confirmer le mot de passe" id="input_confirm_password"></ion-input>
        <ion-button type="submit" id="submit">{{button}}</ion-button>
    </form>
</template>

<script setup lang="ts">
    import { IonInput, IonButton, IonSelect, IonSelectOption, IonText } from '@ionic/vue';
    import { ref, defineProps, defineEmits, watch, onMounted } from 'vue';
    import axios from 'axios';

    const emit = defineEmits(['update:prenom', 'update:nom', 'update:mail', 'update:departement', 'submitHandler']);
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

    const passwordContainsUppercase = ref(false);
    const passwordContainsLowercase = ref(false);
    const passwordContainsNumber = ref(false);
    const passwordContainsSpecialChar = ref(false);
    const passwordIsLongEnough = ref(false);
    const passwordRulesVisible = ref(false);

    const validatePassword = () => {
        const pw = password.value;
        passwordContainsUppercase.value = /[A-Z]/.test(pw);
        passwordContainsLowercase.value = /[a-z]/.test(pw);
        passwordContainsNumber.value = /\d/.test(pw);
        passwordContainsSpecialChar.value = /[!@#$%^&*(),.?":{}|<>]/.test(pw);
        passwordIsLongEnough.value = pw.length >= 12;
        passwordRulesVisible.value = true;
    }

    watch(props, (newValues) => {
        localPrenom.value = newValues.prenom;
        localNom.value = newValues.nom;
        localMail.value = newValues.mail;
        localDepartement.value = newValues.departement;
    });

    const updatePrenom = () => {
        emit('update:prenom', localPrenom.value);
    }
    const updateNom = () => {
        emit('update:nom', localNom.value);
    }

    const updateDepartement = () => {
        emit('update:departement', localDepartement.value);
    }

    const submitForm = () => {
		const emailRegex = /^[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        if (!emailRegex.test(localMail.value)) {
            alert('Veuillez entrer une adresse email valide');
            return;
        }

        // Vérification du mot de passe
        const validPassword = passwordContainsUppercase.value && passwordContainsLowercase.value &&
                              passwordContainsNumber.value && passwordContainsSpecialChar.value && 
                              passwordIsLongEnough.value;

        if (!validPassword) {
            alert('Le mot de passe ne respecte pas les critères requis.');
            return;
        }

        if (password.value !== confirmPSW.value) {
            alert('Les mots de passe ne correspondent pas.');
            return;
        }

        emit('submitHandler', localNom.value, localPrenom.value, localMail.value, password.value, localDepartement.value);
    }

    const departements = ref([]);
    const getDepartements = async () => {
        try {
            const response = await axios.get("jsondb/Departements.json");
            departements.value = response.data;
        } catch (error) {
            console.error('Error fetching departements:', error);
        }
    };

    onMounted(() => {
        getDepartements();
    })
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

	.password-rules {
        margin-top: 5px;
        font-size: 12px;
        color: red;
    }

    .password-rules p {
        margin: 0;
    }

    .password-rules p.valid {
        color: green;
    }
	
</style>
      