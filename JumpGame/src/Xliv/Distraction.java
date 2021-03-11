package Xliv;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Distraction extends GameObject 
{
	
	public Distraction(float x, float y, ID id, float xVel, float yVel)
	{
		super(x, y, id);
				
		velX = xVel;
		velY = yVel;
	}

	
	public Rectangle getBounds()
	{
		return new Rectangle ((int)x, (int)y, 1000, 20);
	}
	
	public void tick()
	{
		x += velX;
		y += velY;
		
		if(y <= 150 || y >= Game.HEIGHT - 50) velY *= -1;
		
		if(x <= 0 || x >= Game.WIDTH - 32) velX *= -1;
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 1000, 20);
	}
	
}
	
