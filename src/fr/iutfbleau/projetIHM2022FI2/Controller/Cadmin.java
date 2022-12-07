package fr.iutfbleau.projetIHM2022FI2.Controller;
import fr.iutfbleau.projetIHM2022FI2.API.*;
import fr.iutfbleau.projetIHM2022FI2.MNP.*;
import fr.iutfbleau.projetIHM2022FI2.MP.*;
import java.util.*;

public class Cadmin {

    public static Cadmin instance = null;
    AbstractGroupeFactory groupeFactory;
    AbstractChangementFactory changementFactory;
    Groupe promo;

    private Cadmin(boolean persist){
        if(persist){
            //this.groupeFactory = new AbstractGroupeFactoryP();
            //this.changementFactory = new AbstractChangementFactoryP();
            //this.promo = groupeFactory.getPromotion();
        }
        else {
            this.groupeFactory = new AbstractGroupeFactoryNP("Promotion actuelle", 15, 92);
            this.changementFactory = new AbstractChangementFactoryNP(groupeFactory);
            this.promo = groupeFactory.getPromotion();

            // Random name
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

            StringBuilder nom = new StringBuilder();
            StringBuilder prenom = new StringBuilder();
        
            Random random = new Random();

            //init etudiant
            for (int i = 0; i < 50; i++) {
                for(int j = 0; j < 5; j++) {
                    int index = random.nextInt(alphabet.length());
              
                    char randomChar = alphabet.charAt(index);

                    nom.append(randomChar);

                    index = random.nextInt(alphabet.length());

                    randomChar = alphabet.charAt(index);
              
                    prenom.append(randomChar);        
                }


                promo.addEtudiant(new EtudiantNP(nom.toString(), prenom.toString()));

                prenom = new StringBuilder();
                nom = new StringBuilder();
            }

            //init groupe
            groupeFactory.createPartition(promo, "TD", 4);

            //init changements
            /*Iterator<Groupe> itgr = promo.getSousGroupes().iterator();
            Groupe A = itgr.next(); // premier sous-groupe
            Groupe B = itgr.next(); // second sous-groupe
            B = itgr.next(); // troisième sous-groupe
            Etudiant e = A.getEtudiants().iterator().next();// premier étudiant du premier sous-groupe.
            changementFactory.createChangement(A,e,B);*/

        }
    }

    public static Cadmin Instance(boolean bool){
        if (instance == null) {
            instance = new Cadmin(bool);
        }
        return instance;
    }

    public AbstractChangementFactory getChangementFactory(){
        return this.changementFactory;
    }
    
    public AbstractGroupeFactory getGroupeFactory(){
        return this.groupeFactory;
    }

    public Groupe getGroupe(int id){
        Set<Groupe> sousGroupe = promo.getSousGroupes();
        for (Groupe groupe : sousGroupe){
            if (groupe.getId() == id) return groupe;
        }
        return null;
    }

    public Groupe getGroupe(String name){
        Set<Groupe> sousGroupe = promo.getSousGroupes();
        for (Groupe groupe : sousGroupe){
            if (groupe.getName() == name) return groupe;
        }
        return null;
    }

    public int getGroupeSize(int id){
        Set<Groupe> sousGroupe = promo.getSousGroupes();
        for (Groupe groupe : sousGroupe){
            if (groupe.getId() == id) return groupe.getSize();
        }
        return 0;
    }

    public Set<Groupe> getAllGroup(){
        return promo.getSousGroupes();
    }

    public Set<Changement> getAllChangements(){
        return changementFactory.getAllChangements();
    }

    public Etudiant getEtudiant(int id){
        Set<Etudiant> tmp = promo.getEtudiants();
        for (Etudiant etu : tmp){
            if (etu.getId() == id) return etu;
        }
        return null;
    }



    //Début MoSCoW 

    // Créer un groupe
    public void createGroup(String name){
        groupeFactory.createGroupe(promo, name, 15, 92);
    }

    // Créer une partition
    public void createPartition(String name, int groupeid, int n){
        groupeFactory.createPartition(getGroupe(groupeid), name, n);
    }

    // Supprimer un groupe
    public void deleteGroup(int id){
        promo.removeSousGroupe(getGroupe(id));
    }

    // Renommer un groupe
    public void renameGroup(int id, String name){ 
        this.createGroup(name);
        Set<Etudiant> tmp = getGroupe(id).getEtudiants();
        for (Etudiant etu : tmp){
            this.getGroupe(name).addEtudiant(etu);
        }
        this.deleteGroup(id);
    }

    // Ajouter un étudiant à un groupe
    public void addToGroup(int id){
        Set<Etudiant> tmp = promo.getEtudiants();
        for (Etudiant etu : tmp){
            this.getGroupe(id).addEtudiant(etu);
        }
    }
    
    // Déplacer un étudiant dans un autre groupe
    public void moveToGroup(int etuID, int groupID){
        groupeFactory.dropFromGroupe(getGroupe(groupID), getEtudiant(etuID));
        groupeFactory.addToGroupe(getGroupe(groupID), getEtudiant(etuID));
    }

    // Rechercher un étudiant avec les premières lettres
    public Set<Etudiant> search(String name, int groupid){
        Set<Etudiant> list = new LinkedHashSet<Etudiant>();
        boolean match = true;
        for (Etudiant etudiant : list) {
            for (int i = 0; i < name.length(); i++) {
                if (etudiant.getNom().charAt(i) == name.charAt(i)) {
                    match = true;
                } else {
                    match = false;
                    break;
                }
            }
            if (match) list.add(etudiant);
        }
        return list;
    }


}

//- classement alphabétique
//- noms credibles
//= implémentation de la recherche