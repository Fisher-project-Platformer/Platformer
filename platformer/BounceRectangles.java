//Author: Joseph Nielson
//Date: 9/27/2016
//Purpose: Bounce a ball off of the walls of a box and rectangles placed in the box.

package platformer;

import java.applet.Applet; //support for applet
import java.awt.*; //allow drawing on applet
import javax.swing.Timer; //give motion
import java.awt.event.*; //respond to events

public class BounceRectangles extends Applet implements MouseListener, ActionListener, ItemListener, KeyListener
{	
	//variables
	public Timer timer;
	private int aWidth = 600, aHeight = 400; //size of applet
	int x = 50, y = 50; //ball starting location
	int r1X, r1Y; //rectangle 1 coordinates
	int r2X, r2Y; //rectangle 2 coordinates
	int r3X, r3Y; //rectangle 3 coordinates
	int r4X, r4Y; //rectangle 4 coordinates
	int bWidth = 25, bHeight = 25; //size of ball
	int r1Width = 50, r1Height = 50; //sizes of rectangles
	int r2Width = 100, r2Height = 100;
	int r3Width = 100, r3Height = 100;
	int r4Width = 50, r4Height = 50;
	double speed = 10.0;
	int direction = 90;
	
	public void mouseReleased(java.awt.event.MouseEvent p1) {  }
	
	public void mouseEntered(java.awt.event.MouseEvent p1) {  }
	
	public void mouseClicked(java.awt.event.MouseEvent p1) {  }
	
	public void mousePressed(java.awt.event.MouseEvent p1)
	{
		x = p1.getX();
		y = p1.getY();
	}//End mousePressed
	
	public void mouseExited(java.awt.event.MouseEvent p1) {  }
	
	public void actionPerformed(java.awt.event.ActionEvent p1) {  }
	
	public void itemStateChanged(java.awt.event.ItemEvent p1) {  }
	
	public void keyReleased(java.awt.event.KeyEvent p1) {  }
	
	public void keyTyped(java.awt.event.KeyEvent p1) {  }
	
	public void keyPressed(java.awt.event.KeyEvent p1)
	{
		if (p1.getKeyCode() == p1.VK_UP)
		{
			speed += 1;
		}
		if (p1.getKeyCode() == p1.VK_DOWN)
		{
			if (speed > 0) speed -= 1;
		}
		
		if (p1.getKeyCode() == p1.VK_RIGHT)
		{
			direction += 2;
		}
		if (p1.getKeyCode() == p1.VK_LEFT)
		{
			direction -= 2;
		}
	}//End keyPressed
	
	public void init () //initialize applet
	{
		setFocusable(true);
		
		//Configure input from mouse and keyboard
		addMouseListener(this);
		addKeyListener(this);
		
		setSize(aWidth, aHeight); //size of applet
		setBackground(Color.white); //background color of applet
		direction = (int) (360 * Math.random()); //initialize direction randomly
		
		//set rectangle coordinates
		r1X = (int) (0.5 * aWidth + ((Math.random() * (0.5 * aWidth - r1Width))));
		r1Y = (int) (Math.random() * (0.5 * aHeight - r1Height));
		
		r2X = (int) (Math.random() * (0.5 * aWidth - r2Width));
		r2Y = (int) (Math.random() * (0.5 * aHeight - r2Height));
		
		r3X = (int) (Math.random() * (0.5 * aWidth - r3Width));
		r3Y = (int) (0.5 * aHeight + ((Math.random() * (0.5 * aHeight - r3Height))));
		
		r4X = (int) (0.5 * aWidth + ((Math.random() * (0.5 * aWidth - r4Width))));
		r4Y = (int) (0.5 * aHeight + ((Math.random() * (0.5 * aHeight - r4Height))));
		
		//set initial ball coordinates
		x = (int) Math.random() * (aWidth - bWidth);
		y = (int) Math.random() * (aHeight - bHeight);
		
		//if ball inside rectangle 1
		if (y + bHeight >= r1Y && y <= r1Y + r1Height && x + bWidth >= r1X && x <= r1X +r1Width)
		{
			if (r1Y > 0.25 * aHeight)
			{
				y -= r1Height + bHeight;
			}
			else
			{
				y += r1Height + bHeight;
			}
		}
		//inside rectangle 2
		else if (y + bHeight >= r2Y && y <= r2Y + r2Height && x + bWidth >= r2X && x <= r2X +r2Width)
		{
			if (r2Y > 0.25 * aHeight)
			{
				y -= r2Height + bHeight;
			}
			else
			{
				y += r2Height + bHeight;
			}
		}
		//inside rectangle 3
		else if (y + bHeight >= r3Y && y <= r3Y + r3Height && x + bWidth >= r3X && x <= r3X +r3Width)
		{
			if (r3Y > 0.75 * aHeight)
			{
				y -= r3Height + bHeight;
			}
			else
			{
				y += r3Height + bHeight;
			}
		}
		//inside rectangle 4
		else if (y + bHeight >= r4Y && y <= r4Y + r4Height && x + bWidth >= r4X && x <= r4X +r4Width)
		{
			if (r4Y > 0.75 * aHeight)
			{
				y -= r4Height + bHeight;
			}
			else
			{
				y += r4Height + bHeight;
			}
		}
		
		timer = new Timer(15, new MyTimer()); //the class associated with the timer and the length of time between firing
		timer.start(); //start timer
	}//end init
	
