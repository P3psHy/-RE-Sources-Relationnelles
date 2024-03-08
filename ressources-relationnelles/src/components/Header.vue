<template>
    <ion-header :translucent="true">
        <ion-toolbar>
            <ion-grid>
                <ion-row>
                    <ion-col>
                        <ion-img id="header-logo" @click="goToHome" src="../sources/header-logo.png"></ion-img>
                    </ion-col>
                    <ion-col>
                        <ion-segment ref="pageName" v-model="pageName">
                            <ion-segment-button router-link="/ressource/new" value="Ressource">Publier</ion-segment-button>
                            <ion-segment-button router-link="/us/connexion" value="Connection">Se connecter</ion-segment-button>
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
    import { useRouter } from 'vue-router';
    const route = useRoute();
    const router = useRouter();
    const pageName = ref()

    // Mettre à jour le nom de la page lors du changement de route
    watch(route, (currentValue, newValue) => {
        console.log(newValue.name);
        pageName.value = newValue.name || '';
    });

    const goToHome = () => {
        router.push("/home")
    };
    
</script>

<style scoped>
    ion-header {
        background-color: #03989E;
    }

    #header-logo {
        max-width: 5vw;
        cursor: pointer;
    }
</style>
  