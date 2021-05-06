import greenfoot.*;  
/**
 * From the initalized list of words, a 'Word' actor is initialized and is set to fall down until the bottom of the screen
 * 
 * @Owen Zhu
 * @v1.0
 */
public class Words extends Actor
{
    SimpleTimer delay = new SimpleTimer();
    public Words(String text)
    {
        setImage(new GreenfootImage(text, 25, Color.BLACK, new Color(0, 0, 0, 0))); // Displays the word onscreen
    }     

    public void act(){
        //Setting a delay for how fast the word falls                 
        if(delay.millisElapsed() < 25) return;
        delay.mark();        
        setLocation(getX(),getY()+1);
        
        //Calls the gameOver() method which exits the game
        if(getY()>=590){          
            ((Game)getWorld()).gameOver();              
        }
    }
}
