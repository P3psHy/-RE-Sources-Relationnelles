<template>
    <ion-header :translucent="true">
        <ion-toolbar>
            <ion-grid>
                <ion-row>
                    <ion-col id="logo" size="2" size-md="1" >
                        <ion-img id="header-logo" @click="goToHome" src="../sources/header-logo.png"></ion-img>
                    </ion-col>
                    <ion-col id="header-menu" size="10" size-md="11">
                        <ion-segment ref="pageName" v-model="pageName">
                            <ion-segment-button>
                                <ion-icon :icon="search"></ion-icon>
                                <ion-label v-if="$grid.breakpoint.includes('l')">Recherche</ion-label>
                            </ion-segment-button>
                            <!-- Bouton qui déclenche l'affichage de la barre de recherche -->
                            <ion-segment-button v-for="button in menuButtons" :key="button.label" :router-link="button.link">
                                <ion-icon :icon="button.icon"></ion-icon>
                                <ion-label v-if="$grid.breakpoint.includes('l')">{{button.label}}</ion-label>
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
        IonTabs, 
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
        person,
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
    
    const menuButtons = [
        { label: 'Accueil', icon: home, link: '/home' },
        { label: 'Publier', icon: addCircle, link: '/ressource' },
        { label: 'Relations', icon: people, link: '/relations' },
        { label: 'Messagerie', icon: send, link: '/messagerie' },
        { label: 'Mon profil', icon: person, link: '/profil' },
    ];
</script>

<style scoped>
    ion-header {
        background-color: #03989E;
    }

    #logo {
        display: flex;
        align-items: center;
    }

    #header-logo {
        height: 5vh;
        cursor: pointer;
    }

    ion-row {
        display: flex;
        width: 100%;
    }

    ion-col {
        width: fit-content;
    }

    #header-menu {
        display: flex;
        align-items: center;
        overflow-x: auto;
    }

    ion-segment-button {
        min-width: auto;
    }

    ion-icon {
        margin: auto;
    }

    ion-label {
        font-size:x-small;
        margin: 0%;
        min-width: 0px !important;
    }

</style>
  