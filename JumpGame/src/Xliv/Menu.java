package Xliv;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Xliv.Game.STATE;

public class Menu extends MouseAdapter{
	
	private Spawn spawn;
	private Game game;
	private HUD hud;
	private Handler handler;
	
	public Menu(Game game, Handler handler, HUD hud, Spawn spawn)
	{
		this.game = game;
		this.handler = handler;
		this.hud = hud;
		this.spawn = spawn;
	}
	
	public void mousePressed(MouseEvent e)
	{
		int mx = e.getX();
		int my = e.getY();
		
		if(game.gameState == STATE.Menu)
		{
			//play button
			if(mouseOver(mx, my, 100, 100, 170, 60))
			{
				spawn.tick();
				game.gameState = STATE.Game;
			}
			
			//quit button
			if(mouseOver(mx, my, 100, 300, 170, 64))
			{
				 System.exit(1);
			}
			//help button
			if(mouseOver(mx, my, 100, 200, 170, 64))
			{
				game.gameState = STATE.Help;
			}
		}
		else if(game.gameState == STATE.Help)
		{
			if(mouseOver(mx, my, 110,370,115,48))
			{
				game.gameState = STATE.Menu;
				return;
			}
		}
		else if(game.gameState == STATE.End)
		{
			//return to menu
			if(mouseOver(mx, my, 100,310,220,50))
			{
				game.gameState = STATE.Menu;
				return;
			}
			
			//try again: back to level 1
			else if(mouseOver(mx, my, 390,310,170,50))
			{
				game.gameState = STATE.Game;
				spawn.levKeep = 0;
				spawn.doorCount = 0;
				hud.setScore(0);
				hud.setLevel(0);
				handler.resetKey();
				spawn.tick();
				return;
			}
		}
		else if(game.gameState == STATE.Win)
		{
			//return to menu
			if(mouseOver(mx, my, 100,410,220,50))
			{
				game.gameState = STATE.Menu;
				return;
			}
		}
	}
	
	public void mouseReleased(MouseEvent e)
	{
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height)
	{
		if(mx > x && mx < x + width)
		{
			if(my > y && my < y + height)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		if(game.gameState == STATE.Menu)
		{
			Font fnt = new Font("arial", 1, 50);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Menu", 120, 60);
			
			
			Font fnt2 = new Font("arial", 1, 30);
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString("Play", 130, 145);
			g.drawRect(100,100,170,60);
			
			g.setColor(Color.white);
			g.drawString("Help", 130, 245);
			g.drawRect(100,200,170,64);
			
			g.setColor(Color.white);
			g.drawString("Quit", 130, 345);
			g.drawRect(100,300,170,64);
		}
		else if(game.gameState == STATE.Help)
		{
			Font fnt = new Font("arial", 1, 50);
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Help", 120, 60);;
			
			Font fnt3 = new Font("arial", 1, 15);
			g.setFont(fnt3);
			g.drawString("1. Use arrows keys to move to control the white square.", 100, 130);
			g.drawString("2. Avoid the reds.", 100, 185);
			g.drawString("3. Collect all every gold on the level to unlock portal.", 100, 240);
			g.drawString("4. Go through the green portal for next level.", 100, 305);
			
			Font fnt2 = new Font("arial", 1, 30);
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString("Back", 130, 405);
			g.drawRect(110,370,115,48);
		}
		else if(game.gameState == STATE.End)
		{
			Font fnt = new Font("arial", 1, 50);
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Game Over", 120, 60);
			
			
			Font fnt2 = new Font("arial", 1, 30);
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString("Score: " + hud.getScore(), 130, 145);
			
			
			g.setColor(Color.white);
			g.drawString("Try again", 400, 345);
			g.drawRect(390,310,170,50);
			
			g.setColor(Color.white);
			g.drawString("Back to menu", 110, 345);
			g.drawRect(100,310,220,50);
		}
		else if(game.gameState == STATE.Win)
		{
			Font fnt = new Font("arial", 1, 50);
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("You Win! Thanks for playing.", 120, 60);
			
			Font fnt2 = new Font("arial", 1, 30);
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString("Score: " + hud.getScore(), 130, 145);
			
			Font fnt3 = new Font("arial", 1, 15);
			g.setFont(fnt3);
			g.setColor(Color.white);
			g.drawString("Let me know if you have other ideas.", 110, 245);
			g.drawString("If you find glitches, deal with it!", 110, 290);
			
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString("Back to menu", 110, 445);
			g.drawRect(100,410,220,50);
		}
	}

}
