package ninja.lars.figuren;

import java.awt.*;

public class Ellipse extends Rechteck {
    public Ellipse(int x, int y, Color lineColor, int breite, int hoehe) {
        super(x, y, lineColor, breite, hoehe);
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawOval(this.getX(), this.getY(), this.getBreite(), this.getHoehe());
    }
}
