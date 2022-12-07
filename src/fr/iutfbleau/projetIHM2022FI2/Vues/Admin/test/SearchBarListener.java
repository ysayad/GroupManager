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
import fr.iutfbleau.projetIHM2022FI2.Controller.Cadmin;
import fr.iutfbleau.projetIHM2022FI2.API.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class SearchBarListener implements MouseListener, KeyListener {
    JTextField searchbar;
    int val;
    public SearchBarListener(JTextField searchbar) {
        this.searchbar = searchbar;
        this.val = 0;
    }



    public void mouseClicked(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {
            this.searchbar.setFocusable(true);
    }

    public void mouseExited(MouseEvent e) {
        if(this.searchbar.getText().equals("") && this.val == 1){
            this.searchbar.setForeground(Color.GRAY);
            this.searchbar.setText("Rechercher par Nom");
            this.searchbar.setFocusable(false);
            this.val = 0;
        }else if(this.searchbar.getText().equals("Rechercher par Nom")){
            this.searchbar.setFocusable(false);
            this.searchbar.setForeground(Color.GRAY);
        }
    }

    public void mousePressed(MouseEvent e) {
        if (this.val == 0) {
            this.searchbar.setFocusable(true);
            this.searchbar.setText("");
            this.searchbar.setForeground(Color.BLACK);
            this.val = 1;
        }
    }

    public void mouseReleased(MouseEvent e) {}



    @Override
    public void keyTyped(KeyEvent e) {
        String name = searchbar.getText();
        if (name.length() != 0) {
            Cadmin admin = Cadmin.Instance(false);
            Set<Etudiant> liste = admin.search(name, admin.getGroupeFactory().getPromotion());
            for (Etudiant etu : liste) {
                System.out.println(etu.getNom() + " " + etu.getPrenom());
            }    
        }
        
    }



    @Override
    public void keyPressed(KeyEvent e) {

        
    }



    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

}