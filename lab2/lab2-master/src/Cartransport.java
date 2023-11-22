import java.awt.*;
import java.util.ArrayList;

public class Cartransport extends Truck implements Tilting{


     private ArrayList<Car> ramparraylist = new ArrayList<>();

    public ArrayList<Car> getRamparraylist() {
        return ramparraylist;
    }
    private boolean carrierPos;


    public Cartransport(){
        super(2,250,Color.gray, "src.Cartransport");
        stopEngine();
        setCanMove(true);


    }
    @Override
    public boolean getCanMove() {
        if (carrierPos){
            return false;
        }
        return true;
    }


    public void addcar(Car smallcar) {
        if (smallcar.isOnTruck() == false) {
            if (Math.abs(smallcar.getXpos() - this.getXpos()) <= 0.5 && Math.abs(smallcar.getYpos() - this.getYpos()) <= 0.5)
                if (carrierPos && ramparraylist.size() <= 8) {
                    smallcar.setXpos(this.getXpos());
                    smallcar.setYpos(this.getYpos());
                    if (smallcar instanceof Truck) {

                    } else {
                        ramparraylist.add(smallcar);
                        smallcar.setOnTruck(true);
                    }
                }
        }
    }

    public int getcarsoncarrier (){
        return ramparraylist.size();
    }

    public void removecar(){
        if (carrierPos){
            ramparraylist.get(ramparraylist.size() - 1).setXpos(this.getXpos() + 0.2);
            ramparraylist.get(ramparraylist.size() - 1).setYpos(this.getYpos() + 0.2);

            ramparraylist.get(ramparraylist.size()-1).setOnTruck(false);
            ramparraylist.remove(ramparraylist.size() - 1);
        }



    }


    @Override
    public void carrierHigher() {
        carrierPos = false;
    }

    @Override
    public void carrierLower() {
        carrierPos = true;
    }


    @Override
    public void move() {

        super.move();
        for(Moveable car : ramparraylist){
                car.move();
        }
    }
}





