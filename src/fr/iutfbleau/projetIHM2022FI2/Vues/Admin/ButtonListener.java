import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class ButtonListener implements MouseListener{
    JButton button;
    public ButtonListener(JButton button) {
        this.button = button;
    }

    public void mouseClicked(MouseEvent e) {
        if (this.button.getName() == "1") {
            System.out.println("on quitte mtn");
        }
    }

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

}