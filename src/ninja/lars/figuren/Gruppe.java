package ninja.lars.figuren;

import java.util.ArrayList;
import java.util.List;

public class Gruppe {
    private List<Figur> figuren = new ArrayList<Figur>();

    public List<Figur> getFiguren() {
        return figuren;
    }

    public void add(Figur f) {
        figuren.add(f);
    }
}
