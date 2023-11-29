
import javax.swing.*;
import java.awt.*;

public class Saab95 extends Car{

    public Saab95(){
        super(2, 100, Color.red, "src.Saab95");
        turboOn = false;
        stopEngine();
        setCanMove(true);

    }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    @Override
    public double speedFactor() {

        if (turboOn) {
            return getEnginePower() * 0.01 * 1.3;
        }
        return getEnginePower() * 0.01;
    }
}

