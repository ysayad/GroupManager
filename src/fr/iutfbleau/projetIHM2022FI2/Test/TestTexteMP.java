package fr.iutfbleau.projetIHM2022FI2.Test;
import fr.iutfbleau.projetIHM2022FI2.API.*;
import fr.iutfbleau.projetIHM2022FI2.MP.*;
import java.util.*;
import java.sql.*;


public class TestTexteMP {
    public static void main(String[] args) throws SQLException {

        System.out.println("Test de l\'API");
        System.out.print("Création des étudiants");
        
        Etudiant e1=new EtudiantP("césar","lycurgus");
        Etudiant e2=new EtudiantP("denis","uranus");
        Etudiant e3=new EtudiantP("marcel","castor");
        Etudiant e4=new EtudiantP("marin","eurydice");
        Etudiant e5=new EtudiantP("constantin","akoni");
        Etudiant e6=new EtudiantP("donat","anakoni");
        Etudiant e7=new EtudiantP("alexandre","apikalia");
        Etudiant e8=new EtudiantP("andré","ekewaka");
        Etudiant e9=new EtudiantP("renard","elikapeka");
        Etudiant e10=new EtudiantP("achille","haukea");

        System.out.print(".");
        
        Etudiant e11=new EtudiantP("agathe","iakopa");
        Etudiant e12=new EtudiantP("sabine","spartacus");
        Etudiant e13=new EtudiantP("michel","caligula");
        Etudiant e14=new EtudiantP("marthe","alaric");
        Etudiant e15=new EtudiantP("juliane","hannibal");
        Etudiant e16=new EtudiantP("anne","juvenal");
        Etudiant e17=new EtudiantP("sophie","bede");
        Etudiant e18=new EtudiantP("louis","hamilcar");
        Etudiant e19=new EtudiantP("diane","ladislas");
        Etudiant e20=new EtudiantP("christine","mahatma");

        System.out.print(".");
        
        Etudiant e21=new EtudiantP("francine","napoleon");
        Etudiant e22=new EtudiantP("louise","lalita");
        Etudiant e23=new EtudiantP("chantal","laxman");
        Etudiant e24=new EtudiantP("giselle","laxmi");
        Etudiant e25=new EtudiantP("caroline","leela");
        Etudiant e26=new EtudiantP("claude","lila");
        Etudiant e27=new EtudiantP("pauline","lilavati");
        Etudiant e28=new EtudiantP("avril","lochan");
        Etudiant e29=new EtudiantP("jacqueline","madhav");
        Etudiant e30=new EtudiantP("denise","turlough");

        System.out.print(".");
        
        Etudiant e31=new EtudiantP("gabrielle","uaithne");
        Etudiant e32=new EtudiantP("julie","uilleag");
        Etudiant e33=new EtudiantP("madeleine","uilliam");
        Etudiant e34=new EtudiantP("charlotte","uinseann");
        Etudiant e35=new EtudiantP("bertrand","ulick");
        Etudiant e36=new EtudiantP("lucile","ultan");
        Etudiant e37=new EtudiantP("nicole","firdaus");
        Etudiant e38=new EtudiantP("blanche","yasmin");
        Etudiant e39=new EtudiantP("jeanine","javed");
        Etudiant e40=new EtudiantP("roxane","naveed");

        System.out.print(".");
        
        Etudiant e41=new EtudiantP("adeline","shahnaz");
        Etudiant e42=new EtudiantP("dion","ardashir");
        Etudiant e43=new EtudiantP("liane","atefeh");
        Etudiant e44=new EtudiantP("myriam","luigina");
        Etudiant e45=new EtudiantP("danielle","luigino");
        Etudiant e46=new EtudiantP("arlette","maddalena");
        Etudiant e47=new EtudiantP("michelle","manfredo");
        Etudiant e48=new EtudiantP("justine","manlio");
        Etudiant e49=new EtudiantP("natalie","marcellino");
        Etudiant e50=new EtudiantP("aline","mariangela");

        System.out.print(".");
        
        Etudiant e51=new EtudiantP("prosper","marzio");
        Etudiant e52=new EtudiantP("mirabelle","massimiliano");
        Etudiant e53=new EtudiantP("carine","matteo");
        Etudiant e54=new EtudiantP("jeannine","melchiorre");
        Etudiant e55=new EtudiantP("dianne","micaela");
        Etudiant e56=new EtudiantP("evette","michela");
        Etudiant e57=new EtudiantP("gisselle","michelangela");

        System.out.println("terminé.");

        System.out.print("Création de l\'usine à groupe");
        AbstractGroupeFactory agf = new AbstractGroupeFactoryP("BUT2 FI", 15, 92);
        System.out.println("terminé.");

        System.out.print("Ajout des étudiants dans le groupe de la promotion racine");

        agf.addToGroupe(agf.getPromotion(),e1);
        agf.addToGroupe(agf.getPromotion(),e2);
        agf.addToGroupe(agf.getPromotion(),e3);
        agf.addToGroupe(agf.getPromotion(),e4);
        agf.addToGroupe(agf.getPromotion(),e5);
        agf.addToGroupe(agf.getPromotion(),e6);
        agf.addToGroupe(agf.getPromotion(),e7);
        agf.addToGroupe(agf.getPromotion(),e8);
        agf.addToGroupe(agf.getPromotion(),e9);
        agf.addToGroupe(agf.getPromotion(),e10);

        System.out.print(".");

        agf.addToGroupe(agf.getPromotion(),e11);
        agf.addToGroupe(agf.getPromotion(),e12);
        agf.addToGroupe(agf.getPromotion(),e13);
        agf.addToGroupe(agf.getPromotion(),e14);
        agf.addToGroupe(agf.getPromotion(),e15);
        agf.addToGroupe(agf.getPromotion(),e16);
        agf.addToGroupe(agf.getPromotion(),e17);
        agf.addToGroupe(agf.getPromotion(),e18);
        agf.addToGroupe(agf.getPromotion(),e19);
        agf.addToGroupe(agf.getPromotion(),e20);

        System.out.print(".");
        
        agf.addToGroupe(agf.getPromotion(),e21);
        agf.addToGroupe(agf.getPromotion(),e22);
        agf.addToGroupe(agf.getPromotion(),e23);
        agf.addToGroupe(agf.getPromotion(),e24);
        agf.addToGroupe(agf.getPromotion(),e25);
        agf.addToGroupe(agf.getPromotion(),e26);
        agf.addToGroupe(agf.getPromotion(),e27);
        agf.addToGroupe(agf.getPromotion(),e28);
        agf.addToGroupe(agf.getPromotion(),e29);
        agf.addToGroupe(agf.getPromotion(),e30);
        agf.addToGroupe(agf.getPromotion(),e31);
        agf.addToGroupe(agf.getPromotion(),e32);
        agf.addToGroupe(agf.getPromotion(),e33);
        agf.addToGroupe(agf.getPromotion(),e34);
        agf.addToGroupe(agf.getPromotion(),e35);
        agf.addToGroupe(agf.getPromotion(),e36);
        agf.addToGroupe(agf.getPromotion(),e37);
        agf.addToGroupe(agf.getPromotion(),e38);
        agf.addToGroupe(agf.getPromotion(),e39);

        System.out.print(".");
        
        agf.addToGroupe(agf.getPromotion(),e40);
        agf.addToGroupe(agf.getPromotion(),e41);
        agf.addToGroupe(agf.getPromotion(),e42);
        agf.addToGroupe(agf.getPromotion(),e43);
        agf.addToGroupe(agf.getPromotion(),e44);
        agf.addToGroupe(agf.getPromotion(),e45);
        agf.addToGroupe(agf.getPromotion(),e46);
        agf.addToGroupe(agf.getPromotion(),e47);
        agf.addToGroupe(agf.getPromotion(),e48);
        agf.addToGroupe(agf.getPromotion(),e49);
        agf.addToGroupe(agf.getPromotion(),e50);
        agf.addToGroupe(agf.getPromotion(),e51);
        agf.addToGroupe(agf.getPromotion(),e52);
        agf.addToGroupe(agf.getPromotion(),e53);
        agf.addToGroupe(agf.getPromotion(),e54);
        agf.addToGroupe(agf.getPromotion(),e55);
        agf.addToGroupe(agf.getPromotion(),e56);
        agf.addToGroupe(agf.getPromotion(),e57);
        System.out.println("terminé.");

        System.out.println("Initialisation complète.");
        
        System.out.println("==========================");
        System.out.println("Le groupe promotion");
        System.out.println(agf.getPromotion().monPrint());

        System.out.println("==========================");
        System.out.println("Partition du groupe racine en 3 groupes TD.");
        agf.createPartition(agf.getPromotion(), "TD",3);
        
        System.out.println(agf.getPromotion().monPrint());

        Groupe racineDeLaPartition = agf.getPromotion().getSousGroupes().iterator().next();
        System.out.println(racineDeLaPartition.monPrint());


    }
}
