package Xliv;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ground extends GameObject 
{
	
	public Ground(float x, float y, ID id)
	{
		super(x, y, id);
				
		velX = 0;
		velY = 0;
	}

	
	public Rectangle getBounds()
	{
		return new Rectangle ((int)x, (int)y, 1000, 20);
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.cyan);
		g.fillRect((int)x, (int)y, 1000, 20);
	}
	
}
	
