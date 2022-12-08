JC = javac -implicit:none -d build -classpath build -sourcepath "src"
SRC = src/fr/iutfbleau/projetIHM2022FI2/
BUILD = build/fr/iutfbleau/projetIHM2022FI2/

API:
	$(JC) $(SRC)API/*.java

MNP:
	$(JC) $(SRC)MNP/*.java

Controller:
	$(JC) $(SRC)Controller/*.java

Vues:
	$(JC) $(SRC)Vues/Admin/test/*.java


classes: 
	$(JC) $(SRC)API/*.java
	$(JC) $(SRC)MNP/*.java
	$(JC) $(SRC)MP/*.java
	$(JC) $(SRC)Controller/*.java
	$(JC) $(SRC)Vues/Admin/test/*.java


jarMNP:
	jar cvfe test-mnp.jar fr.iutfbleau.projetIHM2022FI2.Test.TestTexteMNP -C build fr

jarAdmin: classes
	jar cvfe admin.jar fr.iutfbleau.projetIHM2022FI2.Vues.Admin.test.Admin -C build fr -C build org -C src/fr/iutfbleau/projetIHM2022FI2/Vues/Img .

jarEleve: classes
	jar cvfe eleve.jar fr.iutfbleau.projetIHM2022FI2.Vues.Eleve.test.Eleve -C build fr -C build org -C src/fr/iutfbleau/projetIHM2022FI2/Vues/Img .

jarProf: classes
	jar cvfe prof.jar fr.iutfbleau.projetIHM2022FI2.Vues.Prof.test.Prof -C build fr -C build org -C src/fr/iutfbleau/projetIHM2022FI2/Vues/Img .

runMNP: 
	java -jar test-mnp.jar 

admin: jarAdmin 
	java -jar admin.jar 

eleve: jarEleve 
	java -jar eleve.jar 

prof: jarProf 
	java -jar prof.jar 

clean:
	rm -rf ${BUILD}/* *.jar
