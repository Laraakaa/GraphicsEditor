package ninja.lars.persistence;

import ninja.lars.figuren.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class FigureSaver {
    OutputStreamWriter writer;
    File outputFile;

    public FigureSaver(String filename) throws IOException {
        outputFile = new File(filename);
        writer = new FileWriter(outputFile);
    }

    public void save(List<Figur> figuren) {
        for (Figur f : figuren) {
            String output = String.format("%s,%s,%s,%s", f.getClass().getSimpleName(), f.getX(), f.getY(), f.getLineColor().getRGB());
            if (f.getClass().equals(Rechteck.class) || f.getClass().equals(Ellipse.class)) {
                Rechteck r = (Rechteck)f;
                output += String.format(",%s,%s", r.getBreite(), r.getHoehe());
            }
            if (f.getClass().equals(Kreis.class)) {
                Kreis k = (Kreis)f;
                output += String.format(",%s", k.getRadius());
            }
            if (f.getClass().equals(Linie.class)) {
                Linie l = (Linie)f;
                output += String.format(",%s,%s", l.getEndeX(), l.getEndeY());
            }
            System.out.println(output);
            try {
                writer.write(output + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //writer.write(output);
    }

}
