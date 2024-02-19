<template>
    <ion-header :translucent="true">
        <ion-toolbar>
            <ion-grid>
                <ion-row>
                    <ion-col>
                        <ion-img class="logo" src="../sources/Logo application.png"></ion-img>
                    </ion-col>
                    <ion-col>
                        <ion-segment ref="pageName" :value="pageName">
                            <ion-segment-button router-link="/home" value="Home">Accueil</ion-segment-button>
                            <ion-segment-button router-link="/ressource" value="Ressource">Publier</ion-segment-button>
                            <ion-segment-button router-link="/connect" value="Connection">Se connecter</ion-segment-button>
                            <ion-segment-button router-link="/profile" value="Profile">Mon profil</ion-segment-button>
                        </ion-segment>
                    </ion-col>
                </ion-row>
            </ion-grid>
        </ion-toolbar>
    </ion-header>
</template>
  
<script setup lang="ts">
    import { IonImg, IonHeader, IonSegment, IonSegmentButton, IonToolbar} from '@ionic/vue';
    import { watch, ref } from 'vue'; 
    import { useRoute } from 'vue-router';
    const route = useRoute();
    const pageName = ref()

    // Mettre à jour le nom de la page lors du changement de route
    watch(route, (currentValue, newValue) => {
        console.log(newValue.name);
        pageName = newValue.name || 'Home';
    });
    
</script>

<style scoped>
.logo {
    max-width: 5vw;
}
</style>
  