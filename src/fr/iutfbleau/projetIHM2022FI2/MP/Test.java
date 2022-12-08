package fr.iutfbleau.projetIHM2022FI2.MP;

import fr.iutfbleau.projetIHM2022FI2.API.*;
import fr.iutfbleau.projetIHM2022FI2.MP.*;
import java.util.*;
import org.mariadb.jdbc.*;
import java.sql.*;

public class Test{
     public static void main(String[] args){
        /*
        1er construc = ok
        createGroupe = ok
        del groupe = ok
        addtogroupe = ok
        dropFromGroupe = ok
        getGroupeOfEtudiant = ok
        getEtudiants = Ok

        */
        try{
            //AbstractGroupeFactory facto = new AbstractGroupeFactoryP("PROMOTION",10,15);
            //System.out.println("Test Constructeur 1 : Affichage de la promo");
            AbstractGroupeFactory facto = new AbstractGroupeFactoryP();
            System.out.println("Test Constructeur 2 : Affichage de la promo");
            System.out.println("PROMO TAIILLE "+facto.getPromotion().getEtudiants().size());
            for(Etudiant etuTmp : facto.getPromotion().getEtudiants()){
                System.out.println("    "+etuTmp.getNom());
            }

            // System.out.println("On crée le groupe TD1");
            // facto.createGroupe(facto.getPromotion(),"TD1",10,20);
            Set<Groupe> g = facto.getPromotion().getSousGroupes();
            Iterator<Groupe> it = g.iterator();
            System.out.println(facto.getPromotion().getSousGroupes().size());
            System.out.println("Affichage des sous-groupes de la promo");
            while(it.hasNext()){
                Groupe grp = it.next();
                System.out.println("    "+grp.getName());
                for(Groupe gTmp : grp.getSousGroupes()){
                    System.out.println("        "+gTmp.getName());
                }
            }
            //Groupe td1 = facto.getPromotion().getSousGroupes().iterator().next();
            // facto.deleteGroupe(td1);
            // System.out.println("On va delete td1");
            // g = facto.getPromotion().getSousGroupes();
            // if(g.isEmpty()) System.out.println("Le groupe TD1 a bien été supprimé");
            // it = g.iterator();
            // while(it.hasNext()){
            //     System.out.println(it.next().getId());
            // }
            // Etudiant firstStudent = facto.getPromotion().getEtudiants().iterator().next();
            // System.out.println("On ajoute un étudiant au groupe TD1");
            // facto.addToGroupe(td1,firstStudent);
            
            // System.out.println("Le TD1 possede l'étudiant: "+td1.getEtudiants().iterator().next().getPrenom());
            // System.out.println("On va supprimer l'etudiant du groupe TD1");
            // facto.dropFromGroupe(td1,firstStudent);
            // if(td1.getEtudiants().isEmpty()) System.out.println("Le groupe TD1 est maintenant vide");
            // // if(g.isEmpty()) System.out.println("Le groupe TD1 a bien été supprimé");
            // // it = g.iterator();
            // // while(it.hasNext()){
            // //     System.out.println(it.next().getId());
            // // }
            // System.out.println("On crée une partition de 5 groupes de la promotion");
            // facto.createPartition(facto.getPromotion(),"TD",5);
            // System.out.println("On affiche les sous groupes de Promotion");
            // g = facto.getPromotion().getSousGroupes();
            // it = g.iterator();
            // while(it.hasNext()){
            //     Groupe gTmp = it.next();
            //     System.out.println("    "+gTmp.getName()+" : Possede "+gTmp.getSousGroupes().size()+" sous-groupes");
            //     Iterator<Groupe> it2 = gTmp.getSousGroupes().iterator();
            //         while(it2.hasNext()){
            //             Groupe gTmp2 = it2.next();
            //             System.out.println("        "+gTmp2.getName()+" : Possede "+gTmp2.getSousGroupes().size()+" sous-groupes");
                        
            //         }
            // }

            // System.out.println("Recherche d'étudiants avec un nom commencant par M:");
            // Iterator<Etudiant> itEtu = facto.getEtudiants("M").iterator();
            // while(itEtu.hasNext()){
            //     Etudiant etuTmp = itEtu.next();
            //     System.out.println("    "+etuTmp.getNom());
            // }
            
            // Etudiant etu = facto.getPromotion().getEtudiants().iterator().next();
            // System.out.println("Recuperation des groupes de l'étudiant "+etu.getNom());
            // Set<Groupe> groupes = facto.getGroupesOfEtudiant(etu);
            // Iterator<Groupe> itGrp = groupes.iterator();
            // while(itGrp.hasNext()){
            //     System.out.println("    "+itGrp.next().getName());
            // }
        }catch(IllegalStateException ex){
            System.out.println(ex.getMessage());
        }
        //Test 2eme constructeur 
        // try{
        //     AbstractGroupeFactory facto = new AbstractGroupeFactoryP("PROMOTION",10,15);
        // }catch(IllegalStateException ex){
        //     System.out.println(ex.getMessage());
        // }
     }
}