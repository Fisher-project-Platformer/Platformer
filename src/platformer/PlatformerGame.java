package platformer;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
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
	int charY=0, charX=0; //the coordinates that describe the character's position
	Move character1;
	
	//timer
	int minutes = 0; //minutes
	int seconds = 0; //seconds
	int textPosx = aWidth - 90; //x position of the text
	int textPosy = 35; //y position of the text
	int boxPosx = aWidth - 95; //x position of the box around the timer
	int boxPosy = 0; //y position of the box around the timer
	int boxSizex = 95;
	int boxSizey = 50;
	int start = (int) System.currentTimeMillis(); //get the CPU time right as the program starts
	int change; //initialize the CPU time that will refresh itself via the timer
	Font stringFont = new Font("Monospaced", Font.BOLD, 35); //make the font for the text
	//pause variables
	int pauseTimeOne = (int) System.currentTimeMillis();
	int pauseTimeTwo = 0;
	
	//Other variables
	public Timer timer;
	final int FIRING_INTERVAL = 50;
  int downwardVelocity = 2;
	
	//menu variables
	static boolean isPlaying = false;
	int menuX = 100;
	int menuY = 100;
	int menuWidth = aWidth - 200;
	int menuHeight = aHeight - 200;
	Menu openMenu = new Menu(menuX, menuY, menuWidth, menuHeight);

	//boolean isScrolling = false;


	
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
			
			if (p.getKeyCode() == KeyEvent.VK_Q)//if the Q key is pressed
				System.exit(0);
			

			if (p.getKeyChar() == ' ' && isPlaying == true)
			{
				isPlaying=false;
				//timer stuff
				pauseTimeOne = (int) System.currentTimeMillis();
			}
			
			else if (p.getKeyChar() == ' ' && isPlaying == false)
			{
				isPlaying=true;
				//timer stuff
				pauseTimeTwo = (int) System.currentTimeMillis();
				start += pauseTimeTwo - pauseTimeOne;
			}
					
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
		
		//Timer
		g.setColor(Color.gray); //create the box
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

		//paints character
		  g.setColor(Color.black);
      g.fillRect(Move.xPosit,Move.yPosit,charHeight,charWidth);
        
        //draws menu
        if(!isPlaying) openMenu.draw(g, this);

        g.setColor(Color.CYAN);
		g.drawString(""+Move.yPosit+"," + Move.dy, 100, 100);

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

			if (isPlaying)
			{
				platforms.scrollDown(downwardVelocity);
				Move.scrollDown(downwardVelocity);
			}
			
			Move.tick();//calls the method tick from class moved
			//timer
			
			change = (int) System.currentTimeMillis();
			if (isPlaying == true) //functioning normally
			{
				minutes = Timer2.getMinutes(change, start);
				seconds = Timer2.getSeconds(change, start);
			}
			
			if (isPlaying == false) //functioning while paused
			{
				minutes = Timer2.getMinutes(pauseTimeOne, start);
				seconds = Timer2.getSeconds(pauseTimeOne, start);
			}
			//update the time
			
			repaint();
		}

	}

	
	/**
	 * Generated by Eclipse.
	 */
	private static final long serialVersionUID = 1L;

}
