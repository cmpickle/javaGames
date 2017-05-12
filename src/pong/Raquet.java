package pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Raquet {
    private static final int Y = 330;
    private static final int WIDTH = 60;
    private static final int HEIGHT = 10;
    int x = 0;
    int xa = 0;
    private Pong game;
    
    public Raquet(Pong game)
    {
	this.game=game;
    }
    
    public void move()
    {
	if(x + xa > 0 && x + xa < game.getWidth() - 60)
	    x+=xa;
    }
    
    public void moveCheat()
    {
	x = Ball.getX();
    }
    
    public void Paint(Graphics2D g)
    {
	g.setColor(Color.BLUE);
	g.fillRect(x, 330, 60, 10);
    }
    
    public void keyReleased(KeyEvent e)
    {
	xa=0;
    }
    
    public void keyPressed(KeyEvent e)
    {
	if(e.getKeyCode() == KeyEvent.VK_LEFT)
	    xa=-5;
	if(e.getKeyCode() == KeyEvent.VK_RIGHT)
	    xa=5;
	if(e.getKeyCode() == KeyEvent.VK_P)
	{
	    Pong.cheat = !Pong.cheat;
	}
    }
    
    public Rectangle getBounds()
    {
	return new Rectangle(x, Y, WIDTH, HEIGHT);
    }
    
    public int getTopY()
    {
	return Y - HEIGHT;
    }
}
