package Xliv;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject {

	private Handler handler;
	private GameObject player;
	
	
	public SmartEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		for(int i=0; i < handler.object.size(); i++)
		{
			if(handler.object.get(i).getID() == ID.Player) player = handler.object.get(i);
		}
		
		velX = 5;
		velY = 5;
		
		
	}

	
	public Rectangle getBounds()
	{
		return new Rectangle ((int)x, (int)y, 8, 8);
	}
	
	public void tick()
	{
		x += velX;
		y += velY;
		
		float diffX = x - player.getX() - 8;
		float diffY = y - player.getY() - 8;
		float dist = (float) Math.sqrt(((x-player.getX()) * (x-player.getX())) + ((y-player.getY()) * (y-player.getY())));
		
		velX = (float)(-1.0/dist) * diffX;
		velY = (float)(-1.0/dist) * diffY;
		
		if(y <= 0 || y >= Game.HEIGHT - 50) velY *= -1;
		
		if(x <= 0 || x >= Game.WIDTH - 32) velX *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.yellow, 8, 8, 0.1f, handler));
		
		collision();
	}
	
	
	private void collision()
	{
		for(int i=0; i<handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Ground || tempObject.getID() == ID.P1 || tempObject.getID() == ID.P2
					|| tempObject.getID() == ID.P3 || tempObject.getID() == ID.P4 || tempObject.getID() == ID.P5 
					|| tempObject.getID() == ID.P6 || tempObject.getID() == ID.P7 || tempObject.getID() == ID.P8
					|| tempObject.getID() == ID.P9 || tempObject.getID() == ID.P10 || tempObject.getID() == ID.P11
					|| tempObject.getID() == ID.P12)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					velY *= -1;
				}
			}
		}
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.yellow);
		g.fillRect((int)x, (int)y, 8, 8);
	}
	
}
