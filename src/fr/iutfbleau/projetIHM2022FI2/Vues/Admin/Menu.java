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

public class Menu extends JFrame {
    JPanel menu = new JPanel();
    JFrame window;
    CardLayout cardLayout;
    String content;
    String typeUtilisateur;
    public Menu(JFrame window,CardLayout cardLayout,String content, String typeUtilisateur){
        this.menu.setBackground(new Color(64,0,128));
        this.window = window;
        this.cardLayout = cardLayout;
        this.menu.setLayout(new GridLayout(12,1));
        this.content = content;
        this.typeUtilisateur = typeUtilisateur;
    }

    public JPanel drawButton(String name, String ic){
        JPanel buttonpanel = new JPanel();
        if (this.content == name) {
            buttonpanel.setBackground(new Color(90,0,175));
        }else{
            buttonpanel.setBackground(new Color(64,0,128));
        }
        GridLayout gridLayout = new GridLayout(1,1);
        gridLayout.setHgap(50);
        gridLayout.setVgap(0);
        buttonpanel.setLayout(gridLayout);

        JButton button = new JButton(name);
        button.setFont(new Font("Verdana", Font.PLAIN, 15));
        button.setName(name);

        ImageIcon icfaon = new ImageIcon(ic);
        Image image = icfaon.getImage();
        Image aze = image.getScaledInstance(25, 25, Image.SCALE_DEFAULT); 
        icfaon = new ImageIcon(aze);

        button.setBorderPainted(true);
        button.setFocusPainted(false);
        if (name == "Changements" || name == "Deconnexion") {
            button.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(50,50,50)));
        }else{
            button.setBorder(BorderFactory.createMatteBorder(2, 2, 0, 2, new Color(50,50,50)));
        }

        button.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
        if (name == "Deconnexion") { 
            button.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 0));
        }
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setContentAreaFilled(false);
        button.setBackground(new Color(64,0,128));
        button.setForeground(Color.WHITE);
        //JLabel test = new JLabel(icfaon);
        //test.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
        button.setIcon(icfaon);
        //button.add(test);
        //button.setHorizontalAlignment(SwingConstants.CENTER);
        //button.setHorizontalTextPosition(SwingConstants.LEFT); 
        buttonpanel.add(button);
        button.addMouseListener(new ButtonListener(this.window,this.cardLayout, button, this));
        return buttonpanel;
    }

    public JPanel vide(){
        JPanel vide = new JPanel();
        GridLayout gridLayout = new GridLayout(1,1);
        gridLayout.setHgap(0);
        gridLayout.setVgap(0);
        vide.setLayout(gridLayout);
        vide.setBackground(new Color(64,0,128));
        return vide;
    }


    public JPanel drawMenu(){
        //this.menu.setResizable(false);

        



        ImageIcon icfaon = new ImageIcon("../Img/logo-upec.png");
        Image image = icfaon.getImage();
        Image aze = image.getScaledInstance(188, 80, Image.SCALE_DEFAULT); 
        icfaon = new ImageIcon(aze);


        this.menu.add(this.vide());
        this.menu.add(new JLabel(icfaon));
        this.menu.add(this.vide());
        this.menu.add(this.drawButton("Groupes    ","../Img/groupe.png"));
        this.menu.add(this.drawButton("Etudiants  ","../Img/etudiant.png"));
        this.menu.add(this.drawButton("Changements","../Img/changement.png"));



        
        this.menu.add(this.vide());
        this.menu.add(this.vide());
        this.menu.add(this.vide());
        this.menu.add(this.vide());
        this.menu.add(this.drawButton("Deconnexion","../Img/deconnexion.png"));

        JLabel copyright = new JLabel("");

        copyright.setText("<html><p>Adam Meddahi, Yanis Bouarroudj, Youcef Sayad <br>Copyright © 2022 Entreprise Groupe Manager.</p></html>");
        copyright.setHorizontalAlignment(SwingConstants.CENTER);
        copyright.setHorizontalTextPosition(SwingConstants.CENTER);
        copyright.setForeground(Color.WHITE);
        copyright.setFont(new Font("Verdana", Font.PLAIN, 9));
        this.menu.add(copyright);

        //this.menu.setResizeHorizontal(false);
        //this.menu.setResizeVertical(true);
        this.menu.setPreferredSize(new Dimension(300, this.window.getHeight()));
        this.menu.setSize(new Dimension(400, this.window.getHeight()));

        return this.menu;
    }
}
