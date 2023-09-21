import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pacman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pacman extends Actor
{
    private final int VENSTRE = 0;
    private final int HØJRE = 1;
    private final int OP = 2;
    private final int NED =3;
    
    private int count;
    private int piltast = HØJRE;
    private boolean power;
    private Scoreboard info;
    private Blinky blinky;
    private int liv = 3;
    private GreenfootImage billede1, billede2;
    
    //Now you can fix Pacman, he should not have a blinky and a scoreboard
    //Instead you should get them from the World
    //When you remove Scoreboard and Blinky a lot of methods will break
    //try and fix them using objects gotten from World instead
    public Pacman(Scoreboard i, Blinky b)
    {
        billede1 = new GreenfootImage("pacman02.png");
        billede2 = new GreenfootImage("pacman01.png");
        setImage(billede1);
        info = i;
        power = false;
        count = 0;
        blinky = b;
    }
    
    /**
     * Act - do whatever the Pacman wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        skiftBillede();
        checkTastatur();
        flyt();
        spis();
        gameWin();
        spisPower();
        poweredUp();
    }
    public void gameWin()
    {
        if (getWorld().getObjects(Food.class).size() == 0)
        {
            info.gamewin();
        }
    }
    public void skiftBillede()
    {
        if (getImage() == billede1)
        {
            setImage(billede2);
        }
        else
        {
            setImage(billede1);
        }
    }
    public void checkTastatur()
    {
        if (Greenfoot.isKeyDown("left") && !erMur(VENSTRE)) piltast = VENSTRE;
        else if (Greenfoot.isKeyDown("right") && !erMur(HØJRE)) piltast = HØJRE;
        else if (Greenfoot.isKeyDown("UP") && !erMur(OP)) piltast = OP;
        else if (Greenfoot.isKeyDown("down") && !erMur(NED)) piltast = NED;
    }
    public void flyt()
    {
        if (piltast == VENSTRE && !erMur(VENSTRE)) {
            setRotation(180);
            setLocation(getX()-1, getY());
        }
    
        else if (piltast == HØJRE && !erMur(HØJRE))
        {
            setRotation(0);
            setLocation(getX()+1, getY());
        }
        
        else if (piltast == OP && !erMur(OP))
        {
            setRotation(270);
            setLocation(getX(), getY()-1);
        }
        else if (piltast == NED && !erMur(NED))
        {
            setRotation(90);
            setLocation(getX(), getY()+1);
        }
    }
    
    public boolean erMur(int piltast)
    {
        if (piltast == VENSTRE && getOneObjectAtOffset(-1, 0, Wall.class) == null)
            return false;
        else if (piltast == HØJRE && getOneObjectAtOffset(1, 0, Wall.class) == null)
            return false;
        else if (piltast == OP && getOneObjectAtOffset(0, -1, Wall.class) == null)
            return false;
        else if (piltast == NED && getOneObjectAtOffset(0, 1, Wall.class) == null)
            return false;
        return true;
    }
    
    public void spis()
    {
        Actor A = getOneObjectAtOffset(0, 0, Food.class);
        if (A != null)
        {
            getWorld().removeObject(A);
            info.update(1000);
        }
    }
    
    public void spisPower()
    {
        Actor B = getOneObjectAtOffset(0, 0, Powerfood.class);
        if (B != null)
        {
            getWorld().removeObject(B);
            power = true;
            count = 600;
        }
    }
    
    public void poweredUp()
    {
        if (power && count > 0)
        {
            count = count -1;
            power = true;
        }
        else
        {
            power = false;
        }
    }
    
    public void hovJegBlevSpist()
    {
        liv = liv -1;
        info.opdaterLiv(liv);
        if (liv == 0)
            info.gameover();
    }
    
    public boolean getPower()
    {
        return power;
    }
}
