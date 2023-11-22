import java.util.ArrayList;


public class Workshop<T extends Car> {

    private ArrayList<Car> listAllCars = new ArrayList<>();

    public void addcar(T wagon){
        if(listAllCars.size() <=8){
            listAllCars.add(wagon);
        }

    }
    public void returnCars(T wagon){
        if(listAllCars.contains(wagon)){
            listAllCars.remove(wagon);
        }
    }

    public int listOfCars(){
        return listAllCars.size();
    }
}
