package ninja.lars;

import ninja.lars.figuren.*;
import ninja.lars.persistence.FigureLoader;
import ninja.lars.persistence.FigureSaver;

import java.awt.*;
import java.io.IOException;

public class Main {

    private static final Display  display = new Display();

    public static void main(String[] args) {
	    /* Kreis kreis = new Kreis(10, 10, Color.GREEN, 100);
        Rechteck rechteck = new Rechteck(200, 200, Color.RED, 100, 150);
        Linie linie = new Linie(0, 0, Color.BLACK, 500, 500);
        Ellipse ellipse = new Ellipse(300, 300, Color.CYAN, 200, 100);

        Gruppe gruppe = new Gruppe();
        gruppe.add(kreis);
        gruppe.add(rechteck);

        //display.hinzufuegen(gruppe);
        display.hinzufuegen(kreis);
        display.hinzufuegen(rechteck);

        display.hinzufuegen(linie);
        display.hinzufuegen(ellipse);

        rechteck.move(100, 200);
        display.repaint();

        rechteck.stretch(0.1F);
        display.repaint();

        ellipse.move(200, 200);
        display.repaint();

        linie.move(100, 0);
        display.repaint();

        try {
            FigureSaver saver = new FigureSaver("data.csv");
            saver.save(display.getFigures());
        } catch (IOException e) {
            e.printStackTrace();
        } */

        try {
            FigureLoader loader = new FigureLoader("data.csv");
            display.setFiguren(loader.read());
            display.repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
