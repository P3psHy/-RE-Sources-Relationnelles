<template>
  <ion-content :fullscreen="true">
    <div id="container">
      <router-view></router-view>
    </div>
  </ion-content>
</template>
  
  <script setup lang="ts">
    import { IonContent, IonHeader, IonTitle, IonToolbar } from '@ionic/vue';
    
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
  