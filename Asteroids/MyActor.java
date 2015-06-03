import greenfoot.*;

/**
 * Write a description of class MyActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class MyActor extends Actor
{
    public MyActor myTurn(int angle){
        this.turn(angle);
        return this;
    }
    
    public MyActor myMove(int distance){
        this.move(distance);
        return this;
    }   
}
 