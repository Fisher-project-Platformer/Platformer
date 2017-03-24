package platformer;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Contains a given number of Platforms with a given width and spacing. 
 * The locations of gaps in the platforms are set randomly.
 * The class allows all the platforms to be drawn given the location of the bottom of the bottom platform. 
 * @author Joseph Nielson
 * @version 2017-3-7
 *
 */
public class PlatformSet 
{
	//Variables
	private int numberOfPlatforms;
	private int platformWidth;
	private int firstPlatformLocation;
	private int spacingBetweenPlatforms;
	private int firstGapLocation;
	
	Platform[] platforms;
	
	//Constants
	private final int MIN_SPACE_BETWEEN_GAPS = 60;
	private final int MAX_SPACE_BETWEEN_GAPS = 500;
	private final int DEFAULT_VERTICAL_SPACING = 100;
	private final int DEFAULT_FIRST_GAP_LOCATION = 600;

	
	/**
	 * Creates a set of platforms with the bottom platform beginning at the given location.
	 * @param width the width of the platforms
	 * @param firstPlatformLocation the y-location of the bottom platform
	 * @param numberOfPlatforms the number of platforms in the set
	 */
	public PlatformSet(int width, int firstPlatformLocation, int numberOfPlatforms)
	{
		this.numberOfPlatforms = numberOfPlatforms;
		this.platformWidth = width;
		this.firstPlatformLocation = firstPlatformLocation;
		this.spacingBetweenPlatforms = DEFAULT_VERTICAL_SPACING;
		this.firstGapLocation = DEFAULT_FIRST_GAP_LOCATION;
		
		//Create platforms
		platforms = new Platform[numberOfPlatforms];
		for (int i = 0; i < numberOfPlatforms; i++)
		{
			int platformY = firstPlatformLocation - i * spacingBetweenPlatforms;
			int gapLocation = 15;
			
			if (i == 0)
			{
				gapLocation = firstGapLocation; 
			}
			else
			{
				int gapSize = platforms[i - 1].GAP_SIZE;
				int lastGapLocation = platforms[i - 1].getGapLocation();
				double randomGapSpacing = Math.random();
				
				//Choose left of right of last gap
				boolean placeToLeft = false;
				double leftRightChooser = Math.random();
				if (leftRightChooser < 0.5)
				{
					//There is room to the left
					if (lastGapLocation - MAX_SPACE_BETWEEN_GAPS > 0)
					{
						placeToLeft = true;
					}
					else
					{
						placeToLeft = false;
					}
				}
				else
				{
					//There is room to the right
					if (lastGapLocation + gapSize + MAX_SPACE_BETWEEN_GAPS < width)
					{
						placeToLeft = false;
					}
					else
					{
						placeToLeft = true;
					}
				}
				
				
				//Puts gap to the left of the last gap
				if (placeToLeft)
				{
					gapLocation = lastGapLocation - MAX_SPACE_BETWEEN_GAPS + (int)(randomGapSpacing * (-MIN_SPACE_BETWEEN_GAPS - gapSize + MAX_SPACE_BETWEEN_GAPS));
				}
				//Puts gap to the right of the last gap
				else
				{
					gapLocation = lastGapLocation + gapSize + MIN_SPACE_BETWEEN_GAPS + (int)(Math.random() * (MAX_SPACE_BETWEEN_GAPS - MIN_SPACE_BETWEEN_GAPS) );
				}
				
			}
			platforms[i] = new Platform(width, platformY, gapLocation);
		}
	}
	
	/**
	 * Draws the platform set to the the Graphics context.
	 * @param g an object of the Graphics class
	 */
	public void draw(Graphics g)
	{
		for (Platform e : platforms)
		{
			e.draw(g);
		}
	}
	
	/**
	 * Moves each platform downward (increasing y-value) by the set amount.
	 * @param amount the number of pixels to move the platform set downwards
	 */
	public void scrollDown(int amount)
	{
		//Increment the y-value for each platform
		for (Platform platform : platforms)
		{
			platform.setY(platform.getY() + amount);
		}
	}
	
	/**
	 * Returns true if the given Rectangle intersects any platform in the set. Returns false if otherwise.
	 * @param toTest a Rectangle to test for intersection
	 * @return true if the given Rectangle intersects any platform in the set.
	 */
	public boolean isIntersectingPlatform(Rectangle toTest)
	{
		//Test for intersection in each platform
		for (Platform platform : platforms)
		{
			if (platform.isIntersecting(toTest))
			{
				return true;
			}
		}
		
		//Return false if not intersection
		return false;
	}
}
