package platformer;

import java.awt.*;
import java.applet.*;

/**
 * A menu shows directions for playing Platformer and gives options to get help, quit, or begin playing.
 * @author Joseph Nielson
 * @version 1.0 2017-2-21
 */
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
	private String[] text = new String[numLines];
	
	text[0] = "PLATFORMER";
	text[1] = " ";
	text[2] = "Move left or right";
	text[3] = "Jump";
	text[4] = "Pause/Resume";
	text[5] = " ";
	text[6] = "Quit (Q)";
	text[7] = "Start (Enter)";
	
	int lineSpacing = 25;
	int topMargin = 50;
	int leftMargin = 600;
	
	//Fonts
	private Font menuFont = new Font("SansSerif", Font.PLAIN, 19);
	
	//Images
	Image left, right, up, space;
	
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
	}
	
	/**
	 * Defines the images needed for the menu.
	 * @param applet
	 */
	public void defineImages(Applet applet)
	{
		//Instantiate images
		left = applet.getImage(applet.getCodeBase(), "platformer/images/left_arrow.jpeg");
		right = applet.getImage(applet.getCodeBase(), "platformer/images/right_arrow.jpeg");
		up = applet.getImage(applet.getCodeBase(), "platformer/images/up_arrow.jpeg");
		space = applet.getImage(applet.getCodeBase(), "platformer/images/space_key.jpeg");		
	}
	
	/**
	 * Draws the Menu
	 * @param g a reference to a Graphics object
	 */
	public void draw(Graphics g)
	{
		
		//Background
		g.setColor(menuColor);
		g.fillRect(menuX, menuY, menuWidth, menuHeight);
		
		//Draw text
		int textX = menuX + leftMargin;
		int textY = menuY + topMargin;
		g.setColor(textColor);
		g.setFont(menuFont);
		
		g.drawString(title, textX, textY);
		g.drawString(move, textX, textY + 2 * lineSpacing);
		g.drawString(jump, textX, textY + 3 * lineSpacing);
		g.drawString(pause, textX, textY + 4 * lineSpacing);
		g.drawString(quit, textX, textY + 6 * lineSpacing);
		g.drawString(start, textX, textY + 7 * lineSpacing);
		
		//Place images
		g.drawImage(l)
	}
}
