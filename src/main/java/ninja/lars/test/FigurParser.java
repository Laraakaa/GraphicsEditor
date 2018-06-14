package ninja.lars.test;

import ninja.lars.figuren.Figur;
import ninja.lars.figuren.Kreis;
import ninja.lars.figuren.Linie;
import ninja.lars.figuren.Rechteck;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FigurParser {
  private FigurFileDAO dao;

  public FigurParser(FigurFileDAO dao) {
    this.dao = dao;
  }

  public List<Figur> parse() {
    List<Figur> figuren = new ArrayList<>();
    String[] figurData = dao.readNextFigurData();
    while (figurData != null) {
      String figurTyp = figurData[0];
      int x = Integer.valueOf(figurData[1]);
      int y = Integer.valueOf(figurData[2]);
      Color farbe = Color.decode(figurData[3]);
      switch (figurTyp) {
      case "Rechteck":
        int breite = Integer.valueOf(figurData[4]);
        int hoehe = Integer.valueOf(figurData[5]);
        figuren.add(new Rechteck(x, y, farbe, breite, hoehe));
        break;
      case "Kreis":
        int radius = Integer.valueOf(figurData[4]);
        figuren.add(new Kreis(x, y, farbe, radius));
        break;
      case "Linie":
        int endx = Integer.valueOf(figurData[4]);
        int endy = Integer.valueOf(figurData[5]);
        figuren.add(new Linie(x, y, farbe, endx, endy));
        break;
      }
      figurData = dao.readNextFigurData();
    }
    return figuren;
  }
}
