package ninja.lars.figuren;

import java.awt.*;

public class Rechteck extends Figur {
    private int breite;
    private int hoehe;

    public Rechteck(int x, int y, Color lineColor, int breite, int hoehe) {
        super(x, y, lineColor);

        this.breite = breite;
        this.hoehe = hoehe;
    }

    @Override
    public void stretch(float factor) {
        this.breite = Math.round(factor * breite);
        this.hoehe = Math.round(factor * hoehe);
    }

    public int getBreite() {
        return breite;
    }

    public int getHoehe() {
        return hoehe;
    }
}
