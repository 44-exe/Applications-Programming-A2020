package Xliv;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


public class Game extends Canvas implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1589835601195450119L;

	public static final int WIDTH = 1000, HEIGHT = WIDTH / 12 *10;
	
	private Thread thread;
	
	private boolean running = false;
	
	private Handler handler;
		
	private HUD hud;
		
	private Spawn spawn;
	
	private Menu menu;
		
	public enum STATE
	{
		Menu,
		Help,
		End,
		Win,
		Game
	};
	
	public STATE gameState = STATE.Menu;
	
	public Game()
	{
		handler = new Handler();
				
		hud = new HUD();
		
		spawn = new Spawn(handler, hud, this);
		
		menu = new Menu(this, handler, hud, spawn);
		
		this.addKeyListener(new KeyInput(handler));
		
		this.addMouseListener(menu);
		
		new Window(WIDTH, HEIGHT, "XLIV Game", this);
	}
	
	
	public synchronized void start()
	{
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop()
	{
		try
		{
			thread.join();
			running = false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void run()
	{
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		
		while(running)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1)
			{
				tick();
				delta--;
			}
			if(running)
				render();
			
			if(System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;

			}
		}
		stop();
	}
	
	
	private void tick()
	{
		handler.tick();
		
		if(gameState == STATE.Game)
		{
			hud.tick();
			spawn.tick();
			
			if(HUD.HEALTH <= 0)
			{
				HUD.HEALTH = 100;
				handler.clearAllObjects();
				gameState = STATE.End;
			}
		}
		else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End || gameState == STATE.Win)
		{
			menu.tick();
		}
	}
	
	private void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);

		if(gameState == STATE.Game)
		{
			hud.render(g);
		}
		else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End || gameState == STATE.Win)
		{
			menu.render(g);
		}
		
		g.dispose();
		bs.show();
	}
	
	
	public static float clamp(float var, float min, float max)
	{
		if (var >= max)
			return var = max;
		else if(var <= min)
			return var = min;
		else
			return var;
	}
	
	
	public static void main(String args[])
	{
		new Game();
	}

}
