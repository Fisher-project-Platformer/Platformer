package platformer;
//Author Joseph Carman		Date 2/21/17
//purpose trouble shoot existing Platfofrmer_Launch

import java.applet.Applet;
import java.awt.*;
import javax.swing.Timer;

import java.awt.event.*;

public class platforming extends Applet implements KeyListener
{

		
	/**
	 * 
	 */
	private static final long serialVersionUID = 2103732427266105885L;
	//declaring variables
	int doorX, doorY; //the coordinates that describe the position of the door
	int doorHeight, doorWidth; //the height and width of the door
	int charHeight = 20, charWidth = 20; //width and height of the character
	int speedDown = 4;
	public Timer timer;
	public Move move;
	int width = 1200, height = 600; //size of the window the program runs in
	int charY=height-charHeight, charX=0; //the coordinates that describe the character's position
	boolean menu = true;
	boolean w=false, a=false, d=false;
	Move character1;
	Image person;
	
	// insert code for generating platforms here
	
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
	
	
	public void init () //starts applet
	{		
		// establishing general starting specs in the applet
		setSize(width, height); //sets the window equal to the variables declared earlier
		setBackground(Color.white); //sets the background of the applet to white
		timer = new Timer(50, new MyTimer()); //sets 50 milliseconds as the time interval for MyTimer to be carried out
		timer.start(); //starts the timer
		character1 = new Move(charX,charY);		
		addKeyListener(this);
		setFocusable(true);
	} //ends init
	
    //paints the character 
    public void paint(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRect(Move.xPosit,Move.yPosit,charHeight,charWidth);
    }

	private class MyTimer implements ActionListener
	{		
		
		public void actionPerformed(ActionEvent a)
		{	
			
			Move.tick();//calls the method tick from class move
			repaint(); //repaints after conditions are tested for and resulting action is performed
		} //ends actionPerformed
	}//ends MyTimer	
}//ends platforms
