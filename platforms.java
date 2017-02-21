//Author Joseph Carman		Date 2/21/17
//purpose trouble shoot existing Platfofrmer_Launch

import java.applet.Applet;
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
	int charY = 0, charX = 0; //the coordinates that describe the character's position
	int charHeight = 20, charWidth = 20; //width and height of the character
	int xStep;//the sideways velocity for moving the character
	int speedDown = 0;
	public Timer timer;
	int boxWidth, boxHeight = 300; //the width and size of the start menu
	int width = 1200, height = 600; //size of the window the program runs in
	
	// insert code for generating platforms here
	
	public void init () //starts applet
	{		
		// establishing general starting specs in the applet
		setSize(width, height); //sets the window equal to the variables declared earlier
		setBackground(Color.white); //sets the background of the applet to white
		timer = new Timer(50, new MyTimer()); //sets 50 milliseconds as the time interval for MyTimer to be carried out
		timer.start(); //starts the timer
	} //ends init
	
	public void paint(Graphics g)
	{
		g.setColor(Color.black); //sets the character's color to a light blue
		g.fillRect(charX, charY, charWidth, charHeight); //sets the character's dimensions and starting coordinates
		g.setColor(Color.GRAY);
		g.fillRect(100, 100, boxWidth, boxHeight);
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
