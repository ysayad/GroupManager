package fr.iutfbleau.projetIHM2022FI2.Vues.Admin.test;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.Cursor;
import java.awt.*;
import javax.swing.*;
import javax.swing.UIManager.*;
import javax.swing.border.Border;
import java.io.*;
import java.lang.Thread;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class SearchBarButtonListener implements MouseListener{
    JTextField searchbar;
    JButton button;
    public SearchBarButtonListener(JTextField searchbar, JButton button) {
        this.searchbar = searchbar;
        this.button = button;
    }



    public void mouseClicked(MouseEvent e) {
        System.out.println(searchbar.getText());
    }

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

}