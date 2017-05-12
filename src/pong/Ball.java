package pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {

    private static final int DIAMETER = 30;
    static int x = 0;
    int y = 0;
    double xa = 1;
    double ya = 1;
    private Pong game;
    
    public Ball(Pong game)
    {
	this.game = game;
    }
    
    public void move()
    {
	if(x + xa < 0)
	    xa = game.speed;
	else if(x + xa > game.getWidth() - DIAMETER)
	    xa = -game.speed;
	else if(y + ya < 0)
	    ya = game.speed;
	else if(y + ya > game.getHeight() - DIAMETER)
	    game.gameOver();
	else if(collision())
	{
	    ya=-game.speed;
	    y=game.raquet.getTopY() - DIAMETER;
	    game.score+=1;
	    game.speed+=0.2;
	}
	x+=xa;
	y+=ya;
    }
    
    private boolean collision()
    {
	return game.raquet.getBounds().intersects(getBounds());
    }
    
    public void Paint(Graphics2D g)
    {
	g.setColor(Color.CYAN);
	g.fillOval(x, y, 30, 30);
    }
    
    public Rectangle getBounds()
    {
	return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
    
    public static int getX()
    {
	return x;
    }
}
