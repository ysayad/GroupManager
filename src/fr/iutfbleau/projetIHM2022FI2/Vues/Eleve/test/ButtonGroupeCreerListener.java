package fr.iutfbleau.projetIHM2022FI2.Vues.Eleve.test;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.Cursor;
import java.awt.*;
import javax.swing.*;
import javax.swing.UIManager.*;

import fr.iutfbleau.projetIHM2022FI2.API.Etudiant;
import fr.iutfbleau.projetIHM2022FI2.API.Groupe;
import fr.iutfbleau.projetIHM2022FI2.API.TypeGroupe;
import fr.iutfbleau.projetIHM2022FI2.Controller.Controller;
import javax.swing.border.Border;
import javax.swing.event.MouseInputListener;

import java.io.*;
import java.lang.Thread;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ButtonGroupeCreerListener implements MouseListener {
    JButton button;
    JFrame window;
    Menu menu;
    CardLayout cardLayout;
    Groupe g;

    public ButtonGroupeCreerListener(JButton button , Menu menu, CardLayout cardLayout, JFrame window, Groupe g) {
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

    
    public void create(Groupe g){
            JDialog dialog = new JDialog(this.window, "Créer le groupe : "+g.getName()); 
            JLabel desc = new JLabel("Nommer le groupe : ");
            JTextField saisi_renommer = new JTextField();
            if (g.getType() == TypeGroupe.PARTITION) {
                saisi_renommer.setText(g.getPointPoint().getName());
            } else {
                saisi_renommer.setText("Saisissez un nom");
            }
            saisi_renommer.addMouseListener(new ChampTextListener(saisi_renommer,"Saisissez un nom"));
            saisi_renommer.setBounds(20,20,20,20);
            saisi_renommer.setForeground(Color.GRAY);
            saisi_renommer.setMinimumSize(new Dimension(100,45));
            saisi_renommer.setSize(200, 45);
            saisi_renommer.setPreferredSize( new Dimension( 200, 45 ) );
            saisi_renommer.setFont(new Font("Verdana", Font.PLAIN, 16)); // définition du style de texte
            Border border = BorderFactory.createLineBorder(new Color(25,25,25));  
            saisi_renommer.setBorder(border);
            saisi_renommer.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
            JButton creer = new JButton("Créer");
            creer.addMouseListener(new CreerListener(creer,menu,cardLayout,window,g,dialog,saisi_renommer));
            creer.setFont(new Font("Verdana", Font.PLAIN, 16));
            creer.setBackground(new Color(64,0,128));
            creer.setForeground(Color.WHITE);
            creer.setFocusable(false);
            creer.setCursor(new Cursor(Cursor.HAND_CURSOR));

            JPanel saisi_container = new JPanel(new GridLayout(2,2));

            saisi_container.add(desc);
            saisi_container.add(this.vide());
            saisi_container.add(saisi_renommer);
            saisi_container.add(creer);

            JPanel big_container = new JPanel();
            big_container.add(saisi_container);
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
        this.create(g);
    }

    public void mouseReleased(MouseEvent e) {}

}