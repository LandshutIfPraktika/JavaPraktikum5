import greenfoot.*;

/**
 * Write a description of class myWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class myWorld extends World
{

    public final static int xSize = 1440;
    public final static int ySize = 810;
    private final static int BaseChance = 100;
    
    private int score = 0;
    
    public int getScore(){
        return this.score;
    }
    
    public void increaseScore(){
        this.score = this.score+1;
    }
    
    public void createPowerUp(){
                if (Greenfoot.getRandomNumber(1000) < 5){
                       
                PowerUp myPowerUp;
                switch (Greenfoot.getRandomNumber(3)){
                    case 0:
                    myPowerUp = new FirePowerUp();
                    break;
                    
                    case 1:
                    myPowerUp = new AgillityPowerUp();
                    break;
                    
                    case 2:
                    myPowerUp = new CoolDownPowerUp();
                    break; 
                    
                    
                   default:
                   myPowerUp = new FirePowerUp();
                }
                       

                this.addObject(myPowerUp, Greenfoot.getRandomNumber(xSize), Greenfoot.getRandomNumber(ySize));

                 
            } 
    }
    
    public void createSmallAsteroid(){
        for (int i = 0; i <= this.getScore() / 100; i++){
            if (Greenfoot.getRandomNumber(1000) < BaseChance + this.getScore()){
                SmallAsteroid myAsteroid = new SmallAsteroid();
                switch(Greenfoot.getRandomNumber(4)){
                    
                    case 0: 
                    this.addObject(myAsteroid, 0, Greenfoot.getRandomNumber(ySize));
                    break;
                    
                    case 1: 
                    this.addObject(myAsteroid, xSize, Greenfoot.getRandomNumber(ySize));
                    break;
                    
                    case 2: 
                    this.addObject(myAsteroid, Greenfoot.getRandomNumber(xSize), 0);
                    break;
                    
                    case 3:
                    this.addObject(myAsteroid, Greenfoot.getRandomNumber(xSize), ySize);
                    break;
                }
                myAsteroid.turn(Greenfoot.getRandomNumber(360));  
            }
        }
    }
    
    public void createBigAsteroid(){
        for (int i = 0; i <= this.getScore() / 200; i++){
            if (Greenfoot.getRandomNumber(1000) < (BaseChance + this.getScore())/2){
                BigAsteroid myAsteroid = new BigAsteroid();
                switch(Greenfoot.getRandomNumber(4)){
                    
                    case 0: 
                    this.addObject(myAsteroid, 0, Greenfoot.getRandomNumber(ySize));
                    break;
                    
                    case 1: 
                    this.addObject(myAsteroid, xSize, Greenfoot.getRandomNumber(ySize));
                    break;
                    
                    case 2: 
                    this.addObject(myAsteroid, Greenfoot.getRandomNumber(xSize), 0);
                    break;
                    
                    case 3:
                    this.addObject(myAsteroid, Greenfoot.getRandomNumber(xSize), ySize);
                    break;
                }
                myAsteroid.turn(Greenfoot.getRandomNumber(360));  
            }
        }
    }
    
    /**
     * Constructor for objects of class myWorld.
     * 
     */
    public myWorld()
    {    
        
        super(xSize, ySize, 1); 
        Ship  myShip = new Ship();
        this.addObject(myShip, xSize/2, ySize/2);
        
        
        
    }
    
    public void act(){
       this.createSmallAsteroid();
       this.createBigAsteroid();
       this.createPowerUp();
       this.showText("Score: "+this.getScore(), xSize / 12, ySize / 10);
    }
}
