package fr.iutfbleau.projetIHM2022FI2.Vues.Admin.test;
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

public class CarteEtudiant extends JFrame {
    Menu menu;
    JFrame window;
    Set<Etudiant> liste;
    public CarteEtudiant(Menu menu, JFrame window){
        this.menu = menu;
        this.window = window;
        Controller admin = Controller.Instance(false);
        Groupe promo = Controller.Instance(false).getGroupeFactory().getPromotion();
        if (!promo.getSousGroupes().isEmpty()) {
            if (promo.getSousGroupes().iterator().next().getType() == TypeGroupe.PARTITION) {
                promo = promo.getSousGroupes().iterator().next();
            }
        }
 
            this.liste = promo.getEtudiants();
        
    }

    public CarteEtudiant(Menu menu, JFrame window,Set<Etudiant> liste){
        this.menu = menu;
        this.window = window;
        this.liste = liste;
    }
    
    
    public JPanel drawCarte(String name , String num){
        JPanel carte = new JPanel(){
        final ImageIcon icon = new ImageIcon(getClass().getResource("/carte-background.png"));
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
        carte.add(new JLabel(""),BorderLayout.CENTER);
        carte.add(new JLabel(""),BorderLayout.CENTER);
        carte.add(new JLabel(""),BorderLayout.CENTER);
        carte.add(new JLabel(""),BorderLayout.CENTER);
        carte.add(new JLabel(""),BorderLayout.CENTER);
        carte.add(new JLabel(""),BorderLayout.CENTER);
        JLabel td = new JLabel(name+" "+num);
        td.setFont(new Font("Verdana", Font.PLAIN, 14));
        td.setHorizontalAlignment(SwingConstants.CENTER);
        carte.add(td,BorderLayout.CENTER);

        carte.add(new JLabel(""),BorderLayout.CENTER);
        JLabel nbetudiant = new JLabel("");
        nbetudiant.setFont(new Font("Verdana", Font.PLAIN, 14));
        nbetudiant.setHorizontalAlignment(SwingConstants.CENTER);
        carte.add(nbetudiant,BorderLayout.CENTER);

        GridLayout layout = new GridLayout();
        layout.setVgap(0);
        layout.setHgap(0);

        JPanel test = new JPanel(layout);
        test.setBackground(Color.WHITE);
        test.add(carte);
        //test.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        //test.addMouseListener(new ButtonEtudiantListener(test,this.menu,this.window));
        return test;
    }
    

    public JScrollPane drawCarteGroupe(){

        JPanel cartecontainer = new JPanel();
                int h = 0;


        
        for(Etudiant e : this.liste){
            h+=1;
        }


        cartecontainer.setLayout(new GridLayout(h/5,5));
        //searchbarpanel.setBackground(Color.WHITE);

        h = 0;
        for(Etudiant e : this.liste){
                
            JPanel panneaucarte = new JPanel();
            panneaucarte.add(drawCarte(e.getNom(),e.getPrenom()));
            
            h+=1;
            cartecontainer.add(panneaucarte);
        }



        // cartecontainer.setPreferredSize(new Dimension(this.getWidth(),h/5));
        // cartecontainer.setSize(new Dimension(this.getWidth(),h/5));
        // cartecontainer.setMaximumSize(new Dimension(this.getWidth(),h/5));

        JScrollPane scroll = new JScrollPane(cartecontainer);
        return scroll;
    }

    



}