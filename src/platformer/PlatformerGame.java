package platformer;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

/**
 * Plays the game Platformer. The objectives and rules of the game are shown on launch.
 * @author Joseph Nielson
 * @verison 1.0 2017-3-7
 *
 */
public class PlatformerGame extends Applet implements KeyListener
{
	//Locations and sizes
	int aWidth = 1200, aHeight = 600;
	final int PLATFORM_SPACING = 100; 
	final int NUMBER_OF_PLATFORMS = 10;
	final int FIRST_PLATFORM_LOCATION = 550;
	PlatformSet platforms = new PlatformSet(aWidth, FIRST_PLATFORM_LOCATION, NUMBER_OF_PLATFORMS);
	
	//character variables
	static int charHeight = 20; //width and height of the character
	static int charWidth = 20;
	int charY=aHeight-charHeight, charX=0; //the coordinates that describe the character's position
	Move character1;
	
	//Other variables
	public Timer timer;
	final int FIRING_INTERVAL = 50;
	boolean isScrolling = false;
	
	//code below describes player movement side to side
		public void keyReleased(KeyEvent p)//actions to be performed on key release
		{
			if (p.getKeyCode() == KeyEvent.VK_A)//if up arrow is pressed
				Move.a=false;
			
			if (p.getKeyCode() == KeyEvent.VK_D)//if down arrow is pressed
				Move.d=false;
			
		}//ends keyReleased
		
		public void keyPressed(KeyEvent p)//sets up events for when specific keys are typed
		{
			if (p.getKeyCode() == KeyEvent.VK_A)//if up arrow is pressed
				Move.a=true;
			
			if (p.getKeyCode() == KeyEvent.VK_D)//if down arrow is pressed
				Move.d=true;
			
			if (p.getKeyCode() == KeyEvent.VK_W)//if the W key is pressed
				Move.w=true;
			
		}//ends keyPressed
		
		public void keyTyped(KeyEvent p)
		{
		}//ends keyTyped
	
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
		
		character1 = new Move(charX,charY);		
		
		addKeyListener(this);
		setFocusable(true);
		
	}//End init
	
	/**
	 * Draws the screen to begin and when repaint() is called.
	 * @param g an object of the Graphics class.
	 */
	public void paint(Graphics g)
	{
		//Draw platforms
		platforms.draw(g);
		g.setColor(Color.black);
        g.fillRect(Move.xPosit,Move.yPosit,charHeight,charWidth);
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
			Move.tick();//calls the method tick from class move
			repaint(); //repaints after conditions are tested for and resulting action is performed
		}

	}

	
	/**
	 * Generated by Eclipse.
	 */
	private static final long serialVersionUID = 1L;

}
