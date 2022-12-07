package fr.iutfbleau.projetIHM2022FI2.Vues.Admin.test;
import java.awt.*;
import javax.swing.*;
import javax.swing.UIManager.*;
import javax.swing.border.Border;
import java.io.*;
import java.lang.Thread;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import fr.iutfbleau.projetIHM2022FI2.API.Etudiant;
import fr.iutfbleau.projetIHM2022FI2.API.Groupe;
import fr.iutfbleau.projetIHM2022FI2.Controller.Cadmin;
public class SearchBar extends JFrame {
    Menu menu;
    JFrame window;
    public SearchBar(Menu menu, JFrame window){
        this.menu = menu;
        this.window = window;
    }


    public void refresh(String name, Set<Etudiant> etu){
 if (name == "Etudiants  ") {
    System.out.println("test");
                            this.window.remove(menu);


            Menu menu = new Menu(this.window, this.menu.cardLayout, name, "Administrtateur");
            GridLayout gridLayout = new GridLayout(1,2);
            gridLayout.setHgap(0);
            gridLayout.setVgap(0);


            JPanel menuContainer = new JPanel(new BorderLayout());



            JPanel menuP = new JPanel(new BorderLayout());
            SearchBar searchbar = new SearchBar(menu,this.window);
            menuP.add(searchbar.drawSearchBar(),BorderLayout.PAGE_START);
            CarteEtudiant carteGroupe = new CarteEtudiant(menu,this.window);

            menuP.add(carteGroupe.drawCarteGroupe(name,etu),BorderLayout.CENTER);



            menuContainer.add(menu.drawMenu(),BorderLayout.LINE_START);

            menuContainer.add(menuP);


            this.window.add(menuContainer, "Menu");


            this.window.revalidate();
            this.window.repaint();
            this.window.invalidate();
            this.window.validate();


        }}
    
    
    public JPanel drawSearchBar(){
        JPanel searchbarpanel = new JPanel();

        //GridLayout gridLayout = new GridLayout(1,2);
        //gridLayout.setHgap(0);
        //gridLayout.setVgap(0);
        //searchbarpanel.setLayout(gridLayout);
        //searchbarpanel.setLayout(new BoxLayout(searchbarpanel, BoxLayout.LINE_AXIS ));

        //searchbarpanel.setBackground(Color.WHITE);
        searchbarpanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        JTextField searchbar = new JTextField("Rechercher par Nom");
        searchbar.setBounds(20,20,20,20);
        searchbar.setForeground(Color.GRAY);
        searchbar.setMinimumSize(new Dimension(300,45));
        searchbar.setSize(300, 45);
        searchbar.setPreferredSize( new Dimension( 500, 45 ) );
        searchbar.setFont(new Font("Verdana", Font.PLAIN, 16)); // définition du style de texte
        Border border = BorderFactory.createLineBorder(new Color(25,25,25));  
        searchbar.setBorder(border);
        searchbar.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
        JButton ok = new JButton("");
        ok.setMinimumSize(new Dimension(30,45));
        ok.setSize(30, 45);
        ok.setPreferredSize( new Dimension( 50, 45 ) );
        
        ok.setBackground(Color.WHITE);





        ok.setFont(new Font("Verdana", Font.PLAIN, 15));
        ok.setName("OK");

        ImageIcon icfaon = new ImageIcon(getClass().getResource("/loupe.png"));
        Image image = icfaon.getImage();
        Image aze = image.getScaledInstance(25, 25, Image.SCALE_DEFAULT); 
        icfaon = new ImageIcon(aze);

        ok.setBorderPainted(false);
        ok.setFocusPainted(false);
        ok.setHorizontalAlignment(SwingConstants.LEFT);

        ok.setContentAreaFilled(false);

        

        ok.setIcon(icfaon);









        JPanel test =new JPanel();
        test.setBackground(Color.WHITE);
        test.add(searchbar);
        test.add(ok);
        searchbarpanel.add(test);
        ok.addMouseListener(new SearchBarButtonListener(this,searchbar,ok,this.window,this.menu));
        SearchBarListener listener = new SearchBarListener(searchbar);
        searchbar.addMouseListener(listener);
        searchbar.addKeyListener(listener);
        ok.addMouseListener(new SearchBarButtonListener(this,searchbar,ok,this.window,this.menu));
        searchbar.addMouseListener(new SearchBarListener(searchbar));


        return searchbarpanel;
    }
}