package ninja.lars.persistence;

import ninja.lars.figuren.*;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FigureLoader {

    BufferedReader reader;
    File inputFile;

    public FigureLoader(String filename) throws IOException {
        inputFile = new File(filename);
        reader = new BufferedReader(new FileReader(inputFile));
    }

    public List<Figur> read() {
        List<Figur> figuren = new ArrayList<>();

        while (true) {
            try {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }

                String[] defaultData = line.split(",");

                String className = defaultData[0];
                int x = Integer.valueOf(defaultData[1]);
                int y = Integer.valueOf(defaultData[2]);
                Color color = new Color(Integer.valueOf(defaultData[3]));

                if (className.equals("Rechteck")) {
                    Rechteck r = new Rechteck(x, y, color, Integer.valueOf(defaultData[4]), Integer.valueOf(defaultData[5]));
                    figuren.add(r);
                }
                if (className.equals("Ellipse")) {
                    Ellipse e = new Ellipse(x, y, color, Integer.valueOf(defaultData[4]), Integer.valueOf(defaultData[5]));
                    figuren.add(e);
                }
                if (className.equals("Kreis")) {
                    Kreis k = new Kreis(x, y, color, Integer.valueOf(defaultData[4]));
                    figuren.add(k);
                }
                if (className.equals("Linie")) {
                    Linie l = new Linie(x, y, color, Integer.valueOf(defaultData[4]), Integer.valueOf(defaultData[5]));
                    figuren.add(l);
                }
            } catch (Exception e) {
                System.out.println("Fehler beim auslesen. Bitte Dateiformat überprüfen!");
                e.printStackTrace();
            }
        }

        return figuren;
    }

}
