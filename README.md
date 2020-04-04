# Utaxi

Logiciel permettant de simuler un service de taxi

## Installation

Cette section vous explique comment installer les différentes dépendances et compiler le programme sur différents outils tels que Visual Studio Code ou Eclipse.

### Installation des dépendances

-   JDK : pour ce projet nous utilisons la version 14 du JDK. Rendez-vous sur le [site d'Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) pour l'installer.
-   Maven : Rendez-vous sur le [site d'Apache Maven](https://maven.apache.org/download.cgi) et télécharger l'archive (.zip pour Windows, .tar.gz pour MacOS et Linux) et décompressez-le. Placez-le dans un dossier facilement reconnaissable (par exemple : /Library/Java/Maven pour MacOS ou C:\Program Files\Maven pour Windows).
-   Ajouter JAVA_HOME et MAVEN_HOME à votre PATH :

    -   Pour Linux et MacOS : ajoutez les lignes suivante dans le fichier `~/.zshrc` ou `~/.bashrc` :

    ```sh
    export JAVA_HOME="/chemin/vers/java/jdk-14.jdk"
    export MAVEN_HOME="/chemin/vers/maven/Maven"
    export PATH="$PATH:$JAVA_HOME/bin:$MAVEN_HOME/bin"
    ```

    Sur MacOS, vous devez probablement adaptez la première ligne comme ceci ou la retirez :

    ```sh
    export JAVA_HOME=$(/usr/libexec/java_home)
    ```

    -   Pour Windows : Appuyez sur `Windows`+ `Pause` pour ouvrir les propriétés systèmes, allez dans l'onglet "Avancé", cliquez sur le bouton "Variables d'environnement". Ajouter une propriété `JAVA_HOME` avec le chemin de votre JDK : `C:\chemin\vers\java\jdk-14.jdk`. Modifiez également la propriété `PATH` en ajoutant le chemin vers Java et Maven :

    ```
    ;C:\chemin\vers\jdk-14.jdk\bin;C:\chemin\vers\maven\Maven\bin
    ```

    -   Paramètre optionnel : par défaut le dépôt de Maven est situé à l'adresse `~/.m2/repository` ce qui peut allourdir votre home. Vous pouvez changer cette valeur dans le fichier `~/.m2/settings.xml`. Consultez la [documentation d'Apache Maven](https://maven.apache.org/settings.html) pour en savoir plus.

-   Testez votre installation avec la commande `mvn -v` dans terminal.

### Configuration de Visual Studio Code

- Nous vous recommandons d'installer le [Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack).

-   Ouvrez ce projet dans votre éditeur comme Visual Studio Code et entrez la commande `mvn clean javafx:run`.