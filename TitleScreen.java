import greenfoot.*;
/**
 * Title screen for the 'Gravity Falls'
 * 
 * @Owen Zhu
 * @v1.0
 * 
 * Background images came from: http://www.sclance.com/backgrounds/cartoon-backgrounds-for-animation/view-page-2.htm
 * The music was found online at: https://www.youtube.com/watch?v=uIYBnfsB37k
 */
public class TitleScreen extends World
{
    GreenfootSound backgroundMusic  = new GreenfootSound("sounds/soundtrack.mp3");
    Label title = new Label("Gravity Falls",60);
    Label author = new Label("By: Owen Zhu",40);
    Label nxt = new Label("Press \"space\" to start!",30);
    Label tutorial = new Label("Press \"p\" for intructions on how to play!",30);
    public TitleScreen()
    {    
        //Creates a world 1000 by 600 and adds the titlescreen text       
        super(1000, 600, 1);
        backgroundMusic.playLoop();
        addObject(title,500,200);
        addObject(author,500,260);
        addObject(nxt,500,500);
        addObject(tutorial,500,450);      
    }
    
    //Checks for keyboard input to go to the game or instructions
    public void act()
    {
        if(Greenfoot.isKeyDown("p")){
            Help help = new Help();
            Greenfoot.setWorld(help);
            backgroundMusic.stop(); //In order to prevent multiple instances of the soundtrack from playing
        }else if(Greenfoot.isKeyDown("space")){
            Game game = new Game();
            Greenfoot.setWorld(game);
        } 
    }
}
