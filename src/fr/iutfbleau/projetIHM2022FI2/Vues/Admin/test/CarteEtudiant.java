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
import fr.iutfbleau.projetIHM2022FI2.Controller.Cadmin;

public class CarteEtudiant extends JFrame {
    Menu menu;
    JFrame window;
    public CarteEtudiant(Menu menu, JFrame window){
        this.menu = menu;
        this.window = window;
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

        FlowLayout layout = new FlowLayout();
        layout.setVgap(0);
        layout.setHgap(0);
        JPanel test = new JPanel(layout);
        test.setBackground(Color.WHITE);
        test.add(carte);
        //test.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        test.addMouseListener(new ButtonGroupeListener(test,this.menu,this.window));
        return test;
    }
    

    public JPanel drawCarteGroupe(){
        JPanel cartecontainer = new JPanel();
        //searchbarpanel.setBackground(Color.WHITE);


Cadmin admin = Cadmin.Instance(false);
Groupe grp = admin.getAllGroup().iterator().next();
for(Etudiant e : grp.getEtudiants()){
        
         JPanel panneaucarte = new JPanel();
         panneaucarte.add(drawCarte(e.getNom(),e.getPrenom()));

        cartecontainer.add(panneaucarte);
}


        return cartecontainer;
    }
}