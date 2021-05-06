import greenfoot.*; 
/**
 * Instructions on how to play the game
 * 
 * @Owen Zhu
 * @v1.0
 */
public class Help extends World
{
    GreenfootSound backgroundMusic  = new GreenfootSound("sounds/soundtrack.mp3");
    Label step = new Label("Instructions",60);
    Label step1 = new Label("Words will fall down from the top of the screen every so often.",30);
    Label step2 = new Label("Your job is to type out the words that appear on the screen as fast as you can!",30);
    Label step3 = new Label("Type like you regularly would and press 'enter' to clear the your current word.",30);
    Label back = new Label("Press \"space\" to go back to the homescreen",28);
    public Help()
    {    
        super(1000, 600, 1);
        backgroundMusic.playLoop();
        addObject(step,500,210);
        addObject(step1,500,260);
        addObject(step2,500,290);
        addObject(step3,500,320);
        addObject(back,500,500);
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("space")){
            backgroundMusic.stop(); //In order to prevent multiple instances of the soundtrack from playing
            TitleScreen home = new TitleScreen();
            Greenfoot.setWorld(home);
        } 
    }
}
