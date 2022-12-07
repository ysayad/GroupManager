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
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ButtonGroupeListener implements MouseListener{
    JButton button;
    JFrame window;
    Menu menu;
    JPanel carte;

    public ButtonGroupeListener(JPanel carte , Menu menu, JFrame window) {
        this.window=window;
        this.button = button;
        this.menu = menu;
        this.carte = carte;
    }




  


    public void mouseClicked(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {

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

    public void mouseExited(MouseEvent e) {
                this.carte.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
    }

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

}