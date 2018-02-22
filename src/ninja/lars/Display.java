package ninja.lars;

import ninja.lars.figuren.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Die Klasse Display stellt ein Fenster auf dem Bildschirm zur Verfügung, in welchem
 * Figur-Objekte dargestellt werden können.
 * Siehe auch Java-Grundkurs Abschnitt 10.2 und 10.3.
 *
 * @author Andres Scheidegger
 */
@SuppressWarnings("serial")
public class Display extends JFrame {
    /** Die Liste der dargestellten Figur-Objekte */
    private List<Figur> figuren = new ArrayList<>();
    private List<Gruppe> gruppen = new ArrayList<>();

    /**
     * Konstruktor. Initialisiert das Fenster in der Mitte des Bildschirms und erzeugt ein
     * JFrame-Objekt, auf welchem die Figuren gezeichnet werden.
     */
    public Display() {
        Dimension windowSize = new Dimension(800, 600);
        setSize(windowSize);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int windowPositionX = (screenSize.width - windowSize.width) / 2;
        int windowPositionY = (screenSize.height - windowSize.height) / 2;
        Point windowPosition = new Point(windowPositionX, windowPositionY);
        setLocation(windowPosition);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createAndAddDrawingPanel();
        setVisible(true);
    }

    private void createAndAddDrawingPanel() {
        // Das JPanel-Objekt ist ein Objekt einer anonymen Unterklasse von JPanel
        // Siehe Java-Grundkurs Abschnitt 3.9
        add(new JPanel() {
            // Die paintComponent()-Methode wird automatisch aufgerufen, wenn irgendwer die repaint()-
            // Methode beim Dsiplay aufruft.
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                zeichneFiguren(g);
            }
        });
    }

    /**
     * Zeichnet alle Figuren.
     * @param g Referenz auf das Graphics-Objekt zum zeichnen.
     */
    private void zeichneFiguren(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;

        figuren.forEach(figur -> drawFigure(g2d, figur));
        gruppen.forEach(gruppe -> gruppe.getFiguren().forEach(figur -> drawFigure(g2d, figur)));
    }

    public void drawFigure(Graphics2D g2d, Figur f) {
        g2d.setColor(f.getLineColor());
        if (f.getClass().equals(Rechteck.class)) {
            Rechteck r = (Rechteck)f;
            g2d.drawRect(r.getX(), r.getY(), r.getBreite(), r.getHoehe());
        }
        if (f.getClass().equals(Kreis.class)) {
            Kreis k = (Kreis)f;
            g2d.drawOval(k.getX(), k.getY(), k.getRadius(), k.getRadius());
        }
        if (f.getClass().equals(Linie.class)) {
            Linie l = (Linie)f;
            g2d.drawLine(l.getX(), l.getY(), l.getEndeX(), l.getEndeY());
        }
        if (f.getClass().equals(Ellipse.class)) {
            Ellipse e = (Ellipse)f;
            g2d.drawOval(e.getX(), e.getY(), e.getBreite(), e.getHoehe());
        }
    }

    /**
     * Fügt eine weitere Figur hinzu und löst die Auffrischung des Fensterinhaltes aus.
     * @param figur Referenz auf das weitere Figur-Objekt.
     */
    public void hinzufuegen(Figur figur) {
        figuren.add(figur);
        repaint();
    }

    /**
     * Fügt eine weitere Gruppe hinzu und löst die Auffrischung des Fensterinhaltes aus.
     * @param gruppe Referenz auf das weitere Figur-Objekt.
     */
    public void hinzufuegen(Gruppe gruppe) {
        gruppen.add(gruppe);
        repaint();
    }

    /**
     * Löscht alle Figuren und löst die Auffrischung des Fensterinhaltes aus.
     */
    public void allesLoeschen() {
        figuren.clear();
        repaint();
    }

    public List<Figur> getFigures() {
        return figuren;
    }

    public void setFiguren(List<Figur> figuren) {
        this.figuren = figuren;
    }
}

