import java.awt.*;
import javax.swing.*;

/**
 * Lab 6 
 * 
 * @author Nicholas Barragato
 * @author Patrick Liszewski
 * @version 2/26/25
 */
class graphic extends JPanel{
    
    @Override
    public void paintComponent(Graphics b){

        super.paintComponent(b);

        FontMetrics fM = b.getFontMetrics();

        b.drawLine(100, 100, 900, 900);
        b.drawOval(100, 100, 100, 200);
        int[] a = {100, 200, 300, 200, 500, 900};
        int[] a2 = {100, 400, 25, 900, 100, 350};
        b.drawPolygon(a, a2, 6);
        b.drawOval(200, 100, 100, 200);
        b.drawRect(165, 250, 60, 300);


    }



}
public class ArtProject implements Runnable {

    /**
     * The run method to set up the graphical user interface
     */
    @Override
    public void run() {

        // the usual JFrame setup steps
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame1 = new JFrame("graphic");
        frame1.setPreferredSize(new Dimension(1000, 1000));
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // construct JPanel with a custom paintComponent method
        JPanel panel1 = new graphic();
        frame1.add(panel1);

        // display the window we've created
        frame1.pack();
        frame1.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new ArtProject());
    }
}

