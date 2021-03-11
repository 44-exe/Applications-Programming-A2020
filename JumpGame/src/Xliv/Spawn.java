package Xliv;

import Xliv.Game.STATE;

public class Spawn 
{

	private Handler handler;
	
	private HUD hud;
	
	private Game game;
	
	public int levKeep = 0;
	
	public int doorCount = 0;
	
	
	public Spawn(Handler handler, HUD hud, Game game)
	{
		this.handler = handler;
		this.hud = hud;
		this.game = game;
	}
	
	
	public void tick()
	{
		//handler.clearAllObjects();
		
		if(hud.getLevel() == 0 && levKeep == 0)
		{
			//LEVEL 0: 5 coins
			levKeep++;
			handler.addObject(new Ground(0, 775, ID.Ground));
			handler.addObject(new Player(10, 740, ID.Player, handler, hud));
			
			handler.addObject(new Coin(250, 555, ID.Coin));
			handler.addObject(new Platform(200, 575, ID.P1, 2));
			
			handler.addObject(new Coin(450, 655, ID.Coin));
			handler.addObject(new Platform(400, 675, ID.P2, 3));
			
			handler.addObject(new Coin(650, 555, ID.Coin));
			
			handler.addObject(new Coin(400, 460, ID.Coin));
			handler.addObject(new Coin(500, 460, ID.Coin));
			handler.addObject(new Platform(400, 475, ID.P3, 0));			
		}
		
		if((doorCount == 0) && (hud.getScore() == 500))
		{
			
			doorCount++;
			handler.addObject(new Door(446, 435, ID.Door));
		}
		
		if(hud.getLevel() == 1 && levKeep == 1)
		{
			//LEVEL 1: 8 coins
			levKeep++;
			
			handler.addObject(new Coin(900, 750, ID.Coin));
			handler.addObject(new Coin(200, 750, ID.Coin));
			handler.addObject(new Coin(550, 750, ID.Coin));

			handler.addObject(new Ground(0, 775, ID.Ground));
			
			handler.addObject(new Player(80, 430, ID.Player, handler, hud));
			
			handler.addObject(new Platform(50, 460, ID.P1, 0));
			
			handler.addObject(new Coin(250, 660, ID.Coin));
			handler.addObject(new Platform(200, 675, ID.P2, 0));
			handler.addObject(new Platform(700, 675, ID.P3, 0));
			
			handler.addObject(new Coin(900, 545, ID.Coin));
			handler.addObject(new Platform(850, 560, ID.P4, 0));
			
			handler.addObject(new Coin(900, 435, ID.Coin));
			handler.addObject(new Platform(850, 450, ID.P5, 0));
			
			handler.addObject(new Coin(900, 325, ID.Coin));
			handler.addObject(new Platform(850, 340, ID.P6, 0));
			
			handler.addObject(new Coin(670, 325, ID.Coin));
			handler.addObject(new Platform(620, 340, ID.P7, 0));
			
			handler.addObject(new Platform(620, 220, ID.P8, 0));
			
			handler.addObject(new BasicEnemy(950, 755, ID.BasicEnemy, handler, -5));
			handler.addObject(new BasicEnemy(10, 755, ID.BasicEnemy, handler, 5));
		}
		
		if((doorCount == 1) && (hud.getScore() == 1300))
		{
			doorCount++;
			handler.addObject(new Door(665, 180, ID.Door));
		}
		
		if(hud.getLevel() == 2 && levKeep == 2)
		{
			//LEVEL 2: 4 coins
			//System.out.println("level 2");
			levKeep++;
			
			handler.addObject(new Platform(620, 220, ID.P1, 0));
			handler.addObject(new Ground(0, 775, ID.Ground));
			
			handler.addObject(new Player(650, 190, ID.Player, handler, hud));
			
			//second floor
			handler.addObject(new Coin(240, 415, ID.Coin));
			handler.addObject(new Platform(190, 430, ID.P2, 0));
			handler.addObject(new Platform(410, 430, ID.P3, 0));
			handler.addObject(new Coin(680, 415, ID.Coin));
			handler.addObject(new Platform(630, 430, ID.P4, 0));
			
			handler.addObject(new Platform(410, 550, ID.P9, 0));
			
			//first floor
			handler.addObject(new Coin(150, 660, ID.Coin));
			handler.addObject(new Platform(100, 675, ID.P5, 0));
			handler.addObject(new Platform(320, 675, ID.P6, 0));
			handler.addObject(new Platform(540, 675, ID.P7, 0));
			handler.addObject(new Coin(810, 660, ID.Coin));
			handler.addObject(new Platform(760, 675, ID.P8, 0));
			
			handler.addObject(new BasicEnemy(450, 405, ID.BasicEnemy, handler, 5));
			
			handler.addObject(new BasicEnemy(450, 605, ID.BasicEnemy, handler, -5));
			
			handler.addObject(new BasicEnemy(950, 755, ID.BasicEnemy, handler, -5));
			handler.addObject(new BasicEnemy(10, 755, ID.BasicEnemy, handler, 5));
			handler.addObject(new BasicEnemy(200, 755, ID.BasicEnemy, handler, -5));
			handler.addObject(new BasicEnemy(700, 755, ID.BasicEnemy, handler, 5));
			handler.addObject(new BasicEnemy(450, 755, ID.BasicEnemy, handler, -5));
		}
		
		if((doorCount == 2) && (hud.getScore() == 1700))
		{
			doorCount++;
			handler.addObject(new Door(925, 580, ID.Door));
		}
		
		if(hud.getLevel() == 3 && levKeep == 3)
		{
			//LEVEL 3: 2 coins
			levKeep++;
			handler.addObject(new Platform(450, 300, ID.P3, 0));
			handler.addObject(new Distraction(0, 350, ID.Distraction, 0, 0));
			handler.addObject(new Distraction(0, 450, ID.Distraction, 0, 0));
			handler.addObject(new Distraction(0, 755, ID.Distraction, 0, 0));
			
			handler.addObject(new Distraction(0, 655, ID.Distraction, 0, 0));
			
			handler.addObject(new Coin(150, 640, ID.Coin));
			handler.addObject(new Platform(100, 675, ID.P4, 0));
			handler.addObject(new Platform(400, 675, ID.P5, 0));
			handler.addObject(new Platform(500, 675, ID.P6, 0));
			
			handler.addObject(new Coin(900, 640, ID.Coin));
			handler.addObject(new Platform(850, 675, ID.P7, 0));
			
			handler.addObject(new Distraction(0, 550, ID.Distraction, 0, 0));
			
			
			handler.addObject(new Player(490, 260, ID.Player, handler, hud));
			handler.addObject(new BasicEnemy(50, 757, ID.BasicEnemy, handler, -5));
			handler.addObject(new BasicEnemy(950, 757, ID.BasicEnemy, handler, 5));
			
			handler.addObject(new Ground(0, 775, ID.Ground));
		}
		
		if((doorCount == 3) && (hud.getScore() == 1900))
		{
			doorCount++;
			handler.addObject(new Door(500, 740, ID.Door));
		}
		
		if(hud.getLevel() == 4 && levKeep == 4)
		{
			//LEVEL 4: 6 coins
			levKeep++;
			handler.addObject(new Distraction(0, 650, ID.Distraction, 0, 3));
			handler.addObject(new Distraction(0, 250, ID.Distraction, 0, -3));
			
			handler.addObject(new Ground(0, 775, ID.Ground));
			
			handler.addObject(new Player(465, 750, ID.Player, handler, hud));
			
			
			handler.addObject(new BasicEnemy(260, 200, ID.BasicEnemy, handler, 0));
			handler.addObject(new BasicEnemy(660, 200, ID.BasicEnemy, handler, 0));
			
			handler.addObject(new Coin(470, 205, ID.Coin));
			handler.addObject(new BasicEnemy(260, 300, ID.BasicEnemy, handler, 5));
			handler.addObject(new BasicEnemy(660, 300, ID.BasicEnemy, handler, -5));
			handler.addObject(new Platform(420, 220, ID.P1, -3));
			
			handler.addObject(new Coin(470, 305, ID.Coin));
			handler.addObject(new BasicEnemy(460, 400, ID.BasicEnemy, handler, 5));
			handler.addObject(new Platform(420, 320, ID.P2, 6));
			
			handler.addObject(new Coin(470, 405, ID.Coin));
			handler.addObject(new BasicEnemy(460, 500, ID.BasicEnemy, handler, -5));
			handler.addObject(new Platform(420, 420, ID.P3, -5));
			
			
			handler.addObject(new Coin(470, 505, ID.Coin));
			handler.addObject(new BasicEnemy(460, 600, ID.BasicEnemy, handler, 5));
			handler.addObject(new Platform(420, 520, ID.P4, 4));
			
			handler.addObject(new Coin(470, 605, ID.Coin));
			handler.addObject(new BasicEnemy(460, 700, ID.BasicEnemy, handler, -5));
			handler.addObject(new Platform(420, 620, ID.P5, -3));
			
			handler.addObject(new Coin(470, 705, ID.Coin));
			handler.addObject(new Platform(420, 720, ID.P6, 3));
		}
		
		if((doorCount == 4) && (hud.getScore() >= 2500))
		{
			doorCount++;
			handler.addObject(new Door(467, 130, ID.Door));
		}
		
		if(hud.getLevel() == 5)
		{
			game.gameState = STATE.Win;
		}
		
		
	}
}
