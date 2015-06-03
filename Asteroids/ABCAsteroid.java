import greenfoot.*;

/**
 * Write a description of class ABSAsteroid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class ABCAsteroid extends MyActor
{
    // Hass auf Java fragen warum nicht final
    private int speed = 10;
    private int indestructable = 0;

    public int getIndestructable(){
        return this.indestructable;
    }
    
    public void setIndestructable(int duration){
        this.indestructable = duration;
    }
    
    public int getSpeed(){
        return this.speed;
    }
    
    public void beShot(){
        this.getWorld().removeObject(this);
    }
        
    public void crashAsteroid(ABCAsteroid that){
        if (Greenfoot.getRandomNumber(2) == 0){
            this.getWorld().removeObject(this);
        } else {
            this.myTurn(180);
            that.myTurn(180);
            this.setIndestructable(1);
            that.setIndestructable(1);
        }
    }
    
    
    
    /**
     * Act - do whatever the ABSAsteroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.move(getSpeed());
        
        if (this.isAtEdge()){
            this.getWorld().removeObject(this);
            return;
        }
        
        if (this.isTouching(Laser.class) && this.getIndestructable() == 0){
            this.beShot();
            return;
        }
        
        if (this.isTouching(ABCAsteroid.class) && this.getIndestructable() == 0){
            this.crashAsteroid((ABCAsteroid)this.getOneIntersectingObject(ABCAsteroid.class));
            return;
        }
        
        this.endTurn();
    }    
    
    private void endTurn(){
        int tmp;
        if ((tmp = this.getIndestructable()) > 0 ){
            this.setIndestructable(tmp -1);
        }
    }
        
}
