import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Displays the amount of mouse clicks in the center of a JPanel
 * 
 * @author Patrick Liszewski
 * @author Nicholas Barragato
 * @version 2/26/2025
 */
public class MousePressCounter extends MouseAdapter implements Runnable, ActionListener{
	
    private int clicks = 0;
    private JPanel panel;
    
    /**
	 * The run method to set up the graphical user interface
	 */
	@Override
	public void run() {
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("MouseDemo");
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// construct an anonymous class that extends JPanel,
		// for which we override the paintComponent method
		panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {

				super.paintComponent(g);

				FontMetrics fm = g.getFontMetrics();

                String toDisplay = "Mouse press count: " + clicks;
				int stringWidth = fm.stringWidth(toDisplay);
				int stringAscent = fm.getAscent();

				int xStart = getWidth() / 2 - stringWidth / 2;
				int yStart = getHeight() / 2 + stringAscent / 2;

				g.drawString(toDisplay, xStart, yStart);
            } 

		};
		frame.add(panel);
		panel.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){
                clicks++;
                panel.repaint();
            }


        });

        // creates reset button to set amount of clicks back to 0
        JButton resetButton = new JButton("Reset");
        resetButton.setForeground(Color.RED);
        resetButton.addActionListener(this);
        
       
            
        

		panel.addMouseMotionListener(this);
		panel.addMouseWheelListener(this);
        panel.add(resetButton);

		// display the window we've created
		frame.pack();
		frame.setVisible(true);
	}

    // method for reset button to set clicks back to 0
    @Override
    public void actionPerformed(ActionEvent e) {
        clicks = 0;
        panel.repaint();
    }
 
    // method to increase number of clicks upon mouse click
	@Override
	public void mouseClicked(MouseEvent e) {
        clicks++;
	}

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new MousePressCounter());
    }
}
