package Xliv;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject
{
	Random r = new Random();
	Handler handler;
	HUD hud;
	
	public float grav = 1;
	
	public Player(int x, int y, ID id, Handler handler, HUD hud) 
	{
		super(x, y, id);
		this.handler = handler;
		this.hud = hud;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle ((int)x, (int)y, 30, 30);
	}

	
	public void tick()
	{
		x += velX;
		velY += grav;
		y += velY;
		
		//player limited to the window
		x = Game.clamp(x, 10, Game.WIDTH-50);
		y = Game.clamp(y, 100, Game.HEIGHT-77);
		
		//handler.addObject(new Trail(x, y, ID.Trail, Color.white, 20, 20, 0.1f, handler));
		
		collision();
	}
	
	private void collision()
	{
		for(int i=0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getID() == ID.BasicEnemy || tempObject.getID() == ID.FastEnemy || tempObject.getID() == ID.SmartEnemy)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					HUD.HEALTH -= 50;
					handler.removeObject(tempObject);
				}
			}
			if(tempObject.getID() == ID.Ground)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					handler.gUp = true;
					handler.keyDown[0] = true;
					//System.out.println(handler.gUp);
				}
				else
				{
					handler.gUp = false;
					//handler.keyDown[0] = false;
					//System.out.println("keyDown = " + handler.keyDown[0]);
					//System.out.println(handler.up);
				}
			}
			if(tempObject.getID() == ID.Door)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					handler.clearAllObjects();
					handler.resetKey();
					//handler.level += 1;
					hud.setLevel(hud.getLevel() + 1);
				}
			}
			
			if(tempObject.getID() == ID.Coin)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					handler.removeObject(tempObject);
					hud.setScore(hud.getScore() + 100);
					System.out.println(hud.getScore());
				}
			}
			
			if(tempObject.getID() == ID.P1)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					//set up a platform
					handler.pUp1 = true;
					handler.keyDown[0] = true;
					velY -= grav;
					velX = tempObject.getVelX() + handler.pVelX;
					y = tempObject.getY()-20;
					
					//System.out.println("y1 = " + handler.getMax());
					//System.out.println(handler.pUp1);
				}
				else
				{
					handler.pUp1 = false;
					//System.out.println("y2 = " + handler.getMax());
					//System.out.println(handler.pUp1);
				}
			}
			else if(tempObject.getID() == ID.P2)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					//set up a platform
					handler.pUp2 = true;
					handler.keyDown[0] = true;
					velY -= grav;
					velX = tempObject.getVelX() + handler.pVelX;
					y = tempObject.getY()-20;
				}
				else
				{
					handler.pUp2 = false;
				}
			}
			else if(tempObject.getID() == ID.P3)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					//set up a platform
					handler.pUp3 = true;
					handler.keyDown[0] = true;
					velY -= grav;
					velX = tempObject.getVelX() + handler.pVelX;
					y = tempObject.getY()-20;
					//System.out.println(handler.pUp3);

				}
				else
				{
					handler.pUp3 = false;
					//System.out.println(handler.pUp3);
				}
			}
			else if(tempObject.getID() == ID.P4)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					//set up a platform
					handler.pUp4 = true;
					handler.keyDown[0] = true;
					velY -= grav;
					velX = tempObject.getVelX() + handler.pVelX;
					y = tempObject.getY()-20;
					
				}
				else
				{
					handler.pUp4 = false;
					
				}
			}
			else if(tempObject.getID() == ID.P5)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					//set up a platform
					handler.pUp5 = true;
					handler.keyDown[0] = true;
					velY -= grav;
					velX = tempObject.getVelX() + handler.pVelX;
					y = tempObject.getY()-20;
					
				}
				else
				{
					handler.pUp5 = false;
					
				}
			}
			else if(tempObject.getID() == ID.P6)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					//set up a platform
					handler.pUp6 = true;
					handler.keyDown[0] = true;
					velY -= grav;
					velX = tempObject.getVelX() + handler.pVelX;
					y = tempObject.getY()-20;
					
				}
				else
				{
					handler.pUp6 = false;
				}
			}
			else if(tempObject.getID() == ID.P7)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					//set up a platform
					handler.pUp7 = true;
					handler.keyDown[0] = true;
					velY -= grav;
					velX = tempObject.getVelX() + handler.pVelX;
					y = tempObject.getY()-20;
				}
				else
				{
					handler.pUp7 = false;
				}
			}
			else if(tempObject.getID() == ID.P8)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					//set up a platform
					handler.pUp8 = true;
					handler.keyDown[0] = true;
					velY -= grav;
					velX = tempObject.getVelX() + handler.pVelX;
					y = tempObject.getY()-20;
				}
				else
				{
					handler.pUp8 = false;
				}
			}
			else if(tempObject.getID() == ID.P9)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					//set up a platform
					handler.pUp9 = true;
					handler.keyDown[0] = true;
					velY -= grav;
					velX = tempObject.getVelX() + handler.pVelX;
					y = tempObject.getY()-20;
				}
				else
				{
					handler.pUp9 = false;
				}
			}
			else if(tempObject.getID() == ID.P10)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					//set up a platform
					handler.pUp10 = true;
					handler.keyDown[0] = true;
					velY -= grav;
					velX = tempObject.getVelX() + handler.pVelX;
					y = tempObject.getY()-20;
				}
				else
				{
					handler.pUp10 = false;
				}
			}
			else if(tempObject.getID() == ID.P11)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					//set up a platform
					handler.pUp11 = true;
					handler.keyDown[0] = true;
					velY -= grav;
					velX = tempObject.getVelX() + handler.pVelX;
					y = tempObject.getY()-20;
				}
				else
				{
					handler.pUp11 = false;
				}
			}
			else if(tempObject.getID() == ID.P12)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					//set up a platform
					handler.pUp12 = true;
					handler.keyDown[0] = true;
					velY -= grav;
					velX = tempObject.getVelX() + handler.pVelX;
					y = tempObject.getY()-20;
				}
				else
				{
					handler.pUp12 = false;
				}
			}
		}
	}
	
	

	
	public void render(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect((int) x, (int) y, 20, 20);
	}
	
	
	
}
