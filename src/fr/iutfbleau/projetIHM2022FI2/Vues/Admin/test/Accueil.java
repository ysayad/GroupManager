package fr.iutfbleau.projetIHM2022FI2.Vues.Admin.test;
import java.awt.*;
import javax.swing.*;
import javax.swing.UIManager.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import fr.iutfbleau.projetIHM2022FI2.API.Groupe;
import fr.iutfbleau.projetIHM2022FI2.API.TypeGroupe;
import fr.iutfbleau.projetIHM2022FI2.Controller.Cadmin;

import java.io.*;
import java.lang.Thread;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Accueil {
    public Accueil(){

    }

    public void drawAccueil(){
        JFrame fenetre = new JFrame("Admin");
        fenetre.setSize(1280,720);
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }




        JPanel panneauTitre = new JPanel();
        panneauTitre.setBackground(Color.WHITE);
        panneauTitre.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 400, 0, 400); // définie les espacements entre les elements
        gbc.ipady =  GridBagConstraints.CENTER; // definie la largeur des élements
        gbc.ipadx =  GridBagConstraints.CENTER; // définie la longueur des éléments
        gbc.anchor = GridBagConstraints.CENTER; // définie le type d'espacement entre les element
        gbc.weightx = 1;// définie le nombre d'element horizontale
        gbc.weighty = 2;// définie le nombre d'élement horizontale

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        JLabel titre = new JLabel(" GroupManager ");
        titre.setFont(new Font("Verdana", Font.PLAIN, 25)); // définition du style de texte
        titre.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        panneauTitre.add(titre, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        JLabel titreAdmin = new JLabel(" Administrateur ");
        titreAdmin.setFont(new Font("Verdana", Font.PLAIN, 20)); // définition du style de texte
        titreAdmin.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));

        titreAdmin.setHorizontalAlignment(SwingConstants.CENTER);
        panneauTitre.add(titreAdmin, gbc);







        JPanel panneau = new JPanel();
        panneau.setBackground(Color.WHITE);
        panneau.setLayout(new GridBagLayout());
        GridBagConstraints gbcpanneau = new GridBagConstraints();
        gbcpanneau.fill = GridBagConstraints.BOTH;
        gbcpanneau.insets = new Insets(0, 0, 0, 0); // définie les espacements entre les elements
        gbcpanneau.ipady =  GridBagConstraints.CENTER; // definie la largeur des élements
        gbcpanneau.ipadx =  GridBagConstraints.CENTER; // définie la longueur des éléments
        gbcpanneau.anchor = GridBagConstraints.CENTER; // définie le type d'espacement entre les element
        gbcpanneau.weightx = 1;// définie le nombre d'element horizontale
        gbcpanneau.weighty = 3;// définie le nombre d'élement horizontale

        gbcpanneau.gridx = 1;
        gbcpanneau.gridy = 1;
        gbcpanneau.gridwidth = 1;
        gbcpanneau.gridheight = 1;
        panneau.add(panneauTitre, gbcpanneau);

        gbcpanneau.gridx = 1;
        gbcpanneau.gridy = 2;
        gbcpanneau.gridwidth = 1;
        gbcpanneau.gridheight = 1;
        JPanel panneauLogo = new JPanel();
        JLabel logoupec = new JLabel("");
        panneauLogo.setBackground(Color.WHITE);
        panneauLogo.add(logoupec);
        panneau.add(panneauLogo, gbcpanneau);





        JPanel panneauBouton = new JPanel();
        panneauBouton.setBackground(Color.WHITE);
        panneauBouton.setLayout(new GridBagLayout());
        GridBagConstraints gbcpanneauBouton = new GridBagConstraints();
        gbcpanneauBouton.fill = GridBagConstraints.BOTH;
        gbcpanneauBouton.insets = new Insets(75, 150, 75,150); // définie les espacements entre les elements
        gbcpanneauBouton.ipady =  GridBagConstraints.CENTER; // definie la largeur des élements
        gbcpanneauBouton.ipadx =  GridBagConstraints.CENTER; // définie la longueur des éléments
        gbcpanneauBouton.anchor = GridBagConstraints.CENTER; // définie le type d'espacement entre les element
        gbcpanneauBouton.weightx = 5;// définie le nombre d'element horizontale
        gbcpanneauBouton.weighty = 3;// définie le nombre d'élement horizontale

        gbcpanneauBouton.gridx = 2;
        gbcpanneauBouton.gridy = 2;
        gbcpanneauBouton.gridwidth = 1;
        gbcpanneauBouton.gridheight = 1;
        JButton acces = new JButton(" acces ");
        acces.setText("");
        //acces.setFont(new Font("Verdana", Font.PLAIN, 20)); // définition du style de texte
        acces.setBorderPainted(false);
        acces.setFocusPainted(false);
        acces.setContentAreaFilled(false);
        acces.setBackground(Color.DARK_GRAY);
        acces.setForeground(Color.WHITE);
        acces.setPreferredSize(new Dimension(125, 37));

        acces.setIcon(new ImageIcon(getClass().getResource("/acces.png")));
        acces.setSelectedIcon(new ImageIcon(getClass().getResource("/acces-hover.png")));
        acces.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY));
        acces.setName("entrer");

        JPanel pacces = new JPanel();
        pacces.setBackground(Color.WHITE);
        pacces.add(acces);
        panneauBouton.add(pacces, gbcpanneauBouton);

        gbcpanneauBouton.gridx = 4;
        gbcpanneauBouton.gridy = 2;
        gbcpanneauBouton.gridwidth = 1;
        gbcpanneauBouton.gridheight = 1;
        JButton quitter = new JButton(" Entrer ");
        quitter.setText("");
        //quitter.setFont(new Font("Verdana", Font.PLAIN, 20)); // définition du style de texte
        quitter.setBorderPainted(false);
        quitter.setFocusPainted(false);
        quitter.setContentAreaFilled(false);
        quitter.setBackground(Color.DARK_GRAY);
        quitter.setForeground(Color.WHITE);
        acces.setPreferredSize(new Dimension(125, 37));

        quitter.setIcon(new ImageIcon(getClass().getResource("/quitter.png")));
        quitter.setSelectedIcon(new ImageIcon(getClass().getResource("/quitter-hover.png")));
        quitter.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY));
        quitter.setName("quitter");

        JPanel pquitter = new JPanel();
        pquitter.setBackground(Color.WHITE);
        pquitter.add(quitter);
        panneauBouton.add(pquitter, gbcpanneauBouton);

        gbcpanneau.gridx = 1;
        gbcpanneau.gridy = 3;
        gbcpanneau.gridwidth = 1;
        gbcpanneau.gridheight = 1;
        panneau.add(panneauBouton, gbcpanneau);


        //fenetre.setMinimumSize(new Dimension(1280,850));
        CardLayout cardLayout = new CardLayout();
        fenetre.setLayout(cardLayout);
        Menu menu = new Menu(fenetre, cardLayout, "Groupes    ","Administrtateur");
        acces.addMouseListener(new ButtonListener(fenetre,cardLayout,acces));
        quitter.addMouseListener(new ButtonListener(fenetre,cardLayout,quitter));
        fenetre.add(panneau, "Accueil");

        GridLayout gridLayout = new GridLayout(1,2);
        gridLayout.setHgap(0);
        gridLayout.setVgap(0);


        JPanel menuContainer = new JPanel(new BorderLayout());



        JPanel menuP = new JPanel(new BorderLayout());
        JPanel navbar = new JPanel(new BorderLayout());
        SearchBar searchbar = new SearchBar(menu,fenetre,cardLayout);
        Groupe promo = Cadmin.Instance(false).getGroupeFactory().getPromotion().getSousGroupes().iterator().next();
        
        if (promo.getType() != TypeGroupe.PARTITION) {
            JButton creer = new JButton("Créer un groupe");
            creer.addMouseListener(new ButtonGroupeCreerListener(creer, menu, cardLayout, fenetre, promo));
            navbar.add(creer,BorderLayout.AFTER_LINE_ENDS);
        }
        
        navbar.add(searchbar.drawSearchBar(), BorderLayout.CENTER);
        
        menuP.add(navbar,BorderLayout.PAGE_START);
        CarteGroupe carteGroupe = new CarteGroupe(menu,fenetre,cardLayout, navbar);
        menuP.add(carteGroupe.drawCarteGroupe(promo));



        menuContainer.add(menu.drawMenu(),BorderLayout.LINE_START);

        menuContainer.add(menuP);

        
        fenetre.add(menuContainer, "Menu");
        fenetre.setVisible(true);
        fenetre.addComponentListener(new ComponentAdapter() {
        public void componentResized(ComponentEvent componentEvent) {
            menu.setPreferredSize(new Dimension(300, fenetre.getHeight()));
            menu.setSize(new Dimension(400, fenetre.getHeight()));
            fenetre.revalidate();
        }
        });
    }
}
