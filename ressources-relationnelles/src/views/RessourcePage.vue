<template>
  <ion-content>
    <div id="container">
      <RessourceForm />
    </div>
  </ion-content>
</template>

<script setup lang="ts">
  import { IonContent, IonHeader, IonTitle, IonToolbar, IonButton } from '@ionic/vue';
  import { onBeforeMount } from 'vue';
	import { Preferences } from '@capacitor/preferences';
	import { useRouter } from 'vue-router';
  import RessourceForm from '@/components/RessourceForm.vue';

	const router = useRouter();

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

  #container-small strong {
    font-size: 20px;
    line-height: 26px;
  }

  #container p {
    font-size: 16px;
    line-height: 22px;
    color: #8c8c8c;
    margin: 0;
  }

  #container-small p {
    font-size: 16px;
    line-height: 22px;
    color: #8c8c8c;
    margin: 0;
  }

  #container a {
    text-decoration: none;
  }

  #container-small a {
    text-decoration: none;
  }

  body{
    color : white !important;
  }
</style>
  