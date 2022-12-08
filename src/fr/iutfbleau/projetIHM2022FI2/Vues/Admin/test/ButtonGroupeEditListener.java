package fr.iutfbleau.projetIHM2022FI2.Vues.Admin.test;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.Cursor;
import java.awt.*;
import javax.swing.*;
import javax.swing.UIManager.*;

import fr.iutfbleau.projetIHM2022FI2.API.Etudiant;
import fr.iutfbleau.projetIHM2022FI2.API.Groupe;
import fr.iutfbleau.projetIHM2022FI2.Controller.Cadmin;
import javax.swing.border.Border;
import java.io.*;
import java.lang.Thread;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ButtonGroupeEditListener implements MouseListener {
    JButton button;
    JFrame window;
    Menu menu;
    CardLayout cardLayout;
    Groupe g;

    public ButtonGroupeEditListener(JButton button , Menu menu, CardLayout cardLayout, JFrame window, Groupe g) {
        this.window=window;
        this.button = button;
        this.menu = menu;
        this.cardLayout = cardLayout;
        this.g = g;
    }


    public JPanel vide(){
        JPanel vide = new JPanel();
        vide.setOpaque(false);
        return vide;
    }


    public void edit(Groupe g){
            JDialog dialog = new JDialog(this.window, "Modifier le groupe : "+g.getName()); 
            JLabel desc = new JLabel("Renommer le groupe :");
            JTextField saisi_renommer = new JTextField(g.getName());
            saisi_renommer.setBounds(20,20,20,20);
            saisi_renommer.setForeground(Color.GRAY);
            saisi_renommer.setMinimumSize(new Dimension(100,45));
            saisi_renommer.setSize(200, 45);
            saisi_renommer.setPreferredSize( new Dimension( 200, 45 ) );
            saisi_renommer.setFont(new Font("Verdana", Font.PLAIN, 16)); // définition du style de texte
            Border border = BorderFactory.createLineBorder(new Color(25,25,25));  
            saisi_renommer.setBorder(border);
            saisi_renommer.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
            JButton renommer = new JButton("Renommer");
            renommer.addMouseListener(new CreerListener(renommer, menu, cardLayout, window, g, dialog, saisi_renommer.getText()));
            renommer.setFocusable(false);
            renommer.setCursor(new Cursor(Cursor.HAND_CURSOR));
            renommer.setFont(new Font("Verdana", Font.PLAIN, 16));
            renommer.setBackground(new Color(64,0,128));
            renommer.setForeground(Color.WHITE);
            JPanel saisi_container = new JPanel(new GridLayout(2,2));

            saisi_container.add(desc);
            saisi_container.add(this.vide());
            saisi_container.add(saisi_renommer);
            saisi_container.add(renommer);







            desc = new JLabel("Ajoutez un etudiant :");
            Groupe promo = Cadmin.Instance(false).getGroupeFactory().getPromotion();
            String[] elements = new String[promo.getSize()];
            int j=0;
            for (Etudiant e : promo.getEtudiants()) {
                    elements[j] = e.getNom() + " " + e.getPrenom();
                    j++;
            }
            JComboBox comboBox = new JComboBox(elements);

  

            comboBox.setEditable(true);
            comboBox.setForeground(Color.GRAY);
            comboBox.setMinimumSize(new Dimension(100,45));
            comboBox.setSize(200, 45);
            comboBox.setPreferredSize( new Dimension( 200, 45 ) );
            comboBox.setFont(new Font("Verdana", Font.PLAIN, 16)); // définition du style de texte
/*            border = BorderFactory.createLineBorder(new Color(25,25,25));  
            comboBox.setBorder(border);*/
            JButton ajouter = new JButton("Ajouter");
            ajouter.addMouseListener(new CreerListener(ajouter, menu, cardLayout, window, g, dialog, comboBox));
            ajouter.setFont(new Font("Verdana", Font.PLAIN, 16));
            ajouter.setBackground(new Color(64,0,128));
            ajouter.setForeground(Color.WHITE);
            ajouter.setFocusable(false);
            ajouter.setCursor(new Cursor(Cursor.HAND_CURSOR));
            JPanel ajouter_container = new JPanel(new GridLayout(2,2));

            ajouter_container.add(desc);
            ajouter_container.add(this.vide());
            ajouter_container.add(comboBox);
            ajouter_container.add(ajouter);



            desc = new JLabel("Supprimer un etudiant :");
            String[] elements2 = new String[g.getSize()];
            int i=0;
            for (Etudiant e : g.getEtudiants()) {
                elements2[i] = e.getNom() + " " + e.getPrenom();
                i++;
            }
            JComboBox comboBox1 = new JComboBox(elements2);
            comboBox1.setBackground(new Color(64,0,128));
            comboBox1.setEditable(true);
            comboBox1.setForeground(Color.GRAY);
            comboBox1.setMinimumSize(new Dimension(100,45));
            comboBox1.setSize(200, 45);
            comboBox1.setPreferredSize( new Dimension( 200, 45 ) );
            comboBox1.setFont(new Font("Verdana", Font.PLAIN, 16)); // définition du style de texte
/*            border = BorderFactory.createLineBorder(new Color(25,25,25));  
            comboBox1.setBorder(border);*/
            JButton supprimer = new JButton("Supprimer");
            supprimer.addMouseListener(new CreerListener(supprimer, menu, cardLayout, window, g, dialog, comboBox1));
            supprimer.setFont(new Font("Verdana", Font.PLAIN, 16));
            supprimer.setBackground(new Color(64,0,128));
            supprimer.setForeground(Color.WHITE);
            supprimer.setFocusable(false);
            supprimer.setCursor(new Cursor(Cursor.HAND_CURSOR));
            JPanel supprimer_container = new JPanel(new GridLayout(2,2));

            supprimer_container.add(desc);
            supprimer_container.add(this.vide());
            supprimer_container.add(comboBox1);
            supprimer_container.add(supprimer);


            desc = new JLabel("Partitionner");
            JSpinner nbr = new JSpinner();
            nbr.setForeground(Color.GRAY);
            nbr.setMinimumSize(new Dimension(100,45));
            nbr.setSize(200, 45);
            nbr.setPreferredSize( new Dimension( 200, 45 ) );
            nbr.setFont(new Font("Verdana", Font.PLAIN, 16)); // définition du style de texte
/*            border = BorderFactory.createLineBorder(new Color(25,25,25));  
            nbr.setBorder(border);*/
            JButton partitionner = new JButton("Partitionner");
            partitionner.addMouseListener(new CreerListener(partitionner, menu, cardLayout, window, g, dialog, nbr.toString()));
            partitionner.setFont(new Font("Verdana", Font.PLAIN, 16));
            partitionner.setBackground(new Color(64,0,128));
            partitionner.setForeground(Color.WHITE);
            partitionner.setFocusable(false);
            partitionner.setCursor(new Cursor(Cursor.HAND_CURSOR));
            JPanel partitionner_container = new JPanel(new GridLayout(2,2));

            partitionner_container.add(desc);
            partitionner_container.add(this.vide());
            partitionner_container.add(nbr);
            partitionner_container.add(partitionner);




            JButton suprimmer_groupe = new JButton("Supprimer le groupe");
            suprimmer_groupe.addMouseListener(new CreerListener(suprimmer_groupe, menu, cardLayout, window, g, dialog, ""));
            suprimmer_groupe.setFont(new Font("Verdana", Font.PLAIN, 16));
            suprimmer_groupe.setBackground(new Color(255,0,0));
            suprimmer_groupe.setForeground(Color.WHITE);
            suprimmer_groupe.setFocusable(false);
            suprimmer_groupe.setCursor(new Cursor(Cursor.HAND_CURSOR));



            JPanel big_container = new JPanel();
            big_container.add(saisi_container);
            big_container.add(ajouter_container);
            big_container.add(supprimer_container);
            big_container.add(partitionner_container);
            JPanel gap = new JPanel();
            gap.setMinimumSize(new Dimension(100,45));
            gap.setSize(200, 45);
            gap.setPreferredSize( new Dimension( 200, 45 ) );

            big_container.add(gap);            
            JPanel gap1 = new JPanel();
            gap1.setMinimumSize(new Dimension(100,45));
            gap1.setSize(200, 45);
            gap1.setPreferredSize( new Dimension( 200, 45 ) );

            big_container.add(gap1);

            big_container.add(suprimmer_groupe);
            dialog.add(big_container);
            dialog.setSize(500, 600); 
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) ((dimension.getWidth() - dialog.getWidth()) / 2);
            int y = (int) ((dimension.getHeight() - dialog.getHeight()) / 2);
            dialog.setLocation(x, y);
            dialog.setResizable(false);
            dialog.setVisible(true); 
    }





    public void mouseClicked(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {

        this.button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public void mouseExited(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {
        System.out.println(button.getName());
        this.edit(g);
    }

    public void mouseReleased(MouseEvent e) {}

}