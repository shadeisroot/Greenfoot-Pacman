import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Clyde here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Clyde extends Actor
{
    /**
     * Act - do whatever the Clyde wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private final int VENSTRE = 0;
    private final int HØJRE = 1;
    private final int OP = 2;
    private final int NED = 3;
    
    private int retning = OP;
    private int counter;
    
    private GreenfootImage billede1, billede2;
    public Clyde()
    {
        billede1 = new GreenfootImage("clyde.png");
        billede2 = new GreenfootImage("clyde1.png");
        setImage(billede1);
    }
    
    public void act()
    {
        // Add your action code here.
        skiftBillede();
        spisPacman();
        if (Greenfoot.getRandomNumber(50) == 1)
            retning = Greenfoot.getRandomNumber(4);
        while (!flyt()){
            retning = Greenfoot.getRandomNumber(4);
        }
    }
    
    public void skiftBillede()
    {
        if (getImage() == billede1) setImage(billede2);
        else setImage(billede1);
    }
    
    public boolean flyt()
    {
        if (retning == VENSTRE)
        {
            
            if(!erMur())
            {
                setLocation(getX()-1, getY());
                return true;
            }
            else
            {
                return false;
            }
        }
        else if (retning == HØJRE)
        {
            if(!erMur())
            {
                setLocation(getX()+1, getY());
                return true;
            }
            else
            {
                return false;
            }
        }
        else if (retning == OP)
        {
            if(!erMur())
            {
                setLocation(getX(), getY()-1);
                return true;
            }
            else
            {
                return false;
            }
        }
        else if (retning == NED)
        {
            if(!erMur())
            {
                setLocation(getX(), getY()+1);
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }
    
    public boolean erMur()
    {
        int dx = 0, dy = 0;
        if (retning == VENSTRE) {
            dx = -1; dy = 0;
        }
        else if (retning == HØJRE) {
            dx = 1; dy = 0;
        }
        else if (retning == OP) {
            dx = 0; dy = -1;
        }
        else if (retning == NED) {
            dx = 0; dy = 1;
        }
        Actor M = getOneObjectAtOffset(dx, dy, Wall.class);
        if (M != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void spisPacman()
    {
        Actor A = getOneObjectAtOffset(0, 0, Pacman.class);
        if (A != null)
        {
            getWorld().removeObject(A);
        }
    }
}
