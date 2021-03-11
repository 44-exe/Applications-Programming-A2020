package Xliv;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5415874751228517386L;

	public Window(int width, int height, String title, Game game)
	{
		JFrame frame = new JFrame(title);
		
		
		//setting dimension of the popup box
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		
		//to comepletly close the game
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
		
		
	}
	
	
}
