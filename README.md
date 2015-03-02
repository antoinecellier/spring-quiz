# spring-quiz
Application fil rouge - Antoine Cellier Amaury Lavieille

# Installation

* Modifier le fichier web.xml le paramêtre data (pour l'upload)
* Modifier le fichier applicationContext.xml ligne 52 pour base de données
* 'mvn install' pour générer le .war

Attention si proxy : 
Ajouter un fichier settings.xml et ajouter la configuration de proxy 
example : 
<settings>
  <proxies>
   <proxy>
      <id>unicaen-proxy</id>
      <active>true</active>
      <protocol>http</protocol>
      <host>proxy.unicaen.fr</host>
      <port>3128</port>
    </proxy>
  </proxies>
</settings>

et exécuter la commande suivante mvn -s settings.xml install

* fichier .war générer dans le dossier target

