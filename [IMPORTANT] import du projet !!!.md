Importer le projet sur votre pc :

- Lancez Git Bash et effectuez les commandes suivante :
  * clone https://github.com/Eruliuce/Tower_Defense
  * git config --global user.name "NOM"
  * git config --global user.email mail@mail.com

- lancer Eclipse avec Gradle dans un Workspace en local (surtout PAS dans le dossier du projet). Si vous n'avez pas Gradle, téléchargez-le ici : http://marketplace.eclipse.org/content/gradle-integration-eclipse-44

- Dans Eclipse : file -> import -> Gradle -> Gradle Project
  * Browse vers Tower_Defense\Tower_Defense_Sources puis "Build Model"
  * Cochez toutes les cases puis cliquez sur Finish.

Pusher vos modifications sur le serveur :

- Fermez Eclipse
- Lancez Git Bash et éxecutez les commandes suivantes :
  * git add -A
  * git commit -a -m "message"
  * git pull
  * git push origin master

Pull les modifications :
- Fermez Eclipse
- Dans Git Bash : git pull
- Dans Eclipse (sur le meme workspace que celui où vous avez importé le projet au départ) : F5 sur src et sur chacun des dossiers à update.
