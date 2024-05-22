import { createRouter, createWebHistory } from '@ionic/vue-router';
import { RouteRecordRaw } from 'vue-router';
import BaseLayout from "@/components/BaseLayout.vue"
import HomePage from '@/views/HomePage.vue';
import ProfilePage from '@/views/ProfilePage.vue';
import RessourcePage from '@/views/RessourcePage.vue';
import ConnectionPage from '@/views/ConnectionPage.vue';
import RessourceNew from '@/views/RessourceNew.vue';
import PrivacyPolicyPage from '@/views/PrivacyPolicy.vue';
import TermsConditionsPage from '@/views/TermsConditions.vue';
import ConnectionForm from '@/components/ConnectionForm.vue';
import SubscriptionForm from '@/components/SubscriptionForm.vue';
import ProfileData from '@/components/ProfileData.vue';
import ProfileFiles from '@/components/ProfileFiles.vue';
import RelationsPage from '@/views/RelationsPage.vue';
import MessagingPage from '@/views/MessagingPage.vue';

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    component: BaseLayout,
    redirect: "home",
    children: [
      {
        path: 'home',
        name: 'Home',
        component: HomePage
      },
      {
        // la redirection se fait quand le / est absent au début du path
        path: 'us',
        name: 'Connection',
        component: ConnectionPage,
        redirect: "/us/connexion",
        children: [
          {
            path: 'connexion',
            name: 'Connexion',
            component: ConnectionForm
          },
          {
            path: 'inscription',
            name: 'Inscription',
            component: SubscriptionForm
          }
        ]
      },
      {
        path: 'ressource',
        name: 'Ressource',
        component: RessourcePage
      },
      {
        path: 'ressource/new',
        name: 'RessourceNew',
        component: RessourceNew
      },
      {
        path: 'relations',
        name: 'Relations',
        component: RelationsPage
      },
      {
        path: 'messagerie',
        name: 'Messagerie',
        component: MessagingPage
          
      },
      {
        path: 'profil',
        name: 'Profil',
        component: ProfilePage
          
      },
      {
        path: 'privacy-policy',
        name: 'PrivacyPolicy',
        component: PrivacyPolicyPage
      },
      {
        path: 'terms-conditions',
        name: 'TermsConditions',
        component: TermsConditionsPage
      }
    ]
  },
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
