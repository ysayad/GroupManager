package fr.iutfbleau.projetIHM2022FI2.Vues.Admin.test;
import java.awt.*;
import javax.swing.*;
import javax.swing.UIManager.*;
import javax.swing.border.Border;
import java.io.*;
import java.lang.Thread;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class FenetreAdmin extends JFrame {
    JFrame fenetre = new JFrame("Admin");
    JPanel panneauTitre = new JPanel();
    GridBagConstraints gbc = new GridBagConstraints();
    GridBagConstraints gbcpanneau = new GridBagConstraints();
    JPanel panneauBouton = new JPanel();
    JPanel panneau = new JPanel();
    GridBagConstraints gbcpanneauBouton = new GridBagConstraints();





    public void FenetreAdmin(){
        this.fenetre.setSize(1920,1080);
        this.fenetre.setLocationRelativeTo(null);
        this.fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    public void test() {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }


        this.panneauTitre.setBackground(Color.WHITE);
        this.panneauTitre.setLayout(new GridBagLayout());
        this.gbc.fill = GridBagConstraints.BOTH;
        this.gbc.insets = new Insets(0, this.fenetre.getWidth()/2-110, 0, this.fenetre.getWidth()/2-110); // définie les espacements entre les elements
        this.gbc.ipady =  GridBagConstraints.CENTER; // definie la largeur des élements
        this.gbc.ipadx =  GridBagConstraints.CENTER; // définie la longueur des éléments
        this.gbc.anchor = GridBagConstraints.CENTER; // définie le type d'espacement entre les element
        this.gbc.weightx = 1;// définie le nombre d'element horizontale
        this.gbc.weighty = 2;// définie le nombre d'élement horizontale

        this.gbc.gridx = 1;
        this.gbc.gridy = 1;
        this.gbc.gridwidth = 1;
        this.gbc.gridheight = 1;
        JLabel titre = new JLabel(" GroupManager ");
        titre.setFont(new Font("Verdana", Font.PLAIN, 25)); // définition du style de texte
        titre.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        this.panneauTitre.add(titre, gbc);

        this.gbc.gridx = 1;
        this.gbc.gridy = 2;
        this.gbc.gridwidth = 1;
        this.gbc.gridheight = 1;
        JLabel titreAdmin = new JLabel(" Administrateur ");
        titreAdmin.setFont(new Font("Verdana", Font.PLAIN, 20)); // définition du style de texte
        titreAdmin.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));

        titreAdmin.setHorizontalAlignment(SwingConstants.CENTER);
        this.panneauTitre.add(titreAdmin, gbc);







        this.panneau.setBackground(Color.WHITE);
        this.panneau.setLayout(new GridBagLayout());
        this.gbcpanneau.fill = GridBagConstraints.BOTH;
        this.gbcpanneau.insets = new Insets(0, 0, 0, 0); // définie les espacements entre les elements
        this.gbcpanneau.ipady =  GridBagConstraints.CENTER; // definie la largeur des élements
        this.gbcpanneau.ipadx =  GridBagConstraints.CENTER; // définie la longueur des éléments
        this.gbcpanneau.anchor = GridBagConstraints.CENTER; // définie le type d'espacement entre les element
        this.gbcpanneau.weightx = 1;// définie le nombre d'element horizontale
        this.gbcpanneau.weighty = 3;// définie le nombre d'élement horizontale

        this.gbcpanneau.gridx = 1;
        this.gbcpanneau.gridy = 1;
        this.gbcpanneau.gridwidth = 1;
        this.gbcpanneau.gridheight = 1;
        this.panneau.add(this.panneauTitre, this.gbcpanneau);

        this.gbcpanneau.gridx = 1;
        this.gbcpanneau.gridy = 2;
        this.gbcpanneau.gridwidth = 1;
        this.gbcpanneau.gridheight = 1;
        JPanel panneauLogo = new JPanel();
        JLabel logoupec = new JLabel(new ImageIcon("../Img/logo-upec.png"));
        panneauLogo.setBackground(Color.WHITE);
        panneauLogo.add(logoupec);
        this.panneau.add(panneauLogo, this.gbcpanneau);





        this.panneauBouton.setBackground(Color.WHITE);
        this.panneauBouton.setLayout(new GridBagLayout());
        this.gbcpanneauBouton.fill = GridBagConstraints.BOTH;
        this.gbcpanneauBouton.insets = new Insets(50, 100, 50,100); // définie les espacements entre les elements
        this.gbcpanneauBouton.ipady =  GridBagConstraints.CENTER; // definie la largeur des élements
        this.gbcpanneauBouton.ipadx =  GridBagConstraints.CENTER; // définie la longueur des éléments
        this.gbcpanneauBouton.anchor = GridBagConstraints.CENTER; // définie le type d'espacement entre les element
        this.gbcpanneauBouton.weightx = 5;// définie le nombre d'element horizontale
        this.gbcpanneauBouton.weighty = 3;// définie le nombre d'élement horizontale

        this.gbcpanneauBouton.gridx = 2;
        this.gbcpanneauBouton.gridy = 2;
        this.gbcpanneauBouton.gridwidth = 1;
        this.gbcpanneauBouton.gridheight = 1;
        JButton quitter = new JButton(" Quitter ");
        quitter.setFont(new Font("Verdana", Font.PLAIN, 20)); // définition du style de texte
        quitter.setBorderPainted(false);
        quitter.setFocusPainted(false);
        quitter.setContentAreaFilled(true);
        quitter.setBackground(Color.DARK_GRAY);
        quitter.setForeground(Color.WHITE);
        quitter.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY));
        this.panneauBouton.add(quitter, gbcpanneauBouton);

        this.gbcpanneauBouton.gridx = 4;
        this.gbcpanneauBouton.gridy = 2;
        this.gbcpanneauBouton.gridwidth = 1;
        this.gbcpanneauBouton.gridheight = 1;
        JButton entrer = new JButton(" Entrer ");
        entrer.setFont(new Font("Verdana", Font.PLAIN, 20)); // définition du style de texte
        this.panneauBouton.add(entrer, gbcpanneauBouton);

        this.gbcpanneau.gridx = 1;
        this.gbcpanneau.gridy = 3;
        this.gbcpanneau.gridwidth = 1;
        this.gbcpanneau.gridheight = 1;
        this.panneau.add(this.panneauBouton, this.gbcpanneau);


        this.fenetre.add(panneau);
        this.fenetre.setVisible(true);

    }
}
