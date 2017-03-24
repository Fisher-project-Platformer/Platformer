package platformer;

import java.awt.*;
import java.awt.image.*;
import java.applet.*;

/**
 * A menu shows directions for playing Platformer and gives options to get help, quit, or begin playing.
 * @author Joseph Nielson
 * @version 1.0 2017-2-21
 */

//TODO: Add KeyListener
public class Menu 
{
	//Variables
	
	private int menuX = 0;
	private int menuY = 0;
	
	//Colors
	private Color menuColor = Color.LIGHT_GRAY;
	private Color textColor = Color.BLACK;
	
	//Background
	private int menuWidth = 400;
	private int menuHeight = 300;
	
	//Text
	int numLines = 9;
	String[] text = new String[]{
			"PLATFORMER",
			" ",
			"a d             Move left or right",
			"w               Jump",
			"SPACE        Pause/Resume",
			" ",
			"Quit (Q)",
			"Start (SPACE)"
			};
	
	int lineSpacing = 25;
	int topMargin = 50;
	int leftMargin = 600;
	
	//Fonts
	private Font menuFont = new Font("SansSerif", Font.PLAIN, 19);
	
	/**
	 * Creates a Menu object at the given location (x, y). 
	 * The menu describes Platformer's controls and allows the user to quit or start/resume.
	 * @param x the horizontal location of the menu's top-left corner
	 * @param y the vertical location of the menu's top-left corner
	 */
	public Menu(int x, int y)
	{
		menuX = x;
		menuY = y;
	}
	
	/**
	 * Creates a Menu object at the given location (x, y) with the given dimensions. 
	 * The menu describes Platformer's controls and allows the user to quit or start/resume.
	 * @param x the horizontal location of the menu's top-left corner
	 * @param y the vertical location of the menu's top-left corner
	 * @param width the desired width of the menu
	 * @param height the desired height of the menu
	 */
	public Menu(int x, int y, int width, int height)
	{
		menuX = x;
		menuY = y;
		menuWidth = width;
		menuHeight = height;
		leftMargin = width / 2 - 50;
	}
	
	/**
	 * Draws the Menu
	 * @param g a reference to a Graphics object
	 */
	public void draw(Graphics g, ImageObserver applet)
	{
		
		//Background
		g.setColor(menuColor);
		g.fillRect(menuX, menuY, menuWidth, menuHeight);
		
		//Draw text
		int textX = menuX + leftMargin;
		int textY = menuY + topMargin;
		g.setColor(textColor);
		g.setFont(menuFont);
		
		for (int i = 0; i < text.length; i++)
		{
			g.drawString(text[i], textX, textY + i * lineSpacing);
		}
		
	}
}
