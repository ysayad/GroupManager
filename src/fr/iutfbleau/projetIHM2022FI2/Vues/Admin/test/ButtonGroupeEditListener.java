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

public class ButtonGroupeEditListener implements MouseListener{
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
            JPanel saisi_container = new JPanel(new GridLayout(2,2));

            saisi_container.add(desc);
            saisi_container.add(this.vide());
            saisi_container.add(saisi_renommer);
            saisi_container.add(renommer);







            desc = new JLabel("Ajoutez un etudiant :");
            String[] elements = {"Apple", "Banana", "Orange"};
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
            comboBox1.setEditable(true);
            comboBox1.setForeground(Color.GRAY);
            comboBox1.setMinimumSize(new Dimension(100,45));
            comboBox1.setSize(200, 45);
            comboBox1.setPreferredSize( new Dimension( 200, 45 ) );
            comboBox1.setFont(new Font("Verdana", Font.PLAIN, 16)); // définition du style de texte
/*            border = BorderFactory.createLineBorder(new Color(25,25,25));  
            comboBox1.setBorder(border);*/
            JButton supprimer = new JButton("Supprimer");
            JPanel supprimer_container = new JPanel(new GridLayout(2,2));

            supprimer_container.add(desc);
            supprimer_container.add(this.vide());
            supprimer_container.add(comboBox1);
            supprimer_container.add(supprimer);










            JPanel big_container = new JPanel();
            big_container.add(saisi_container);
            big_container.add(ajouter_container);
            big_container.add(supprimer_container);
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