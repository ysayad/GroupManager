// package fr.iutfbleau.projetIHM2022FI2.Vues;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Menu extends JFrame {
    JPanel menu = new JPanel();
    JFrame window;
    CardLayout cardLayout;
    public Menu(JFrame window,CardLayout cardLayout){
        this.window = window;
        this.cardLayout = cardLayout;
        this.menu.setLayout(new GridLayout(6,1));
    }

    public JPanel drawButton(String name, JLabel icon){
        JPanel buttonpanel = new JPanel();
        buttonpanel.setBackground(Color.BLACK);
        buttonpanel.setLayout(new GridLayout(1,2));
        buttonpanel.add(icon);
        JButton button = new JButton(name);
        button.setName(name);

        buttonpanel.add(button);
        button.addMouseListener(new ButtonListener(this.window,this.cardLayout, button));

        return buttonpanel;
    }


    public JPanel drawMenu(){
        //this.menu.setResizable(false);
        this.menu.setPreferredSize(new Dimension(500,54654465));
        this.menu.setBackground(new Color(150,0,255));
        JLabel logo = new JLabel(new ImageIcon("../Img/logo-upec.png"));
        this.menu.add(logo);
        this.menu.add(drawButton("Groupes",new JLabel(new ImageIcon("../Img/logo-upec.png"))));
        this.menu.add(drawButton("Etudiants",new JLabel(new ImageIcon("../Img/logo-upec.png"))));
        this.menu.add(drawButton("Changements",new JLabel(new ImageIcon("../Img/logo-upec.png"))));
        this.menu.add(drawButton("Deconnexion",new JLabel(new ImageIcon("../Img/logo-upec.png"))));
        this.menu.add(new JLabel("COPYRIGHT COPYRIGHT COPYRIGHT COPYRIGHT COPYRIGHT COPYRIGHT COPYRIGHT COPYRIGHT COPYRIGHT COPYRIGHT COPYRIGHT COPYRIGHT COPYRIGHT"));

        return this.menu;
    }
}
