package fr.iutfbleau.projetIHM2022FI2.Vues.Admin.test;
import java.awt.*;
import javax.swing.*;
import javax.swing.UIManager.*;
import javax.swing.border.Border;
import java.io.*;
import java.lang.Thread;
import java.awt.event.*;
import java.util.*;

import fr.iutfbleau.projetIHM2022FI2.API.Groupe;
import fr.iutfbleau.projetIHM2022FI2.Controller.Cadmin;

public class CarteGroupe extends JFrame {
    Menu menu;
    JFrame window;
    public CarteGroupe(Menu menu, JFrame window){
        this.menu = menu;
        this.window = window;
    }
    
    
    public JPanel drawCarte(){
        JPanel carte = new JPanel();
        Cadmin test = new Cadmin(false);
        test.createGroup("Groupe");
        test.createGroup("Groupe 1");
        test.createGroup("Groupe 3");
        test.createGroup("Groupe 4");
        test.createGroup("Groupe 5");
        test.createGroup("Groupe 6");
        test.createGroup("Groupe 7");
        test.createGroup("Groupe 8");
        test.createGroup("Groupe 9");
        test.createGroup("Groupe 10");
        test.createGroup("Groupe 11");
        test.createGroup("Groupe 12");
        for (Groupe t : test.getAllGroup() ) {
            JButton groupbutton = new JButton();
            groupbutton.add(new JLabel(t.getName()));
            carte.add(groupbutton);
            groupbutton.addMouseListener(new ButtonGroupeListener(groupbutton,this.menu , this.window));
        }
        return carte;
    }
    

    public JPanel drawCarteGroupe(){
        JPanel searchbarpanel = new JPanel();
        searchbarpanel.setBackground(Color.WHITE);
        searchbarpanel.add(drawCarte());
        return searchbarpanel;
    }
}