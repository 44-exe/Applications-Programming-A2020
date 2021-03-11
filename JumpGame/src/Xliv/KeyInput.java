package Xliv;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	
	
	
	public KeyInput(Handler handler)
	{
		this.handler = handler;
		
		handler.keyDown[0] = false; //UP
		//keyDown[1] = false; //DOWN
		handler.keyDown[2] = false; //LEFT
		handler.keyDown[3] = false; //RIGHT
	}
	
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		for(int i = 0; i< handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Player)
			{
				//key events for player 1
				if(key == KeyEvent.VK_UP && handler.keyDown[0] == true && (handler.gUp == true 
						|| handler.pUp1 == true || handler.pUp2 == true || handler.pUp3 == true 
						|| handler.pUp4 == true || handler.pUp5 == true || handler.pUp6 == true	
						|| handler.pUp7 == true || handler.pUp8 == true || handler.pUp9 == true 
						|| handler.pUp10 == true || handler.pUp11 == true || handler.pUp12 == true))
				{
					tempObject.setVelY(-15);
					System.out.println("key up = " + handler.keyDown[0]);
					System.out.println("gUP = " + handler.gUp);
					System.out.println("pUP1 = " + handler.pUp1);
				}
				/*if(key == KeyEvent.VK_DOWN) 
				{ 
					tempObject.setVelY(5); 
					keyDown[1] = true; 
				}*/
				if(key == KeyEvent.VK_LEFT) 
				{ 
					tempObject.setVelX(-5);
					handler.keyDown[2] = true;
					handler.pVelX = -5;
					
				}
				if(key == KeyEvent.VK_RIGHT) 
				{ 
					tempObject.setVelX(5); 
					handler.keyDown[3] = true;
					handler.pVelX = 5;
				}
			}
		}
		
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
		
	}
	
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		for(int i = 0; i< handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Player)
			{
				//key events for player 1
				
				if(key == KeyEvent.VK_UP) handler.keyDown[0] = false;//tempObject.setVelY(0);
				//if(key == KeyEvent.VK_DOWN) keyDown[1] = false;// tempObject.setVelY(0);
				if(key == KeyEvent.VK_LEFT)
				{
					handler.keyDown[2] = false;//tempObject.setVelX(0);
					handler.pVelX = 0;
				}
				if(key == KeyEvent.VK_RIGHT) 
				{
					handler.keyDown[3] = false; //tempObject.setVelX(0);
					handler.pVelX = 0;
				}
				
				if(!handler.keyDown[0] && !handler.keyDown[1]) tempObject.setVelY(0);
				if(!handler.keyDown[2] && !handler.keyDown[3]) tempObject.setVelX(0);


			}
		}
	}
	
}
