import greenfoot.*;
/**
 * Main driver for the typing game
 * The class is initialized with a set list of words
 * It detects and keyboard input and checks through the list of words to see if any of the words match
 * 
 * @Owen Zhu
 * @v1.0
 */
public class Game extends World
{
    SimpleTimer speed = new SimpleTimer();
    int n=0,lvlspeed=1100,lvl=1,score=0;
    String[] list= {"ahir","phil","best","akan","amin","bomb","play","bots","idol","grad","pork","laos","hugo","iran","wisp","cato","dude","cear","sett","bene","colt","edda","felid","clips","xerox","kusch","neath","clark","papen","nancy","salem","perky","owing","lanky","udall","spume","djaja","bluff","janet","minim","queen","ideal","paris","cagey","tommy","phyfe","wootz","sorus","rowdy","ouphe","rabbi","shied","flood","boron","hecht","cadet","lille","still","emmet","urine","bring","adman","concha","citify","sliver","childe","flavin","rement","twiner","curtin","spener","raffia","thymol","harlow","munich","judaea","runoff","jevons","pascal","cherie","hatasu","tomboy","intort","hanger","nardoo","redraw","azbine","embark","fizeau","opener","dosser","yorker","driech","junius","dactyl","damage","alidad","alexin","flowerer","doggoned","groggier","presumed","unwintry","gauziest","vivisect","amarillo","flockbed","flowerlet","remention","underplot","preconise","prudishly","troostite","pentalpha","denotation","prewilling","suspicious","pichiciego","influencer","mongreliser","overimposed","collimating","effervescing","breasfeeding","venerational","interimperial","southeasterner","trichloroethylene"};
    String typed = "";
    Words[] test = new Words[135];

    //Displays blank scores onto the screen
    public Game()
    {    
        super(1000, 600, 1);
        showText("Score:",400,570);
        showText("0",445,570);
        showText("Level:",560,570);
        showText("1",600,570);
    }

    //Act method contanstly checks for keyboard input and matches the words typed to the one onscreen
    public void act()
    {
        String type = typing(); //Stores the typed word from typed(); to the varible 'type'
        for(int i = 0; i <= n; i++)
        {                    
            if(type.equals(list[i])&&!list[i].equals("-1")) //Checks if the word matchs and the of world on screen
            {
                typed=""; //reseting variable typed
                showText("Typed Word:",500,530); //erasing the typed word
                removeObject(test[i]); //Removes the word object from the screen
                list[i]="-1"; //Setting the previously typed word to '-1'/null so it can't be typed again
                showText(Integer.toString(++score),445,570); //Incrementing the score by 1
                break;
            }
        }

        if(speed.millisElapsed() < lvlspeed) return; // Setting a delay so that a world spawns every so often
        speed.mark();
        spawn(); //Calls the spawn() method to create another word in the game
    }

    //Takes the current word in the list of words and 
    public void spawn()
    {
        if(list[n]!="-1"){ //Covers the edge case where a word is pressed as soon as it's spawned
            test[n] = new Words(list[n]); //Intiallizes another 'word actor' with the word from the word list
            addObject(test[n], Greenfoot.getRandomNumber(850)+50, 0); //Randomly displays the word on the top of the screen
        }

        if(n%10==0&&n!=0) //Every 10 words the speed at which the words spawn increases
        {
            showText(Integer.toString(++lvl),600,570); //Incrementing the level
            lvlspeed-=15; //Increasing the speed at which the words spawn
        }
        n++; //Increasing n by 1 so that it points to the next word in the array
    }

    //The typing method that returns a typed word
    public String typing()
    {
        String input = Greenfoot.getKey(); //Returns the keyboard input of the user
        if(input!=null)//Checks if an actual letter is pressed and it's not returning 'null'
        {
            if(input.equals("enter")||input.equals("tab")||input.equals("shift")||input.equals("caps lock")||input.equals("control")||input.equals("space")||input.equals("alt")||input.equals("windows")||input.equals("context menu")||input.equals("alt graph")){ 
                //Making sure that the game doesn't register any unwanted keyboard input
                input = "";
            }
            else if(input.equals("backspace")){//Implementing backspace
                if(typed.length()>0){ //Makes sure that there are letters to delete from the typed word
                    typed = typed.substring(0,typed.length()-1); //Takes the previously typed word and makes a substring without the last letter
                }
            }else{
                typed+=input; //Adds the typed letter to the entire word
            }

            //Clears the word if "enter" is pressed
            if(Greenfoot.isKeyDown("enter")) typed = "";                   
            showText("Typed Word: "+typed,500,530); //Displays the new word
        }
        return typed; //Returns the entire new word
    }
    
    //A gameover method that displays scores and exits after a while
    public void gameOver()
    {
        Label over = new Label("Gameover",100);
        Label scr = new Label("Score: " + Integer.toString(score),50);
        Label level = new Label("Level: " + Integer.toString(lvl),50);        
        Label exit = new Label("The game will shortly exit...",35);
        
        addObject(over,500,170);
        addObject(scr,400,260);
        addObject(level,600,260);
        addObject(exit,500,350);
        
        Greenfoot.delay(1000);
        System.exit(0);
    }
}       

