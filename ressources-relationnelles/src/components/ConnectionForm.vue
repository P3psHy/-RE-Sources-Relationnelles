<template>
<h2>Se connecter</h2>
    <form class="form" id="formulaire">
        <ion-input type="text" placeholder="Login" id="input_login"></ion-input>
        <ion-input type="password" placeholder="Mot de passe" id="input_password"></ion-input>
        <ion-button type="submit" id="submit">Se connecter</ion-button>
    </form>
</template>

<script setup lang="ts">
    import { IonInput, IonTextarea, IonButton } from '@ionic/vue';
    
  </script>
  
  <style scoped>

  #formulaire{
    padding: 10px;
    border: 1px solid #FFFFFF;
    width: 70%;
    margin-left: auto;
    margin-right: auto;
  }

  #title{
    font-size: 20px;
    line-height: 26px;
    
    color: #FFFFFF;
    margin-bottom: 5%;
  }
  
  </style>
  