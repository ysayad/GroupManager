package fr.iutfbleau.projetIHM2022FI2.Vues.Eleve.test;
import java.awt.*;
import javax.swing.*;
import javax.swing.UIManager.*;
import javax.swing.border.Border;
import java.io.*;
import java.lang.Thread;
import java.awt.event.*;
import java.util.*;

import fr.iutfbleau.projetIHM2022FI2.API.Etudiant;
import fr.iutfbleau.projetIHM2022FI2.API.Groupe;
import fr.iutfbleau.projetIHM2022FI2.API.TypeGroupe;
import fr.iutfbleau.projetIHM2022FI2.Controller.Controller;

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
    

    public JPanel vide(){
        JPanel vide = new JPanel();
        vide.setOpaque(false);
        return vide;
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




        carte.setLayout(new GridLayout(3,1));
        carte.setPreferredSize(new Dimension(150,150));
        carte.setSize(new Dimension(150,150));
        carte.setMinimumSize(new Dimension(150,150));
        carte.setBackground(Color.WHITE);


        JButton edit = new JButton("");
        edit.setFont(new Font("Verdana", Font.PLAIN, 15));
        edit.setName("edit");

        ImageIcon icfaon = new ImageIcon(getClass().getResource("/editeleve.png"));
        Image image = icfaon.getImage();
        Image aze = image.getScaledInstance(20, 20, Image.SCALE_DEFAULT); 
        icfaon = new ImageIcon(aze);

        edit.setBorderPainted(false);
        edit.setFocusPainted(false);
        edit.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));

        edit.setHorizontalAlignment(SwingConstants.CENTER);
        edit.setContentAreaFilled(false);
        edit.setBackground(new Color(64,0,128));
        edit.setForeground(Color.WHITE);
        //JLabel test = new JLabel(icfaon);
        //test.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
        edit.setIcon(icfaon);

        edit.setPreferredSize(new Dimension(40,40));
        edit.setSize(new Dimension(40,40));
        edit.setMaximumSize(new Dimension(40,40));


        edit.setComponentOrientation(
        ComponentOrientation.RIGHT_TO_LEFT);
        edit.setOpaque(false);


  
        JPanel wtf = new JPanel(new GridLayout(2,4));
        wtf.setOpaque(false);
        wtf.add(this.vide());
        wtf.add(this.vide());
        wtf.add(this.vide());
        wtf.add(edit);
        wtf.add(this.vide());
        wtf.add(this.vide());
        wtf.add(this.vide());     
        wtf.add(this.vide());     

        carte.add(wtf);

        JLabel td = new JLabel(name);
        td.setFont(new Font("Verdana", Font.PLAIN, 14));
        td.setHorizontalAlignment(SwingConstants.CENTER);

        carte.add(this.vide());

        JLabel nbetudiant = new JLabel(num+"/" + g.getMax() + " etudiant");
        nbetudiant.setFont(new Font("Verdana", Font.PLAIN, 14));
        nbetudiant.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel test2 = new JPanel(new GridLayout(2,1));
        test2.add(td);
        test2.add(nbetudiant); 
        
        test2.setOpaque(false);

        carte.add(test2,BorderLayout.CENTER);

        FlowLayout layout = new FlowLayout();
        layout.setVgap(0);
        layout.setHgap(0);
        JPanel test = new JPanel(layout);
        test.setBackground(Color.WHITE);
        test.addMouseListener(new ButtonGroupeListener(test,menu, cardLayout,window,g));
        edit.addMouseListener(new ButtonGroupeEditListener(edit,this.menu, cardLayout,this.window,g));
        test.add(carte);
        //test.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));

        return test;
    }
    

    public JScrollPane drawCarteGroupe(Groupe pere){
        JPanel cartecontainer = new JPanel();
                int h = 0;

        //cartecontainer.add(new JButton("Créer un groupe"),BorderLayout.PAGE_START);
        //searchbarpanel.setBackground(Color.WHITE);
        Set<Groupe> list = pere.getSousGroupes();

        for(Groupe g : list){
            h+=1;
        }
         if (pere.getType() == TypeGroupe.FREE) {
                    for(Etudiant e : pere.getEtudiants()){
                    h+=1;
                    }
                }
        cartecontainer.setLayout(new GridLayout(h/5,4));  

        for(Groupe g : list){
                JPanel panneaucarte = new JPanel();
                panneaucarte.add(drawCarte(g.getName(),g.getSize(), g));
                cartecontainer.add(panneaucarte);



        }

        if (pere.getType() == TypeGroupe.FREE) {
            for(Etudiant e : pere.getEtudiants()){
                JPanel panneaucarte = new JPanel();
                CarteEtudiant carteEtudiant = new CarteEtudiant(menu, window);
                panneaucarte.add(carteEtudiant.drawCarte(e.getNom(),e.getPrenom()));
                cartecontainer.add(panneaucarte);




            }
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
        JScrollPane scroll = new JScrollPane(cartecontainer);
        return scroll;
    }
}