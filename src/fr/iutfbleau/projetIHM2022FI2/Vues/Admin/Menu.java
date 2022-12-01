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
        gbc.weightx = 5;// définie le nombre d'elements horizontale
        gbc.weighty = 2;// définie le nombre d'élements verticale

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        JPanel table = new JPanel();
        table.setBackground(new Color(125,0,255));
        table.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));
        this.menu.add(table, gbc);


        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        JPanel table2 = new JPanel();
        table2.setBackground(Color.DARK_GRAY);



        //table2.setBackground(new Color(125,0,255));
        table2.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));
        this.menu.add(table2, gbc);


        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        JPanel carteGroupe = new JPanel();
        this.menu.add(carteGroupe, gbc);

        for (int i = 0; i < 2 ; i+=1 ) {
            for (int j = 0; j < 4 ; j+=1 ) {
            
            }
        }



    }
}
