package fr.iutfbleau.projetIHM2022FI2.Vues.Admin.test;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.Cursor;
import java.awt.*;
import javax.swing.*;
import javax.swing.UIManager.*;
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
            JTextField saisi_ajoutez = new JTextField(g.getName());
            dialog.add(comboBox);
            saisi_ajoutez.setBounds(20,20,20,20);
            saisi_ajoutez.setForeground(Color.GRAY);
            saisi_ajoutez.setMinimumSize(new Dimension(100,45));
            saisi_ajoutez.setSize(200, 45);
            saisi_ajoutez.setPreferredSize( new Dimension( 200, 45 ) );
            saisi_ajoutez.setFont(new Font("Verdana", Font.PLAIN, 16)); // définition du style de texte
            border = BorderFactory.createLineBorder(new Color(25,25,25));  
            saisi_ajoutez.setBorder(border);
            saisi_ajoutez.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
            JButton ajouter = new JButton("Ajouter");
            JPanel ajouter_container = new JPanel(new GridLayout(3,2));

            ajouter_container.add(desc);
            ajouter_container.add(this.vide());
            ajouter_container.add(saisi_ajoutez);

            ajouter_container.add(ajouter);
            ajouter_container.add(comboBox);

            ajouter_container.add(this.vide());






            JPanel big_container = new JPanel();





            big_container.add(saisi_container);
            big_container.add(ajouter_container);
            dialog.add(big_container);
            dialog.setSize(500, 600); 

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