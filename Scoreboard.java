import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scoreboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scoreboard extends Actor
{
    private int score;
    private int liv;
    private Blinky blinky;
    public Scoreboard()
    {
        score = 0;
    }
    
    public void update(int s)
    {
        score = score + s;
    }
    /**
     * Act - do whatever the Scoreboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        getWorld().showText("score: " + score + "Liv: " + liv, 5, 0);
    }
    
    public void gameover()
    {
        getWorld().showText("GAME OVER: " + score, 12, 7);
        Greenfoot.stop();
    }
    
    public void gamewin()
    {
        getWorld().showText("YOU WON!: " + score, 12, 7);
        Greenfoot.stop();
    }
    
    public void opdaterLiv(int l)
    {
        liv = l;
        getWorld().addObject(new Pacman(this, blinky), 1, 4);
    }
}
