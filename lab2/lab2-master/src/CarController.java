import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    //private T Car;
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    private boolean touchEdge = false;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<Saab95> Saab = new ArrayList<>();
    ArrayList<Scania> Scania = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        //CarController <Saab95> Saab95CarController = new CarController<>();
        //Saab95 mysaab = new Saab95();
        //Saab95CarController.cars.add(mysaab);



        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Scania());
        cc.Saab.add(new Saab95());
        cc.Scania.add(new Scania());

        //Saab95CarController.frame = new CarView("CarSim 1.0",Saab95CarController);
        //Saab95CarController.timer.start();

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                car.move();
                int x = (int) Math.round(car.getXpos());
                int y = (int) Math.round(car.getYpos());
                if (y < 0 || y > 500) {
                    double currspeed = car.getCurrentSpeed();
                    while (car.getCurrentSpeed() > 0) {
                        car.brake(1);
                    }

                    car.setDirection(car.getDirection() + 180);
                    while (car.getCurrentSpeed() < currspeed){
                        car.gas(1);

                    }
                }
                if (x > 700 || x < 0) {
                    double currspeed = car.getCurrentSpeed();
                    while (car.getCurrentSpeed() > 0) {
                        car.brake(1);
                    }

                    car.setDirection(car.getDirection() + 180);
                    while (car.getCurrentSpeed() < currspeed){
                        car.gas(1);
                    }
                }

                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }

        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car: cars) {
            car.brake(brake);

        }
    }

    void turboON(){
        for (Saab95 car: Saab) {
            car.setTurboOn();
        }
    }
    void turboOff(){
        for (Saab95 car: Saab) {
            car.setTurboOff();
        }
    }
    void lowerBed(){
        for (Scania car: Scania) {
            car.carrierLower();
        }
    }


    void higherBed(){
        for(Scania car:Scania){
            car.carrierHigher();
        }


    }

}
