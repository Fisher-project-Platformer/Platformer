/**
 * A platform is located at a given y-coordinate, fills the given width, and has a gap at a given x-coordinate.
 * For use the Platformer, a group project by Joseph Carman, Anthony Derfler, and Joseph Nielson for Mr. Rick Fisher's Java Programming class.
 * @author Joseph Nielson
 * @version 1.0 2017-2-15
 *
 */


public class Platform 
{
	//Variables for platform
	private int platformY = 0; //Vertical location of platform
	private final int HEIGHT = 20; //Height or thickness of platform
	private int width = 0; //The given width of the applet
	
	//Variables for gap
	private final double GAP_SIZE = 0.10; //Percentage of the width of the platform that the gap occupies
	private double gapLocation = 0; //The desired location of the gap
	
	/**
	 * Creates a platform and a gap with the given measurements
	 * @param width the width of the screen to fill with the platform
	 * @param verticalLocation the y-coordinate of the desired location for the platform
	 * @param gapLocation the desired location of the gap. Must be less than width.
	 */
	public Platform(int width, int verticalLocation, int gapLocation)
	{
		this.width = width;
		this.platformY = verticalLocation;
		this.gapLocation = gapLocation;
	}
	
	/**
	 * Draws the platform
	 */
	public draw()
	{
		//Set color and fill rectangles
		
	}
}
