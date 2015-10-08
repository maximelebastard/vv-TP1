V&V - TP1 - Rapport
======

Question 1
---
Le test n'assure pas que la ligne list.remove(o) ; fonctionne, car le test n'est pas indépendant. 
En effet, plusieurs opérations sont effectuées sur la liste, dont la création de l'objet à y ajouter, l'ajout dans la liste et la suppression. Le fait que la taille de la liste soit égale à zéro à la fin du test peut donc avoir plusieurs causes, et pas uniquement une défaillance de la ligne list.remove(o) ;

Question 2
---
Mais si le cas de test est positif, cela ne révèle pas forcément que la méthode list.remove(o) fonctionne. En effet, il est également possible que la méthode list.add(o) soit défaillante et que l'objet ne soit jamais ajouté à la liste. Le test sera alors valide, même si la méthode add a échoué. Le test ne peut donc pas prouver que la méthode add dysfonctionne.

Question 3
---
Pour que le test de la méthode remove soit valide, il faut être sûr de l'état initial de l'objet fourni au cas de test et ne tester que la méthode remove. Il faudrait donc déporter l'alimentation initiale de la liste dans la méthode setUp, tester la méthode add en amont, et ensuite tester la méthode remove. Nous serions ainsi sûrs que la liste fournie au cas de test contient un élément en entrée et, en ne testant que la méthode remove, nous serions sûrs que si la liste est vide en sortie, c'est bien du fait de la méthode remove.

Question 4
---
L'ordre des cas de test n'a pas d'importance au sein de la classe. En effet, comme leur nom l'indique, tous les tests unitaires doivent être réalisés dans le même contexte, sans lien les uns avec les autres. Cette indépendance permet de cibler précisément la cause du succès ou de l'échec d'un test, et d'éviter les tests d'interférer les uns avec les autres.

Question 5
---
Si le résultat du test de add est satisfaisant, nous pouvons considérer que la méthode addBefore fonctionne correctement dans le cadre de l'appel de la fonction add. En revanche, si addBefore est appelée dans d'autres méthodes, il faudra tester toutes les autres méthodes qui utilisent addBefore voire la méthode addBefore elle même pour pouvoir affirmer qu'elle a été suffisamment testée.

Question 6
---
Etant donné que les méthodes privées sont utilisées indirectement par les méthodes publiques, un test efficace des méthodes publiques peut être suffisant. La couverture de code n'est pas une bonne métrique, car passer par toutes les méthodes ne signifie pas tester tous les chemins de code possibles. Un test méthodique des cas aux limite des méthodes est plus efficace qu'une couverture à 100% du code.
Dans certains cas, il peut de toute façon être difficile de couvrir tout le code, notamment lors de l'utilisation de librairies externes.