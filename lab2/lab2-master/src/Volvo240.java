import java.awt.*;

public class Volvo240 extends Car{

    public Volvo240(){
        super(4,125, Color.black, "src.Volvo240");
        stopEngine();
        setTrimFactor(1.25);
        setCanMove(true);
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * getTrimFactor();
    }

}
