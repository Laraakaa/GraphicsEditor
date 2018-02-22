package ninja.lars.figuren;

import java.awt.*;

public class Figur {
    private int x;
    private int y;
    private Color lineColor;

    Figur(int x, int y, Color lineColor) {
        this.x = x;
        this.y = y;
        this.lineColor = lineColor;
    }

    public void move(int deltaX, int deltaY) {
        this.x = x + deltaX;
        this.y = y + deltaY;
    }

    public void stretch(float factor) {
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getLineColor() {
        return lineColor;
    }
}
