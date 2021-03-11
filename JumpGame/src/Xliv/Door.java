package Xliv;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Door extends GameObject 
{
	//constructor
	public Door(float x, float y, ID id)
	{
		super(x, y, id);
		
		velX = 0;
		velY = 0;
	}

	
	public Rectangle getBounds()
	{
		return new Rectangle ((int) x, (int) y, 10, 40);
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.green);
		g.fillRect((int) x, (int) y, 10, 40);
	}
	
}
	
