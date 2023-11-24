import javax.imageio.ImageIO;
import javax.lang.model.element.Element;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    ArrayList<Image> Images = new ArrayList();

    //BufferedImage Image;
    // To keep track of a singel cars position
    Point Point = new Point();




    // TODO: Make this genereal for all cars
    void moveit(int x, int y){
        Point.x = x;
        Point.y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            Images.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            Images.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
            Images.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int yExtend = 0;
        for(int i = 0; i < Images.size(); i++) {
            g.drawImage(Images.get(i), Point.x, Point.y + yExtend, null); // see javadoc for more info on the parameters
            yExtend += 100;
        }
    }
}
