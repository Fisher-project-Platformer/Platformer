package platformer;

public class jumping {
	static boolean isJump(boolean w)
	{
		Move.dy=-18+(Move.grav);
        Move.count++;
        if(Move.yPosit >= 600 || Move.count == 9)//hits top of platform condition (planned)
        {
            Move.count = 0; 
            Move.dy=0;
            Move.reset = true;
            Move.w = false;
            Move.fall=true;
        }
        return w;
    }

}
