package Proiect2.Code;

import javax.swing.*;

public class Piece {    private String name;
    private Point point;
    private JLabel jLabel;

    public Piece(String name) {
        this.name = name;
    }

    void setPoint(int x, int y) {
        if (point == null) {
            point = new Point(x, y);
        } else {
            point.changePoint(x, y);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getPoint() {
        return point;
    }


    public void setjLabel(JLabel jLabel) {
        this.jLabel = jLabel;
    }

    public JLabel getjLabel() {
        return jLabel;
    }
}
