/**
 * A platform is located at a given y-coordinate, fills the given width, and has a gap at a given x-coordinate.
 * For use the Platformer, a group project by Joseph Carman, Anthony Derfler, and Joseph Nielson for Mr. Rick Fisher's Java Programming class.
 * @author Joseph Nielson
 * @version 1.0 2017-2-15
 *
 */

import java.awt.*; //For graphics

public class Platform 
{
	//Variables for platform
	private int platformY = 0; //Vertical location of platform
	final int PLATFORM_HEIGHT = 20; //Height or thickness of platform
	private int width = 0; //The given width of the applet
	
	//Variables for gap
	final int GAP_SIZE = 50; //Width of gap
	private int gapLocation = 0; //The x-coordinate of the gap
	
	/**
	 * Creates a platform and a gap with the given measurements
	 * @param width the width of the screen that the platform will fill
	 * @param yCoordinate the y-coordinate for the top-left corner of the platform
	 * @param gapLocation the x-coordinate of the left-hand side of the gap. Must be less than width.
	 */
	public Platform(int width, int yCoordinate, int gapLocation)
	{
		this.width = width;
		this.platformY = yCoordinate;
		this.gapLocation = gapLocation;
	}
	
	/**
	 * Draws the platform
	 */
	public void draw(Graphics g)
	{
		//Set color
		g.setColor(Color.blue);
		
		//Create 2 rectangles for each platform
		//Left of gap
		g.fillRect(0, platformY, gapLocation, PLATFORM_HEIGHT);
		//Right of gap
		g.fillRect(gapLocation + GAP_SIZE, platformY, width - gapLocation - GAP_SIZE, PLATFORM_HEIGHT);
	}
	
	/**
	 * Returns the y-coordinate of the platform.
	 * @return the y-coordinate of the platform.
	 */
	public int getY()
	{
		return platformY;
	}
	
	/**
	 * Set the y-coordinate of the platform
	 * @param newY the desired y-coordinate of the platform
	 */
	public void setY(int newY)
	{
		this.platformY = newY;
	}
}
