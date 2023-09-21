import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Blinky here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blinky extends Actor
{
    //Blinky does not need or use a scoreboard, so i have removed it
    private final int VENSTRE = 0;
    private final int HØJRE = 1;
    private final int OP = 2;
    private final int NED = 3;
    
    //Blinky shouldn't have a Pacman object
    //If blinky needs to know about Pacman, you should get it from the world
    private int retning = OP;
    private GreenfootImage billede1, billede2, billede3;
    //I have also removed the scoreboard and pacman from the constructor
    public Blinky()
    {
        billede1 = new GreenfootImage("blinky.png");
        billede2 = new GreenfootImage("blinky1.png");
        billede3 = new GreenfootImage("blueGhost.png");
    }
    /**
     * Act - do whatever the Blinky wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        skiftBillede();
        if (Greenfoot.getRandomNumber(50) == 1)
            retning = Greenfoot.getRandomNumber(4);
        while (!flyt()){
            retning = Greenfoot.getRandomNumber(4);
        }
        spisPacman();
        
    }
    
    public void skiftBillede()
    {
        //Instead of using the Pacman object you had in Blinky before
        //I am now getting a list of the Pacman objects in the world
        List<Pacman> pacman = getWorld().getObjects(Pacman.class);
        //I then check on the first (and hopefully only)
        //Pacman object on the list and then check his power levels (over 9000)
        if (!pacman.get(0).getPower()){
            if (getImage() == billede1) 
            {
                setImage(billede2);
            }
            else 
            {
                setImage(billede1);
            }
        }
        else
        {
            setImage(billede3);
        }
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
    
    //Now you can make this method getting objects from the world instead of from Blinky
    public void spisPacman()
    {
        
    }
}
