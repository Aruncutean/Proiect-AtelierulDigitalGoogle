package Proiect2.Code;

import javax.swing.*;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {

        this.x = x;
        this.y = y;
    }


    public void changePoint(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }
}
