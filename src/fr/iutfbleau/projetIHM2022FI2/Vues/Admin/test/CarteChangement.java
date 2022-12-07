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
    public CarteChangement(Menu menu, JFrame window){
        this.menu = menu;
        this.window = window;
    }
    
    
    public JPanel drawCarte(String nomChangement){
        JPanel carte = new JPanel();
        carte.setLayout(new GridLayout(1,3));



      

        carte.setPreferredSize(new Dimension(300,50));
        carte.setSize(new Dimension(300,50));
        carte.setMinimumSize(new Dimension(300,50));
        carte.setBackground(Color.WHITE);
        JLabel td = new JLabel(nomChangement);
        td.setFont(new Font("Verdana", Font.PLAIN, 14));
        td.setHorizontalAlignment(SwingConstants.CENTER);
        carte.add(td,BorderLayout.CENTER);

        JButton yes = new JButton("yes");
        yes.setMinimumSize(new Dimension(50,50));
        yes.setSize(50, 50);
        yes.setPreferredSize( new Dimension( 50, 50 ) );
        yes.setBackground(Color.WHITE);
        yes.setFont(new Font("Verdana", Font.PLAIN, 15));
        yes.setName("yes");
        carte.add(yes);

        JButton no = new JButton("no");
        no.setMinimumSize(new Dimension(50,50));
        no.setSize(50, 50);
        no.setPreferredSize( new Dimension( 50, 50 ) );
        no.setBackground(Color.WHITE);
        no.setFont(new Font("Verdana", Font.PLAIN, 15));
        no.setName("no");

        carte.add(no);  

        GridLayout layout = new GridLayout();
        layout.setVgap(0);
        layout.setHgap(0);

        JPanel test = new JPanel(layout);
        test.setBackground(Color.WHITE);
        test.add(carte);

        yes.addMouseListener(new ButtonChangementListener(yes,test,this.menu,this.window));
        no.addMouseListener(new ButtonChangementListener(no,test,this.menu,this.window));      
        //test.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        return test;
    }
    

    public JScrollPane drawCarteGroupe(){
        JPanel cartecontainer = new JPanel();
        cartecontainer.setLayout(new FlowLayout());

        //searchbarpanel.setBackground(Color.WHITE);

int h = 0;
Cadmin admin = Cadmin.Instance(false);
Groupe grp = admin.getAllGroup().iterator().next();
for(int i = 0; i<25;i+=1){
        
         JPanel panneaucarte = new JPanel();
         panneaucarte.add(drawCarte("Demaine n"+i));
         h+=300;
        cartecontainer.add(panneaucarte);
}



        cartecontainer.setPreferredSize(new Dimension(this.getWidth(),h/5));
        cartecontainer.setSize(new Dimension(this.getWidth(),h/5));
        cartecontainer.setMaximumSize(new Dimension(this.getWidth(),h/5));

        JScrollPane scroll = new JScrollPane(cartecontainer,
                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        return scroll;
    }
}