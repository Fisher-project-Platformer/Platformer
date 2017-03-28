package platformer;

public class jumping {
	static boolean isJump(boolean w)
	{
<<<<<<< HEAD
		Move.dy=-5;
        Move.count++;
        if(Move.count == 28)
        {
            Move.count = 0;
            Move.reset = false;
            return false;
=======
		Move.dy=-18+(Move.grav);
        Move.count++;
        if(Move.yPosit >= 600 || Move.count == 9)//hits top of platform condition (planned)
        {
            Move.count = 0; 
            Move.dy=0;
            Move.reset = true;
            Move.w = false;
>>>>>>> refs/remotes/origin/master
        }
        return w;
    }

}
