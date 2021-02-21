package Proiect2.Code;

import javax.swing.*;

public class BoardPoz {
    private int x;
    private int y;
    private JLabel label;

    BoardPoz(JLabel label, int x, int y) {
        this.label = label;
        this.y = y;
        this.x = x;
    }


    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public JLabel getLabel() {
        return label;
    }

}
