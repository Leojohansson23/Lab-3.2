import junit.framework.TestCase;
import org.junit.Test;

import java.awt.*;

public class Saab95Test extends TestCase {

    @Test
    public void testspeed(){
        Saab95 test = new Saab95();
        test.startEngine();
        test.gas(1.0);
        assertEquals(1.35,test.getCurrentSpeed());
    }

    public void testmove(){
        Saab95 test = new Saab95();
        test.startEngine();
        test.move();
        test.move();
        test.turnright();
        test.move();
        //assertEquals(3, test.getYpos());
        assertEquals(0.1,test.getXpos());
    }



    @Test
    public void testspeedturbo(){
        Saab95 test = new Saab95();
        test.startEngine();
        test.setTurboOff();
        test.stopEngine();
        test.setTurboOn();
        test.gas(10.0);
        assertEquals(0.0,test.getCurrentSpeed());
    }

    @Test
    public void testspeedturbooff(){
        Saab95 test = new Saab95();
        test.startEngine();
        test.setTurboOn();
        test.gas(1.0);
        assertEquals(1.725,test.getCurrentSpeed());
    }

    @Test
    public void testegetenginepower(){
        Saab95 test = new Saab95();
        assertEquals(125.0, test.getEnginePower());
    }
    @Test
    public void testmodelname(){
        Saab95 test = new Saab95();
        assertEquals("src.Saab95", test.getModelName());



    }


    @Test
    public void testdoors(){
        Saab95 test = new Saab95();
        assertEquals(2,test.getNrDoors());
    }

    public void testcolor(){
        Saab95 testcar = new Saab95();
        Color expectedcolor = new Color(255,0,0);
        assertEquals(expectedcolor,testcar.getColor());





    }
}
