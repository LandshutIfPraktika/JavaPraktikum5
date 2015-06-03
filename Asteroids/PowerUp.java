import greenfoot.*;

/**
 * Write a description of class PowerUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class PowerUp extends MyActor
{
    private int turnsLeft = 100;
    
    
    public void act(){
        if (this.isTouching(Ship.class)) {
            this.getWorld().removeObject(this);
            return;
        }
        
        if (this.turnsLeft == 0) {
            this.getWorld().removeObject(this);
            return;            
        }
        
        this.turnsLeft = this.turnsLeft -1;
    }
  
}
