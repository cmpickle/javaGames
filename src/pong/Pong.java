package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Pong extends JPanel {
    
    Ball ball = new Ball(this);
    Raquet raquet = new Raquet(this);
    public double speed = 1;
    public int score = 0;
    public static boolean cheat = false;

    private int getScore()
    {
	return score;
    }
    
    public Pong()
    {
	KeyListener listener = new MyKeyListener();
	addKeyListener(listener);
	setFocusable(true);
    }
    
    @Override
    public void paint(Graphics g)
    {
	super.paint(g);
	g.fillRect(0, 0, 300, 400);
	Graphics2D g2d = (Graphics2D) g;
	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	ball.Paint(g2d);
	raquet.Paint(g2d);
	
	g2d.setColor(Color.GRAY);
	g2d.setFont(new Font("Verdana", Font.BOLD, 30));
	g2d.drawString(String.valueOf(getScore()), 10, 30);
    }

    public void gameOver()
    {
	JOptionPane.showMessageDialog(this, "Your score is " + getScore(), "Game Over", JOptionPane.YES_NO_OPTION);
	System.exit(ABORT);
    }
    
    public static void main(String[] Args) throws InterruptedException
    {
	JFrame frame = new JFrame("Pong");
	Pong game = new Pong();
	frame.add(game);
	frame.setSize(300, 400);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	while(true)
	{
	    game.ball.move();
	    if(cheat)
		game.raquet.moveCheat();
	    else
		game.raquet.move();
	    game.repaint();
	    Thread.sleep(10);
	    
	}
    }
    
    public class MyKeyListener implements KeyListener {
	@Override
	public void keyTyped(KeyEvent e)
	{
	    
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
	    raquet.keyPressed(e);
//	    System.out.println("KeyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
	}
	
	@Override 
	public void keyReleased(KeyEvent e)
	{
	    raquet.keyReleased(e);
//	    System.out.println("KeyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
	}
    }
}
