package fr.iutfbleau.projetIHM2022FI2.Vues.Admin.test;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.Cursor;
import java.awt.*;
import javax.swing.*;
import javax.swing.UIManager.*;
import fr.iutfbleau.projetIHM2022FI2.API.Groupe;
import fr.iutfbleau.projetIHM2022FI2.Controller.Cadmin;
import javax.swing.border.Border;
import java.io.*;
import java.lang.Thread;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ButtonGroupeListener implements MouseListener{
    JButton button;
    JFrame window;
    Menu menu;
    JPanel carte;
    CardLayout cardLayout;
    Groupe g;

    public ButtonGroupeListener(JPanel carte , Menu menu, CardLayout cardLayout, JFrame window, Groupe g) {
        this.window=window;
        this.button = button;
        this.menu = menu;
        this.carte = carte;
        this.cardLayout = cardLayout;
        this.g = g;
    }


    public void refresh(String name, Groupe g){
        this.window.remove(menu);


        Menu menu = new Menu(this.window, cardLayout, name, "Administrtateur");
        GridLayout gridLayout = new GridLayout(1,2);
        gridLayout.setHgap(0);
        gridLayout.setVgap(0);


        JPanel menuContainer = new JPanel(new BorderLayout());



        JPanel menuP = new JPanel(new BorderLayout());
        JPanel navbar = new JPanel(new BorderLayout());
        SearchBar searchbar = new SearchBar(menu,this.window,this.cardLayout);
        JButton retour = new JButton("Retour");
        JButton creer = new JButton("Créer un groupe");
        retour.addMouseListener(new ButtonGroupeListener(null,menu, cardLayout,window,g.getPointPoint()));
        creer.addMouseListener(new ButtonGroupeCreerListener(creer, menu, cardLayout, window, g));
        navbar.add(searchbar.drawSearchBar(), BorderLayout.CENTER);
        navbar.add(creer,BorderLayout.AFTER_LINE_ENDS);
        navbar.add(retour,BorderLayout.BEFORE_LINE_BEGINS);
        navbar.add(Box.createHorizontalStrut(100));
        navbar.add(searchbar.drawSearchBar(), BorderLayout.CENTER);
        menuP.add(navbar,BorderLayout.PAGE_START);
        

        if (g.getSousGroupes().isEmpty()) {
            CarteEtudiant carteEtudiant = new CarteEtudiant(menu,this.window, g.getEtudiants());
            menuP.add(carteEtudiant.drawCarteGroupe(),BorderLayout.CENTER);
        } else {
            CarteGroupe carteGroupe = new CarteGroupe(menu,this.window, cardLayout, navbar);
            menuP.add(carteGroupe.drawCarteGroupe(g),BorderLayout.CENTER);
        }




        menuContainer.add(menu.drawMenu(),BorderLayout.LINE_START);

        menuContainer.add(menuP);

        
        this.window.add(menuContainer, "Menu");


        this.window.revalidate();
        this.window.repaint();
        this.window.invalidate();
        this.window.validate();
    }

  


    public void mouseClicked(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {

        if (this.carte != null) {
            this.carte.setBorder(
                BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 2, 0, Color.DARK_GRAY),
                BorderFactory.createMatteBorder(0, 0, 0, 3, Color.GRAY)
            )
            
            );
            JPanel defaultcolor = new JPanel();
            //this.carte.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 5, defaultcolor.getBackground ()));
            this.carte.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

    }

    public void mouseExited(MouseEvent e) {
        if (this.carte != null) {
            this.carte.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
        }
                
    }

    public void mousePressed(MouseEvent e) {
        System.out.println(g.getName());
        this.refresh("Groupes   ",g);
        this.cardLayout.show(this.window.getContentPane(), "Menu");
    }

    public void mouseReleased(MouseEvent e) {}

}