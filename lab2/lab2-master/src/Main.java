

public class  Main {

        public static void main(String[] args) {

                Saab95 saab1 = new Saab95();
                Saab95 saab2 = new Saab95();
                Volvo240 volvo1 = new Volvo240();
                Volvo240 volvo2 = new Volvo240();
                Cartransport cartransport1 = new Cartransport();
                Scania scania1 = new Scania();
                Cartransport cartt1 = new Cartransport();
                Saab95 saab55 = new Saab95();


                Workshop<Saab95> saab95Workshop = new Workshop<>();
                saab95Workshop.addcar(saab1);

                cartransport1.carrierLower();
                cartt1.carrierLower();
                cartransport1.addcar(saab1);
                cartransport1.addcar(saab2);
                cartransport1.addcar(saab1);
                cartt1.addcar(saab1);

                System.out.println(cartransport1.getRamparraylist());
                System.out.println(cartt1.getRamparraylist());

















        }
}