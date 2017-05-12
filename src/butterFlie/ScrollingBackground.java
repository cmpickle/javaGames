package butterFlie;

import java.awt.Canvas;
import java.awt.Color;
//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
 
public class ScrollingBackground extends Canvas implements Runnable {
 
	private static final long serialVersionUID = 2399031745905586968L;
// Two copies of the background image to scroll
    private Background backOne;
    private Background backTwo;
 
    private BufferedImage back;
 
    public ScrollingBackground() {
        backOne = new Background();
        backTwo = new Background(backOne.getImageWidth(), 0);
 
        new Thread(this).start();
        setVisible(true);
    }
 
    @Override
    public void run() {
        try {
            while (true) {
                Thread.currentThread();
		Thread.sleep(50);
                repaint();
            }
        }
        catch (Exception e) {}
    }
 
    @Override
    public void update(Graphics window) {
        paint(window);
    }
 
    public void paint(Graphics window) {
        Graphics2D twoD = (Graphics2D)window;
 
        twoD.setColor(Color.BLACK);
        twoD.fillOval(400, 300, 20, 20);
 
        if (back == null)
            back = (BufferedImage)(createImage(getWidth(), getHeight()));
 
        // Create a buffer to draw to
        Graphics buffer = back.createGraphics();
 
        // Put the two copies of the background image onto the buffer
        backOne.draw(buffer);
        backTwo.draw(buffer);
 
        // Draw the image onto the window
        twoD.drawImage(back, null, 0, 0);
    }
 
}
