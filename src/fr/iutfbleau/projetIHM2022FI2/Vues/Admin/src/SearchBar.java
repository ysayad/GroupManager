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

public class SearchBar extends JFrame {
    Menu menu;
    JFrame window;
    public SearchBar(Menu menu, JFrame window){
        this.menu = menu;
        this.window = window;
    }
    
    
    public JPanel drawSearchBar(){
        JPanel searchbarpanel = new JPanel();

        //GridLayout gridLayout = new GridLayout(1,2);
        //gridLayout.setHgap(0);
        //gridLayout.setVgap(0);
        //searchbarpanel.setLayout(gridLayout);
        searchbarpanel.setLayout(new BoxLayout(searchbarpanel, BoxLayout.X_AXIS ));

        searchbarpanel.setBackground(new Color(200,0,255));
        JTextField searchbar = new JTextField("Rechercher par Nom");
        searchbar.setBounds(20,20,20,20);
        
        searchbar.setMinimumSize(new Dimension(300,45));
        searchbar.setSize(300, 45);
        searchbar.setPreferredSize( new Dimension( 500, 45 ) );
        searchbar.setFont(new Font("Verdana", Font.PLAIN, 16)); // définition du style de texte
        Border border = BorderFactory.createLineBorder(new Color(25,25,25));  
        searchbar.setBorder(border);
        searchbar.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
        JButton ok = new JButton("OK");
        ok.setMinimumSize(new Dimension(30,45));
        ok.setSize(30, 45);
        ok.setPreferredSize( new Dimension( 50, 45 ) );


        JPanel test =new JPanel();
        test.add(searchbar);
        searchbarpanel.add(test);
        searchbarpanel.add(ok);
        ok.addMouseListener(new SearchBarButtonListener(searchbar,ok));
        searchbar.addMouseListener(new SearchBarListener(searchbar));


        return searchbarpanel;
    }
}