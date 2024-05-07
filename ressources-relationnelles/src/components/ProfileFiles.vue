<template>
    <IonContent>
        <div class="ion-padding">
            <h1>Mon profil</h1>
            <div id="ressources">
                <label>Mes ressources</label>
                <p></p>
            </div>
            <div id="relations">
                <label>Mes relations</label>
                <p></p>
            </div>
            <div id="ressourcesFav">
                <label>Mes ressources favorites</label>
                <p></p>
            </div>
            <ion-button router-link="/profile/data" value="Data">Mes informations</ion-button>
        </div>
    </IonContent>
</template>

<script setup lang="ts">
    import { IonContent, IonButton } from '@ionic/vue';
</script>

<style scoped>

   .ion-padding {
    text-align: center;
     padding: 1rem;
     margin-left: auto;
     margin-right: auto;
   }
</style>