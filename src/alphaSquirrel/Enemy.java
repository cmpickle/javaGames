package alphaSquirrel;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;

public class Enemy {
	private BufferedImage squirrel;
	public static int width;
	public static int height;
	public int growth = 4;
	public int spawnX;
	public int spawnY;
	Random rand = new Random();
	public int[] spawnArea = {rand.nextInt(1000), rand.nextInt(1000), rand.nextInt(1000), rand.nextInt(1000), rand.nextInt(1000)};
	
	public Enemy()
	{
		try {
			squirrel = ImageIO.read(new File("res/squirrel.png"));
			spawnX = GUI.WIDTH - ((squirrel.getWidth()/growth)/2);;
			spawnY = GUI.HEIGHT - ((squirrel.getWidth()/growth)/2);;
		} catch (Exception e) {		
			System.out.println(e);
		}
		
	}
	
	public void paint(Graphics2D g2d)
	{
			g2d.drawImage(squirrel, getY(), getX(), squirrel.getWidth()/growth, squirrel.getHeight()/growth, null);
	}
	
	public int getY()
	{
		return this.spawnY - spawnArea[2]; // we need spawnX and Y for us to reach the squirrel enemy, or else we wont be able to find him until he has a move path...
		
	}
	
	public int getX()
	{
		return this.spawnX - spawnArea[1];
		
	}
	
	public void move()
	{
		spawnX += Background.dy;
		spawnY += Background.dx;
	}
	public Rectangle getBounds()
	{
		return new Rectangle(spawnX, spawnY, width, height);
		
	}
}
