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
    JPanel carte;

    public ButtonChangementListener(JButton button,JPanel carte, Menu menu, JFrame window) {
        this.window=window;
        this.button = button;
        this.menu = menu;
        this.carte = carte;
    }


public void refresh(){

                this.window.remove(menu);


            Menu menu = new Menu(this.window, this.menu.cardLayout, "Changements", "Administrtateur");
            GridLayout gridLayout = new GridLayout(1,2);
            gridLayout.setHgap(0);
            gridLayout.setVgap(0);


            JPanel menuContainer = new JPanel(new BorderLayout());



            JPanel menuP = new JPanel(new BorderLayout());
            SearchBar searchbar = new SearchBar(menu,this.window);
            menuP.add(searchbar.drawSearchBar(),BorderLayout.PAGE_START);
            CarteChangement carteGroupe = new CarteChangement(menu,this.window);
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
        this.carte.remove(carte);
        this.refresh();
    }

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

}