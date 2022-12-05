package fr.iutfbleau.projetIHM2022FI2.Controller;
import fr.iutfbleau.projetIHM2022FI2.API.*;
import fr.iutfbleau.projetIHM2022FI2.MNP.*;
//import fr.iutfbleau.projetIHM2022FI2.MP.*;
import java.util.*;

public class Cadmin {

    AbstractGroupeFactory groupeFactory;
    AbstractChangementFactory changementFactory;
    Groupe promo;

    public Cadmin(boolean exist){
        if(exist){

        }
        else {
            this.groupeFactory = new AbstractGroupeFactoryNP("Promotion actuelle", 15, 92);
            this.changementFactory = new AbstractChangementFactoryNP(groupeFactory);
            this.promo = groupeFactory.getPromotion();

            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

            StringBuilder nom = new StringBuilder();
            StringBuilder prenom = new StringBuilder();
        
            Random random = new Random();


            for (int i = 0; i < 50; i++) {
                for(int j = 0; i < 5; i++) {
                    int index = random.nextInt(alphabet.length());
              
                    char randomChar = alphabet.charAt(index);

                    nom.append(randomChar);

                    index = random.nextInt(alphabet.length());

                    randomChar = alphabet.charAt(index);
              
                    prenom.append(randomChar);        
                }

                promo.addEtudiant(new EtudiantNP(nom.toString(), prenom.toString()));
            }

            this.createGroup("Groupe 1");
            this.createGroup("Groupe 2");
            this.createGroup("Groupe 3");

        }
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

    public Etudiant getEtudiant(int id){
        Set<Etudiant> tmp = promo.getEtudiants();
        for (Etudiant etu : tmp){
            if (etu.getId() == id) return etu;
        }
        return null;
    }


    public void createGroup(String name){
        groupeFactory.createGroupe(promo, name, 15, 92);
    }

    public void deleteGroup(int id){
        promo.removeSousGroupe(getGroupe(id));
    }

    public void renameGroup(int id, String name){ 
        this.createGroup(name);
        Set<Etudiant> tmp = getGroupe(id).getEtudiants();
        for (Etudiant etu : tmp){
            this.getGroupe(name).addEtudiant(etu);
        }
        this.deleteGroup(id);
    }

    public void addToGroup(int id){
        Set<Etudiant> tmp = promo.getEtudiants();
        for (Etudiant etu : tmp){
            this.getGroupe(id).addEtudiant(etu);
        }
    }
    
    public void moveToGroup(int etuID, int groupID){
        
        

        groupeFactory.dropFromGroupe(getGroupe(groupID), getEtudiant(etuID));
        groupeFactory.addToGroupe(getGroupe(groupID), getEtudiant(etuID));
    }

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
