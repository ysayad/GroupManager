package fr.iutfbleau.projetIHM2022FI2.Vues.Admin.test;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.Cursor;
import java.awt.*;
import javax.swing.*;
import javax.swing.UIManager.*;
import javax.swing.border.Border;
import java.io.*;
import java.lang.Thread;
import java.lang.ProcessBuilder.Redirect.Type;

import fr.iutfbleau.projetIHM2022FI2.Controller.Cadmin;
import fr.iutfbleau.projetIHM2022FI2.API.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class CreerListener implements MouseListener {
    JButton button;
    JFrame window;
    Menu menu;
    CardLayout cardLayout;
    Groupe g;
    JDialog dialog;
    String saisie;
    JComboBox combobox;

    

    public CreerListener(JButton button , Menu menu, CardLayout cardLayout, JFrame window, Groupe g, JDialog dialog, String saisie) {
        this.window=window;
        this.button = button;
        this.menu = menu;
        this.cardLayout = cardLayout;
        this.g = g;
        this.dialog = dialog;
        this.saisie = saisie;
    }

    public CreerListener(JButton button , Menu menu, CardLayout cardLayout, JFrame window, Groupe g, JDialog dialog, JComboBox combobox) {
        this.window=window;
        this.button = button;
        this.menu = menu;
        this.cardLayout = cardLayout;
        this.g = g;
        this.dialog = dialog;
        this.combobox = combobox;
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
        if (g.getType() != TypeGroupe.ROOT) {
            JButton retour = new JButton("Retour");
            retour.addMouseListener(new ButtonGroupeListener(null,menu, cardLayout,window,g.getPointPoint()));
            navbar.add(retour,BorderLayout.BEFORE_LINE_BEGINS);
        }
        
        if (g.getType() != TypeGroupe.PARTITION) {
            JButton creer = new JButton("Créer un groupe");
            creer.addMouseListener(new ButtonGroupeCreerListener(creer, menu, cardLayout, window, g));
            navbar.add(creer,BorderLayout.AFTER_LINE_ENDS);
        }
        
        
        
        navbar.add(searchbar.drawSearchBar(), BorderLayout.CENTER);
        
        
        navbar.add(Box.createHorizontalStrut(100));
        navbar.add(searchbar.drawSearchBar(), BorderLayout.CENTER);
        menuP.add(navbar,BorderLayout.PAGE_START);
        
        CarteGroupe carteGroupe = new CarteGroupe(menu,this.window, cardLayout, navbar);
        menuP.add(carteGroupe.drawCarteGroupe(g),BorderLayout.CENTER);





        menuContainer.add(menu.drawMenu(),BorderLayout.LINE_START);

        menuContainer.add(menuP);

        this.window.add(menuContainer, "Menu");


        this.window.revalidate();
        this.window.repaint();
        this.window.invalidate();
        this.window.validate();
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        if (button.getText() == "Créer") {
            Cadmin.Instance(false).getGroupeFactory().createGroupe(g, saisie, 12, 95);
        }

        if (button.getText() == "Renommer") {
            System.out.println(saisie);
            Cadmin.Instance(false).renameGroup(g, saisie);
        }
        
        if (button.getText() == "Ajouter") {
            String nom = combobox.getEditor().getItem().toString().split(" ",2)[0];
            Cadmin.Instance(false).getGroupeFactory().addToGroupe(g, Cadmin.Instance(false).search(nom, Cadmin.Instance(false).getGroupeFactory().getPromotion()).iterator().next());
        }

        if (button.getText() == "Supprimer") {
            String nom = combobox.getEditor().getItem().toString().split(" ",2)[0];
            Cadmin.Instance(false).getGroupeFactory().dropFromGroupe(g, Cadmin.Instance(false).search(nom, Cadmin.Instance(false).getGroupeFactory().getPromotion()).iterator().next());
        }

        if (button.getText() == "Partitionner") {
            Cadmin.Instance(false).getGroupeFactory().createPartition(g, g.getName(), Integer.parseInt(saisie));
        }

        if (button.getText() == "Supprimer le groupe") {
            Cadmin.Instance(false).getGroupeFactory().deleteGroupe(g);

        }
        dialog.dispose();
        this.refresh("Groupes   ", g);
        this.cardLayout.show(this.window.getContentPane(), "Menu");
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }             
}