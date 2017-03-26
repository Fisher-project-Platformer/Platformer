//Author Joseph Carman		Date 2/21/17
//purpose trouble shoot existing Platfofrmer_Launch

package platformer;

import java.applet.*;
import java.awt.*;
import javax.swing.Timer;

import java.awt.event.*;

public class platforms extends Applet
{
		/**
	 * 
	 */
	private static final long serialVersionUID = -6016057044823814349L;//auto generated to resolve issue
		
	//declaring variables
	int doorX, doorY; //the coordinates that describe the position of the door
	int doorHeight, doorWidth; //the height and width of the door
	int charY = 80, charX = 20; //the coordinates that describe the character's position
	int charHeight = 20, charWidth = 20; //width and height of the character
	int xStep;//the sideways velocity for moving the character
	int speedDown = 0;
	public Timer timer;
	int boxWidth = 300, boxHeight = 300; //the width and size of the start menu
	int width = 1200, height = 600; //size of the window the program runs in
	
	//platforms
	int platform1Y = 100;
	int platform1GapLocation = (int)(width * 0.8);
	
	int platform2Y = 200;
	int platform2GapLocation = (int)(width * 0.2);
	
	int platform3Y = 300;
	int platform3GapLocation = (int)(width * 0.6);
	
	//menu
	int menuX = 100;
	int menuY = 100;
	int menuWidth = width - 200;
	int menuHeight = height - 200;
	Menu openMenu = new Menu(menuX, menuY, menuWidth, menuHeight);
	
	//images
	Image character;
	
	public void init () //starts applet
	{		
		// establishing general starting specs in the applet
		setSize(width, height); //sets the window equal to the variables declared earlier
		setBackground(Color.white); //sets the background of the applet to white
		timer = new Timer(50, new MyTimer()); //sets 50 milliseconds as the time interval for MyTimer to be carried out
		timer.start(); //starts the timer
		
		//Instantiates images
		character = getImage(getCodeBase(), "platformer/images/character.png");
		
	} //ends init
	
	public void paint(Graphics g)
	{
		//Character
		g.drawImage(character, charX, charY, this);
		/*
		g.setColor(Color.black); //sets the character's color to a light blue
		g.fillRect(charX, charY, charWidth, charHeight); //sets the character's dimensions and starting coordinates
		*/
		//platforms
		Platform platform1 = new Platform(width, platform1Y, platform1GapLocation);
		platform1.draw(g);
		
		Platform platform2 = new Platform(width, platform2Y, platform2GapLocation);
		platform2.draw(g);
		
		Platform platform3 = new Platform(width, platform3Y, platform3GapLocation);
		platform3.draw(g);
		
		
		//Menu	
		openMenu.draw(g, this);
	
		//g.setColor(Color.GRAY);
		//g.fillRect(100, 100, boxWidth, boxHeight);
	} //ends paint
	
	private class MyTimer implements ActionListener, KeyListener
	{
		//KeyListener commands
		public void keyReleased(KeyEvent p1) {}
		public void keyPressed(KeyEvent p1)
		{
			/*up arrow of 'w' jump
			*an if condition is necessary to stop jumping while in the air
			*space bar pause*
			*when pressed set up to paint menu and set v to 0 
			*store v somehow
			*as well as stopping directions and g
			*enter to start
			*set up so that enter reestablishes values for g and v
			*direction will just be changed with arrow keys*/
		}
		public void keyTyped(KeyEvent p1)
		{
			/*left arrow or 'a' movement
			*right arrow or 'd' movement*/
		
			repaint();//repaints graphics after key events are listened for
		}//ends keyTyped
		
		//ActionListener commands
		public void actionPerformed(ActionEvent a)
		{
			/*write in here events to be listend for
			*hit detection for bottom of platforms
			*hit detection for top of platforms
			*hit detection for sides of platforms
			*hit detection for door
			*hit detection for bottom of screen
			*hit detection for the sides of the screen*/
			
			repaint(); //repaints graphics after all events are looked for
		}//ends actionPerformed
	}//ends MyTimer	
}//ends platforms
