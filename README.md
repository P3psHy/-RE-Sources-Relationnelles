# -RE-Sources-Relationnelles

#- Projet sous Symfony 6.4 -#


- Lancer le projet -

Procédure à suivre pour lancer le site ainsi que la base de donnée 
Lancer l'API:
au préalable:
- MySQLWorkbench doit être installé et ouvert avec comme identifiant: root, et comme mot de passe: root ( à changer si voulu dans le fichier .env)
- Symfony et composer doivent être installé
 Après avoir télécharger le projet, ouvrer une invite de commande dans celui-ci, allez dans /symfony-backend/backend-ress-rela/
 Tapez la commande:
  - php bin/console doctrine:database:create (permet de créer la base de donnée)
  - php bin/console doctrine:schema:create (permet de créer les tables)
  - php bin/console doctrine:fixtures:load (permet de charger un jeu de test) puis écrivez "Yes"

Ces commandes crééront la base de donnée, ensuite tapez la commande 
 symfony serve 

 L'API sera disposible sur votre environnement local: https://127.0.0.1:8000


Lancer les test applications: 
dans le dossier /symfony-backend/backend-ress-rela/ tapez les commandes:
 - php bin/console --env=test doctrine:database:create (permet de créer la base de donnée de test)
 - php bin/console --env=test doctrine:schema:create (permet de créer les tables)
 - php bin/console --env=test doctrine:fixtures:load (permet de charger un jeu de test) puis écrivez "Yes"

 Dès que ces actions sont réalisé, tapez la commande php bin/phpunit
 Cela vérifiera le fonctionnement de toutes les requètes utilisable par l'API


 Lancer le site
 au préalable:
 - Ionic doit être installé

Ouvrer une invite de commande dans la racine du projet, allez dans /ressource-relationnelles et tapez la commande:
ionic serve
 - faire npm install
 - faire npm install @capacitor/core@latest @capacitor/cli@latest @capacitor/android@latest @capacitor/ios@latest

Le site se lancera en local à l'adresse: http://localhost:8100

