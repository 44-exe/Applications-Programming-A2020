package Xliv;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static float HEALTH = 100;
	
	private float greenValue = 255;
	private int score = 0;
	private int level = 0;
	private int timem = 0;
	private int timeS = 0;
	private int timeM = 0;
	private int timeH = 0;
	
	
	public void tick()
	{
		HEALTH = Game.clamp(HEALTH, 0, 100);
		greenValue = Game.clamp(greenValue, 0, 255);
		
		greenValue = HEALTH*2;
		timem++;
		calcTime();
	}
	
	public void render(Graphics g)
	{
		g.setColor(new Color(75, (int)greenValue, 0));
		g.fillRect(15, 15, (int)HEALTH * 2, 32);
		
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		
		g.drawString("Score: " + score, 15, 64);
		g.drawString("level: " + level, 15, 80);
		g.drawString("time: " + timeH + ":" + timeM + ":" + timeS, 15, 96);
	}
	
	private void calcTime()
	{
		if(timem == 59)
		{
			timeS += 1;
			timem = 0;
			if(timeS == 59)
			{
				timeM += 1;
				timeS = 0;
				if(timeM == 59)
				{
					timeH +=1;
					timeM = 0;
				}
				
			}
		}
	}
	
	public void setScore(int score)
	{
		this.score = score;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public void setLevel(int level)
	{
		this.level = level;
	}
	
	public int getLevel()
	{
		return level;
	}
	
	public void reTime(int time)
	{
		this.timem = 0;
		this.timeS = 0;
		this.timeM = 0;
		this.timeH = 0;
	}
}
