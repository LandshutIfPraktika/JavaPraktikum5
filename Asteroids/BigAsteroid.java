import greenfoot.*;

/**
 * Write a description of class BigAsteroid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BigAsteroid extends ABCAsteroid
{
    
    @Override
    public void  beShot(){
        for (int i = 1; i<=3; i++){
            SmallAsteroid myAsteroid = new SmallAsteroid();
            
            myAsteroid.setIndestructable(5 );
            this.getWorld().addObject(myAsteroid.myTurn(this.getRotation() + 30 + i * 120), this.getX(), this.getY());
        }
        super.beShot();
    }    
}
