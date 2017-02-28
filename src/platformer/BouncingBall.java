//Author: Joseph Carman  Date:10/9/16
//Purpose: program that bounces a ball off the walls of the screen
package platformer;
import java.applet.Applet;
import java.awt.*;
import javax.swing.Timer;
import java.awt.event.*;
public class BouncingBall extends Applet
{
 //declaring variables
 int x, y; //starting coordinates of the ball
 int wBall, hBall = 20; //width and height of ball
 int direction; //angle the ball starts at
 public Timer timer;
 double speed;
 int width = 1200, height = 600; //size of the window the program runs in
  
 public void init () //starts applet
 {
  //set random starting point for the ball
  x = (int)(Math.random() * width);
  y = (int)(Math.random() * height);
  
  //stop the ball from being generated while intersecting the right or bottom walls
  if (x > (width - wBall))
   x = x - wBall;
  if (y > (height - hBall))
   y = y - hBall;
   
  setSize(width, height); //sets the window equal to the variables declared earlier
  setBackground(Color.white); //sets the background of the applet to white
  direction = (int)(360 * Math.random()); //sets the initial angle 0<direction<360
  timer = new Timer(50, new MyTimer()); //sets 50 milliseconds as the time interval for MyTimer to be carried out
  timer.start(); //starts the timer
 } //ends init
 
 public void paint(Graphics g)
 {
  g.setColor(Color.black); //sets the ball's color to black
  g.fillOval(x, y, wBall, hBall); //sets the balls diameter and starting coordinates
 } //ends paint
 
 private class MyTimer implements ActionListener
 {
  public void actionPerformed(ActionEvent a)
  {
   x += (int)(speed * Math.cos(Math.PI * direction / 180.0)); //adding horizontal component of speed to x to find new x
   y += (int)(speed * Math.sin(Math.PI * direction / 180.0)); //adding vertical component of speed to y to find new y
   
   if (x > width - wBall) //if ball hits the right side
   {
    if (direction >= 0 && direction <= 90)
     direction = 180 - direction;
    else if (direction >=270 && direction <= 360)
     direction = 540 - direction;
   } //end right side bounce
   
   if (x < width) //if ball hits the left side
   {
    if (direction >= 90 && direction <= 180)
     direction = 180 - direction;
    else if (direction >= 180 && direction <= 270)
     direction = 540 - direction;
   } //ends left side bounce
   
   if (y > height - hBall)
   {
    if (direction >= 270 && direction <= 360)
     direction = 360 - direction;
    if (direction <= 90 && direction>= 180)
     direction = 360 - direction;
   } //ends top bounce
  }
 }
}