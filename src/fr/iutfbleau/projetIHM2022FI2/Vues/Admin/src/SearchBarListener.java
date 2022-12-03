import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.Cursor;
// package fr.iutfbleau.projetIHM2022FI2.Vues;
import java.awt.*;
import javax.swing.*;
import javax.swing.UIManager.*;
import javax.swing.border.Border;
import java.io.*;
import java.lang.Thread;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class SearchBarListener implements MouseListener{
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
            this.searchbar.setText("Rechercher par Nom");
            this.searchbar.setFocusable(false);
            this.val = 0;
        }
    }

    public void mousePressed(MouseEvent e) {
                if (this.val == 0) {
            this.searchbar.setFocusable(true);
            this.searchbar.setText("");
            this.val = 1;
        }
    }

    public void mouseReleased(MouseEvent e) {}

}