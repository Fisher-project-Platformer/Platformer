package platformer;
//Author: Anthony Derfler
//Purpose: To create a timer for the platformer
//date: 3/6/17
public class Timer2 
{
	//returns the seconds value, which resets at 60
	public static Integer getSeconds(int change, int start)
	{
		int aSeconds = (change - start)/1000; //calculate seconds from cpu time (will be /1000 in final product, reduced to 100 for testing)
		int interval = aSeconds/60;
		int bSeconds = aSeconds - 60 * interval;
		//from the way int round-off works, this actually works out, though algebraically, it should be 0
		
		return bSeconds;
	} //end Seconds
	
	//returns the number of minutes that have passed
	public static Integer getMinutes(int change, int start)
	{
		int minutes = 0;
		int seconds = 0;
		seconds = (change - start)/1000;
		minutes = seconds/60;
		return minutes; //alternatively, using the returned bSeconds from the previous class and divide it by 60 to find minutes in the main class.
	} //end Minutes
} //end Timer