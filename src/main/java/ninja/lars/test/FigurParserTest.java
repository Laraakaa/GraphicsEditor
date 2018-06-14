package ninja.lars.test;

import ninja.lars.figuren.Figur;
import ninja.lars.figuren.Kreis;
import ninja.lars.figuren.Rechteck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;

public class FigurParserTest {

    private FigurFileDAO dao;
    private FigurParser fp;

    @BeforeEach
    public void setup() {
        dao = new FigurFileDAOStub();
        fp = new FigurParser(dao);
    }

    @Test
    public void testParse() {
        List<Figur> figuren = fp.parse();

        Assertions.assertEquals(3, figuren.size());

        Assertions.assertEquals("Rechteck", figuren.get(0).getClass().getSimpleName());
        Assertions.assertEquals("Kreis", figuren.get(1).getClass().getSimpleName());

        Assertions.assertEquals(100, figuren.get(0).getX());
        Assertions.assertEquals(200, figuren.get(0).getY());

        Assertions.assertEquals(100, figuren.get(1).getX());
        Assertions.assertEquals(200, figuren.get(1).getY());

        Rechteck rechteck = (Rechteck) figuren.get(0);
        Assertions.assertEquals(50, rechteck.getBreite());
        Assertions.assertEquals(200, rechteck.getHoehe());

        Kreis kreis = (Kreis) figuren.get(1);
        Assertions.assertEquals(100, kreis.getRadius());
    }

    @Test
    public void testParseMockito() {
        FigurFileDAO mocked = mock(FigurFileDAO.class);
        FigurParser fp = new FigurParser(mocked);

        List<Figur> figuren = fp.parse();

        Assertions.assertEquals(3, figuren.size());

        Assertions.assertEquals("Rechteck", figuren.get(0).getClass().getSimpleName());
        Assertions.assertEquals("Kreis", figuren.get(1).getClass().getSimpleName());

        Assertions.assertEquals(100, figuren.get(0).getX());
        Assertions.assertEquals(200, figuren.get(0).getY());

        Assertions.assertEquals(100, figuren.get(1).getX());
        Assertions.assertEquals(200, figuren.get(1).getY());

        Rechteck rechteck = (Rechteck) figuren.get(0);
        Assertions.assertEquals(50, rechteck.getBreite());
        Assertions.assertEquals(200, rechteck.getHoehe());

        Kreis kreis = (Kreis) figuren.get(1);
        Assertions.assertEquals(100, kreis.getRadius());
    }

}
