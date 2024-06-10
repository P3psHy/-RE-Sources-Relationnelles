<template>
  <ion-content>
    <div id="container">
      <router-view></router-view>
    </div>
  </ion-content>
</template>
  
  <script setup lang="ts">
    import { IonContent, IonHeader, IonTitle, IonToolbar } from '@ionic/vue';
    
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
  