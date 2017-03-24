package platformer;

public class jumping {
	static boolean isJump(boolean w)
	{
		Move.dy=-31+(Move.grav);
        Move.count++;
        if(Move.yPosit >= 600)
        {
        	Move.yPosit = PlatformerGame.aHeight- ;
            Move.count = 0;
            Move.reset = false;
            w = false;
        }
        return w;
    }

}
