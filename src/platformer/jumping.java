package platformer;

public class jumping {
	static boolean isJump(boolean w)
	{
		Move.dy=-15+(Move.grav);
        Move.count++;
        if(Move.yPosit >= 600 || Move.count == 8)//hits top of platform condition (planned)
        {
            Move.count = 0; 
            Move.reset = true;
            Move.w = false;
            
        }
        return w;
    }

}
