import { createRouter, createWebHistory } from '@ionic/vue-router';
import { RouteRecordRaw } from 'vue-router';
import BaseLayout from "@/components/BaseLayout.vue"
import HomePage from '../views/HomePage.vue';
import ProfilePage from '../views/ProfilePage.vue';
import RessourcePage from '../views/RessourcePage.vue';
import ConnectionPage from '../views/ConnectionPage.vue';
import RessourceNew from '../views/RessourceNew.vue';

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    component: BaseLayout,
    redirect: "/home",
    children: [
      {
        path: '/home',
        name: 'Home',
        component: HomePage
      },
      {
        path: '/connect',
        name: 'Connection',
        component: ConnectionPage
      },
      {
        path: '/profile',
        name: 'Profile',
        component: ProfilePage
      },
      {
        path: '/ressource',
        name: 'Ressource',
        component: RessourcePage
      },
      {
        path: '/ressource/new',
        name: 'RessourceNew',
        component: RessourceNew
      }
    ]
  },
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
