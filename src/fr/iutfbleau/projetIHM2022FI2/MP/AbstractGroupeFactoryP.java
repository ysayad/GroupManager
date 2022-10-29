package fr.iutfbleau.projetIHM2022FI2.MP;
import fr.iutfbleau.projetIHM2022FI2.API.*;
import java.util.*;

/**
 * Usine abstraite gérant l'ensemble des groupes.
 * 
 */

public class AbstractGroupeFactoryP implements AbstractGroupeFactory {
    public AbstractGroupeFactoryP(String string, int i, int j) {
    }

    public Groupe getPromotion(){
        return null;
    }

    public void deleteGroupe(Groupe g){
        
    }

    public void createGroupe(Groupe pere, String name, int min, int max){

    }

    public void createPartition(Groupe pere, String name, int n){

    }

    public void addToGroupe(Groupe g, Etudiant e){

    }

    public void dropFromGroupe(Groupe g, Etudiant e){

    }

    public Set<Etudiant> getEtudiants(String nomEtu){
        return null;
    }

    public Set<Groupe> getGroupesOfEtudiant(Etudiant etu){
        return null;
    }
}
