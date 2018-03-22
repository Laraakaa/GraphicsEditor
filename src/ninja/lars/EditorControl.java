package ninja.lars;

import ninja.lars.figuren.Kreis;
import ninja.lars.figuren.Linie;
import ninja.lars.figuren.Rechteck;
import ninja.lars.figuren.Zeichnung;

import java.awt.*;

final class EditorControl {
  private Zeichnung zeichnung = new Zeichnung();
  private char figurTyp = 'k';
  private Point ersterPunkt;

  public void allesNeuZeichnen(Graphics g) {
    zeichnung.getFiguren().forEach(f -> f.draw((Graphics2D)g));
  }

  public void setFigurTyp(char figurTyp) {
    this.figurTyp = figurTyp;
  }

  public void setErsterPunkt(Point ersterPunkt) {
    this.ersterPunkt = ersterPunkt;
  }

  public void erzeugeFigurMitZweitemPunkt(Point zweiterPunkt) {
    switch(figurTyp) {
      case 'r':
        zeichnung.add(new Rechteck((int)ersterPunkt.getX(), (int)ersterPunkt.getY(), Color.BLACK, (int)(zweiterPunkt.getX() - ersterPunkt.getX()), (int)(zweiterPunkt.getY() - ersterPunkt.getY())));
        break;
      case 'k':
        double xDiff = zweiterPunkt.getX() - ersterPunkt.getX();
        double yDiff = zweiterPunkt.getY() - ersterPunkt.getY();

        double radius = Math.sqrt(xDiff * xDiff + yDiff * yDiff);
        zeichnung.add(new Kreis((int)ersterPunkt.getX(), (int)ersterPunkt.getY(), Color.BLACK, (int)radius));
        break;
        case 'l':
        zeichnung.add(new Linie((int) ersterPunkt.getX(), (int) ersterPunkt.getY(), Color.BLACK, (int) zweiterPunkt.getX(), (int)zweiterPunkt.getY()));
        break;
    }
  }
}
