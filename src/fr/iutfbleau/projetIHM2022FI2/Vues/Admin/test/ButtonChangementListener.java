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

public class ButtonChangementListener implements MouseListener{
    JButton button;
    JFrame window;
    Menu menu;

    public ButtonChangementListener(CarteChangement carte,JButton button, Menu menu, JFrame window) {
        this.window=window;
        this.button = button;
        this.menu = menu;
    }


public void refresh(){}
  


    public void mouseClicked(MouseEvent e) {
        System.out.println(this.button.getName());
        //this.carte.cartecontainer.remove(this.carte.panneaucarte);
    }

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

}