import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Actor
{
    /**
     * Act - do whatever the Wall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        foundFood();
        removeFood();
    }
    public boolean foundFood()
    {
        Actor food = getOneObjectAtOffset(0, 0, Food.class);
        if(food != null) {
            return true;
        }
        else {
            return false;
        }
    }
    public void removeFood()
    {
        Actor food = getOneObjectAtOffset(0, 0, Food.class);
        if(food != null)
        {
            getWorld().removeObject(food);
        }
    }
}
