<template>
  <ion-content :fullscreen="true">
    <div id="container">
      <strong>Cette page affichera la messagerie</strong>
    </div>
  </ion-content>
</template>

<script setup lang="ts">
	import { IonContent, IonHeader, IonTitle, IonToolbar } from '@ionic/vue';
	import { onBeforeMount } from 'vue';
	import { Preferences } from '@capacitor/preferences';
	import { useRouter } from 'vue-router';

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
  