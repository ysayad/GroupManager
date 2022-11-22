// package fr.iutfbleau.projetIHM2022FI2.Vues;
import java.awt.*;
import javax.swing.*;
import javax.swing.UIManager.*;
import javax.swing.border.Border;

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
        
        GridBagLayout layout = new GridBagLayout();
        JPanel p = new JPanel(layout);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        c.insets = new Insets(2, 2, 2, 2);
        c.ipady = c.anchor = GridBagConstraints.CENTER;
        c.weightx = 1;
        c.weighty = 2;
        c.gridy = 1;
        c.gridx = 1;
        JLabel titreGroupManager = new JLabel(" GroupManager ");
        titreGroupManager.setFont(new Font("Verdana", Font.PLAIN, 25));
        Border border = BorderFactory.createMatteBorder(0,0,3,0,Color.BLACK);

        titreGroupManager.setHorizontalAlignment(SwingConstants.CENTER);
        titreGroupManager.setBorder(border);

        p.add(titreGroupManager,c);

        c.gridy = 2;
        c.gridx = 1;

        JLabel titreAdmin = new JLabel(" Administrateur ");
        titreAdmin.setFont(new Font("Verdana", Font.PLAIN, 20));
        titreAdmin.setHorizontalAlignment(SwingConstants.CENTER);

        Border borderpanel = BorderFactory.createEmptyBorder(0,300,0,300);

        p.setBorder(borderpanel);
        p.add(titreAdmin,c);
        p.setBackground(Color.WHITE);

        JLabel logoUpec = new JLabel(new ImageIcon("../Img/logo-upec.png"));
        logoUpec.setBackground(Color.WHITE);





















        GridBagLayout layoutb = new GridBagLayout();
        JPanel pb = new JPanel(layoutb);

        GridBagConstraints cb = new GridBagConstraints();
        cb.fill = GridBagConstraints.BOTH;

        cb.insets = new Insets(2, 2, 2, 2);
        cb.ipady = c.anchor = GridBagConstraints.CENTER;
        cb.weightx = 2;
        cb.weighty = 1;
        cb.gridy = 1;
        cb.gridx = 1;
        JButton entrer = new JButton(" Entrer ");
        entrer.setFont(new Font("Verdana", Font.PLAIN, 25));
        entrer.setHorizontalAlignment(SwingConstants.CENTER);

        pb.add(entrer,cb);

        cb.gridy = 1;
        cb.gridx = 2;

        JButton quitter = new JButton(" Quitter ");
        quitter.setFont(new Font("Verdana", Font.PLAIN, 20));
        quitter.setHorizontalAlignment(SwingConstants.CENTER);

        

        
        pb.add(quitter,cb);
        pb.setBackground(Color.WHITE);



























        
        f.add(p,BorderLayout.NORTH);
        f.add(logoUpec,BorderLayout.CENTER);
        f.add(pb,BorderLayout.SOUTH);

        f.setSize(1280,720);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        f.setVisible(true);
    
    }
}
