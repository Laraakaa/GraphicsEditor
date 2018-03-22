package ninja.lars;

public class Main {

    private static final EditorFrame display = new EditorFrame(500, 500);

    public static void main(String[] args) {
	    /* Kreis kreis = new Kreis(10, 10, Color.GREEN, 100);
        Rechteck rechteck = new Rechteck(200, 200, Color.RED, 100, 150);
        Linie linie = new Linie(0, 0, Color.BLACK, 500, 500);
        Ellipse ellipse = new Ellipse(300, 300, Color.CYAN, 200, 100);

        Zeichnung gruppe = new Zeichnung();
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

        /* try {
            FigureLoader loader = new FigureLoader("data.csv");
            Zeichnung z = new Zeichnung(loader.read());
            //display.getEditorControl().setZeichnung(z);
            //display.repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //display.getEditorControl();
    }
}
