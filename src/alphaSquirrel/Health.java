package alphaSquirrel;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Health {
	private BufferedImage heart;
	public static int width;
	public static int height;
	public int growth = 4;
	public int x;
	public int y;
	public Health(){
		try{
			heart = ImageIO.read(new File("res/heart.png"));
				x = GUI.HEIGHT - ((heart.getHeight()));
				y = GUI.WIDTH - ((heart.getWidth()));
		}catch (Exception e){
			System.out.println(e);
		}
	}
	
	public void paint(Graphics2D g2d)
	{
		g2d.drawImage(heart, getX() + 100, getY(), heart.getWidth(), heart.getHeight(), null);
		g2d.drawImage(heart, getX() + 150, getY(), heart.getWidth(), heart.getHeight(), null);
		g2d.drawImage(heart, getX() + 200, getY(), heart.getWidth(), heart.getHeight(), null);
	}
	
	private int getY() 
	{
		return this.y - 750;
	}
	
	private int getX() 
	{
		return this.x;
	}
}

