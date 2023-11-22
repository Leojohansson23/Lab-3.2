import junit.framework.TestCase;
import org.junit.Test;

public class WorkshopTest extends TestCase {

    @Test
    public void testaddandreturncar() {
        Workshop <Volvo240> volvoWorkshop = new Workshop<>();
        Scania scania = new Scania();
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();
        volvoWorkshop.addcar(volvo);
        volvoWorkshop.returnCars(volvo);
        assertEquals(0, volvoWorkshop.listOfCars());

    }



}