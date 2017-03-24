package platformer;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/**
 * Plays the game Platformer. The objectives and rules of the game are shown on launch.
 * @author Joseph Nielson
 * @verison 1.0 2017-3-7
 *
 */
public class PlatformerGame extends Applet
{
	//Locations and sizes
	int aWidth = 1200, aHeight = 600;
	final int PLATFORM_SPACING = 100; 
	final int NUMBER_OF_PLATFORMS = 10;
	final int FIRST_PLATFORM_LOCATION = 550;
	PlatformSet platforms = new PlatformSet(aWidth, FIRST_PLATFORM_LOCATION, NUMBER_OF_PLATFORMS);
	
	//timer variables
	int minutes = 0; //minutes
	int seconds = 0; //seconds
	int textPosx = aWidth - 90; //x position of the text
	int textPosy = 35; //y position of the text
	int boxPosx = aWidth - 95; //x position of the box around the timer
	int boxPosy = 0; //y position of the box around the timer
	int boxSizex = 95; //x dimensions of the box
	int boxSizey = 50; //y dimensions of the box
	int start = (int) System.currentTimeMillis(); //get the CPU time right as the program starts
	int change; //initialize the CPU time that will refresh itself via the timer
	
	static Font stringFont = new Font("Monospaced", Font.BOLD, 35); //make the font for the text
	
	//Other variables
	public Timer timer;
	final int FIRING_INTERVAL = 50;
	boolean isScrolling = false;
	/**
	 * Runs when the Applet starts. Sets size and color of Applet and starts timer.
	 */
	public void init()
	{
		//Applet
		setSize(aWidth, aHeight);
		setBackground(Color.white);
		
		//Timer
		timer = new Timer(FIRING_INTERVAL, new PlatformerTimer());
		timer.start();
		
	}//End init
	
	/**
	 * Draws the screen to begin and when repaint() is called.
	 * @param g an object of the Graphics class.
	 */
	public void paint(Graphics g)
	{
		//Draw platforms
		platforms.draw(g);
		
		//Timer drawing
		g.setColor(Color.black); //create the box
		g.fillRect(boxPosx, boxPosy, boxSizex, boxSizey); //fill the box
		g.setColor(Color.CYAN); //create the text
		g.setFont(stringFont); //set its font
		if (seconds >= 10)
			g.drawString(Integer.toString(minutes) + ":" +
					Integer.toString(seconds), textPosx, textPosy);
		//if the seconds are greater than 10, you don't need an extra 0 in the timer
		
		if (seconds < 10)
			g.drawString(Integer.toString(minutes) + ":0" + 
					Integer.toString(seconds), textPosx, textPosy);
		//if the seconds are less than 10, you do need that extra 0
		
		
	}
	
	/**
	 * Runs at given intervals to move objects.
	 * @author Joseph Nielson
	 * @verison 1.0 2017-3-7
	 *
	 */
	public class PlatformerTimer implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			
			//timer
			change = (int) System.currentTimeMillis();
			minutes = Timer2.getMinutes(change, start);
			seconds = Timer2.getSeconds(change, start);
			
			repaint();			
		}

	}

	
	/**
	 * Generated by Eclipse.
	 */
	private static final long serialVersionUID = 1L;

}
