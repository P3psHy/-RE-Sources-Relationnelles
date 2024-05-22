<template>
    <ion-header :translucent="true">
        <ion-toolbar>
            <ion-grid>
                <ion-row>
                    <ion-col id="logo">
                        <ion-img id="header-logo" @click="goToHome" src="../sources/header-logo.png"></ion-img>
                    </ion-col>
                    <ion-col>
                        <ion-segment ref="pageName" v-model="pageName">
                            <ion-segment-button>
                                <ion-icon :icon="search"></ion-icon>
                                <ion-label v-if="$grid.breakpoint.includes('l')">Recherche</ion-label>
                            </ion-segment-button>
                            <!-- Bouton qui déclenche l'affichage de la barre de recherche -->
                            <ion-segment-button router-link="/home" value="Home">
                                <ion-icon :icon="home"></ion-icon>
                                <ion-label v-if="$grid.breakpoint.includes('l')">Accueil</ion-label>
                            </ion-segment-button>
                            <ion-segment-button router-link="/ressource" value="Ressource">
                                <ion-icon :icon="addCircle"></ion-icon>
                                <ion-label v-if="$grid.breakpoint.includes('l')">Publier</ion-label>
                            </ion-segment-button>
                            <ion-segment-button router-link="/relations" value="Relations">
                                <ion-icon :icon="people"></ion-icon>
                                <ion-label v-if="$grid.breakpoint.includes('l')">Relations</ion-label>
                            </ion-segment-button>
                            <ion-segment-button router-link="/messagerie" value="Messagerie">
                                <ion-icon :icon="send"></ion-icon>
                                <ion-label v-if="$grid.breakpoint.includes('l')">Messagerie</ion-label>
                            </ion-segment-button>
                            <ion-segment-button router-link="/profil" value="Profil">
                                <ion-icon :icon="person"></ion-icon>
                                <ion-label v-if="$grid.breakpoint.includes('l')">Mon profil</ion-label>
                            </ion-segment-button>
                        </ion-segment>
                    </ion-col>
                </ion-row>
            </ion-grid>
        </ion-toolbar>
    </ion-header>
</template>
  
<script setup lang="ts">
    import { 
        IonImg, 
        IonHeader, 
        IonSegment, 
        IonSegmentButton, 
        IonToolbar,
        IonCol, 
        IonGrid, 
        IonRow,
        IonIcon
    } from '@ionic/vue';
    import { watch, ref } from 'vue'; 
    import { useRoute } from 'vue-router';
    import { useRouter } from 'vue-router';
    import { 
        search,
        home,
        addCircle,
        people,
        send,
        person
     } from 'ionicons/icons';
    const route = useRoute();
    const router = useRouter();
    const pageName = ref()

    // Mettre à jour le nom de la page lors du changement de route
    watch(route, (currentValue, newValue) => {
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

    #logo {
        display: flex;
        
    }

    #header-logo {
        height: 5vh;
        cursor: pointer;
    }
</style>
  