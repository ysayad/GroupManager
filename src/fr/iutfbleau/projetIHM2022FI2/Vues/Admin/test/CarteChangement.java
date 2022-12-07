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
        
        this.carte.setLayout(new GridLayout(1,3));



      

        this.carte.setPreferredSize(new Dimension(300,50));
        this.carte.setSize(new Dimension(300,50));
        this.carte.setMinimumSize(new Dimension(300,50));
        this.carte.setBackground(Color.WHITE);
        JLabel td = new JLabel(nomChangement);
        td.setFont(new Font("Verdana", Font.PLAIN, 14));
        td.setHorizontalAlignment(SwingConstants.CENTER);
        this.carte.add(td,BorderLayout.CENTER);

        this.yes = new JButton("yes");
        this.yes.setMinimumSize(new Dimension(50,50));
        this.yes.setSize(50, 50);
        this.yes.setPreferredSize( new Dimension( 50, 50 ) );
        this.yes.setBackground(Color.WHITE);
        this.yes.setFont(new Font("Verdana", Font.PLAIN, 15));
        this.yes.setName("yes");
        this.carte.add(this.yes);

        this.no = new JButton("no");
        this.no.setMinimumSize(new Dimension(50,50));
        this.no.setSize(50, 50);
        this.no.setPreferredSize( new Dimension( 50, 50 ) );
        this.no.setBackground(Color.WHITE);
        this.no.setFont(new Font("Verdana", Font.PLAIN, 15));
        this.no.setName("no");

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
Groupe grp = admin.getAllGroup().iterator().next();
Set<Changement> liste = Cadmin.getAllChangements();
for(Changement e : liste ){
        
         this.panneaucarte = new JPanel();
         this.panneaucarte.add(drawCarte("Demaine n"+i));

        this.yes.addMouseListener(new ButtonChangementListener(this,yes,this.menu,this.window));
        this.no.addMouseListener(new ButtonChangementListener(this,no,this.menu,this.window)); 
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