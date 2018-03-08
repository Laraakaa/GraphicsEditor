package ninja.lars.figuren;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Zeichnung {
    private List<Figur> figuren;

    public Zeichnung() {
        figuren = new ArrayList<>();
    }

    public Zeichnung(List<Figur> figuren) {
        this.figuren = figuren;
    }

    public List<Figur> getFiguren() {
        return figuren;
    }

    public void add(Figur f) {
        figuren.add(f);
    }

    /**
     * Zeichnet alle Figuren.
     * @param g Referenz auf das Graphics-Objekt zum zeichnen.
     */
    public void zeichneFiguren(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;

        figuren.forEach(figur -> zeichneFigur(g2d, figur));
    }

    /**
     * Zeichnet eine einzelne Figur
     * @param g2d Referenz auf das Grahpics-Objekt zum zeichnen
     * @param f Referenz auf die Figur, die gezeichnet werden soll.
     */
    private void zeichneFigur(Graphics2D g2d, Figur f) {
        f.draw(g2d);
    }
}
