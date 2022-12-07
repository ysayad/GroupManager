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
    public SearchBarButtonListener(JTextField searchbar, JButton button) {
        this.searchbar = searchbar;
        this.button = button;
    }



    public void mouseClicked(MouseEvent e) {
        String name = searchbar.getText();
        Cadmin admin = Cadmin.Instance(false);
        Set<Etudiant> liste = admin.search(name, admin.getGroupeFactory().getPromotion());
        for (Etudiant etu : liste) {
            System.out.println(etu.getNom() + " " + etu.getPrenom());
        }    
    }

    public void mouseEntered(MouseEvent e) {
        this.button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public void mouseExited(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

}