package platformer;

public class jumping {
	static boolean isJump(boolean w)
	{
		Move.dy=-31+(Move.grav);
        Move.count++;
        if(Move.yPosit >= 600)//hits top of platform condition (planned)
        {
        	Move.yPosit = 580 ;//set position to on platform
            Move.count = 0; 
            Move.reset = true;
            Move.w = false;
            
        }
        return w;
    }

}
