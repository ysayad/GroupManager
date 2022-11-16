// package fr.iutfbleau.projetIHM2022FI2.Vues;
import java.awt.*;
import javax.swing.*;
import javax.swing.UIManager.*;

public class Admin {
    public static void main(String[] args) {
        JFrame f = new JFrame("Admin");
        
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
        
        JPanel p = new JPanel(new GridBagLayout());

        JLabel titre = new JLabel("GroupManager");
        p.add(titre);

        f.setSize(1280,720);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
    }
}
