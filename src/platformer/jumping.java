package platformer;

public class jumping {
	static boolean isJump(boolean w)
	{
		Move.dy=-31+(Move.grav);
        Move.count++;
        if(Move.yPosit == 600)
        {
            Move.count = 0;
            Move.reset = false;
            return false;
        }
        return w;
    }

}
