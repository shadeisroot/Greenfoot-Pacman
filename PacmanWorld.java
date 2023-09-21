import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PacmanWorld extends World
{
    
    private Scoreboard info;
    private Pacman pacman;
    private Blinky blinky;
    private Clyde clyde;
    private int[][] nytMap; 
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public PacmanWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(25, 15, 40);
        Greenfoot.setSpeed(30);
        
        setPaintOrder(Blinky.class, Food.class);
        info = new Scoreboard();
        addObject(info, 0, 0);
        
        //You create a new Blinky and Pacman object here
        blinky = new Blinky();
        clyde = new Clyde();
        pacman = new Pacman(info, blinky);
                
        
        int [][] nytMap = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 9, 3, 9, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 4, 5, 6, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 2, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
        

        for (int row = 0; row <nytMap.length; row++){
            for (int col = 0; col<nytMap[row].length; col++) {
                if (nytMap [row][col] == 1) {
                    addObject(new Wall(), col, row);
                } else if (nytMap [row][col] == 0){
                        addObject (new Food(), col, row);
                } else if (nytMap [row][col] == 2){
                        addObject (new Pacman(info, blinky), col, row);
                } else if (nytMap [row][col] == 3){
                        addObject (new Blinky(), col, row);
                } else if (nytMap [row][col] == 4){
                        addObject (new Clyde(), col, row);
                } else if (nytMap [row][col] == 5){
                        addObject (new Pinky(), col, row);
                } else if (nytMap [row][col] == 6){
                        addObject (new Inky(), col, row);
                } else if (nytMap [row][col] == 9){
                        continue;
                }
            }

        }
    }
}
