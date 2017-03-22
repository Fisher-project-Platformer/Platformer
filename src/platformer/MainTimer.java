package platformer;
//Author: Anthony
//Purpose: To display the timer in the game
//Date: 3/20/17
import java.applet.Applet;
import java.awt.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.awt.Font;

public class MainTimer extends java.applet.Applet
{
	public Timer timer;
	
	int minutes = 0; //minutes
	int seconds = 0; //seconds
	
	int appletSizex = 1000;
	int appletSizey = 600;

	int textPosx = appletSizex - 90; //x position of the text
	int textPosy = 35; //y position of the text
	int boxPosx = appletSizex - 95; //x position of the box around the timer
	int boxPosy = 0; //y position of the box around the timer
	int boxSizex = 95;
	int boxSizey = 50;
	
	
	int start = (int) System.currentTimeMillis(); //get the CPU time right as the program starts
	int change; //initialize the CPU time that will refresh itself via the timer
	
	Font stringFont = new Font("Monospaced", Font.BOLD, 35); //make the font for the text
	
	
	public void init()
	{
		setSize(appletSizex,appletSizey); //size of applet
		setBackground(Color.white); //color of applet
		
		timer = new Timer(100, new MyTimer() );
		timer.start();
		//timer stuff
	} //end init
	
	public void paint (Graphics g)
	{
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

	} //end Graphics g
	
	public class MyTimer implements ActionListener
	{
		public void actionPerformed(ActionEvent a)
		{
			change = (int) System.currentTimeMillis();
			minutes = Timer2.getMinutes(change, start);
			seconds = Timer2.getSeconds(change, start);
			//update the time
			
			repaint();
		} //end actions performed
	}//end Timer
}//end Main Timer
