# ProjetFinalSecurity_G1

//Jour1// (Scrum master : Lucie Argaud)<br>
07/04/2023<br>

- Réutilisation du Notion du projet principal

-Configuration Github<br>
<ul>
 <li> Créer un nouveau repository </li><li>
  Ajouter des collaborateurs : Settings -> Collaborators -> Add people </li><li>
  Pour la personne qui crée le repository : création du projet Spring puis lier le repository avec Team -> Share Project -> Pull puis entrer l'url du repository Github
  </li><li>
  Pour les autres collaborateurs : dans Eclipse File -> Import -> Project from Git (with smart import) -> Clone URI puis entrer l'url du repository. Importer la 
  branche master et faire un update du projet Maven</li>
</ul>

-Création du projet Spring (Spring Starter Project) avec les dépendances : H2 Database, Spring Boot Devtools, Spring Web, Lombok, Spring Data JPA, Thymeleaf, 
MySQLDriver, SpringSecurity
<ul>
 <li>Java version 14 </li><li>
 Spring version 2.7.9 </li><li>
 Fichier application.properties : configuration à la base de données </li><li>
 Création des packages : com.inti.model, .repository, .controller </li><li>
 Création des classes </li><li>
 Ajout des annotations sur les classes qui ne sont pas des classes filles : @Entity, @Data, @Table, @NoArgConstructor, @Id et 
 @GeneratedValue(stratedy=GenerationType.IDENTITY). <br>
 La classe mère Personne a été configurée en abstract puisqu'une personne est forcément dans une des classes filles. <br>
 Pour les classes filles, mettre uniquement les @Entity, @Table et @Data si il y a des arguments propres à la classe fille
 Création des relations entre les classes : @OneToMany et @ManyToOne avec la commande @JoinColumn(name="") dans la classe avec la plus petite cardinalité. 
 L'autre classe n'a pas besoin de faire le @JoinColumn, il suffit de préciser @ManyToOne(mappedBy = "NomObjet"). Avec les relations, il y a un risque que 
 certaines fonctions appellent en boucle des objets. La commande @JsonIgnoreProperties permet d'anticiper ces erreurs.</li><li>
 Pour créer les tables sur SQL en prenant en compte l'héritage, on ajoute les annotations @Inheritance (strategy=InheritanceType.JOINED) dans la table MERE 
 et @PrimaryKeyColumn(name="") dans les tables FILLES. Ces annotations permettent de créer une table de la classe mère et une table par classe fille, avec 
 les attributs associés.</li><li>
 On lance le projet en Spring Boot App (Run as -> Spring Boot App), ce qui crée automatiquement les tables en base de données. </li><li>
 Liaison avec github : Team -> Push Branch master puis coller le lien du github utilisé </li><li>
 Push du projet créé </li>
</ul>

//Jour2// (Scrum master : Lucie Argaud)<br>
11/04/2023<br>

<ul>-Configuration Security
 <li> Configuration Http <br>
 Dans com.inti.configuration, le fichier SecurityConfig définit les rôles et les pages autorisées grâce à l'ojet HttpSecurity. On peut autoriser un ou plusieurs rôles à consulter des pages avec un certain RequestMapping et définir une page de login et d'accueil. Le fichier définit également une fonction BCryptPasswordEncoder pour avoir des mots de passe cyptés.</li><li>
 Pour s'authentifier, la page UserDetailsServiceImpl cherche si l'id entré correspond à une des classes d'utilisateur et asigne le rôle correspondant.
</li>
</ul>

<ul>- Admin
 <li> Gestion des utilisateurs <br>
 Lorsqu'un utilisateur se crée un compte, il est ajouté en base de donnée. L'administrateur a accès à une page qui répertorie tous les utilisateurs .</li><li>
 Pour s'authentifier, la page UserDetailsServiceImpl cherche si l'id entré correspond à une des classes d'utilisateur et asigne le rôle correspondant.
</li>
</ul>
