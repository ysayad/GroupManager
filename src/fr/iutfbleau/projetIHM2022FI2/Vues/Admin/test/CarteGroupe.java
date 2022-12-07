package fr.iutfbleau.projetIHM2022FI2.Vues.Admin.test;
import java.awt.*;
import javax.swing.*;
import javax.swing.UIManager.*;
import javax.swing.border.Border;
import java.io.*;
import java.lang.Thread;
import java.awt.event.*;
import java.util.*;

import fr.iutfbleau.projetIHM2022FI2.API.Groupe;
import fr.iutfbleau.projetIHM2022FI2.Controller.Cadmin;

public class CarteGroupe extends JFrame {
    Menu menu;
    JFrame window;
    CardLayout cardLayout;
    JPanel navbar;

    public CarteGroupe(Menu menu, JFrame window,CardLayout cardLayout, JPanel navbar){
        this.menu = menu;
        this.window = window;
        this.cardLayout = cardLayout;
        this.navbar = navbar;
    }
    
    
    public JPanel drawCarte(String name , int num, Groupe g){
        JPanel carte = new JPanel(){
        final ImageIcon icon = new ImageIcon(getClass().getResource("/carte-background-groupe.png"));
      Image img = icon.getImage();
      // initialiseur d'instance
      {setOpaque(false);}
      public void paintComponent(Graphics graphics) 
      {
        graphics.drawImage(img, 0, 0, this);
        super.paintComponent(graphics); 
      }
    };


      

        carte.setLayout(new GridLayout(10,1));
        carte.setPreferredSize(new Dimension(150,150));
        carte.setSize(new Dimension(150,150));
        carte.setMinimumSize(new Dimension(150,150));
        carte.setBackground(Color.WHITE);


        JButton edit = new JButton("");
        edit.setFont(new Font("Verdana", Font.PLAIN, 15));
        edit.setName("edit");

        ImageIcon icfaon = new ImageIcon(getClass().getResource("/edit.png"));
        Image image = icfaon.getImage();
        Image aze = image.getScaledInstance(25, 25, Image.SCALE_DEFAULT); 
        icfaon = new ImageIcon(aze);

        edit.setBorderPainted(true);
        edit.setFocusPainted(false);
        edit.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(50,50,50)));
        edit.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));

        edit.setHorizontalAlignment(SwingConstants.LEFT);
        edit.setContentAreaFilled(false);
        edit.setBackground(new Color(64,0,128));
        edit.setForeground(Color.WHITE);
        //JLabel test = new JLabel(icfaon);
        //test.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
        edit.setIcon(icfaon);














        carte.add(edit,BorderLayout.EAST);
        carte.add(new JLabel(""),BorderLayout.CENTER);
        carte.add(new JLabel(""),BorderLayout.CENTER);
        carte.add(new JLabel(""),BorderLayout.CENTER);
        carte.add(new JLabel(""),BorderLayout.CENTER);
        carte.add(new JLabel(""),BorderLayout.CENTER);
        carte.add(new JLabel(""),BorderLayout.CENTER);
        JLabel td = new JLabel(name);
        td.setFont(new Font("Verdana", Font.PLAIN, 14));
        td.setHorizontalAlignment(SwingConstants.CENTER);
        carte.add(td,BorderLayout.CENTER);

        carte.add(new JLabel(""),BorderLayout.CENTER);
        JLabel nbetudiant = new JLabel(num+"/35 etudiant");
        nbetudiant.setFont(new Font("Verdana", Font.PLAIN, 14));
        nbetudiant.setHorizontalAlignment(SwingConstants.CENTER);
        carte.add(nbetudiant,BorderLayout.CENTER);

        FlowLayout layout = new FlowLayout();
        layout.setVgap(0);
        layout.setHgap(0);
        JPanel test = new JPanel(layout);
        test.setBackground(Color.WHITE);
        test.addMouseListener(new ButtonGroupeListener(test,this.menu, cardLayout,this.window,g));
        test.add(carte);
        //test.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));

        return test;
    }
    

    public JPanel drawCarteGroupe(Groupe pere){
        JPanel cartecontainer = new JPanel();
        //cartecontainer.add(new JButton("Créer un groupe"),BorderLayout.PAGE_START);
        //searchbarpanel.setBackground(Color.WHITE);
        Set<Groupe> list = pere.getSousGroupes();

        for(Groupe g : list){
                JPanel panneaucarte = new JPanel();
                panneaucarte.add(drawCarte(g.getName(),g.getSize(), g));
                cartecontainer.add(panneaucarte);
        }
// Cadmin admin = new Cadmin.Instance(false);
// Groupe grp = admin.getAllGroup().iterator().next();
// Set<Groupe> list = grp.getSousGroupes();

//          for (Groupe t : list ) {

//         System.out.println(t.getName());
//         JPanel panneaucarte = new JPanel();
//         panneaucarte.add(drawCarte("test",12));

//        cartecontainer.add(panneaucarte);
            
//          }
    
        return cartecontainer;
    }
}