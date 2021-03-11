package Xliv;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Coin extends GameObject {
	
	
	
	public Coin(float x, float y, ID id)
	{
		super(x, y, id);
				
		velX = 0;
		velY = 0;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle ((int)x, (int)y, 16, 16);
	}
	
	public void tick()
	{
		
	}

	public void render(Graphics g)
	{
		g.setColor(Color.yellow);
		g.fillRect((int)x, (int)y, 4, 4);
		g.fillRect((int)x+2, (int)y, 4, 4);
		g.fillRect((int)x-2, (int)y, 4, 4);
		g.fillRect((int)x, (int)y+2, 4, 4);
		g.fillRect((int)x, (int)y-2, 4, 4);
	}
	
}
