import greenfoot.*;

/**
 * Write a description of class Laser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Laser extends MyActor
{
    private final int speed;
    private boolean spent = false;
    private int spentTimer = 5;
    
    private static final int LASERDEFAULTSPEED = 10;
    
    Laser(){
        super();
        this.speed = LASERDEFAULTSPEED;
    }
    
    Laser(int speed, int angle){
        super();
        this.speed = speed;
        this.turn(angle);
    }
    
    public int getSpeed(){
        return this.speed;
    }
    

    
    /**
     * Act - do whatever the Laser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.move(getSpeed());
        
        if (this.isAtEdge()){
            this.getWorld().removeObject(this);
            return;
        }
        
        if (this.isTouching(ABCAsteroid.class)){
            this.spent = true;
        }
        
        this.endTurn();
    } 
    
    private void endTurn(){
        if (this.spent) this.spentTimer = this.spentTimer -1;
        if (this.spentTimer == 0){
            this.getWorld().removeObject(this);
        }
    } 
}
