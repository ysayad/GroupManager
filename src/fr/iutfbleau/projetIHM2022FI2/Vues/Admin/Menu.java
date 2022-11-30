// package fr.iutfbleau.projetIHM2022FI2.Vues;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Menu extends JFrame {
    JPanel menu = new JPanel();
    public Menu(){
        this.menu.setBackground(Color.WHITE);
        this.menu.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.ipady =  GridBagConstraints.CENTER; // definie la largeur des élements
        gbc.ipadx =  GridBagConstraints.CENTER; // définie la longueur des éléments
        gbc.anchor = GridBagConstraints.CENTER; // définie le type d'espacement entre les element
        gbc.weightx = 2;// définie le nombre d'elements horizontale
        gbc.weighty = 1;// définie le nombre d'élements verticale

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        JPanel table = new JPanel();
        table.setBackground(new Color(125,0,255));
        table.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));
        this.menu.add(table, gbc);



        JPanel table2 = new JPanel();
        table2.setBackground(Color.DARK_GRAY);


        //table2.setBackground(new Color(125,0,255));
        table2.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        this.menu.add(table2, gbc);

    }
}
