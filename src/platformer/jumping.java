package platformer;

public class jumping {
	static boolean isJump(boolean w)
	{
		Move.dy=-5;
        Move.count++;
        if(Move.count == 28)
        {
            Move.count = 0;
            Move.reset = false;
            return false;
        }
        return w;
    }

}
