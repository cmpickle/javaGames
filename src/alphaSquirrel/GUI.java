package alphaSquirrel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Alpha Squirrel
 * 
 * A game where you control a small squirrel that eats other squirrels that are smaller than it. If you eat smaller squirrels
 * you will grow larger in size. If you run into a squirrel that is larger than you are you will lose a life.
 * 
 * There will possibly be upgrades too.
 * @author Cameron Pickle and Nathan Pickle
 *
 * It's gonna be so fun!!
 */
public class GUI extends JPanel {
	private static final long serialVersionUID = -4256701721248003251L;
	public static final int HEIGHT = 600;
	public static final int WIDTH = 800;
	Enemy enemy = new Enemy();
	Health health = new Health();
	Health health1 = new Health();
	Health health2 = new Health();
	Character character = new Character();
	Background bg1 = new Background();
	Background bg2 = new Background(bg1.getImageWidth(), 0);
	Background bg3 = new Background(0, bg1.getImageHeight());
	Background bg4 = new Background(bg1.getImageWidth(), bg1.getImageHeight());
	
	public GUI() {
		KeyListener listener = new MyKeyListener();
		addKeyListener(listener);
		setFocusable(true);
	}

	public static void main(String[] args) throws InterruptedException
	{
		JFrame frame = new JFrame("Alpha Squirrel");
		GUI gui = new GUI();
		frame.add(gui);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		while(true)
		{
			gui.bg1.move();
			gui.bg2.move();
			gui.bg3.move();
			gui.bg4.move();
			gui.enemy.move();
			gui.repaint();
			Thread.sleep(10);
		}
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		bg1.paint(g2d);
		bg2.paint(g2d);
		bg3.paint(g2d);
		bg4.paint(g2d);
		character.paint(g2d);
		enemy.paint(g2d);
		health.paint(g2d);
	}
	
	public class MyKeyListener implements KeyListener
	{
		@Override
		public void keyPressed(KeyEvent e)
		{
			if(e.getKeyCode() == KeyEvent.VK_UP)
				Character.up = true;
			if(e.getKeyCode() == KeyEvent.VK_DOWN)
				Character.up = false;
			if(e.getKeyCode() == KeyEvent.VK_LEFT)
				Character.right = false;
			if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				Character.right = true;
			bg1.KeyPressed(e);
			bg2.KeyPressed(e);
			bg3.KeyPressed(e);
			bg4.KeyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e)
		{
			bg1.KeyReleased(e);
			bg2.KeyReleased(e);
			bg3.KeyReleased(e);
			bg4.KeyReleased(e);			
		}

		@Override
		public void keyTyped(KeyEvent e)
		{
			// nothing...
			
		}
	}
}
