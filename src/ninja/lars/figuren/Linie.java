package ninja.lars.figuren;

import java.awt.*;

public class Linie extends Figur {
    private int endeX;
    private int endeY;

    public Linie(int x, int y, Color lineColor, int endeX, int endeY) {
        super(x, y, lineColor);

        this.endeX = endeX;
        this.endeY = endeY;
    }

    @Override
    public void move(int deltaX, int deltaY) {
        super.move(deltaX, deltaY);
        this.endeX = endeX + deltaX;
        this.endeY = endeY + deltaY;
    }

    @Override
    public void stretch(float factor) {
        this.endeX = Math.round(this.endeX * factor);
        this.endeY = Math.round(this.endeY * factor);
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawLine(this.getX(), this.getY(), this.getEndeX(), this.getEndeY());
    }

    public int getEndeX() {
        return endeX;
    }

    public int getEndeY() {
        return endeY;
    }
}
