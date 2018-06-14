package ninja.lars.test;

public class FigurFileDAOStub implements FigurFileDAO {
    private String[] testFiguren = {
            "Rechteck,100,200,-65536,50,200",
            "Kreis,100,200,-16711681,100",
            "Linie,100,200,-16711681,50,200"
    };

    // Zustand
    private int position = 0;

    @Override
    public String[] readNextFigurData() {
        if (position < testFiguren.length) {
            String[] data = testFiguren[position].split(",");
            position++;
            return data;
        }
        return null;
    }
}
