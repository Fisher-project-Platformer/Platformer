package platformer;
import java.awt.*;

public class Move extends Rectangle {


	/**
	 * 
	 */
	private static final long serialVersionUID = 807125589929370139L;
	public static boolean a=false, w=false, d=false, reset=true, fall=true;
	private static boolean up = true;
	private static boolean down = true;
	private static boolean left = true;
	private static boolean right = true;
    private static int speed = 8;
 	static int dx=0;
	static int dy=0;
	static int count=0;
	static int grav;
    public static int xPosit;
	public static int yPosit;
	public int x, y;

	public Move(int charX, int charY)
	{
		// TODO Auto-generated constructor stub
		xPosit=charX;
		yPosit=charY;
	}
		
    public static void tick()
    {
    	
    	grav=(int)(.25*count*count);	
    	//controls ability to move in the directions specified
    	if(xPosit<=0)left=false;//if the character hits the left side of the screen the ability to move left is set to false
    	if(xPosit>=PlatformerGame.aWidth-PlatformerGame.charWidth)right=false;//if the character hits the right side of the screen the ability to move is set to false
    	if(yPosit<=0)up=false;//if the character hits the top of the screen the ability to continue up is set to false
    	if(yPosit>=PlatformerGame.aHeight-PlatformerGame.charHeight)
    		{
    			down=false;//if the character hits the bottom of the screen the ability to move down is set to false
    			PlatformerGame.lose=true;//if the character hits the bottom the player loses the game
    		}
    	
    	//sets the change of x and y as the speed in the respective direction
        if(a)dx-=speed;//moves the character left 1 dx each time the timer executes
        if(d)dx+=speed;//moves the character right 1 dx each time the timer executes
        if(w && reset)//if w is pressed and the ability to jump is present (character isn't already jumping or falling)
        {
        	jumping.isJump(w);//calls the jump method
        }
        
        
        //sets the change of x and y to 0 if the conditions for no movement are met
        if(right==false && dx>0) dx = 0;
        if(left==false && dx<0) dx = 0;
        if(up==false && dy<0) dy = 0;
        if(down==false && dy>0) dy = 0;
        
        //sets the x and y coordinates as the old coordinates + the current change in x and y
        xPosit+=dx;
        yPosit+=dy;
        
        //resets the change of x and y to 0
        dx=0;
        
        
        //recreates the ability to move in the respective directions after each time the method is executed
        //(for cases where it hits a box)
        up = true;
        down = true;
        left = true;
        right = true;
    }
    
    public static void scrollDown(int amount)
    {
    	if (!w && reset)
    	{
    		dy = amount;//sets the character to scroll with the platforms provided it isn't jumping
    	}
    }
}
           
   
    
