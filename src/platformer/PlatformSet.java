package platformer;

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
	//Constants
	private final int VERTICAL_SPACING = 100;
	private final int PLATFORM_HEIGHT = 30;
	private final int GAP_SIZE = 90;
	private final int GAP_LOCATION_PATTERN_SIZE = 14;
	private final double[] gapLocationPattern = new double[]{0.};
	
	
	//Variables
	private int numberOfPlatforms= 6;
	private int bottomY;
	private int width;
	double[] gapLocations;
	Platform[] platforms;
	
	/**
	 * Creates a set of platforms with the bottom platform beginning at the given location.
	 * @param width the width of the platforms
	 * @param bottomY the y-location of the bottom of the bottom platform
	 */
	public PlatformSet(int width, int bottomY, int numberOfPlatforms)
	{
		this.width = width;
		this.bottomY = bottomY;
		this.numberOfPlatforms = numberOfPlatforms;
		
		//Define gap locations
		gapLocations = new double[numberOfPlatforms];
		for (int i = 0; i < numberOfPlatforms; i++)
		{
			
		}
		
		//Create platforms
		platforms = new Platform[numberOfPlatforms];
		for (int i = 0; i < numberOfPlatforms; i++)
		{
			int platformY = bottomY - i * VERTICAL_SPACING;
			platforms[i] = new Platform(width, platformY, );
		}
	}
	
	
	
	
}
