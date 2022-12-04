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

        for (Groupe t : test.getAllGroup() ) {
            carte.add(new JLabel(t.getName()));
        }
        return carte;
    }
    

    public JPanel drawCarteGroupe(){
        JPanel searchbarpanel = new JPanel();
        searchbarpanel.setBackground(Color.BLACK);
        
        return searchbarpanel;
    }
}