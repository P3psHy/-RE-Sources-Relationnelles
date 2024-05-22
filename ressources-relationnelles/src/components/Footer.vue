<template>
    <ion-footer collapse="fade">
        <ion-grid>
            <ion-row>
                <ion-col>
                    Copyright © 2024 AJM Services. All rights reserved.
                </ion-col>
                <ion-col>
                    <a href="/privacy-policy">
                        Politique de confidentialité
                    </a>
                    |
                    <a href="/terms-conditions">
                        Termes et conditions
                    </a>
                </ion-col>
                <ion-col id="logo-fr">
                    <ion-img class="logo" src="../sources/gouvernement-logos-idpqhzX_Mk.png"></ion-img>
                </ion-col>
            </ion-row>
        </ion-grid>
    </ion-footer>
</template>

<script setup lang="ts">
    import { IonImg, IonFooter, IonGrid, IonRow, IonCol} from '@ionic/vue';
</script>

<style scoped>
    .logo {
    max-width: 5vh;
    }

    ion-col {
        display: flex;
        justify-content: center;
        align-items: center;
        font-size: x-small;
        text-align: center;
    }

    a {
        margin: auto;
        cursor: pointer;
    }

    #logo-fr {
        justify-content: end;
    }  
</style>