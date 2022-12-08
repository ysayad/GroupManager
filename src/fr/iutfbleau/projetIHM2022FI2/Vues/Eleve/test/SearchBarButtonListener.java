package fr.iutfbleau.projetIHM2022FI2.Vues.Eleve.test;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.Cursor;
import java.awt.*;
import javax.swing.*;
import javax.swing.UIManager.*;
import javax.swing.border.Border;

import fr.iutfbleau.projetIHM2022FI2.Controller.Controller;
import fr.iutfbleau.projetIHM2022FI2.API.*;

import java.io.*;
import java.lang.Thread;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class SearchBarButtonListener implements MouseListener{
    JTextField searchbar;
    JFrame window;
    Menu menu;
    JButton button;
    CardLayout cardLayout;




    public SearchBarButtonListener(JFrame window,CardLayout cardLayout, JButton button, Menu menu,JTextField searchbar) {
        this.window=window;
        this.button = button;
        this.cardLayout = cardLayout;
        this.menu = menu;
        this.searchbar = searchbar;
    }






public void refresh(String name, Set<Etudiant> liste){

            if (name == "Etudiants  ") {
                this.window.remove(menu);


            Menu menu = new Menu(this.window, cardLayout, name, "Administrtateur");
            GridLayout gridLayout = new GridLayout(1,2);
            gridLayout.setHgap(0);
            gridLayout.setVgap(0);


            JPanel menuContainer = new JPanel(new BorderLayout());



            JPanel menuP = new JPanel(new BorderLayout());
            SearchBar searchbar = new SearchBar(menu,this.window,this.cardLayout);
            menuP.add(searchbar.drawSearchBar(),BorderLayout.PAGE_START);
            CarteEtudiant carteGroupe = new CarteEtudiant(menu,this.window, liste);

            menuP.add(carteGroupe.drawCarteGroupe(),BorderLayout.CENTER);



            menuContainer.add(menu.drawMenu(),BorderLayout.LINE_START);

            menuContainer.add(menuP);


            this.window.add(menuContainer, "Menu");


            this.window.revalidate();
            this.window.repaint();
            this.window.invalidate();
            this.window.validate();


        }

}

   
    

    public void mouseClicked(MouseEvent e) {
        String name = searchbar.getText();
        Controller admin = Controller.Instance(false);
        Set<Etudiant> liste = admin.search(name, admin.getGroupeFactory().getPromotion());
        for (Etudiant etu : liste) {
            System.out.println(etu.getNom() + " " + etu.getPrenom());
        }    
        
        this.refresh("Etudiants  ",liste);
        this.cardLayout.show(this.window.getContentPane(), "Menu");

    }

    public void mouseEntered(MouseEvent e) {
        this.button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public void mouseExited(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

}