package Xliv;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Platform extends GameObject 
{
	Handler handler;
	
	public Platform(float x, float y, ID id, float xVel)
	{
		super(x, y, id);
				
		velX = xVel;
		velY = 0;
	}

	
	public Rectangle getBounds()
	{
		return new Rectangle ((int) x, (int) y, 100, 20);
	}
	
	public void tick()
	{
		x += velX;
		
		if(x <= 0 || x >= Game.WIDTH - 128) velX *= -1;
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.cyan);
		g.fillRect((int) x, (int) y, 100, 20);
	}
	
}
	
