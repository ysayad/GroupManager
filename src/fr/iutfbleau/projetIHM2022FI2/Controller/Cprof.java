package fr.iutfbleau.projetIHM2022FI2.Controller;
import fr.iutfbleau.projetIHM2022FI2.API.*;
import fr.iutfbleau.projetIHM2022FI2.MNP.*;
import fr.iutfbleau.projetIHM2022FI2.MP.*;
import java.util.*;

public class Cprof {
    AbstractGroupeFactory groupeFactory;
    AbstractChangementFactory changementFactory;
    Groupe promo;
    Etudiant himself;

    public Cprof(boolean persist){
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

            this.himself = promo.getEtudiants().iterator().next();

            //init groupe
            groupeFactory.createPartition(promo, "TD", 4);

            //init changements
            Iterator<Groupe> itgr = promo.getSousGroupes().iterator();
            Groupe A = itgr.next(); // premier sous-groupe
            Groupe B = itgr.next(); // second sous-groupe
            B = itgr.next(); // troisième sous-groupe
            Etudiant e = A.getEtudiants().iterator().next();// premier étudiant du premier sous-groupe.
            changementFactory.createChangement(A,e,B);
        }
    }

    public Set<Groupe> getAllGroup(){
        return promo.getSousGroupes();
    }

    public Set<Etudiant> getStudentsOf(Groupe grp){
        return grp.getEtudiants();
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
