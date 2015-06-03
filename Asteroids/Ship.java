import greenfoot.*;

/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship extends MyActor
{
    
    private int speed = 0;
    private int agillity = 5;
    private int firePower = 0;
    
    private int coolDown = 0;
    private int maxCoolDown = 5;
    
    
    // getter and setter methods
    
    public int getSpeed(){
        return this.speed;
    }
    
    public int getAgillity(){
        return this.agillity;
    }
    
    public int getFirePower(){
        return this.firePower;
    }
    
    public int getCoolDown(){
        return this.coolDown;
    }
    
    public void setCoolDown(int coolDown){
        this.coolDown = coolDown;
    }
    
    public int getMaxCoolDown(){
        return this.maxCoolDown;
    }
    
    // acting methods
    
        public void increaseSpeed(){
        this.speed = this.speed +1;
    }
    
    public void brake(){
        if (this.speed > 0) {
            this.speed = this.speed -1;
        }
    }
    
    public void turnRight(){
        this.turn(+(this.getAgillity()));
    }
    
    public void turnLeft(){
        this.turn(-(this.getAgillity()));
    }
    
    public void fireLaser(){
        switch (this.getFirePower()){
            case 0:{
                Laser myLaser = new Laser(this.calculateLaserSpeed(),this.getRotation());
                this.getWorld().addObject(myLaser, this.getX(), this.getY());
                break;
            }
            
            case 1:{
                Laser leftLaser = new Laser(this.calculateLaserSpeed(),this.getRotation());
                Laser centreLaser = new Laser(this.calculateLaserSpeed(),this.getRotation());
                Laser rightLaser = new Laser(this.calculateLaserSpeed(),this.getRotation());
                
                this.getWorld().addObject(leftLaser, this.getX(), this.getY());
                leftLaser.myTurn(-90).myMove(myWorld.ySize / 40).myTurn(90);
                
                this.getWorld().addObject(rightLaser, this.getX(), this.getY());
                rightLaser.myTurn(90).myMove(myWorld.ySize / 40).myTurn(-90);
                
                this.getWorld().addObject(centreLaser, this.getX(), this.getY());
                
                break;
            }
            default:{}
        }
        
        this.setCoolDown(this.getMaxCoolDown());
    }
    
    public void powerUp(PowerUp that){
        if (that instanceof FirePowerUp){
            this.firePower = 1;
        } else if (that instanceof AgillityPowerUp){
            this.agillity = 10;
        } else if (that instanceof CoolDownPowerUp) {
            this.maxCoolDown = 3;
        }        
    }
    
    /**
     * Act - do whatever the Ship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.move(getSpeed());
        
        if (Greenfoot.isKeyDown("up")){
            this.increaseSpeed();
        }
        
        if (Greenfoot.isKeyDown("down")) {
            this.brake();
        }
        
        if (Greenfoot.isKeyDown("left")) {
            this.turnLeft();
        }
        
        if (Greenfoot.isKeyDown("right")) {
            this.turnRight();
        }
        
        if (Greenfoot.isKeyDown("space") && this.getCoolDown() == 0){
            this.fireLaser();
        }
        
        if (this.isTouching(ABCAsteroid.class)){
            this.getWorld().showText("Game Over! \nFinal Score: " + ((myWorld)this.getWorld()).getScore(), myWorld.xSize / 2, myWorld.ySize / 2);
            Greenfoot.stop();
           
        }
        
        if (this.isTouching(PowerUp.class)){
            this.powerUp((PowerUp)this.getOneIntersectingObject(PowerUp.class));
        }
        
        this.turnEnd();
    } 
    
    //private methods
    
    private int calculateLaserSpeed(){
        return (int) (this.getSpeed()*1.2 +10);
    }
    
    private void turnEnd(){
        int tmp;
        if ((tmp = this.getCoolDown()) > 0){
            this.setCoolDown(tmp-1);
        }
    }
}
