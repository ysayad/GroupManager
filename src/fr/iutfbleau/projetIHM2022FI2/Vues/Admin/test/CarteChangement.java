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
import fr.iutfbleau.projetIHM2022FI2.API.Changement;
import fr.iutfbleau.projetIHM2022FI2.API.Groupe;
import fr.iutfbleau.projetIHM2022FI2.Controller.Cadmin;

public class CarteChangement extends JFrame {
    Menu menu;
    JFrame window;
    JPanel carte;
    JPanel cartect;
    JButton yes;
    JButton no;
    JPanel panneaucarte;
    JPanel cartecontainer;
    public CarteChangement(Menu menu, JFrame window){
        this.menu = menu;
        this.window = window;
    }

 
    
    public JPanel drawCarte(String nomChangement){
        this.carte = new JPanel();
        



      

        JLabel td = new JLabel(nomChangement);
        this.carte.setPreferredSize(new Dimension(800,60));
        this.carte.setSize(new Dimension(800,60));
        this.carte.setMaximumSize(new Dimension(1000,60));
        this.carte.setBackground(Color.WHITE);
        td.setFont(new Font("Verdana", Font.PLAIN, 14));
        td.setHorizontalAlignment(SwingConstants.CENTER);
        this.carte.add(td,BorderLayout.CENTER);

        this.yes = new JButton("Oui");
        this.yes.setMinimumSize(new Dimension(50,50));
        this.yes.setMaximumSize(new Dimension(50,50));
        this.yes.setSize(50, 50);
        this.yes.setPreferredSize( new Dimension( 60, 50 ) );
        this.yes.setBackground(Color.WHITE);
        this.yes.setFont(new Font("Verdana", Font.PLAIN, 15));
        this.yes.setName("Oui");
        this.carte.add(this.yes);

        this.no = new JButton("Non");
        this.no.setMinimumSize(new Dimension(50,50));
        this.no.setMaximumSize(new Dimension(50,50));
        this.no.setSize(50, 50);
        this.no.setPreferredSize( new Dimension( 60, 50 ) );
        this.no.setBackground(Color.WHITE);
        this.no.setFont(new Font("Verdana", Font.PLAIN, 15));
        this.no.setName("Non");

        this.carte.add(this.no);  

        GridLayout layout = new GridLayout();
        layout.setVgap(0);
        layout.setHgap(0);

        this.cartect = new JPanel(layout);
        this.cartect.setBackground(Color.WHITE);
        this.cartect.add(this.carte);
     
        //test.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        return this.cartect;
    }
    

    public JScrollPane drawCarteGroupe(){
        this.cartecontainer = new JPanel();
        this.cartecontainer.setLayout(new FlowLayout());

        //searchbarpanel.setBackground(Color.WHITE);

int h = 0;
Cadmin admin = Cadmin.Instance(false);
Set<Changement> liste = admin.getAllChangements();
for(Changement e : liste ){
        
         this.panneaucarte = new JPanel();
         this.panneaucarte.add(drawCarte("Changement " + e.getEtu().getNom() + " " + e.getEtu().getPrenom() + " vers groupe " + e.getB().getName()));

        this.yes.addMouseListener(new ButtonChangementListener(this,yes,this.menu,this.window, e));
        this.no.addMouseListener(new ButtonChangementListener(this,no,this.menu,this.window, e)); 
         h+=300;
        this.cartecontainer.add(this.panneaucarte);
} 



        this.cartecontainer.setPreferredSize(new Dimension(this.getWidth(),h/5));
        this.cartecontainer.setSize(new Dimension(this.getWidth(),h/5));
        this.cartecontainer.setMaximumSize(new Dimension(this.getWidth(),h/5));

        JScrollPane scroll = new JScrollPane(this.cartecontainer,
                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        return scroll;
    }
}