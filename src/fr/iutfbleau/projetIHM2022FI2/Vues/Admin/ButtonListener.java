import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.Cursor;
// package fr.iutfbleau.projetIHM2022FI2.Vues;
import java.awt.*;
import javax.swing.*;
import javax.swing.UIManager.*;
import javax.swing.border.Border;
import java.io.*;
import java.lang.Thread;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ButtonListener implements MouseListener{
    JButton button;
    CardLayout cardLayout;
    JFrame window;
    public ButtonListener(JFrame window,CardLayout cardLayout, JButton button) {
        this.window=window;
        this.button = button;
        this.cardLayout = cardLayout;
    }

    public void mouseClicked(MouseEvent e) {
        if (this.button.getName() == "quitter") {
            System.exit(1);
        }
        if (this.button.getName() == "entrer") {
            System.out.println("Entrer");
            this.cardLayout.show(this.window.getContentPane(), "Menu");
        }
    }

    public void mouseEntered(MouseEvent e) {
        this.button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public void mouseExited(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

}