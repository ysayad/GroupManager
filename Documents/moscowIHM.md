**L’administrateur doit pouvoir :**

* M : ``créer, supprimer et renommer un groupe ``

* M : ``ajouter un individu dans un groupe``

* M : ``déplacer un individu dans un autre groupeS déplacer un individu en validant sa demande (demande de type 1)``

* S : ``refus d’une demande (de type 1)``

* S : ``fabriquer automatiquement une partition des étudiants en plusieurs groupes``

* C : ``Les groupes forment une arborescence. Tout en haut toute la promo, un groupe indes-tructibles ensuite on peut soit ajouter des groupes qui ne forment pas une partition, soitun groupe qui forme une partition.Par exemple : à une partition classique sous forme d’arbre Promo, groupes de TD, groupesde TP, groupes de projets, on pourrait ajouter en parallèle de groupes de TD une autrepartition en boursier/non boursiers, et des groupes qui ne forment pas de partition parexemple en (aime la) pizza et (aime les) pâtes``

* W : ``généralisation de l’idée ci-dessus mais avec des cycles de taille plus grande que 2``

* W : ``adapter toutes les opérations à cette arborescence complexe.NB. la suppression d’un groupe n’entraîne pas la destruction d’un étudiant y appartenant. Il est tout à fait possible d’appartenir à plusieurs groupes.``





**L’enseignant doit pouvoir:**

* M : ``afficher la liste des groupes``

* M : ``afficher la liste des étudiant d’un groupe donné``

* S : ``chercher le groupe d’un étudiant à partir des premières lettres de son nom``

**L’étudiant doit pouvoir**

* M : ``afficher la liste des groupes``

* M :`` afficher la liste des étudiant d’un groupe donné``

* M : ``demander à passer dans un groupe qui est moins plein que le sien en ajoutant une explication (demande de type 1 à faire valider).``
  
* S : ``demander à passer dans un groupe qui est de même taille ou plus grand en ajoutant une explication pour l’administrateur (demande de type 2 à faire valider).``

* S : ``voir les demandes de changement de groupe du type 2 (pour favoriser les échanges).``