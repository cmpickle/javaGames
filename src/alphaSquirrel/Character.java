package alphaSquirrel;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Character {
	private BufferedImage squirrel;
	private BufferedImage squirrelLeft;
	private BufferedImage squirrelUp;
	private BufferedImage squirrelLeftUp;
	public static int width;
	public static int height;
	public int growth = 4;
	public int x;
	public int y;
	public static boolean right = true;
	public static boolean up = false;
	
	public Character()
	{
		try{
			squirrel = ImageIO.read(new File("res/squirrel.png"));
			squirrelLeft = ImageIO.read(new File("res/squirrelLeft.png"));
			squirrelUp = ImageIO.read(new File("res/squirrelUp.png"));
			squirrelLeftUp = ImageIO.read(new File("res/squirrelLeftUp.png"));
			x = GUI.WIDTH/2-((squirrel.getWidth()/growth)/2);
			y = GUI.HEIGHT/2-((squirrel.getWidth()/growth)/2);
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void paint(Graphics2D g2d)
	{
		if(right && !up)
			g2d.drawImage(squirrel, getX(), getY(), squirrel.getWidth()/growth, squirrel.getHeight()/growth, null);
		else if(!right && !up)
			g2d.drawImage(squirrelLeft, getX(), getY(), squirrel.getWidth()/growth, squirrel.getHeight()/growth, null);
		else if(right && up)
			g2d.drawImage(squirrelUp, getX(), getY(), squirrel.getWidth()/growth, squirrel.getHeight()/growth, null);
		else
			g2d.drawImage(squirrelLeftUp, getX(), getY(), squirrel.getWidth()/growth, squirrel.getHeight()/growth, null);
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, width, height);
	}
	
	public boolean overlap()
	{
		 return x < getBounds().x + getBounds().width && x + width > getBounds().x && y < getBounds().y + getBounds().height && y + height > getBounds().y;
	}
}
