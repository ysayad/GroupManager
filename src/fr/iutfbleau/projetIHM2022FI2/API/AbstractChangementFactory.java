package fr.iutfbleau.projetIHM2022FI2.API;
import java.util.*;
/**
 * Usine abstraite gérant l'ensemble des changements.
 * 
 * 
 */

public interface AbstractChangementFactory {

    /**
     * permet de récupérer une usine abstraite pour les groupes qui fonctionne en tandem avec cette usine abstraite
     * @return cette usine abstraite
     */
    public AbstractGroupeFactory getGroupeFactory();
    
    /**
     * permet de récupérer les changements 
     * @return tous les changements en attente
     */
    public Iterator<Changement> getAllChangements();

    /**
     * permet de supprimer un changement connu de l'usine abstraite.
     *
     * @throws java.lang.NullPointerException si un argument est null
     * @throws java.lang.IllegalArgumentException si inconnu de l'usine abstraite
     */
    public void deleteChangement(Changement c);

    /**
     * permet d'ajouter un nouveau changement.
     *
     * @param A groupe actuel
     * @param B groupe demandé
     * @param e étudiant concerné par le changement
     *
     * @throws java.lang.NullPointerException si un argument est null
     * @throws java.lang.IllegalArgumentException si les groupes ou l'étudiant ne sont pas connus de la factory partenaire, ou e n'appartient pas à A ou A et B ne sont pas frères dans l'arbre des groupes.
     *        
     */
    public void createChangement(Groupe A, Etudiant e, Groupe B);
    
}
