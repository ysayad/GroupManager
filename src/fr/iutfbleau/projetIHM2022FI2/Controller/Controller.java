package fr.iutfbleau.projetIHM2022FI2.Controller;
import fr.iutfbleau.projetIHM2022FI2.API.*;
import fr.iutfbleau.projetIHM2022FI2.MNP.*;
import fr.iutfbleau.projetIHM2022FI2.MP.*;
import java.util.*;

public class Controller {

    public static Controller instance = null;
    AbstractGroupeFactory groupeFactory;
    AbstractChangementFactory changementFactory;
    Groupe promo;

    private Controller(boolean persist){
        if(persist){
            this.groupeFactory = new AbstractGroupeFactoryP();
            //this.changementFactory = new AbstractChangementFactoryNP(groupeFactory);
            this.promo = groupeFactory.getPromotion();
        }
        else {
            this.groupeFactory = new AbstractGroupeFactoryNP("Promotion actuelle", 15, 92);
            this.changementFactory = new AbstractChangementFactoryNP(groupeFactory);
            this.promo = groupeFactory.getPromotion();

            promo.addEtudiant(new EtudiantNP("césar","lycurgus"));
            promo.addEtudiant(new EtudiantNP("denis","uranus"));
            promo.addEtudiant(new EtudiantNP("marcel","castor"));
            promo.addEtudiant(new EtudiantNP("marin","eurydice"));
            promo.addEtudiant(new EtudiantNP("constantin","akoni"));
            promo.addEtudiant(new EtudiantNP("donat","anakoni"));
            promo.addEtudiant(new EtudiantNP("alexandre","apikalia"));
            promo.addEtudiant(new EtudiantNP("andré","ekewaka"));
            promo.addEtudiant(new EtudiantNP("renard","elikapeka"));
            promo.addEtudiant(new EtudiantNP("achille","haukea"));
            promo.addEtudiant(new EtudiantNP("agathe","iakopa"));
            promo.addEtudiant(new EtudiantNP("sabine","spartacus"));
            promo.addEtudiant(new EtudiantNP("michel","caligula"));
            promo.addEtudiant(new EtudiantNP("marthe","alaric"));
            promo.addEtudiant(new EtudiantNP("juliane","hannibal"));
            promo.addEtudiant(new EtudiantNP("anne","juvenal"));
            promo.addEtudiant(new EtudiantNP("sophie","bede"));
            promo.addEtudiant(new EtudiantNP("louis","hamilcar"));
            promo.addEtudiant(new EtudiantNP("diane","ladislas"));
            promo.addEtudiant(new EtudiantNP("christine","mahatma"));
            promo.addEtudiant(new EtudiantNP("youcef","sayad"));
            promo.addEtudiant(new EtudiantNP("francine","napoleon"));
            promo.addEtudiant(new EtudiantNP("adam","meddahi"));
            promo.addEtudiant(new EtudiantNP("louise","lalita"));
            promo.addEtudiant(new EtudiantNP("yanis","bouarroudj"));
            promo.addEtudiant(new EtudiantNP("chantal","laxman"));
            promo.addEtudiant(new EtudiantNP("giselle","laxmi"));
            promo.addEtudiant(new EtudiantNP("caroline","leela"));
            promo.addEtudiant(new EtudiantNP("florent","madelaine"));
            promo.addEtudiant(new EtudiantNP("claude","lila"));
            promo.addEtudiant(new EtudiantNP("luc","hernandez"));
            promo.addEtudiant(new EtudiantNP("pauline","lilavati"));
            promo.addEtudiant(new EtudiantNP("avril","lochan"));
            promo.addEtudiant(new EtudiantNP("jacqueline","madh)av"));
            promo.addEtudiant(new EtudiantNP("denise","turlough"));
            promo.addEtudiant(new EtudiantNP("gabrielle","uaithne"));
            promo.addEtudiant(new EtudiantNP("julie","uilleag"));
            promo.addEtudiant(new EtudiantNP("madeleine","uilliam"));
            promo.addEtudiant(new EtudiantNP("charlotte","uinseann"));
            promo.addEtudiant(new EtudiantNP("bertrand","ulick"));
            promo.addEtudiant(new EtudiantNP("lucile","ultan"));
            promo.addEtudiant(new EtudiantNP("nicole","firdaus"));
            promo.addEtudiant(new EtudiantNP("blanche","yasmin"));
            promo.addEtudiant(new EtudiantNP("jeanine","javed"));
            promo.addEtudiant(new EtudiantNP("roxane","naveed"));       
            promo.addEtudiant(new EtudiantNP("adeline","shahnaz"));
            promo.addEtudiant(new EtudiantNP("dion","ardashir"));
            promo.addEtudiant(new EtudiantNP("liane","atefeh"));
            promo.addEtudiant(new EtudiantNP("myriam","luigina"));
            promo.addEtudiant(new EtudiantNP("danielle","luigino"));
            promo.addEtudiant(new EtudiantNP("arlette","maddalena"));
            promo.addEtudiant(new EtudiantNP("michelle","manfredo"));
            promo.addEtudiant(new EtudiantNP("justine","manlio"));
            promo.addEtudiant(new EtudiantNP("natalie","marcellino"));
            promo.addEtudiant(new EtudiantNP("aline","mariangela"));          
            promo.addEtudiant(new EtudiantNP("prosper","marzio"));
            promo.addEtudiant(new EtudiantNP("mirabelle","massimiliano"));
            promo.addEtudiant(new EtudiantNP("carine","matteo"));
            promo.addEtudiant(new EtudiantNP("jeannine","melchiorre"));
            promo.addEtudiant(new EtudiantNP("dianne","micaela"));
            promo.addEtudiant(new EtudiantNP("evette","michela"));
            promo.addEtudiant(new EtudiantNP("gisselle","michelangela"));

            //init groupe
            groupeFactory.createPartition(promo, "TD", 4);
            groupeFactory.createGroupe(groupeFactory.getPromotion().getSousGroupes().iterator().next().getSousGroupes().iterator().next(), "Frites", 15, 92);

            //init changements
            Iterator<Groupe> itgr = promo.getSousGroupes().iterator().next().getSousGroupes().iterator();
            Groupe A = itgr.next(); // premier sous-groupe
            Groupe B = itgr.next(); // second sous-groupe
            B = itgr.next(); // troisième sous-groupe
            Etudiant e = A.getEtudiants().iterator().next();// premier étudiant du premier sous-groupe.
            changementFactory.createChangement(A,e,B);
            changementFactory.createChangement(B,B.getEtudiants().iterator().next(),A);

        }
    }

    public static Controller Instance(boolean bool){
        if (instance == null) {
            instance = new Controller(bool);
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
    public void renameGroup(Groupe g, String name){ 
        groupeFactory.createGroupe(g.getPointPoint(), name, g.getMin(), g.getMax());
        Set<Etudiant> tmp = g.getEtudiants();
        for (Groupe gggg : g.getPointPoint().getSousGroupes()) {
            if (gggg.getName() == name) {
                for (Etudiant etu : tmp){
                    gggg.addEtudiant(etu);
                }
            }
        }

        groupeFactory.deleteGroupe(g);
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
    public Set<Etudiant> search(String name, Groupe grp){
        Set<Etudiant> list = grp.getEtudiants();
        Set<Etudiant> out = new LinkedHashSet<Etudiant>();
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
            if (match) out.add(etudiant);
        }
        return out;
    }


}

//- classement alphabétique
//- noms credibles
//= implémentation de la recherche