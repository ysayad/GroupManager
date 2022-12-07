package fr.iutfbleau.projetIHM2022FI2.Vues.Admin.test;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.Cursor;
import java.awt.*;
import javax.swing.*;
import javax.swing.UIManager.*;
import javax.swing.border.Border;

import fr.iutfbleau.projetIHM2022FI2.API.Changement;
import fr.iutfbleau.projetIHM2022FI2.Controller.Cadmin;

import java.io.*;
import java.lang.Thread;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ButtonChangementListener implements MouseListener{
    JButton button;
    JFrame window;
    Menu menu;
    Changement ch;

    public ButtonChangementListener(CarteChangement carte,JButton button, Menu menu, JFrame window, Changement ch) {
        this.window=window;
        this.button = button;
        this.menu = menu;
        this.ch = ch;
    }


public void refresh(){}
  


    public void mouseClicked(MouseEvent e) {
        System.out.println(this.button.getName());
        Cadmin admin = Cadmin.Instance(false);
        if (button.getName() == "Oui") {
            admin.getChangementFactory().applyChangement(ch);
        }
        if (button.getName() == "Non") {
            admin.getChangementFactory().deleteChangement(ch);
        }
        
        this.refresh();
        
    }

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

}