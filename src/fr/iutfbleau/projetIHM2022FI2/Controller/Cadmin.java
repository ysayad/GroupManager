package fr.iutfbleau.projetIHM2022FI2.Controller;
import fr.iutfbleau.projetIHM2022FI2.API.*;
import fr.iutfbleau.projetIHM2022FI2.MNP.*;
import fr.iutfbleau.projetIHM2022FI2.MP.*;
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
            this.changementFactory = new AbstractChangementFactoryP();
            this.promo = groupeFactory.getPromotion();
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


}
