<template>
    <ion-page>
        <Header></Header>
        <router-view></router-view>
        <Footer></Footer>
    </ion-page>
</template>

<script setup lang="ts">
    import { IonPage } from "@ionic/vue"
    import Header from './Header.vue'
    import Footer from './Footer.vue'
</script>