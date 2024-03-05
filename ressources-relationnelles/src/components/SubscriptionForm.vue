<template>
    <h2>Créer un compte</h2>
        <form class="form" id="formulaire">
            <ion-input type="text" placeholder="Login" id="input_login"></ion-input>
            <ion-input type="text" placeholder="Nom" id="input_name"></ion-input>
            <ion-input type="text" placeholder="Prénom" id="input_F_name"></ion-input>
            <ion-input type="password" placeholder="Mot de passe" id="input_password"></ion-input>
            <ion-input type="password" placeholder="Confirmer le mot de passe" id="input_confirm_password"></ion-input>
            <ion-button type="submit" id="submit">Continuer</ion-button>
        </form>
    </template>
    
    <script setup lang="ts">
        import { IonInput, IonButton } from '@ionic/vue';
        
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
      