	//draw applet
	public void paint(Graphics g)
	{
		g.setColor(Color.black);
		g.fillOval(x, y, bWidth, bHeight); //draw ball as circle
		
		//draw rectangles
		g.setColor(Color.red);
		g.fillRect(r1X, r1Y, r1Width, r1Height);
		
		g.setColor(Color.green);
		g.fillRect(r2X, r2Y, r2Width, r2Height);
		
		g.setColor(Color.blue);
		g.fillRect(r3X, r3Y, r3Width, r3Height);
		
		g.setColor(Color.yellow);
		g.fillRect(r4X, r4Y, r4Width, r4Height);
	}//end paint
	
	//move ball
	private class MyTimer implements ActionListener
	{
		public void actionPerformed(ActionEvent a)
		{
			//change location of ball
			x += (int) (speed * Math.cos(Math.PI * direction / 180.0));
			y += (int) (speed * Math.sin(Math.PI * direction / 180.0));
			
			//Ensure that direction is between 0 and 360
			while (direction < 0 || direction >= 360)
			{
				if (direction < 0)
				{
					direction += 360;
				}
				else if (direction >= 360)
				{
					direction -= 360;
				}
			}
			
			//Bounce off of surface to the right
			if (x + bWidth > aWidth 
					|| (x + bWidth > r1X - speed && x + bWidth < r1X && y + bHeight / 2 > r1Y && y + bHeight / 2 < r1Y + r1Height) 
					|| (x + bWidth > r2X - speed && x + bWidth < r2X && y + bHeight / 2 > r2Y && y + bHeight / 2 < r2Y + r2Height) 
					|| (x + bWidth > r3X - speed && x + bWidth < r3X && y + bHeight / 2 > r3Y && y + bHeight / 2 < r3Y + r3Height) 
					|| (x + bWidth > r4X - speed && x + bWidth < r4X && y + bHeight / 2 > r4Y && y + bHeight / 2 < r4Y + r4Height)
				)
			{
				if (direction >= 0 && direction <= 90) //going down
				{
					direction = 180 - direction;
				}
				else if (direction >= 270 && direction <= 360) //going up
				{
					direction = 540 - direction;
				}
			}//End surface to the right
			
			//Bounce off of surface above
			if (y < 0 
					|| (x + bWidth / 2 > r1X && x + bWidth / 2 < r1X + r1Width && y > r1Y + r1Height && y < r1Y + r1Height + speed) 
					|| (x + bWidth / 2 > r2X && x + bWidth / 2 < r2X + r2Width && y > r2Y + r2Height && y < r2Y + r2Height + speed) 
					|| (x + bWidth / 2 > r3X && x + bWidth / 2 < r3X + r3Width && y > r3Y + r3Height && y < r3Y + r3Height + speed) 
					|| (x + bWidth / 2 > r4X && x + bWidth / 2 < r4X + r4Width && y > r4Y + r4Height && y < r4Y + r4Height + speed)
				) 
			{
				if (direction >= 180 && direction <= 270) //going left
				{
					direction = 360 - direction;
				}
				else if (direction >= 270 && direction <= 360) //going right
				{
					direction = 360 - direction;
				}
			}//End bounce off surface above
			
			//Bounce off of surface to the left
			if (x < 0 
					|| (x > r1X + r1Width && x < r1X + r1Width + speed && y + bHeight / 2 > r1Y && y + bHeight / 2 < r1Y + r1Height) 
					|| (x > r2X + r2Width && x < r2X + r2Width + speed && y + bHeight / 2 > r2Y && y + bHeight / 2 < r2Y + r2Height) 
					|| (x > r3X + r3Width && x < r3X + r3Width + speed && y + bHeight / 2 > r3Y && y + bHeight / 2 < r3Y + r3Height) 
					|| (x > r4X + r4Width && x < r4X + r4Width + speed && y + bHeight / 2 > r4Y && y + bHeight / 2 < r4Y + r4Height)
				)
			{
				if (direction >= 180 && direction <= 270) //going up
				{
					direction = 540 - direction;
				}
				else if (direction >= 90 && direction <= 180) //going down
				{
					direction = 180 - direction;
				}
			}//End bounce off of surface to the left
			
			//Bounce off of surface below
			if (y + bHeight > aHeight 
					|| (x + bWidth / 2 > r1X && x + bWidth / 2 < r1X + r1Width && y + bHeight > r1Y - speed && y + bHeight < r1Y) 
					|| (x + bWidth / 2 > r2X && x + bWidth / 2 < r2X + r2Width && y + bHeight > r2Y - speed && y + bHeight < r2Y) 
					|| (x + bWidth / 2 > r3X && x + bWidth / 2 < r3X + r3Width && y + bHeight > r3Y - speed && y + bHeight < r3Y) 
					|| (x + bWidth / 2 > r4X && x + bWidth / 2 < r4X + r4Width && y + bHeight > r4Y - speed && y + bHeight < r4Y)
				)
			{
				if (direction >= 90 && direction <= 180) //going left
				{
					direction = 360 - direction;
				}
				else if (direction >= 0 && direction <= 90) //going right
				{
					direction = 360 - direction;
				}
			}//End bounce off of surface below
			
			//Bounce off of corners
			//Top left corner
			if ((x + bWidth > r1X && x + bWidth < r1X + speed && y + bHeight > r1Y && y + bHeight < r1Y + speed)
					|| (x + bWidth > r2X && x + bWidth < r2X + speed && y + bHeight > r2Y && y + bHeight < r2Y + speed)
					|| (x + bWidth > r3X && x + bWidth < r3X + speed && y + bHeight > r3Y && y + bHeight < r3Y + speed)
					|| (x + bWidth > r4X && x + bWidth < r4X + speed && y + bHeight > r4Y && y + bHeight < r4Y + speed)
				)
			{
				direction += 180;
			}
			//Top right corner
			else if ((x > r1X + r1Width - speed && x < r1X + r1Width && y + bHeight > r1Y && y + bHeight < r1Y + speed)
					|| (x > r2X + r2Width - speed && x < r2X + r2Width && y + bHeight > r2Y && y + bHeight < r2Y + speed)
					|| (x > r3X + r3Width - speed && x < r3X + r3Width && y + bHeight > r3Y && y + bHeight < r3Y + speed)
					|| (x > r4X + r4Width - speed && x < r4X + r4Width && y + bHeight > r4Y && y + bHeight < r4Y + speed)
				)
			{
				direction += 180;
			}
			//Bottom right corner
			else if ((x > r1X + r1Width - speed && x < r1X + r1Width && y > r1Y + r1Height - speed && y < r1Y + r1Height)
					|| (x > r2X + r2Width - speed && x < r2X + r2Width && y > r2Y + r2Height - speed && y < r2Y + r2Height)
					|| (x > r3X + r3Width - speed && x < r3X + r3Width && y > r3Y + r3Height - speed && y < r3Y + r3Height)
					|| (x > r4X + r4Width - speed && x < r4X + r4Width && y > r4Y + r4Height - speed && y < r4Y + r4Height)
				)
			{
				direction -= 180;
			}
			//Bottom left corner
			else if ((x + bWidth > r1X && x + bWidth < r1X + speed && y > r1Y + r1Height - speed && y < r1Y + r1Height)
					|| (x + bWidth > r2X && x + bWidth < r2X + speed && y > r2Y + r2Height - speed && y < r2Y + r2Height)
					|| (x + bWidth > r3X && x + bWidth < r3X + speed && y > r3Y + r3Height - speed && y < r3Y + r3Height)
					|| (x + bWidth > r4X && x + bWidth < r4X + speed && y > r4Y + r4Height - speed && y < r4Y + r4Height)
				)
			{
				direction -= 180;
			}
			
			repaint();
		}//end actionPerformed
	}//end class MyTimer
	
		
}//end BounceRectangles
