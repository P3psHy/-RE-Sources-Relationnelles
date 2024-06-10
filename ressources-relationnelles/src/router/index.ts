import { createRouter, createWebHistory } from '@ionic/vue-router';
import { RouteRecordRaw } from 'vue-router';
import BaseLayout from "@/components/BaseLayout.vue"
import HomePage from '@/views/HomePage.vue';
import ProfilePage from '@/views/ProfilePage.vue';
import RessourcePage from '@/views/RessourcePage.vue';
import ConnectionPage from '@/views/ConnectionPage.vue';
import PrivacyPolicyPage from '@/views/PrivacyPolicy.vue';
import TermsConditionsPage from '@/views/TermsConditions.vue';
import ConnectionForm from '@/components/ConnectionForm.vue';
import RelationsPage from '@/views/RelationsPage.vue';
import MessagingPage from '@/views/MessagingPage.vue';
import Ressource from '@/components/Ressource.vue';
import UneRessource from '@/components/UneRessource.vue';
import SubscriptionPage from '@/views/SubscriptionPage.vue';
import UserProfile from '@/components/UserProfile.vue';
import ListRessources from '@/components/ListRessources.vue';

const routes: Array<RouteRecordRaw> = [
	{
		path: '/',
		component: BaseLayout,
		redirect: "home",
		children: [
			{
				path: 'home',
				name: 'Home',
				component: HomePage,
				children: [
					{
						path: 'user',
						name: 'UserProfile',
						component: UserProfile
					},
					{
						path: 'ressources',
						name: 'UserRessources',
						component: ListRessources
					},
					{
						path: 'see/:idRessource', // Utilisez un paramètre pour l'ID de la ressource
						name: 'VoirRessource',
						component: UneRessource
					}
				]
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
						component: SubscriptionPage
					}
				]
			},
			{
				path: 'ressource',
				name: 'Ressource',
				component: RessourcePage
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
