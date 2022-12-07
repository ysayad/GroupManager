package fr.iutfbleau.projetIHM2022FI2.Vues.Admin.test;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.Cursor;
import java.awt.*;
import javax.swing.*;
import javax.swing.UIManager.*;
import javax.swing.border.Border;

import fr.iutfbleau.projetIHM2022FI2.Controller.Cadmin;
import fr.iutfbleau.projetIHM2022FI2.API.*;

import java.io.*;
import java.lang.Thread;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class SearchBarButtonListener implements MouseListener{
    JTextField searchbar;
    JButton button;
    public SearchBarButtonListener(JTextField searchbar, JButton button, JFrame window, Menu menu){
        this.searchbar = searchbar;
        this.button = button;
    }



    public void refresh(String name){
 if (name == "Etudiants  ") {
                            this.window.remove(menu);


            Menu menu = new Menu(this.window, cardLayout, name, "Administrtateur");
            GridLayout gridLayout = new GridLayout(1,2);
            gridLayout.setHgap(0);
            gridLayout.setVgap(0);


            JPanel menuContainer = new JPanel(new BorderLayout());



            JPanel menuP = new JPanel(new BorderLayout());
            SearchBar searchbar = new SearchBar(menu,this.window);
            menuP.add(searchbar.drawSearchBar(),BorderLayout.PAGE_START);
            CarteEtudiant carteGroupe = new CarteEtudiant(menu,this.window);

            menuP.add(carteGroupe.drawCarteGroupe(name),BorderLayout.CENTER);



            menuContainer.add(menu.drawMenu(),BorderLayout.LINE_START);

            menuContainer.add(menuP);


            this.window.add(menuContainer, "Menu");


            this.window.revalidate();
            this.window.repaint();
            this.window.invalidate();
            this.window.validate();


        }}

    public void mouseClicked(MouseEvent e) {
        String name = searchbar.getText();
        Cadmin admin = Cadmin.Instance(false);
        Set<Etudiant> liste = admin.getGroupeFactory().getEtudiants(name);
        for (Etudiant etu : liste) {
            refresh(etu.getNom() + " " + etu.getPrenom(),etu);
        }    
    }

    public void mouseEntered(MouseEvent e) {
        this.button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public void mouseExited(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

}