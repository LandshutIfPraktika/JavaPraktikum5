import greenfoot.*;

/**
 * Write a description of class SmallAsteroid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SmallAsteroid extends ABCAsteroid
{
    
    @Override
    public void beShot(){
        ((myWorld)this.getWorld()).increaseScore();
        super.beShot();
    }   
}
