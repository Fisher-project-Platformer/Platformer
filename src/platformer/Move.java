package platformer;
import java.awt.*;

public class Move extends Rectangle {


	/**
	 * 
	 */
	private static final long serialVersionUID = 807125589929370139L;
	public static boolean a=false, w=false, d=false, reset=true;
	private static boolean up = true;
	private static boolean down = true;
	private static boolean left = true;
	private static boolean right = true;
    private static int speed = 5;
    private static int jumpSpeed = 30;
	private static int dx=0;
	static int dy=0;
	static int count=0;
	private static int grav;
    public static int xPosit;
	public static int yPosit;
	public int x, y;

	public Move(int charX, int charY)
	{
		// TODO Auto-generated constructor stub
		xPosit=charX;
		yPosit=charY;
		System.out.println(charX);
	}
		
    public static void tick()
    {
    	grav=(int) (.25*count*count);	
    	//controls ability to move in the directions specified
    	if(xPosit<=0)left=false;
    	if(xPosit>=1200)right=false;
    	if(yPosit<=0)up=false;
    	if(yPosit>=600)down=false;
    	
    	//sets the change of x and y as the speed in the respective direction
        if(a)dx-=speed;
        if(d)dx+=speed;
        if(w && reset)
        {
        	jumping.isJump(w);
        }
        
        
        //sets the change of x and y to 0 if the conditions for no movement are met
        if(right==false && dx>0) dx = 0;
        if(left==false && dx<0) dx = 0;
        if(up==false && dy<0) dy = 0;
        if(down==false && dy>0) dy = 0;
        
        //sets the x and y coordinates as the old coordinates + the change in x and y
        xPosit+=dx;
        yPosit+=dy;
        
        //resets the change of x and y to 0
        dy=0;
        dx=0;
        
        
        //recreates the ability to move in the respective directions
        up = true;
        down = true;
        left = true;
        right = true;
    }
    
   
    
}