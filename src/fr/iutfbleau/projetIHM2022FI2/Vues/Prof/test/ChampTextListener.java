package fr.iutfbleau.projetIHM2022FI2.Vues.Prof.test;
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
import fr.iutfbleau.projetIHM2022FI2.Controller.Controller;
import fr.iutfbleau.projetIHM2022FI2.API.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ChampTextListener implements MouseListener, KeyListener {
    JTextField searchbar;
    int val;
    String txt;
    public ChampTextListener(JTextField searchbar, String txt) {
        this.searchbar = searchbar;
        this.val = 0;
        this.txt = txt;
    }



    public void mouseClicked(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {
            this.searchbar.setFocusable(true);
    }

    public void mouseExited(MouseEvent e) {
        if(this.searchbar.getText().equals("") && this.val == 1){
            this.searchbar.setForeground(Color.GRAY);
            this.searchbar.setText(txt);
            this.searchbar.setFocusable(false);
            this.val = 0;
        }else if(this.searchbar.getText().equals(txt)){
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

    }



    @Override
    public void keyPressed(KeyEvent e) {

        
    }



    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        String name = searchbar.getText();
        if (name.length() != 0) {
            Controller admin = Controller.Instance(false);
            Set<Etudiant> liste = admin.search(name, admin.getGroupeFactory().getPromotion());
            for (Etudiant etu : liste) {
                System.out.println(etu.getNom() + " " + etu.getPrenom());
            }    
        }
        
    }

}