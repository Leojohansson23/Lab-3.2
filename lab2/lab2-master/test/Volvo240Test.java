import junit.framework.TestCase;
import org.junit.Test;

import java.awt.*;

public class  Volvo240Test extends TestCase {

    @Test
    public void testspeed(){

        Volvo240 test = new Volvo240();
        test.startEngine();
        test.gas(0.2);
        test.brake(0.1);
        assertEquals(0.22499999999999998,test.getCurrentSpeed());

    }

    @Test
    public void testdoors(){
        Volvo240 test = new Volvo240();
        assertEquals(4,test.getNrDoors());
    }

    @Test
    public void testmoveypos(){
        Volvo240 test = new Volvo240();
        test.startEngine();
        test.turnleft();
        test.move();
        test.move();
        test.move();
        test.move();
        assertEquals(3, test.getDirection());
    }

    @Test
    public void direction() {

    }

    @Test
    public void testmovexpos(){
        Volvo240 test = new Volvo240();
        test.startEngine();
        test.move();
        test.turnleft();
        test.move();
        test.turnright();
        test.move();
        assertEquals(-0.1,test.getXpos());}

    @Test
    public  void testcolor(){
        Volvo240 testcar = new Volvo240();
        Color expectedcolor = new Color(0,0,0);
        assertEquals(expectedcolor,testcar.getColor());


    }

    @Test
    public void testmodelname(){
        Volvo240 test = new Volvo240();
        assertEquals("src.Volvo240", test.getModelName());

    }

}