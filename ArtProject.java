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

        b.setColor(Color.BLUE);
        b.fillRect(0, 0, 1000, 1000);

        b.setColor(Color.green);
        b.fillRect(0, 800, 1000, 200);

        b.setColor(Color.yellow);
        int[] hx = {200, 200, 400, 600, 600};
        int[] hy = {800, 400, 200, 400, 800};
        b.fillPolygon(hx, hy, 5);

        b.setColor(Color.red);
        b.fillRect(500, 700, 200, 100);
        b.fillRect(550, 300, 100, 400);
        int[] cx = {525, 525, 600, 675, 675};
        int[] cy = {300, 250, 200, 250, 300};
        b.fillPolygon(cx, cy, 5);

        b.setColor(Color.white);
        b.fillOval(400, 50, 300, 100);

        b.setColor(Color.orange);
        b.fillRect(300, 600, 100, 200);

        b.setColor(Color.yellow);
        b.fillOval(310 ,690, 20, 20);

        b.setColor(Color.blue);
        b.fillRect(450, 600, 100, 100);

        b.setColor(Color.white);
        b.drawLine(500, 600, 500, 700);
        b.drawLine(450, 650, 550, 650);


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

