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
import fr.iutfbleau.projetIHM2022FI2.Controller.Controller;

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
    CardLayout cardLayout;
    public ButtonChangementListener(CardLayout cardLayout,CarteChangement carte,JButton button, Menu menu, JFrame window, Changement ch) {
        this.window=window;
        this.button = button;
        this.menu = menu;
        this.ch = ch;
        this.cardLayout = cardLayout;
    }


public void refresh(){
    this.window.remove(menu);


            Menu menu = new Menu(this.window, cardLayout, "Changements", "Administrtateur");
            GridLayout gridLayout = new GridLayout(1,2);
            gridLayout.setHgap(0);
            gridLayout.setVgap(0);


            JPanel menuContainer = new JPanel(new BorderLayout());



            JPanel menuP = new JPanel(new BorderLayout());
            SearchBar searchbar = new SearchBar(menu,this.window,this.cardLayout);
            menuP.add(searchbar.drawSearchBar(),BorderLayout.PAGE_START);
            CarteChangement carteGroupe = new CarteChangement(this.cardLayout,menu,this.window);
            menuP.add(carteGroupe.drawCarteGroupe());



            menuContainer.add(menu.drawMenu(),BorderLayout.LINE_START);

            menuContainer.add(menuP);


            this.window.add(menuContainer, "Menu");


            this.window.revalidate();
            this.window.repaint();
            this.window.invalidate();
            this.window.validate();
        }
  


    public void mouseClicked(MouseEvent e) {
        System.out.println(this.button.getName());
        Controller admin = Controller.Instance(false);
        if (button.getName() == "Oui") {
            admin.getChangementFactory().applyChangement(ch);
        }
        if (button.getName() == "Non") {
            admin.getChangementFactory().deleteChangement(ch);
        }
        
        this.refresh();
        this.cardLayout.show(this.window.getContentPane(), "Menu");
        
    }

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

}