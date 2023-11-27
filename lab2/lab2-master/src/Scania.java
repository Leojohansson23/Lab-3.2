import java.awt.*;

public class Scania extends Truck implements Tilting{

    private int angle = 0;
    private  int maxAngle = 70;

    private int minAngle = 0;
    public Scania(){
        super(2,300,Color.pink, "src.Scania");
        stopEngine();
        setCanMove(true);

    }


    public int getangle(){
        return angle;

    }
    public void setangle(int degree){
        angle = degree;

    }
    @Override
    public void carrierHigher() {
        if(getCurrentSpeed() == 0) {
            if ((getangle() + 10) <= maxAngle) {
                setangle(getangle() + 10);
            }
            else {setangle(maxAngle);

            }
        }
    }

    @Override
    public void carrierLower() {
        if(getCurrentSpeed() == 0) {
            if ((getangle() - 10) > minAngle) {
                setangle(getangle() - 10);
            }
            else {setangle(minAngle);
            }

        }
    }

    @Override
    public boolean getCanMove(){
        if (angle > minAngle){
            return false;
        }
        return true;
    }


}