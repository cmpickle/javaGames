package alphaSquirrel;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Background {
	private BufferedImage bg;
	public int x;
	public int y;
	public static int dx = 0;
	public static int dy = 0;
	public int moveSpeed = 1;

	public Background()
	{
		this(0, 0);
	}

	public Background(int x, int y)
	{
		this.x = x;
		this.y = y;

		try
		{
			bg = ImageIO.read(new File("res/AlphaBackground.jpg"));
			
		} catch (Exception e){
			System.out.println(e);
		}
	}
	
	public void paint(Graphics2D g2d)
	{
		g2d.drawImage(bg, getX(), getY(), bg.getWidth(), bg.getHeight(), null);
	}
	
	public void move()
	{
		x += dx;
		y += dy;
		
		// Check to see if the image has gone off stage x axis
	        if (this.x <= -1 * bg.getWidth())
	            this.x = this.x + bg.getWidth() * 2;
	        if (this.x >= (bg.getWidth()))
	        	this.x = -1 * bg.getWidth();
	        
	        // Check to see if the image has gone off stage y axis
	        if (this.y <= -1 * bg.getHeight())
	            this.y = this.y + bg.getHeight() * 2;
	        if (this.y >= (bg.getHeight()))
	        	this.y = -1 * bg.getHeight();
	}
	
	public int getImageWidth()
	{
		return bg.getWidth();
	}	
	
	public int getImageHeight()
	{
		return bg.getHeight();
	}
	
	public int getX()
	{
		return this.x;
	}	
	
	public int getY()
	{
		return this.y;
	}
	
	public void KeyPressed(KeyEvent e) 
	{
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		        dx = -moveSpeed;
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			dx = moveSpeed;
		if(e.getKeyCode() == KeyEvent.VK_UP)
			dy = moveSpeed;
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
			dy = -moveSpeed;
	}
	
	public void KeyReleased(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT)
		        dx = 0;
		if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN)
			dy = 0;
	}
}
