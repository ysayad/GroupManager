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

public class ButtonListener implements MouseListener{
    JButton button;
    CardLayout cardLayout;
    JFrame window;
    Menu menu;

    public ButtonListener(JFrame window,CardLayout cardLayout, JButton button) {
        this.window=window;
        this.button = button;
        this.cardLayout = cardLayout;
    }



    public ButtonListener(JFrame window,CardLayout cardLayout, JButton button, Menu menu) {
        this.window=window;
        this.button = button;
        this.cardLayout = cardLayout;
        this.menu = menu;
    }


    public void refresh(String name){
            this.window.remove(menu);


            Menu menu = new Menu(this.window, cardLayout, name, "Administrtateur");
            GridLayout gridLayout = new GridLayout(1,2);
            gridLayout.setHgap(0);
            gridLayout.setVgap(0);

            GridLayout gridLayout2 = new GridLayout(1,1);
            gridLayout2.setHgap(0);
            gridLayout2.setVgap(0);

            JPanel menuPanneau = new JPanel();
            menuPanneau.setLayout(gridLayout2);
            menuPanneau.add(menu.drawMenu());
            //menuPanneau.setPreferredSize(new Dimension(300,700));
            JPanel menuContainer = new JPanel();
            menuContainer.setLayout(gridLayout);


            
            menuContainer.add(menuPanneau);
            JPanel menuP = new JPanel();
            GridLayout gridLayout3 = new GridLayout(1,2);
            gridLayout3.setHgap(0);
            gridLayout3.setVgap(0);
            menuP.setLayout(gridLayout3);
            SearchBar searchbar = new SearchBar(this.menu,this.window);
            menuP.add(searchbar.drawSearchBar());
            menuContainer.add(menuP);

            this.window.add(menuContainer, "Menu");


            this.window.revalidate();
            this.window.repaint();
            this.window.invalidate();
            this.window.validate();
}



    public void mouseClicked(MouseEvent e) {
        if (this.button.getName() == "quitter") {
            System.exit(1);
        }
        if (this.button.getName() == "entrer") {
            System.out.println("Entrer");
            this.cardLayout.show(this.window.getContentPane(), "Menu");
        }


        if (this.button.getName() == "Groupes    ") {
            System.out.println("Groupes");
            this.refresh("Groupes    ");
            this.cardLayout.show(this.window.getContentPane(), "Menu");
        }
        if (this.button.getName() == "Etudiants  ") {
            System.out.println("Etudiants");
            this.refresh("Etudiants  ");
            this.cardLayout.show(this.window.getContentPane(), "Menu");
            
        }
        if (this.button.getName() == "Changements") {
            System.out.println("Changements");
            this.refresh("Changements");
            this.cardLayout.show(this.window.getContentPane(), "Menu");
            
        }
        if (this.button.getName() == "Deconnexion") {
            System.out.println("Deconnexion de l'"+this.menu.typeUtilisateur);
            this.refresh("Deconnexion");
            this.cardLayout.show(this.window.getContentPane(), "Menu");
            
        }

    }

    public void mouseEntered(MouseEvent e) {
        this.button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public void mouseExited(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

}