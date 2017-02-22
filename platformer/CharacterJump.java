/**
 * Simulates a character jumping.
 * For Platformer.
 * @author Joseph Nielson
 * @version 1.0 2017-2-17
 */

package platformer;

import java.applet.Applet;
import java.awt.*; 
import javax.swing.Timer;

import java.awt.event.*;

public class CharacterJump extends Applet implements ActionListener, ItemListener, KeyListener
{
	//Variables
	public Timer timer;
	private int aHeight = 400, aWidth = 600;
	int charX = aWidth / 2, charY = aHeight - 20;
	int charWidth = 20, charHeight = 20;
	double charVerticalSpeed = 0;
	
	//Constants
	final double GRAVITY_ACCELERATION = -9.8;
	final int JUMP_HEIGHT = 40;
	
	//Images
	Image character;
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == e.VK_UP)
		{
			charVerticalSpeed = Math.sqrt(-2 * GRAVITY_ACCELERATION * JUMP_HEIGHT);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Initialize the applet
	 */
	public void init ()
	{
		setFocusable(true);

		addKeyListener(this);
		
		setSize(aWidth, aHeight); 
		setBackground(Color.white);
		
		//Length of time between firing the timer.
		timer = new Timer(15, new MyTimer());
		timer.start(); //start timer
		
		//
	}//End init
	
	/**
	 * Draws the applet.
	 * @param g an object of the Graphics class
	 */
	public void paint(Graphics g)
	{
		//Create platform
		Platform platform1 = new Platform(aWidth, aHeight / 2, (int)(aWidth * 0.8));
		platform1.draw(g);
		
		//Put character on platform
		charY = platform1.getY() - charHeight;
		
		//Square to represent character
		g.setColor(Color.black);
		g.fillRect(charX, charY, charWidth, charHeight);
		
	}
	
	/**
	 * Moves the character. Based off of notes from Mr. Fisher.
	 * @author Joseph Nielson
	 * @version 1.0 2017-2-20
	 *
	 */
	private class MyTimer implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			//Perform jump
			
			repaint();
			
		}//End actionPerformed
		
	}//End MyTimer
	
}//End CharacterJump
