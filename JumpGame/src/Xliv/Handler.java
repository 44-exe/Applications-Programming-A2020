package Xliv;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler 
{
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public boolean gUp = false;
	public boolean pUp1 = false;
	public boolean pUp2 = false;
	public boolean pUp3 = false;
	public boolean pUp4 = false;
	public boolean pUp5 = false;
	public boolean pUp6 = false;
	public boolean pUp7 = false;
	public boolean pUp8 = false;
	public boolean pUp9 = false;
	public boolean pUp10 = false;
	public boolean pUp11 = false;
	public boolean pUp12 = false;
	
	public boolean[] keyDown = new boolean[4];
	
	public float pVelX = 0;
	
	private HUD hud = new HUD();
		
	//int level = hud.getLevel();
	
	public void tick()
	{
		for(int i=0; i<object.size(); i++)
		{
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
	}
	
	public void render(Graphics g)
	{
		int i;
		
		for(i=0; i<object.size(); i++)
		{
			GameObject tempObject = object.get(i);
			tempObject.render(g);
		}
	}
	
	public void clearEnemy()
	{
		for(int i=0; i<object.size(); i++)
		{
			GameObject tempObject = object.get(i);
			
			if(tempObject.getID() != ID.Player)
			{
				//removeObject(tempObject);
			}
		}
	}
	
	public void clearAllObjects()
	{
		object.clear();
	}
	
	public void addObject(GameObject object)
	{
		this.object.add(object);
	}
	
	public void removeObject(GameObject object)
	{
		this.object.remove(object);
	}
	
	
	
	public float getMax()
	{
		for(int i=0; i<object.size(); i++)
		{
			GameObject tempObject = object.get(i);
			
			if(tempObject.getID() == ID.P1 || tempObject.getID() == ID.P2 || tempObject.getID() == ID.P3
				|| tempObject.getID() == ID.P4 || tempObject.getID() == ID.P5 || tempObject.getID() == ID.P6
				|| tempObject.getID() == ID.P7 || tempObject.getID() == ID.P8 || tempObject.getID() == ID.P9
				|| tempObject.getID() == ID.P10 || tempObject.getID() == ID.P11 || tempObject.getID() == ID.P12)
			{
				return tempObject.getY() - 20;
			}
		}
		return Game.HEIGHT-77;
	}
	
	public void resetKey()
	{
		gUp = false;
		pUp1 = false;
		pUp2 = false;
		pUp3 = false;
		pUp4 = false;
		pUp5 = false;
		pUp6 = false;
		pUp7 = false;
		pUp8 = false;
		pUp9 = false;
		pUp10 = false;
		pUp11 = false;
		pUp12 = false;
	}
	
	
}
